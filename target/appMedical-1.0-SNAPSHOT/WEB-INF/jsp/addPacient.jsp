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
<div class="row">
   <h1>Search Client</h1>
    <form action="addPacient" method="post">
      Search: <input type="text" name="searchText" /><br/>
      <input type="reset"/>
         <input type="submit" name="action" value="search" />
      <input type="submit"  name="action" value="save" />
      
    </form>
  
    <h2>Found User</h2>

 
        <ul>
          <li>Email:  ${addPacient.email}</li>
          <li>Nume:   ${addPacient.firstName}</li>
          <li>Prenume:${addPacient.lastName}</li>
          
        </ul>
  
   
 

 
 

</div>
</body>
</html>