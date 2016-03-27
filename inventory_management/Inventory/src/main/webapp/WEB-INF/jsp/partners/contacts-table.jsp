<%-- 
    Document   : address-table
    Created on : Mar 23, 2016, 7:27:22 AM
    Author     : Ervinne Sodusta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<table id="contacts-table" class="table table-striped">
    <thead>
        <tr>            
            <th></th>
            <th>Name</th>
            <th>Email</th>            
            <th>Title</th>
            <th>Phone</th>
            <th>Notes</th>
        </tr>
    </thead>
    <tbody>
        <c:if test="${partner != null}">
            <c:forEach items="${partner.contactList}" var="contact">
                <tr>
                    <td>${contact.id}</td>
                    <td>${contact.name}</td>
                    <td>${contact.email}</td>
                    <td>${contact.title}</td>
                    <td>${contact.phone}</td>
                    <td>${contact.notes}</td>
                </tr>
            </c:forEach>
        </c:if>

    </tbody>   
</table>
