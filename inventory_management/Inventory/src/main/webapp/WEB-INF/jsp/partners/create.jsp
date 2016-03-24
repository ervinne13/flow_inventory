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
        <link rel="stylesheet" href="<c:url value="/resources/plugins/select2/select2.min.css"/>">        

        <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>">
    </jsp:attribute>
    <jsp:attribute name="bodyImports">
        <script src="<c:url value="/resources/plugins/iCheck/icheck.min.js" />"></script>
        <script src="<c:url value="/resources/plugins/select2/select2.min.js" />"></script>

        <script src="<c:url value="/resources/plugins/tabledit/jquery.tabledit.js" />"></script>        

        <script src="<c:url value="/resources/js/form-utils.js" />"></script>        

        <script src="<c:url value="/resources/js/pages/partners/create.js" />"></script>        
        <script src="<c:url value="/resources/js/pages/partners/address-table.js" />"></script>        
    </jsp:attribute>
    <jsp:body>
        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>
                    Create Partner
                </h1>
                <ol class="breadcrumb">                    
                    <li><a href="<c:url value="/partners" />"><i class="fa fa-group"></i>partners</a></li>
                    <li class="active">Create</li>
                </ol>
            </section>

            <!-- Main content -->
            <section class="content">

                <div class="row">
                    <div class="col-md-12">                          
                        <div class="box box-info">
                            <div class="box-header with-border">
                                <h3 class="box-title">Item Details</h3>
                            </div>
                            <div class="box-body">
                                <div class="row">
                                    <div class="col-md-8">                                        
                                        <jsp:include page="partner-form-fields.jsp"/>
                                    </div>

                                    <!--Right text-->
                                    <div class="col-md-4">
                                        <h3>Partner Details</h3>

                                        <p>
                                            Enter the partner's details here.
                                        </p>

                                        <p>
                                            Fill up his addresses and contact information below.
                                        </p>
                                    </div>
                                </div>

                                <hr>

                                <div class="row">
                                    <div class="col-md-12">
                                        <jsp:include page="address-table.jsp"/>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-md-12">
                                        <button id="add-address" class="btn-link center-block"><i class="fa fa-plus"></i> Add Address</button>
                                    </div>
                                </div>
                            </div>
                            <div class="box-footer">
                                <div>
                                    <button id="save-partner" class="pull-right btn btn-success">Save</button>
                                    <button id="clear-partner" class="pull-left btn btn-default">Clear</button>
                                </div>
                            </div>
                        </div>                       
                    </div>                    
                </div>

            </section>

        </div>
    </jsp:body>       
</t:adminlte>