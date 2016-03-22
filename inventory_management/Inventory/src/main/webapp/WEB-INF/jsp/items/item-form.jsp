<%-- 
    Document   : item-form
    Created on : Mar 22, 2016, 8:07:44 AM
    Author     : Ervinne Sodusta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<form class="form-horizontal">
    <div class="form-group col-sm-12">
        <label class="col-sm-3 control-label" for="name">
            <span class="text-red">*</span> <span>Item Name</span>
        </label>

        <div class="col-sm-6">
            <input id="name" class="form-control" placeholder="e.g. Black Forest Cake" type="text">
        </div>
    </div>    
    <div class="form-group col-sm-12">
        <label class="col-sm-3 control-label" for="name">
            <span class="text-red">*</span> <span>Unit of Measurement</span>
        </label>

        <div class="col-sm-6">
            <select id="uom" class="select2">
                <option value="0" disabled selected></option>
                <option value="1">Unit(s)</option>
                <option value="2">PC(s)</option>
            </select>
        </div>
    </div>
    <div class="form-group col-sm-12">                                            
        <div class="col-sm-6 col-sm-offset-3">
            <input id="can-be-purchased" class="icheck" type="checkbox"> Can be purchased?
        </div>                                            
    </div>
    <div class="form-group col-sm-12">                                            
        <label class="col-sm-3 control-label" for="vendor">
            Vendor
        </label>

        <div class="col-sm-6">
            <!--http://businessdiary.com.ph/2525/baking-and-confectionery-supplies/-->
            <select id="vendor" class="select2">
                <option value="0" disabled selected></option>
                <option value="2">Alter Trade Corp.</option>
                <option value="3">Chocolate Lover Inc.</option>
                <option value="4">Everwealth Commercial</option>
                <option value="5">Gourdo’s Retail Cafe</option>
                <option value="6">Link Inport Export Enterprises Inc.</option>
                <option value="7">Mokkilato</option>
                <option value="8">MOTZ Food Products</option>
                <option value="9">PENCO Inc.</option>
                <option value="10">RMC Bakery Equipment and Supply</option>
                <option value="11">Sta. Maria Dairy Farmers MPC</option>
                <option value="12">Sweetcraft Baking and Confectionery Supplies</option>
                <option value="13">Sweetlink Inc.</option>
                <option value="14">Theobroma</option>
                <option value="15">Virgie’s Homemade Products</option>
                <option value="16">Wellman Trading</option>
            </select>
        </div>

        <label class="col-sm-3 control-label-right">
            or <a href="#">Create a new vendor</a>
        </label>
    </div>                                           

    <div class="form-group col-sm-12">                                            
        <label class="col-sm-3 control-label">
            Tags
        </label>

        <div class="col-sm-6">                                                    
            <select id="tags" class="select2" multiple="multiple">
                <option value="1" disabled></option>
                <option value="2">Bread</option>
                <option value="3">Cakes</option>
                <option value="4">Sweets</option>
            </select>
        </div>

        <label class="col-sm-3 control-label-right">
            or <a href="#">Create a tag</a>
        </label>
    </div>

    <div class="form-group col-sm-12">                                            
        <label class="col-sm-3 control-label">
            Description
        </label>

        <div class="col-sm-6">                                                    
            <textarea class="form-control"></textarea>
        </div>
    </div>
</form>