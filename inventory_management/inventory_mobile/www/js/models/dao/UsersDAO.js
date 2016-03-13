
//  Stateless
var UsersDAO = function (DataAccessObject, $q) {

    var TABLE = "Users";

    function find(webId, server) {
        var where = "u.web_id = ? AND u.server = ?";
        var whereValues = [webId, server];

        return findRowWithRawWhere(where, whereValues);
    }

    function getLastActiveUser() {
        var where = "u.last_active = ?";
        var whereValues = [1];

        var user;
        var dfd = $q.defer();

        findRowWithRawWhere(where, whereValues)
            .then(function (foundUser) {
                user = foundUser;
                if (user) {
                    return getUserGroups(user.web_id);
                } else {
                    dfd.resolve(user);
                }
            }, function (error) {
                dfd.reject(error);
            })
            .then(function (groups) {
                console.log(groups);
                if (user) {
                    user.groups = groups;
                }
                dfd.resolve(user);
            }, function (error) {
                dfd.reject(error);
            })
            ;

        return dfd.promise;
    }

    function resetActiveUsers() {
        var update = {
            last_active: 0
        };

        var where = {
            last_active: 1
        };

        DataAccessObject.update(TABLE, update, where);
    }

    function findRowWithRawWhere(whereRaw, whereValues) {

        var query = "SELECT * FROM Users WHERE " + whereRaw;

        var dfd = $q.defer();

        DataAccessObject.rawQuery(query, whereValues)
            .then(function (users) {
                if (users.length > 0) {
                    dfd.resolve(users[0]);
                } else {
                    //  user not found
                    console.warn("User not found using where: " + whereRaw + " - " + JSON.stringify(whereValues));
                    dfd.resolve(null);
                }
            }, function (error) {
                dfd.reject(error);
            })
            ;

        return dfd.promise;
    }

    function insert(user) {

        return DataAccessObject.insert(TABLE, user)
            .then(function (res) {
                console.log(TABLE + " insertId: " + res.insertId);
                user.id = res.insertId;
                return user;
            }, function (err) {
                console.error(err);
                console.error("Failed query: " + DataAccessObject.getLastQuery());
            });

    }

    function update(user, where) {
        return DataAccessObject.update(TABLE, user, where)
            .then(function (res) {
                return user;
            }, function (err) {
                console.error(err);
                console.error("Failed query: " + DataAccessObject.getLastQuery());
            });
    }

    return {
        find: find,
        getLastActiveUser: getLastActiveUser,
        resetActiveUsers: resetActiveUsers,
        insert: insert,
        update: update
    };

};
