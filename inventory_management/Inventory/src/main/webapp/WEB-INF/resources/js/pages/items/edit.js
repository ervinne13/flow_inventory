/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function () {

    //  Fields
    var $vendorSelectField;

    $(document).ready(function () {
        $('.item-variants-container').css('display', 'none');

        initializeComponents();
        initializeEvents();

    });

    function initializeComponents() {

        //  all select2
        $('.select2').select2();

        //  initialize vendor to blank and the item can-be-purchased = false
        $vendorSelectField = $('select#vendor').select2();
        setCanBePurchased(false);

        $('.icheck').iCheck({
            checkboxClass: 'icheckbox_square-blue',
            radioClass: 'iradio_square-blue',
            increaseArea: '20%' // optional
        });

    }

    function initializeEvents() {

        $('#can-be-purchased').on('ifChecked', function () {
            setCanBePurchased(true);
        });

        $('#can-be-purchased').on('ifUnchecked', function () {
            setCanBePurchased(false);
        });

    }

    function setCanBePurchased(canBePurchased) {
        //  TODO: set can be purchased to unchecked here
        $('select#vendor').prop('disabled', !canBePurchased);

        if (!canBePurchased) {
            //  remove selected
            $vendorSelectField.val(0).trigger('change');
        }
    }

    function saveItemHeader() {
        
    }

})();