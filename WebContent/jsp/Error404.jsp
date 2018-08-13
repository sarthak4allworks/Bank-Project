<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error 404</title>
<style>
a
{
	border-radius: 15px;
}
a:link, a:visited {
    background-color: lightblue;
    color: white;
    padding: 14px 25px;
    text-align: center; 
    text-decoration: none;
    display: inline-block;
}

a:hover, a:active {
    background-color: Blue;
}
</style>
</head>
<body>
<%@ page isErrorPage="true" %>
<center>
	<h1 style="color:red;">Sorry, an exception occured!</h1><br/>
	Exception is: <%= exception %>
	<br/><br/>
	<a href="<%=request.getContextPath()%>/BankController?action=home&emp=hmerror">Home</a>
</center>
</body>
</html>