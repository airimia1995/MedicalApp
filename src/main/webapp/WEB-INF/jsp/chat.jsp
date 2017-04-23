<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div >
		<textarea rows="15" cols="60" readonly="readonly" >
		 <c:forEach items="${mesajeRead}" var="mesajeRead">
		${mesajeRead.mesaj}
		</c:forEach>
		</textarea>
	</div>
	
	<form:form id="postMessageForm" action="/chat?mail=${mail}" method="post"  modelAttribute="mesaje" >
		<p>
			<input id="message" name="mesaj" type="text"/>
			<button id="post" type="submit" >Post</button>
		</p>
	</form:form>
</body>
<script type="text/javascript" src="../../../resources/js/jquery-1.7.2.min.js" th:src="@{/resources/js/jquery-1.7.2.min.js}"></script>
<script type="text/javascript" src="../../../resources/js/knockout-2.0.0.js" th:src="@{/resources/js/knockout-2.0.0.js}"></script>
<script type="text/javascript" src="../../../resources/js/chat.js" th:src="@{/resources/js/chat.js}"></script>
</body>
</html>