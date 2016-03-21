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

        <script>
            (function () {

                $(document).ready(function () {
                    $('.icheck').iCheck({
                        checkboxClass: 'icheckbox_square-blue',
                        radioClass: 'iradio_square-blue',
                        increaseArea: '20%' // optional
                    });

                    $(".select2").select2();
                });

            })();
        </script>
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
                        <div class="box box-info">
                            <div class="box-header with-border">
                                <h3 class="box-title">Item Details</h3>
                            </div>
                            <div class="box-body">
                                <div class="row">
                                    <div class="col-md-8">                                        
                                        <form class="form-horizontal">
                                            <div class="form-group col-sm-12">
                                                <label class="col-sm-3 control-label" for="name">
                                                    <span class="text-red">*</span> <span>Item Name</span>
                                                </label>

                                                <div class="col-sm-6">
                                                    <input id="name" class="form-control" placeholder="e.g. Black Forest Cake" type="text">
                                                </div>
                                            </div>
                                            <div class="form-group col-sm-12">                                            
                                                <div class="col-sm-6 col-sm-offset-3">
                                                    <input class="icheck" type="checkbox"> Can be purchased?
                                                </div>                                            
                                            </div>                                        
                                            <div class="form-group col-sm-12">                                            
                                                <label class="col-sm-3 control-label" for="vendor">
                                                    Vendor
                                                </label>

                                                <div class="col-sm-6">
                                                    <!--http://businessdiary.com.ph/2525/baking-and-confectionery-supplies/-->
                                                    <select id="vendor" class="select2">
                                                        <option value="1" disabled></option>
                                                        <option value="2">Alter Trade Corp.</option>
                                                        <option value="3">Chocolate Lover Inc.</option>
                                                        <option value="4">Everwealth Commercial</option>
                                                        <option value="5">Gourdo’s Retail Cafe</option>
                                                        <option value="6">Link Inport Export Enterprises Inc.</option>
                                                        <option value="7">Mokkilato</option>
                                                        <option value="8">MOTZ Food Products</option>
                                                        <option value="9">PENCO Inc.</option>
                                                        <option value="10">RMC Bakery Equipment and Supply</option>
                                                        <option value="11">Sta. Maria Dairy Farmers MPC</option>
                                                        <option value="12">Sweetcraft Baking and Confectionery Supplies</option>
                                                        <option value="13">Sweetlink Inc.</option>
                                                        <option value="14">Theobroma</option>
                                                        <option value="15">Virgie’s Homemade Products</option>
                                                        <option value="16">Wellman Trading</option>
                                                    </select>
                                                </div>

                                                <label class="col-sm-3 control-label-right">
                                                    or <a href="#">Create a new vendor</a>
                                                </label>
                                            </div>                                           

                                            <div class="form-group col-sm-12">                                            
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
                                            </div>

                                            <div class="form-group col-sm-12">                                            
                                                <label class="col-sm-3 control-label">
                                                    Description
                                                </label>

                                                <div class="col-sm-6">                                                    
                                                    <textarea class="form-control"></textarea>
                                                </div>
                                            </div>
                                        </form>
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
                    </div>                    
                </div>               

                <div class="row" class="item-variants-container">
                    <div class="col-md-12">  
                        <div class="box box-info">
                            <div class="box-header with-border">
                                <h3 class="box-title">Item Variants</h3>
                            </div>
                            <div class="box-body">
                                <!--Main Product Details-->
                                <div class="row">
                                    <div class="col-md-12">
                                        <table class="table table-striped">
                                            <thead>
                                                <tr>                                                    
                                                    <th>SKU</th>
                                                    <th>Name</th>
                                                    <th>Wholesale</th>
                                                    <th>SRP</th>
                                                    <th>Purchase</th>
                                                    <th>Available</th>
                                                    <th>On Hand</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>                                                    
                                                </tr>                                               
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>                    
                    </div>
                </div>                               

                <div class="row" id="variant-editor-container">
                    <div class="col-md-12">  
                        <div class="box box-info">
                            <div class="box-header with-border">
                                <h3 class="box-title">Create/Update Variant</h3>
                            </div>
                            <div class="box-body">
                                <div class="col-md-8">                                    
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

                                    <div class="form-group col-sm-12">                                            
                                        <label class="col-sm-3 control-label">
                                            <span class="text-red">*</span> <span>SKU</span>
                                        </label>

                                        <div class="col-sm-6">
                                            <input id="sku" class="form-control" placeholder="e.g. BF-Cherry" type="text">
                                        </div>                                   
                                    </div>

                                    <div class="form-group col-sm-12">                                            
                                        <label class="col-sm-3 control-label">
                                            Supplier Code
                                        </label>

                                        <div class="col-sm-6">
                                            <input id="supplier-code" class="form-control" placeholder="" type="text">
                                        </div>                                   
                                    </div>

                                    <div class="form-group col-sm-12">                                            
                                        <label class="col-sm-3 control-label">
                                            Barcode
                                        </label>

                                        <div class="col-sm-6">
                                            <input id="barcode" class="form-control" placeholder="" type="text">
                                        </div>                                   
                                    </div>

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

                                    TODO: Stock locations
                                    
                                </div>

                                <div class="col-md-4">
                                    <h3>Variant Details</h3>

                                    <p>
                                        Each item must at least have 1 variant.
                                    </p>

                                    <p>
                                        Variants can be sold or bought, specify the prices.
                                    </p>
                                </div>
                            </div>
                        </div>                    
                    </div>
                </div>

            </section>

        </div>
    </jsp:body>       
</t:adminlte>