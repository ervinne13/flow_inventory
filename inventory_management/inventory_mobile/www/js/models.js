/* global angular, SQLiteDataAccessService, LocalDataAccessService, SessionManagementService, StartupService, UsersAPI, DataAccessObject, UsersDAO */

angular.module('starter.models', ['ionic', 'ngCordova'])

    //  Services
    .service('StartupService', [
        '$state', '$rootScope', '$cordovaSplashscreen', 'SQLiteDAS', 'Session', StartupService
    ])

    .service('SQLiteDAS', ['$cordovaSQLite', '$http', '$q', SQLiteDataAccessService])

    .service('LocalDAS', ['$window', LocalDataAccessService])

    .service('Session', [
        'LocalDAS', 'UsersAPI', 'UsersDAO', '$q', SessionManagementService
    ])

    //  <editor-fold desc="API" defaultstate="collapsed">

    .factory('UsersAPI', ['$http', '$q', UsersAPI])

    //  </editor-fold>

    //  <editor-fold desc="DAO" defaultstate="collapsed">

    .factory('DataAccessObject', ['SQLiteDAS', '$cordovaSQLite', '$q', DataAccessObject])
    .factory('UsersDAO', ['DataAccessObject', '$q', UsersDAO])

    //  </editor-fold>

    ;