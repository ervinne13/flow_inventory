/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var baseUrl;

//  TODO: put these to meta instead
var partnerTypes = [{id: 1, desc: "Individual"}, {id: 2, desc: "Company"}]
var addressTypes = [
    {id: 1, desc: "Primary Address"},
    {id: 2, desc: "Invoice Address"},
    {id: 3, desc: "Shipping Address"},
    {id: 4, desc: "Other Address"},
];

$(document).ready(function () {
    baseUrl = $('meta[name=base-url]').attr('content');
});

//  Check/uncheck icheck fields
$('.icheck').on('ifChecked', function (event) {
    $(this).parent().find('input[type="checkbox"]').val(true);
});

$('.icheck').on('ifUnchecked', function (event) {
    $(this).parent().find('input[type="checkbox"]').val(false);
});