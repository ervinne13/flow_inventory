/* global angular, SQLiteDataAccessService, LocalDataAccessService, SessionManagementService */

angular.module('starter.models', ['ionic', 'ngCordova'])

    .service('StartupService', [
        '$state', '$rootScope', '$cordovaSplashscreen', 'SQLiteDAS', 'Session', StartupService
    ])

    .service('SQLiteDAS', ['$cordovaSQLite', '$http', '$q', SQLiteDataAccessService])

    .service('LocalDAS', ['$window', LocalDataAccessService])

    .service('Session', [
        'LocalDAS', 'UsersAPI', 'UsersDAO', 'CompaniesDAO', 'GroupsDAO', '$q',
        SessionManagementService
    ]);