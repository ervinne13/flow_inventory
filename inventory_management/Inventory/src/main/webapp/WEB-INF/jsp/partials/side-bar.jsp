<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">            
            <div class="pull-left image">
                <img src="<c:url value="/resources/img/ghe.jpg"/>" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p>Geraldine Aligno</p>
                <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
        </div>   
        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu">
            <li class="header">MAIN NAVIGATION</li>
            <li>
                <a href="<c:url value="/"/>">
                    <i class="fa fa-dashboard text-aqua"></i> <span>Dashboard</span>
                </a>
            </li>
            <li>
                <a href="<c:url value="/item/add"/>">
                    <i class="fa fa-plus text-aqua"></i> <span>New Item</span>
                </a>
            </li>
            <li>
                <a href="<c:url value="/items"/>">
                    <i class="fa fa-shopping-cart text-aqua"></i> <span>Items</span>
                </a>
            </li>
            <li class="header">PRODUCTION</li>
            <li>
                <a href="<c:url value="/produce"/>">
                    <i class="fa fa-home text-green"></i> <span>Produce</span>
                </a>
            </li>
            <li>
                <a href="<c:url value="/productionBOM"/>">
                    <i class="fa fa-money text-green"></i> <span>Production BOM</span>
                </a>
            </li>
            <li class="header">CASH FLOW & PURCHASES</li>
            <li>
                <a href="<c:url value="/purchase"/>">
                    <i class="fa fa-money text-orange"></i> <span>Purchase Items</span>
                </a>
            </li>
            <li>
                <a href="<c:url value="/sell"/>">
                    <i class="fa fa-money text-orange"></i> <span>Mark Sold Items</span>
                </a>
            </li>
        </ul>
    </section>
    <!-- /.sidebar -->
</aside>