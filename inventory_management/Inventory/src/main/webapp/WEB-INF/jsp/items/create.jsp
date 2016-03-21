<%-- 
    Document   : create
    Created on : Mar 13, 2016, 5:33:57 PM
    Author     : Ervinne Sodusta
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


<t:adminlte>
    <jsp:attribute name="pageTitle">
        Inventory | Admin
    </jsp:attribute>
    <jsp:attribute name="skin">
        skin-purple
    </jsp:attribute>
    <jsp:attribute name="headImports">
        <link rel="stylesheet" href="<c:url value="/resources/plugins/iCheck/square/blue.css"/>">
    </jsp:attribute>
    <jsp:attribute name="bodyImports">
        <script src="<c:url value="/resources/plugins/iCheck/icheck.min.js" />"></script>
        <script src="<c:url value="/resources/js/pages/items/create.js" />"></script>        
    </jsp:attribute>
    <jsp:body>
        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>
                    Create Item                    
                </h1>
                <ol class="breadcrumb">
                    <li><a href="#"><i class="fa fa-dashboard"></i>Items</a></li>
                    <li class="active">Create</li>
                </ol>
            </section>

            <!-- Main content -->
            <section class="content">

                <form:form id="create-item-form" method="POST" action="${pageContext.request.contextPath}/items" modelAttribute="itemBean">
                    <div class="row">
                        <!-- Main Info col -->
                        <div class="col-md-8">  
                            <div class="box box-info">
                                <div class="box-header with-border">
                                    <h3 class="box-title">Item Details</h3>
                                </div>
                                <div class="box-body">
                                    <div class="row">
                                        <div class="col-md-12">                                        
                                            <div class="form-group has-feedback">                                                
                                                <label>Item Name</label>
                                                <b>
                                                    <form:input id="name" name="name" path="name" type='text' class='form-control'/>
                                                </b>                                                                     
                                            </div>
                                            <div class="form-group has-feedback">
                                                <label>Unit of Measurement</label>

                                                <select class="form-control">
                                                    <c:forEach items="${uomList}" var="uom">
                                                        <option value="${uom.id}">${uom.name}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <!-- Selling Info col -->
                        <div class="col-md-4">  
                            <div class="box box-info">
                                <div class="box-header with-border">
                                    <h3 class="box-title">Selling Details</h3>
                                </div>
                                <div class="box-body">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="checkbox icheck">
                                                <label>
                                                    <input name="isCanBeSold" type="checkbox"> Can Be Sold
                                                </label>
                                            </div>
                                            <div class="form-group">                                                
                                                <label>Sale Value</label>
                                                <b>
                                                    <form:input id="saleValue" name="saleValue" path="saleValue" type='numeric' class='form-control'/>
                                                </b>                                                                     
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>                        
                        </div>
                        <!-- Purchasing Info col -->
                        <div class="col-md-4">  
                            <div class="box box-info">
                                <div class="box-header with-border">
                                    <h3 class="box-title">Purchasing Details</h3>
                                </div>
                                <div class="box-body">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="checkbox icheck">
                                                <label>
                                                    <input name="can_be_purchased" type="checkbox"> Can Be Purchased
                                                </label>
                                            </div>
                                            <div class="form-group">                                                
                                                <label>Purchase Value</label>
                                                <b>
                                                    <form:input id="purchaseValue" name="purchaseValue" path="purchaseValue" type='numeric' class='form-control'/>
                                                </b>                                                                     
                                            </div>
                                            <select name="vendor_id" class="form-control">
                                                <option value="0" disabled></option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </div>                        
                        </div>                        
                    </div>
                    <div class="row">
                        <div class="col-lg-8">
                            <div class="pull-right">                        
                                <button type="submit" class="btn btn-primary btn-block btn-flat">Create</button>
                            </div>
                        </div>
                    </div>
                </form:form>

            </section>

        </div>
    </jsp:body>       
</t:adminlte>