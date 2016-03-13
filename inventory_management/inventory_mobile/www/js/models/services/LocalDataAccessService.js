/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var LocalDataAccessService = function ($window) {

    this.set = function (key, value) {
        $window.localStorage[key] = value;
    };

    this.get = function (key, defaultValue) {
        return $window.localStorage[key] || defaultValue;
    };

    this.setObject = function (key, value) {
        $window.localStorage[key] = JSON.stringify(value);
    };

    this.getObject = function (key) {

        if (key === "active_user") {
            console.log(JSON.parse($window.localStorage[key] || '{}'));
        }

        return JSON.parse($window.localStorage[key] || '{}');
    };

    this.clear = function () {
        $window.localStorage.clear();
    };

};