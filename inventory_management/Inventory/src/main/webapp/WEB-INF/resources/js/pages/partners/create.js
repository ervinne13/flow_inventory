/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global form_utils */

(function () {

    $(document).ready(function () {
        initializeComponents();
        initializeEvents();
    });

    function initializeComponents() {

        //  all select2
        $('.select2').select2();

    }

    function initializeEvents() {
        $('#save-partner').click(function () {
            savePartner();
        });
    }

    function savePartner() {
        console.log(form_utils.getInputsInsideElement('#partner-form-fields-container'));
    }

})();