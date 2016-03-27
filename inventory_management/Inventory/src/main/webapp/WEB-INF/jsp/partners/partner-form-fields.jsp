<%-- 
    Document   : partner-form
    Created on : Mar 22, 2016, 11:23:45 AM
    Author     : Ervinne Sodusta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<div id="partner-form-fields-container" class="form-horizontal">
    <div class="form-group col-sm-12">
        <label class="col-sm-3 control-label" for="name">
            <span class="text-red">*</span> <span>Partner Name</span>
        </label>

        <div class="col-sm-6">
            <form:input id="name" name="name" class="form-control" placeholder="e.g. Alter Trade Corp." type="text" path="name" />
        </div>
    </div>

    <div class="form-group col-sm-12">
        <label class="col-sm-3 control-label" for="primary-contact">
            <span>Primary Contact Number</span>
        </label>

        <div class="col-sm-6">
            <form:input  id="primary-contact" name="primary_contact" class="form-control" placeholder="" type="text" path="primaryContact"  />
        </div>
    </div>


    <div class="form-group col-sm-12">
        <div class="col-sm-3 col-sm-offset-3">
            <form:checkbox id="vendor" class="icheck" path="vendor"/> Vendor?
        </div>
        <div class="col-sm-3">
            <form:checkbox id="customer" class="icheck" path="customer" /> Customer?
        </div>   
    </div>

</div>
