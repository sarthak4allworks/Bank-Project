<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
	.input-group button{
		height:34px;
	}
	
</style>
</head>
<body>
<%@ page errorPage="Error404.jsp" %>
<nav class="navbar navbar-inverse" id="myHeader">
  <div class="container-fluid">
    <div class="navbar-header">
     <h3 style="color:white;"><img src="<%=request.getContextPath()%>/img/bank.png" height="50" width="50" alt="logo" /> Bank ABC </h3>  
    </div>
    <ul class="nav navbar-nav text-center" style="padding-top:20px;">
    <% String name = (String)session.getAttribute("currentsessionId");
    if( name == null || name.equalsIgnoreCase("")){
    	%>
      <li ><a href="<%=request.getContextPath()%>/BankController?action=home&emp=hm">Home</a></li>
     <%}else{ 
     	int role = (int)session.getAttribute("RoleOfCurrentEmployee");
     	if(role == 1)
     	{
     %>
     <li ><a href="<%=request.getContextPath()%>/BankController?action=home&emp=executive">Home</a></li>
     <%}
     	else
     		{%>
     		<li ><a href="<%=request.getContextPath()%>/BankController?action=home&emp=cashier">Home</a></li>
     		<% }} %>
      <li><a href="">Contact</a></li>
      <li><a href="<%=request.getContextPath()%>/BankController?action=about">About us</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right text-center" style="padding-top:15px;padding-right:20px;">
      <li><a href="<%=request.getContextPath()%>/BankController?action=log"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>    
  </div>
</nav>
  


</body>
</html>
	