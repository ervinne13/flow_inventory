<%-- 
    Document   : item-variant
    Created on : Mar 22, 2016, 8:04:24 AM
    Author     : Ervinne Sodusta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<form>
    <div class="row">
        <div class="form-group col-sm-12">                                            
            <label class="col-sm-3 control-label">
                <span class="text-red">*</span> <span>Variant Name</span>
            </label>

            <div class="col-sm-6">
                <input id="name" class="form-control" placeholder="e.g. Black Forest Cake w/ Cherry" type="text">
            </div>
            <div class="col-sm-3">
                <input class="icheck" type="checkbox"> Default?
            </div>  
        </div>
    </div>

    <div class="row">
        <div class="form-group col-sm-12">                                            
            <label class="col-sm-3 control-label">
                <span class="text-red">*</span> <span>SKU</span>
            </label>

            <div class="col-sm-6">
                <input id="sku" class="form-control" placeholder="e.g. BF-Cherry" type="text">
            </div>                                   
        </div>
    </div>

    <div class="row">
        <div class="form-group col-sm-12">                                            
            <label class="col-sm-3 control-label">
                Supplier Code
            </label>

            <div class="col-sm-6">
                <input id="supplier-code" class="form-control" placeholder="" type="text">
            </div>
        </div>
    </div>

    <div class="row">
        <div class="form-group col-sm-12">
            <div class="col-sm-3">
                <label class="control-label">Wholesale Price</label>
                <input id="wholesale-price" class="form-control" placeholder="PHP" type="number">
            </div>

            <div class="col-sm-3">
                <label class="control-label">Retail Price</label>
                <input id="retail-price" class="form-control" placeholder="PHP" type="number">
            </div>

            <div class="col-sm-3">
                <label class="control-label">Purchase Price</label>
                <input id="purchase-price" class="form-control" placeholder="PHP" type="number">
            </div>                                       
        </div>
    </div>

    <div class="row">
        <div class="form-group col-sm-12">                                            
            <div class="col-sm-3">
                <input id="expires" class="icheck" type="checkbox"> Expires/Spoils?
            </div>
            <div class="col-sm-6">
                <input id="expire-days" class="form-control" placeholder="Expires in number of days" type="number">
            </div>
        </div>
    </div>

</form>
