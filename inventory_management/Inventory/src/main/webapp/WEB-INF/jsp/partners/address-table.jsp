<%-- 
    Document   : address-table
    Created on : Mar 23, 2016, 7:27:22 AM
    Author     : Ervinne Sodusta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<table id="address-table" class="table table-striped">
    <thead>
        <tr>            
            <th></th>
            <th>Label</th>
            <th>Address</th>
            <th>City</th>
            <th>Email</th>
            <th>Zip</th>
            <th>Phone</th>            
            <th>Notes</th>
        </tr>
    </thead>
    <tbody>
        <c:if test="${partner != null}">
            <c:forEach items="${partner.addressList}" var="address">
                <tr>
                    <td>${address.id}</td>
                    <td>${address.label}</td>
                    <td>${address.address}</td>
                    <td>${address.city}</td>
                    <td>${address.email}</td>
                    <td>${address.zip}</td>
                    <td>${address.phone}</td>
                    <td>${address.notes}</td>
                </tr>
            </c:forEach>
        </c:if>

    </tbody>   
</table>
