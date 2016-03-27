/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global form_utils, address_table, baseUrl, partnerTypes, contacts_table */

(function () {

    $(document).ready(function () {
        initializeComponents();
        initializeEvents();
    });

    function initializeComponents() {

        //  all select2
        $('.select2').select2();

        $('.icheck').iCheck({
            checkboxClass: 'icheckbox_square-blue',
            radioClass: 'iradio_square-blue',
            increaseArea: '20%' // optional
        });

    }

    function initializeEvents() {
        $('#save-partner').click(function () {
            savePartner();
        });

        $('#update-partner').click(function () {
            savePartner('EDIT');
        });
    }

    function enableActionButtons(enable) {
        if (enable) {
            $('#save-partner').removeAttr('disabled');
            $('#update-partner').removeAttr('disabled');
        } else {
            $('#save-partner').attr('disabled', 'disabled');
            $('#update-partner').attr('disabled', 'disabled');
        }
    }

    function getCurrentPartnerId() {
        return $('meta[name=partner-id]').attr('content');
    }

    function savePartner(mode) {
        var partner = form_utils.getInputsInsideElement('#partner-form-fields-container');
        partner.partnerAccountingDetails = [];
        partner.addressList = address_table.getTableData();
        partner.contactList = contacts_table.getTableData();

        console.log(partner);

        var url;
        var method;

        if (mode == 'EDIT') {
            var currentPartnerId = getCurrentPartnerId();

            url = baseUrl + "partners/" + currentPartnerId + "?responseType=json";
//            partner["_method"] = "PUT"; //  immitate a put request
            method = "PUT";
        } else {
            url = baseUrl + "partners?responseType=json";
            method = "POST";
        }

        $.ajax({
            headers: {
                Accept: 'application/json',
                'Content-Type': 'application/json'
            },
            type: method,
            url: url,
            data: JSON.stringify(partner),
            dataType: 'json',
            success: function (response) {
                console.log(response);
                enableActionButtons(true);

                location.href = baseUrl + "partners/edit/" + response.id;
            }
        });

        enableActionButtons(false);

    }

})();