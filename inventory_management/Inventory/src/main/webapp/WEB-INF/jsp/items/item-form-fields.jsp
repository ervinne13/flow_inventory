<%-- 
    Document   : item-form
    Created on : Mar 22, 2016, 8:07:44 AM
    Author     : Ervinne Sodusta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

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
        <form:select 
            id="uom" 
            name="uom_id" 
            class="select2" 
            path="uom"
            items="${uomList}" 
            itemValue="id" 
            itemLabel="name"
            />
    </div>

</div>
<div class="form-group col-sm-12">                                            
    <div class="col-sm-4 col-sm-offset-3">
        <input id="can-be-purchased" class="icheck" type="checkbox"> Can be purchased?
    </div>
    <div class="col-sm-4">
        <input id="can-be-sold" class="icheck" type="checkbox"> Can be sold?
    </div>
</div>
<div class="form-group col-sm-12">                                            
    <label class="col-sm-3 control-label" for="vendor">
        Vendor
    </label>

    <!--http://businessdiary.com.ph/2525/baking-and-confectionery-supplies/-->
    <div class="col-sm-6">            
        <form:select 
            id="vendor" 
            name="vendor" 
            class="select2" 
            path="vendor"
            items="${vendorList}" 
            itemValue="id" 
            itemLabel="name"
            />
    </div>

    <label class="col-sm-3 control-label-right">
        or <a href="<c:url value="/partners/create"/>" target="_blank">Create a new vendor</a>
    </label>
</div>                                           

<!--<div class="form-group col-sm-12">                                            
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
</div>-->

<div class="form-group col-sm-12">                                            
    <label class="col-sm-3 control-label">
        Description
    </label>

    <div class="col-sm-6">                                                    
        <textarea class="form-control"></textarea>
    </div>
</div>