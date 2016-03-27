/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var contacts_table = {};

(function (contacts_table) {

    var lastUsedTemporaryId = 0;
    var $contactsTable;

    var editableRows = [
        [1, 'name'],
        [2, 'email'],
        [3, 'title'],
        [4, 'phone'],
        [5, 'notes']
    ];

    $(document).ready(function () {
        setupEditableTable();
        initializeEvents();
    });

    function setupEditableTable() {

        $contactsTable = $('#contacts-table').Tabledit({
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
        $('#add-contact').click(addBlankContact);
    }

    function addBlankContact() {
        var rowHtmlString = '<tr class="temp-row">';

        //  TODO: move this to an html template later
        lastUsedTemporaryId++;
        rowHtmlString += '<td>' + lastUsedTemporaryId + "</td>"; // Id

        for (var i in editableRows) {
            rowHtmlString += "<td></td>";   //  add in blank columns
        }

        rowHtmlString += "</tr>";

        $('#contacts-table > tbody').append(rowHtmlString);
        $contactsTable.notifyDataSetChanged('edit');
    }

    //  public members
    contacts_table.getTableData = function () {
        return $contactsTable.getTableData();
    };

})(contacts_table);