<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>Flat HTML5/CSS3 Login Form</title>
  
  <link href="<c:url value='/static2/css/style.css' />"  rel="stylesheet"></link>  
</head>


<body>
  <div class="login-page" >
  <div class="form">
  
  
	<form method="post" action="#" name="loginform" class="login-form" >
      <input type="text" name="emailLOG" placeholder="username"/>
      <input type="password" name="passwordLOG" placeholder="password" />
      <button type="submit">login</button>
      <p class="message">Not registered? <a href="/inserare">Create an account</a></p>
    </form>
   
  </div>
</div>
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

    
    <script src="<c:url value='/static2/js/index.js' />" ></script>

</body>
</html>