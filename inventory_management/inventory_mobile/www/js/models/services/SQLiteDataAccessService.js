/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var SQLiteDataAccessService = function ($cordovaSQLite, $http, $q) {

    var DB_CONFIG = {
        name: "inventory.db",
        version: "1.0"
    };

    var database;

    this.initializeDatabase = function () {

        var dfd = $q.defer();

        try {
            if (window.cordova) {
                //  use device file system for database
                database = $cordovaSQLite.openDB(DB_CONFIG.name);
            } else {
                //  use browser for database
                database = window.openDatabase(DB_CONFIG.name, DB_CONFIG.version, 'database', -1);
            }

            $http.get('assets/create_tables.sql').then(function (response) {
                var queries = response.data.split(';');
                for (var i in queries) {
                    if (queries[i]) {
                        $cordovaSQLite.execute(database, queries[i])
                            .then(function (result) {
//                                    console.log('Executed: ' + queries[i]);
//                                    console.log(result);
                                dfd.resolve(result);
                            }, function (error) {
                                console.error(error);
                                dfd.reject(error);
                            });
                    }
                }

            }, function (error) {
                console.error(error);
                dfd.reject(error);
            });
        } catch (e) {
            console.error('DataAccessService', 'Failed to open database ' + DB_CONFIG.name + ': ' + e);
            dfd.reject(e);
        }

        return dfd.promise;

    };

    this.onUpgrade = function (database) {
        database.transaction(function (tx) {
            tx.executeSql("DROP TABLE IF EXISTS Users");
        });
    };

    this.getDatabase = function () {
        if (database) {
            return database;
        } else {
            throw "Database not yet initialized!";
        }

    };

};