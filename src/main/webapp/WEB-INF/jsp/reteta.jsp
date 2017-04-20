<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
 <form:form class="register-form"  method="post" modelAttribute="reteta" >
      
      <form:input type="text" placeholder="name" path="boala" name="boala" id = "boala" />
      <form:input type="date" placeholder="startDate" path ="startDate" name="startDate" id = "startDate"  />
      <form:input type="date" placeholder="endDate" path ="endDate" name="endDate" id = "endDate"/>
      <button  value="Register">next</button>
      
    </form:form>
    <a href="<c:url value='/reteta-${reteta.boala}' />" class="btn btn-default">NEXT</a>
    
  
</div>
</body>
</html>