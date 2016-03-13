<%-- 
    Document   : denied
    Created on : Mar 8, 2016, 8:47:11 AM
    Author     : Ervinne Sodusta
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<style>
    .info-box > span > i {
        /*Center Vertical*/
        position: relative;
        top: 50%;
        transform: translateY(-50%);
    }

    .info-box-text > a {
        color: white;       
    }
</style>

<t:adminlte skin="skin-purple">
    <jsp:attribute name="pageTitle">
        Inventory | Admin
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
                    Dashboard
                    <small>Version 0.1 (Beta)</small>
                </h1>
                <ol class="breadcrumb">
                    <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                    <li class="active">Dashboard</li>
                </ol>
            </section>

            <!-- Main content -->
            <section class="content">

                <!--Monthly Recap-->              
                <!-- Main row -->
                <div class="row">
                    <!-- Left col -->
                    <div class="col-md-8">                        
                        <!--Monthly Recap Report Box-->
                        <div class="box">                           
                            <div class="box-header with-border">
                                <h3 class="box-title">Monthly Recap Report</h3>
                                <div class="box-tools pull-right">
                                    <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                    <div class="btn-group">
                                        <button class="btn btn-box-tool dropdown-toggle" data-toggle="dropdown"><i class="fa fa-wrench"></i></button>
                                        <ul class="dropdown-menu" role="menu">
                                            <li><a href="#">Action</a></li>
                                            <li><a href="#">Another action</a></li>
                                            <li><a href="#">Something else here</a></li>
                                            <li class="divider"></li>
                                            <li><a href="#">Separated link</a></li>
                                        </ul>
                                    </div>
                                    <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                </div>
                            </div><!-- /.box-header -->
                            <div class="box-body">
                                <div class="row">
                                    <div class="col-md-12">
                                        <p class="text-center">
                                            <strong>Production Cost & Value</strong>
                                        </p>
                                        <div class="chart">
                                            <!-- Sales Chart Canvas -->
                                            <canvas id="productionChart" style="height: 180px;"></canvas>
                                        </div><!-- /.chart-responsive -->
                                    </div><!-- /.col -->                                    
                                </div><!-- /.row -->
                            </div><!-- ./box-body -->
                            <div class="box-footer">
                                <div class="row">
                                    <div class="col-sm-3 col-xs-6">
                                        <div class="description-block border-right">
                                            <span class="description-percentage text-blue"><i class="fa fa-caret-down"></i> 5%</span>
                                            <h5 class="description-header">P489,740</h5>
                                            <span class="description-text">Total Production Value</span>
                                        </div><!-- /.description-block -->
                                    </div><!-- /.col -->
                                    <div class="col-sm-3 col-xs-6">
                                        <div class="description-block border-right">
                                            <span class="description-percentage text-yellow"><i class="fa fa-caret-down"></i> 40%</span>
                                            <h5 class="description-header">P349,840</h5>
                                            <span class="description-text">Total Production Cost</span>
                                        </div><!-- /.description-block -->
                                    </div><!-- /.col -->
                                    <div class="col-sm-3 col-xs-6">
                                        <div class="description-block border-right">
                                            <span class="description-percentage text-green"><i class="fa fa-caret-up"></i> 35%</span>
                                            <h5 class="description-header">P139,900</h5>
                                            <span class="description-text">TOTAL PROFIT</span>
                                        </div><!-- /.description-block -->
                                    </div><!-- /.col -->                                    
                                </div><!-- /.row -->
                            </div><!-- /.box-footer -->
                        </div><!-- /.box -->

                        <!-- Table: Latest Orders-->
                        <div class="box box-info">
                            <div class="box-header with-border">
                                <h3 class="box-title">Latest Incoming Orders</h3>
                                <div class="box-tools pull-right">
                                    <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                    <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                </div>
                            </div><!-- /.box-header -->
                            <div class="box-body">
                                <div class="table-responsive">
                                    <table class="table no-margin">
                                        <thead>
                                            <tr>
                                                <th>Order ID</th>
                                                <th>Item</th>
                                                <th>Amount</th>
                                                <th>Status</th>                                                
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td><a href="pages/examples/invoice.html">OR9842</a></td>
                                                <td>Sugar</td>
                                                <td>50 KG</td>
                                                <td><span class="label label-info">Processed</span></td>                                                
                                            </tr>
                                            <tr>
                                                <td><a href="pages/examples/invoice.html">OR9843</a></td>
                                                <td>Flour</td>
                                                <td>60 KG</td>
                                                <td><span class="label label-warning">Processing</span></td>                                                
                                            </tr>
                                            <tr>
                                                <td><a href="pages/examples/invoice.html">OR9847</a></td>
                                                <td>Salt</td>
                                                <td>20 KG</td>
                                                <td><span class="label label-success">Shipped</span></td>                                                
                                            </tr>
                                            <tr>
                                                <td><a href="pages/examples/invoice.html">OR9850</a></td>
                                                <td>Tray</td>
                                                <td>200 PCs</td>
                                                <td><span class="label label-danger">Delivered</span></td>                                                
                                            </tr>
                                            <tr>
                                                <td><a href="pages/examples/invoice.html">OR9858</a></td>
                                                <td>Eggs</td>
                                                <td>100 PCs</td>
                                                <td><span class="label label-success">Shipped</span></td>                                                
                                            </tr>
                                        </tbody>
                                    </table>
                                </div><!-- /.table-responsive -->
                            </div><!-- /.box-body -->
                            <div class="box-footer clearfix">
                                <a href="javascript::;" class="btn btn-sm btn-info btn-flat pull-left">Place New Order</a>
                                <a href="javascript::;" class="btn btn-sm btn-default btn-flat pull-right">View All Orders</a>
                            </div><!-- /.box-footer -->
                        </div><!-- /.box -->
                    </div><!-- /.col -->

                    <div class="col-md-4">
                        <!-- Info Boxes -->                        
                        <div class="info-box bg-red">
                            <span class="info-box-icon"><i class="fa fa-close"></i></span>
                            <div class="info-box-content">
                                <span class="info-box-text"><a href="">Expiry / Spoilage</a></span>
                                <span class="info-box-number">~140</span>
                                <div class="progress">
                                    <div class="progress-bar" style="width: 60%"></div>
                                </div>
                                <span class="progress-description">
                                    Will expire / spoil on the next 30 days                                    
                                </span>
                            </div><!-- /.info-box-content -->
                        </div><!-- /.info-box -->
                        <!-- Info Boxes -->                        
                        <div class="info-box bg-yellow">
                            <span class="info-box-icon"><i class="fa fa-close"></i></span>
                            <div class="info-box-content">
                                <span class="info-box-text"><a href="">Stock Count</a></span>
                                <span class="info-box-number">23 Items</span>                                
                                <span class="progress-description">
                                    ... is low on stock count
                                </span>
                            </div><!-- /.info-box-content -->
                        </div><!-- /.info-box -->
                        <div class="info-box bg-green">
                            <span class="info-box-icon"><i class="fa fa-home"></i></span>
                            <div class="info-box-content">
                                <span class="info-box-text">Production</span>
                                <span class="info-box-number">1,250</span>                         
                                <span class="progress-description">
                                    5% Decrease in 30 Days
                                </span>
                            </div><!-- /.info-box-content -->
                        </div><!-- /.info-box -->
                        <div class="info-box bg-aqua">
                            <span class="info-box-icon"><i class="fa fa-shopping-cart"></i></span>
                            <div class="info-box-content">
                                <span class="info-box-text">Orders</span>
                                <span class="info-box-number">720</span>
                                <span class="progress-description">
                                    40% Decrease in 30 Days
                                </span>
                            </div><!-- /.info-box-content -->
                        </div><!-- /.info-box -->
                        <!-- PRODUCT LIST -->
                        <div class="box box-primary">
                            <div class="box-header with-border">
                                <h3 class="box-title">Recently Produced Products</h3>
                                <div class="box-tools pull-right">
                                    <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                    <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                </div>
                            </div><!-- /.box-header -->
                            <div class="box-body">
                                <ul class="products-list product-list-in-box">
                                    <li class="item">
                                        <div class="product-img">
                                            <img src="<c:url value="/resources/img/loaf.png"/>" alt="">
                                        </div>
                                        <div class="product-info">
                                            <a href="javascript::;" class="product-title">Bread<span class="label label-info pull-right">P30</span></a>
                                            <span class="product-description">
                                                300 PCs Produced 3 days ago
                                            </span>
                                        </div>
                                    </li><!-- /.item -->
                                    <li class="item">
                                        <div class="product-img">
                                            <img src="<c:url value="/resources/img/cake.png"/>" alt="Product Image">
                                        </div>
                                        <div class="product-info">
                                            <a href="javascript::;" class="product-title">9" Ring Black Forest <span class="label label-info pull-right">P350</span></a>
                                            <span class="product-description">
                                                50 PCs Produced 3 days ago
                                            </span>
                                        </div>
                                    </li><!-- /.item -->
                                    <li class="item">
                                        <div class="product-img">
                                            <img src="<c:url value="/resources/img/cake.png"/>" alt="Product Image">
                                        </div>
                                        <div class="product-info">
                                            <a href="javascript::;" class="product-title">9" Ring Double Chocolate <span class="label label-info pull-right">P250</span></a>
                                            <span class="product-description">
                                                50 PCs Produced 3 days ago
                                            </span>
                                        </div>
                                    </li><!-- /.item -->
                                    <li class="item">
                                        <div class="product-img">
                                            <img src="<c:url value="/resources/img/cake.png"/>" alt="Product Image">
                                        </div>
                                        <div class="product-info">
                                            <a href="javascript::;" class="product-title">9" Ring Blueberry Cheese Cake <span class="label label-info pull-right">P400</span></a>
                                            <span class="product-description">
                                                50 PCs Produced a week ago
                                            </span>
                                        </div>
                                    </li><!-- /.item -->                                                                        
                                </ul>
                            </div><!-- /.box-body -->
                            <div class="box-footer text-center">
                                <a href="javascript::;" class="uppercase">View All Products</a>
                            </div><!-- /.box-footer -->
                        </div><!-- /.box -->
                    </div><!-- /.col -->
                </div><!-- /.row -->
            </section><!-- /.content -->
        </div>        
    </jsp:body>
</t:adminlte>