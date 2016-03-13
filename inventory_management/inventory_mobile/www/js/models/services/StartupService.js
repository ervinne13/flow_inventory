
var StartupService = function ($state, $rootScope, $cordovaSplashscreen, SQLiteDAS, Session) {

    function startup() {

        SQLiteDAS.initializeDatabase()
            .then(function () {
                var callbacks = new SessionInitializationCallbacks();

                callbacks.onNoLocalCredentialsFound = function () {
                    $state.go('login');
                    finishStartup();
                };

                callbacks.onLocalCredentialsFailedLogin = function () {
                    //  TODO: change to tab.home later when offline mode is stable
                    $state.go('login');
                    finishStartup();
                };

                callbacks.onLoginSuccess = function (activeUser) {
                    finishStartup();
                    console.log('Auto logged in');
                    console.log(activeUser);
                    startSyncService();
                };

                callbacks.onNoConnectivity = function () {
                    //  offline mode
                    finishStartup();
                };

                Session.initialize(callbacks);

            });

        // listen for Online event
        $rootScope.$on('$cordovaNetwork:online', function (event, networkState) {
            console.log(event);
            console.log(networkState);
        });

        // listen for Offline event
        $rootScope.$on('$cordovaNetwork:offline', function (event, networkState) {
            console.log(event);
            console.log(networkState);
        });

//    $state.go('tab.profile');
    }

    function finishStartup() {
        try {
            console.log('closing splash');
            $cordovaSplashscreen.hide();
        } catch (e) {

        }
    }

    function startSyncService() {
        //  TODO: Sychronize here
    }

    return {
        startup: startup,
        startSyncService: startSyncService
    };

};
