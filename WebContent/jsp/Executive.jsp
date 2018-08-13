<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/navBar.css">
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/design.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Executive Dashboard</title>
</head>
<body>
	<%@ page errorPage="Error404.jsp" %>
	<jsp:include page="headerAfterLogin.jsp"></jsp:include>
	<div class="container"> 

	<div class="sidebar col-md-3" style="margin-top:-20px;margin-left: -155px;">
		<a href="<%=request.getContextPath()%>/ExecutiveController?action=createCustomer">Create Customer</a>
		<a href="#">Update Customer</a>
		<a href="#">Delete Customer</a>
		<a href="<%=request.getContextPath()%>/ExecutiveController?action=createAccount">Create Account</a>
		<a href="#">Delete Account</a>
		<a href="#">Customer Status</a>
		<a href="#">Account Status</a>
	</div>
	<div class="col-md-6" style="margin-left:30px;">
		<h2 style="color: blue;">
			Welcome to Executive page 
		</h2>
		<p>Welcome to ABC Bank, Ideal destination for Personal Banking
			need!</p>
		<p>We offer a wide range of personal banking services including
			loans, credit cards, savings and many more.</p>
		<h3 style="color: blue;">HAPPY BANKING!</h3><br><br>
		
	</div>
		<div class="col-md-3 text-center">
				  
				  <br>
		</div>
	</div>	
	<jsp:include page="footer.jsp"></jsp:include>
		
</body>
</html>