/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var form_utils = {};

form_utils.getInputsInsideElement = function (selector) {

    var inputsSelector = $(selector + " :input")
        .not(':input[type=button], :input[type=submit], :input[type=reset]');

    var data = {};

    $(inputsSelector).each(function () {
        data[$(this).attr('name')] = $(this).val();
    });

    return data;

};