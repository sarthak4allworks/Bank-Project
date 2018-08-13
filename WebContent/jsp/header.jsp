<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>HEADER</title>
	<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/design.css">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<%@ page errorPage="Error404.jsp" %>
<div class="head">

	  <ul class="nav nav-pills nav-justified">
	    <li><img src="<%=request.getContextPath()%>/img/logo.jpg" height="80" width="200" alt="logo" /></li>
	    <li></li>
	    <li><a href="">Contact</a></li>
	    <li><a href="<%=request.getContextPath()%>/BankController?action=about">About</a></li>
	  </ul>
	  <hr style="height:1px;border:none;color:#333;background-color:#333;" />
</div>
</body>
</html>