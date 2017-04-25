<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Users List</title>
    <link href="<c:url value='/static2/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static2/css/app.css' />" rel="stylesheet"></link>
</head>
 
<body>
    <div class="generic-container">
        <div class="panel panel-default">
              <!-- Default panel contents -->
            <div class="panel-heading"><span class="lead"> MEDICAMENTE</span></div>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Nume</th>
                        <th>Concentratie</th>
                        <th>Tip</th>
                        <th>Forma</th>
                        <th width="100"></th>
                        <th width="100"></th>
                    </tr>
                </thead>
              <tbody>
                <c:forEach items="${medicamente}" var="medicamente">
                    <tr>
                        <td>${medicamente.nume}</td>
                        <td>${medicamente.concentratie}</td>
                        <td>${medicamente.tip}</td>
                      	<td>${medicamente.forma}</td>
                </c:forEach>
                </tbody>
                </table>
        </div>
       
    </div>
</body>
</html>