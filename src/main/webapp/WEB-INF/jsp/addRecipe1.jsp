<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
  <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html SYSTEM "about:legacy-compat">
<html lang="en">
<head>

<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="<c:url value='/static/css/bootstrap.min.css' />"  rel="stylesheet"></link>  
    <link href="<c:url value='/static/css/sb-admin.css' />"  rel="stylesheet"></link>  
     
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="<c:url value='/welcome' />">SB Admin</a>
                
            </div>
            <!-- Top Menu Items -->
            <ul class="nav navbar-right top-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> John Smith <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="#"><i class="fa fa-fw fa-user"></i> Profile</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-fw fa-envelope"></i> Inbox</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-fw fa-gear"></i> Settings</a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href='/logout'><i class="fa fa-fw fa-power-off"></i> Log Out</a>
                        </li>
                    </ul>
                </li>
            </ul>
            <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
                   
                
                    <li >
                        <a href="<c:url value='/welcome' />"><i class="fa fa-fw fa-file"></i> Welcome</a>
                        
                    </li>
                     <sec:authorize access="hasAuthority('medic')">
                     <li class="active">
                        <a href="<c:url value='/patientList' />"><i class="fa fa-fw fa-table"></i> Patient List</a>
                    </li>
                    </sec:authorize>
                      <sec:authorize access="hasAuthority('pacient')">
                    <li>
                        <a href="<c:url value='/viewRecipes' />"><i class="fa fa-fw fa-table"></i> Recipe List</a>
                    </li>
                    </sec:authorize>
                   
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </nav>
	
      <div id="page-wrapper">

            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-6">
                        <h1 class="page-header">
                            ADD RECIPE
                        </h1>
                      
                    </div>
         </div>
        <!-- /#page-wrapper -->
		<div class="col-lg-6">
				<form:form role="form" method="post" modelAttribute="reteta">
                      
                          <div class="form-group has-success"  >
                          		<label>DISEASE</label>
                                <label class="control-label" for="inputSuccess">Input with success</label>
                                <form:input type="text" class="form-control" id="inputSuccess" placeholder="Disease" path="boala" name="boala" />
                                
                                <label>START DATE RECIPE</label>
                                <form:input  type="date" class="form-control" placeholder="startDate" path ="startDate" name="startDate" />
                                
                                <label>END DATE RECIPE</label>
                                <form:input  type="date" class="form-control"  placeholder="endDate" path ="endDate" name="endDate" />
                            
                                 <button type="register" class="btn btn-lg btn-primary"  id="p2" onclick="demoShow();">SAVE RECIPE</button>
                                 <script type="text/javascript"> 
    										function demoShow()
    										{document.getElementById("p2").style.display="none";}
								</script>
								   <a href="<c:url value='/retetaM?boala=${reteta.boala}' />"class="btn btn-lg btn-primary"  >ADD 
DRUGS</a>
                            </div>
                  </form:form>
                    </div>
                </div>
    
    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
   
<script src="<c:url value='/static/js/jquery.js' />" ></script>
<script src="<c:url value='/static/js/bootstrap.min.js' />" ></script>
    <!-- Bootstrap Core JavaScript -->
   
</body>
</html>