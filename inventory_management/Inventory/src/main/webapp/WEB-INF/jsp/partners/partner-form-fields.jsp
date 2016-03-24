<%-- 
    Document   : partner-form
    Created on : Mar 22, 2016, 11:23:45 AM
    Author     : Ervinne Sodusta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div id="partner-form-fields-container" class="form-horizontal">
    <div class="form-group col-sm-12">
        <label class="col-sm-3 control-label" for="name">
            <span class="text-red">*</span> <span>Partner Name</span>
        </label>

        <div class="col-sm-6">
            <input id="name" name="name" class="form-control" placeholder="e.g. Alter Trade Corp." type="text">
        </div>
    </div>

    <div class="form-group col-sm-12">
        <label class="col-sm-3 control-label" for="primary-contact">
            <span>Contact Number</span>
        </label>

        <div class="col-sm-6">
            <input id="primary-contact" name="primary_contact" class="form-control" placeholder="" type="text">
        </div>
    </div>

    <div class="form-group col-sm-12">                                            
        <label class="col-sm-3 control-label" for="vendor">
            Type
        </label>

        <div class="col-sm-6">            
            <select id="partner-type" name="partner_type_id" class="select2">                
                <option value="2">Company</option>
                <option value="1">Individual</option>
            </select>
        </div>
    </div>
</div>
