<%-- 
    Document   : partners-table
    Created on : Mar 26, 2016, 12:53:49 PM
    Author     : Ervinne Sodusta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>


<c:choose>
    <c:when test="${partners != null}">
        <table id="address-table" class="table table-striped">
            <thead>
                <tr>            
                    <th></th>
                    <th>Type</th>
                    <th>Name</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${partners}" var="partner">
                    <tr>
                        <td>${partner.id}</td>
                        <td>${partner.vendor ? "Vendor" : ""} | ${partner.customer ? "Customer" : ""}</td>
                        <td>${partner.name}</td>
                        <td>
                            <a href="<c:url value="/partners/edit/${partner.id}"/>">edit</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>   
        </table>
    </c:when>
    <c:otherwise>
        <div class="row">
            <div class="col-md-12 text-center">
                <span>No partners yet, <a href="<c:url value="/partners/create"/>">create one</a></span>
            </div>
        </div>
    </c:otherwise>
</c:choose>
