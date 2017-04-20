<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

   	<p>Welcome ${user.profile} ${user.firstName} ${user.lastName}</p>
   	<br><br>
	<button onclick="location.href='/logout'" >Logout</button>
	
	 <sec:authorize access="hasAuthority('medic')">
	 <button onclick="location.href='/addPacient'" >Add a new pacient</button>
	 
	</sec:authorize>
	 <sec:authorize access="hasAuthority('medic')">
	  <table>
        <tr>
            <td>LISTA PACIENTI</td><td></td>
        </tr>
        <c:forEach items="${useri}" var="foruser">
           	<tr>
           	<td><a href="<c:url value='/reteta-${foruser.email}-pacient' />">${foruser.email}</a></td>
            <td>Pacient email: <c:out value="${foruser.email}"/></td>
            <td>Nume: <c:out value="${foruser.firstName}"/></td>
            <td>Prenume: <c:out value="${foruser.lastName}"/></td>
            
        	</tr>
        </c:forEach>
      </table>
	</sec:authorize>
	
	
</body>
</html>