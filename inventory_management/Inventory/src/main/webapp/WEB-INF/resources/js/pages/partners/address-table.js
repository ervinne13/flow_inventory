/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function () {

    var $addressTable;
    var typeOptions = {primary: "Primary", billing: "Billing", other: "Other"};

    $(document).ready(function () {
        setupEditableTable();
        initializeEvents();
    });

    function setupEditableTable() {

        $addressTable = $('#address-table').Tabledit({
            hideIdentifier: true,
            autoFocus: true,
            columns: {
                identifier: [0, 'id'],
                editable: [
                    [1, 'type', typeOptions],
                    [2, 'email'],
                    [3, 'phone'],
                    [4, 'address_1'],
                    [5, 'address_2'],
                    [6, 'website'],
                    [7, 'notes']
                ]
            },
            onAjax: function (action, serialize, unserialized) {
                console.log(action);
                console.log(unserialized);

                //  disable automatic ajax handle
                return false;
            }
        });
    }

    function initializeEvents() {
        $('#add-address').click(addBlankAddress);
    }

    function addBlankAddress() {

        $addressTable.addRow();

//        $('#address-table tbody').append('<tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>');
//        setupEditableTable();
    }

})();