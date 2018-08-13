<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/design.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Success Page</title>
</head>
<body>
<%@ page errorPage="Error404.jsp" %>
	<jsp:include page="headerAfterLogin.jsp"></jsp:include>
	<div class="content container " style="height:400px;"> 
		<div class="col-md-9">
	
		<h1 style="color: blue;"><%= request.getAttribute("msg") %></h1>
		<img align="middle" style="size: 1000px;" src="<%=request.getContextPath()%>/img/success.png">
	</div>
	<div class="col-md-3 text-center">
			  
	</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>