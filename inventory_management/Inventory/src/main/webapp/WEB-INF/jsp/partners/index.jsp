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
            <!-- Main content -->
            <section class="content">
                <div class="row">
                    <div class="col-md-12">                          
                        <div class="box box-info">
                            <div class="box-header with-border">
                                <h3 class="box-title">Partners</h3>
                            </div>
                            <div class="box-body">
                                <div class="row">
                                    <div class="col-md-8">
                                        <jsp:include page="partners-table.jsp"/>
                                    </div>

                                    <!--Right text-->
                                    <div class="col-md-4">
                                        <h3>Setup your partners</h3>

                                        <p>
                                            Customers are used for Sales Orders, while Vendors are used in Purchase Orders.                                             
                                        </p>

                                        <a class="btn btn-info" href="<c:url value="/partners/create"/>">
                                            <i class="fa fa-plus"></i> <span>Create a New Partner</span>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>                       
                    </div>                    
                </div>
            </section>

        </div>
    </jsp:body>       
</t:adminlte>