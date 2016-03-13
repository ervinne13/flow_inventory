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
    <jsp:attribute name="bodyImports">
        <!-- AdminLTE dashboard demo (This is only for demo purposes) -->
        <script src="<c:url value="/resources/lib/AdminLTE/js/pages/dashboard2.js" />"></script>
        <!-- AdminLTE for demo purposes -->
        <script src="<c:url value="/resources/lib/AdminLTE/js/demo.js"/>"></script>
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

                <div class="row">
                    <!-- Main Info col -->
                    <div class="col-md-6">  
                        <div class="box box-info">
                            <div class="box-header with-border">
                                <h3 class="box-title">Item Details</h3>
                            </div>
                            <div class="box-body">
                                <div class="row">
                                    <div class="col-md-12">
                                        <form:form id="loginForm" method="post" action="items" modelAttribute="itemBean">
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
                                        </form:form>
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
                                </div>
                            </div>
                        </div>                        
                    </div>
                </div>

            </section>

        </div>
    </jsp:body>       
</t:adminlte>