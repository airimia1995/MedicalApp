<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <h1>Search Medicament</h1>
  <table>
    <c:forEach items="${medicamentList}" var="medicament">
           	<tr>
           	<td>${medicament.nume}</td>
            <td> <a href="<c:url value="/retetaM?boala=${reteta.boala}&medid=${medicament.medicament_id}"/>">ADD</a></td> 
            
        	</tr>
        </c:forEach>
</table>
  <h2>Found medicamentr</h2>
      <c:forEach items="${reteta.medicamentList}" var="medicamentReteta">
           	<tr>
           	<td>${medicamentReteta.nume}</td>
           <td> <a  href="<c:url value="/retetaM?boala=${reteta.boala}&medid_remove=${medicamentReteta.medicament_id}"/>">Remove</a></td> 
			
        	</tr>
        </c:forEach>
 
</body>
</html>