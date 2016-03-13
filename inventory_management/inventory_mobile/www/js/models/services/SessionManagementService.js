/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global Connection */

var SessionManagementService = function (LocalDAS, UsersAPI, UsersDAO, CompaniesDAO, GroupsDAO, $q) {

    var ACTIVE_USER = "active_user";
    var ACTIVE_USER_COMPANY = "company";
    var HOST = "host";

    SessionManagementService.WIFI = "CONNECTION_WIFI";
    SessionManagementService.DATA = "CONNECTION_MOBILE_DATA";
    SessionManagementService.NONE = "CONNECTION_NONE";
    SessionManagementService.WEB = "CONNECTION_WEB";

    SessionManagementService.MODE_OFFLINE = "MODE_OFFLINE";
    SessionManagementService.MODE_ONLINE = "MODE_ONLINE";

    var activeUserCache = null;

    /**
     * Initializes the session management service.
     * 1. Will check for connectivity
     * 2. Will check for last active user
     * 3. Automatically login the last active user if found
     * 4. Will return no-local-credentials where the controller must open the login view for the user to login
     * @returns 
     */
    this.initialize = function (callbacks) {
        var _this = this;

        UsersDAO.getLastActiveUser()
            .then(function (lastActiveUser) {
//                console.log(lastActiveUser);
                if (lastActiveUser) {
                    //  login using last active user                    
                    var connectivityType = _this.getConnectionType();
                    console.log("Connectivity Type: " + connectivityType);

                    if (connectivityType === SessionManagementService.NONE) {
                        callbacks.onNoConnectivity();
                    } else {
                        var loginData = {
                            server: lastActiveUser.server,
                            email: lastActiveUser.email,
                            password: lastActiveUser.password
                        };

                        console.log("Logging in with below details:");
                        console.log(loginData);

                        _this.login(loginData)
                            .then(function (activeUser) {
                                callbacks.onLoginSuccess(activeUser);
                            }, function (error) {
                                callbacks.onLocalCredentialsFailedLogin(error);
                            })
                            ;
                    }


                } else {
                    callbacks.onNoLocalCredentialsFound();
                }
            }, function (error) {
                callbacks.onError(error);
            })
            ;

    };

    this.getConnectionType = function () {
        var connectionType = SessionManagementService.WEB;
        if (window.Connection) {
            switch (navigator.connection.type) {
                case Connection.WIFI:
                    connectionType = SessionManagementService.WIFI;
                    break;
                case Connection.CELL_2G:
                case Connection.CELL_3G:
                case Connection.CELL_4G:
                    connectionType = SessionManagementService.WIFI;
                    break;
                case Connection.NONE:
                    connectionType = SessionManagementService.NONE;
                    break;
            }
        }

        return connectionType;
    };

    this.checkConnection = function () {

    };

    this.getCurrentUser = function () {
        if (activeUserCache) {
            return activeUserCache;
        } else {
            return LocalDAS.getObject(ACTIVE_USER);
        }
    };

    this.getCurrentHost = function () {
        LocalDAS.get(HOST);
    };

    this.logout = function () {

        var update = {last_active: 0};
        var where = {last_active: 1};

        activeUserCache = null;
        LocalDAS.clear();

        return UsersDAO.update(update, where);
    };

    this.login = function (loginData) {

        var loggedInUser;
        var loggedInUserCompany;

        var dfd = $q.defer();

        var server = UsersAPI.prependHttp(loginData.server);

        UsersAPI.login(server, loginData.email, loginData.password)
            .then(function (data) {
                console.log(data);
                //  TODO: validate user data
                loggedInUser = data.results;
                return registerCompany(loggedInUser, server);
            })
            //  company is now registered, update user data
            .then(function (company) {
                loggedInUserCompany = company;
                return registerUser(loggedInUser, company, loginData.password);
            })
            .then(function () {
                return registerGroups(loggedInUser);
            }, function (error) {
                dfd.reject(error);
            })
            .then(function () {
                //  get the final active user data
                return UsersDAO.getLastActiveUser();
            }, function (error) {
                dfd.reject(error);
            })
            .then(function (activeUser) {
                //  save details locally for easy access
                LocalDAS.setObject(ACTIVE_USER, activeUser);
                LocalDAS.setObject(ACTIVE_USER_COMPANY, loggedInUserCompany);
                LocalDAS.set(HOST, loggedInUserCompany.host);

                console.log(activeUser);
                activeUserCache = activeUser;

                dfd.resolve(activeUserCache);
            }, function (error) {
                dfd.reject(error);
            })
            ;

        return dfd.promise;

    };

    function registerCompany(user, server) {
        var dfd = $q.defer();

        //  get company and then save to database
        CompaniesDAO.find(user.company.id, server)
            .then(function (company) {
                if (!company) {
                    //  create a company if it does not exist yet
                    console.log("Creating new company " + user.company.name);
                    return CompaniesDAO.insert(user.company, server);
                } else {
                    dfd.resolve(company);
                }
            }, function (error) {
                console.error("Failed to find company: " + error);
                dfd.reject(error);
            })
            .then(function (company) {
                dfd.resolve(company);
            }, function (companyInsertError) {
                console.error(companyInsertError);
                dfd.reject(companyInsertError);
            });

        return dfd.promise;

    }

    function registerUser(user, company, password) {

        var dfd = $q.defer();

        //  check if the user exists
        UsersDAO.find(user.id, company.id)
            .then(function (registeredUser) {
                var adaptedUser = adaptUserFromAPItoDAO(user, company, 1, password);  //  set as last active

                if (registeredUser) {
                    //  user exists, update the user
                    var userId = registeredUser.id;
                    return UsersDAO.update(adaptedUser, {id: userId});
                } else {
                    //  user does not exist yet, create a new one
                    return UsersDAO.insert(adaptedUser);
                }

                console.log('User Registered:');
                console.log(registeredUser);
            }, function (error) {
                dfd.reject(error);
            })
            .then(function (registeredUser) {
                dfd.resolve(registeredUser);
            })
            ;

        return dfd.promise;

    }

    function registerGroups(user) {

        if (user.groups && user.groups.length) {
            var groupPromises = user.groups.map(function (group) {
                //  use id and company id since this is unparsed version of user
                group.user_web_id = user.id;
                group.company_web_id = user.company_id;
                GroupsDAO.saveGroup(group);
            });

            return $q.all(groupPromises);
        } else {
            return [];
        }
    }

    function adaptUserFromAPItoDAO(user, company, lastActive, password) {
        return {
            web_id: user.id,
            email: user.email,
            display_name: user.display_name,
            company_id: company.id,
            last_active: lastActive,
            department: user.department,
            department_id: user.department_id,
            department_code: user.department_code,
            position: user.position,
            user_level_id: user.user_level_id,
            image_url: user.image_url,
            password: password  //  TODO: add encryption
        };
    }

};

var SessionInitializationCallbacks = function () {
    this.onNoConnectivity = function () {
    };
    this.onNoLocalCredentialsFound = function () {
    };
    this.onLocalCredentialsFailedLogin = function () {
    };
    this.onLoginSuccess = function () {
    };
    this.onError = function (errorMessage) {
        //  will be overrided, log error by default
        console.error(errorMessage);
    };
};
