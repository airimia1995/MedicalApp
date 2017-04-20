<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

  <h1>Search Medicament</h1>
    <form action="reteta-${foruser.email}-pacient" method="post">
      Search: <input type="text" name="searchMedicament" /><br/>
      <input type="reset"/>
         <input type="submit" name="action" value="search" />
      <input type="submit"  name="action" value="save" />
      
    </form>

  <h2>Found medicamentr</h2>
  	 <ul>
          <li>Nume:  ${medicament.nume}</li>
         
          
     </ul>
</body>
</html>