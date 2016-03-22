<%-- 
    Document   : partner-form
    Created on : Mar 22, 2016, 11:23:45 AM
    Author     : Ervinne Sodusta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<form class="form-horizontal">
    <div class="form-group col-sm-12">
        <label class="col-sm-3 control-label" for="name">
            <span class="text-red">*</span> <span>Partner Name</span>
        </label>

        <div class="col-sm-6">
            <input id="name" class="form-control" placeholder="e.g. Alter Trade Corp." type="text">
        </div>
    </div>

    <div class="form-group col-sm-12">                                            
        <label class="col-sm-3 control-label" for="vendor">
            Type
        </label>

        <div class="col-sm-6">            
            <select id="partner-type" class="select2">                
                <option value="2">Company</option>
                <option value="1">Individual</option>
            </select>
        </div>
    </div>

</form>