<%-- 
    Document   : create2
    Created on : Mar 21, 2016, 8:12:25 PM
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
        Inventory
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
        <script src="<c:url value="/resources/js/pages/items/edit.js" />"></script>        
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

                    <div class="col-md-12">
                        <form:form class="form-horizontal" action="/items" method="POST" modelAttribute="item">
                            <div class="box box-info">
                                <div class="box-header with-border">
                                    <h3 class="box-title">Item Details</h3>
                                </div>
                                <div class="box-body">
                                    <div class="row">
                                        <div class="col-md-8">                                        
                                            <jsp:include page="item-form-fields.jsp"/>
                                        </div>

                                        <!--Right text-->
                                        <div class="col-md-4">
                                            <h3>Item Details</h3>

                                            <p>
                                                Enter your item name, type and supplier details.
                                            </p>

                                            <p>
                                                You can also add tags to help searching and reporting on this product later.
                                            </p>
                                        </div>
                                    </div>

                                </div>                               
                            </div>
                        </form:form>
                    </div>                    
                </div>                                           

                <div class="row" id="variant-editor-container">
                    <a name="variant"></a>
                    <div class="col-md-12">  
                        <div class="box box-info">
                            <div class="box-header with-border">
                                <h3 class="box-title">Create Variant</h3>
                                <div class="box-tools pull-right">                                    
                                    <!--<button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>-->
                                </div>
                            </div>
                            <div class="box-body">
                                <div class="col-md-8">                                    
                                    <jsp:include page="item-variant-form.jsp" >                                        
                                        <jsp:param name="isDefault" value="${true}" />
                                    </jsp:include>

                                    TODO: Stock locations

                                </div>

                                <div class="col-md-4">
                                    <h3>Variant Details</h3>

                                    <p>
                                        Each item must at least have 1 variant.
                                    </p>

                                    <p>
                                        Check default to make this variant the default variant.
                                        The first variant is automatically set as the default variant.
                                    </p>

                                    <p>
                                        Variants can be sold or bought, specify the prices.
                                    </p>
                                </div>
                            </div>                            
                        </div>                    
                    </div>
                </div>

                <div class="pull-right">
                    <button id="save" class="btn btn-success">Save and Create New Variant</button>
                    <button id="save-and-new" class="btn btn-info">Save and Create New Item</button>
                </div>
                <div class="clearfix"></div>

            </section>

        </div>
    </jsp:body>       
</t:adminlte>