
//  Stateless
var UsersAPI = function ($http, $q) {

    function login(server, email, password) {

        var url = prependHttp(server) + '/api/login';
        var data = {
            email: email,
            password: password
        };

        var req = {
            method: 'POST',
            url: url,
            data: Object.toParams(data),
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        };

        return $http(req)
            .then(function (response) {
                console.log(response);
                if (isAPIResponseSuccess(response)) {
                    return response.data;
                } else {
                    return $q.reject(response.data);
                }

            }, function (error) {
                console.log(error);
                return $q.reject(error);
            });

    }

    function prependHttp(server) {
        if (server && server.indexOf("http://") === -1) {
            server = "http://" + server;
        }

        return server;
    }

    return {
        login: login,
        prependHttp: prependHttp
    };

};
