/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global Connection */

var SessionManagementService = function (LocalDAS, UsersAPI, UsersDAO, $q) {

    var ACTIVE_USER = "active_user";
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

        var dfd = $q.defer();
        var server = UsersAPI.prependHttp(loginData.server);

        UsersAPI.login(server, loginData.email, loginData.password)
            .then(function (data) {
                console.log(data);
                //  TODO: validate user data

                var user = data.user;
                user.server = server;
                user.password = loginData.password;

                return registerUser(user);
            }, function (error) {
                dfd.reject(error);
            })
            .then(function (activeUser) {
                //  save details locally for easy access
                LocalDAS.setObject(ACTIVE_USER, activeUser);
                LocalDAS.set(HOST, server);

                console.log(activeUser);
                activeUserCache = activeUser;

                dfd.resolve(activeUserCache);
            }, function (error) {
                dfd.reject(error);
            })
            ;

        return dfd.promise;

    };

    function registerUser(user) {

        var dfd = $q.defer();

        //  check if the user exists
        UsersDAO.find(user.id, user.server)
            .then(function (registeredUser) {
                var adaptedUser = adaptUserFromAPItoDAO(user, 1);  //  set as last active

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

    function adaptUserFromAPItoDAO(user, lastActive) {
        return {
            web_id: user.id,
            email: user.email,
            display_name: user.displayName,
            is_active: user.isActive,
            last_active: lastActive,
            description: user.description,
            image_url: user.imageUrl,
            password: user.password  //  TODO: add encryption
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
