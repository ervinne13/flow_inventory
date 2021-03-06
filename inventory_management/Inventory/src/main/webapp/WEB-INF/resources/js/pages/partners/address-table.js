/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global Tabledit */

var address_table = {};

(function (address_table) {

    var lastUsedTemporaryId = 0;
    var $addressTable;

    var editableRows = [
        [1, 'label'],
        [2, 'address'],
        [3, 'city'],
        [4, 'email'],
        [5, 'zip'],
        [6, 'phone'],
        [7, 'notes']
    ];

    $(document).ready(function () {
        setupEditableTable();
        initializeEvents();
    });

    function setupEditableTable() {

        $addressTable = $('#address-table').Tabledit({
            hideIdentifier: true,
            autoFocus: true,
            onEnterBehavior: 'FOCUS_NEXT_FIELD',
            columns: {
                identifier: [0, 'id'],
                editable: editableRows
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

        var rowHtmlString = '<tr class="temp-row">';

        //  TODO: move this to an html template later
        lastUsedTemporaryId++;
        rowHtmlString += '<td>' + lastUsedTemporaryId + "</td>"; // Id

        for (var i in editableRows) {
            rowHtmlString += "<td></td>";   //  add in blank columns
        }

        rowHtmlString += "</tr>";

        $('#address-table > tbody').append(rowHtmlString);
        $addressTable.notifyDataSetChanged('edit');

    }

    //  public members
    address_table.getTableData = function () {
        return $addressTable.getTableData();
    };

})(address_table);