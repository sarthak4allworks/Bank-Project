<!DOCTYPE html>
<html lang="en">
<head>
  <title>Header</title>
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
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
     <h3 style="color:white;text-align: center;"><img style="padding-top:1px;padding-bottom:1px;" src="https://instaemi.com/assets/images/bank.png" height="50" width="50" alt="logo" /> Bank ABC </h3>  
    </div>
    <ul class="nav navbar-nav text-center" style="padding-top:20px;">
    <%
    	int role = (int)session.getAttribute("RoleOfCurrentEmployee");
    	String user = (String)session.getAttribute("currentsessionId");
    	if(role == 1)
    	{
    %>
      <li ><a href="<%=request.getContextPath()%>/BankController?action=home&emp=executive">Home</a></li>
      <%}else{ %>
     	<li ><a href="<%=request.getContextPath()%>/BankController?action=home&emp=cashier">Home</a></li>
     	<%}  %>
      <li><a href="#">Contact</a></li>
      <li><a href="<%=request.getContextPath()%>/BankController?action=about">About us</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right text-center" style="padding-top:15px;padding-right:20px;">
      <li><a href="<%=request.getContextPath()%>/BankController?action=logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
    </ul>
    <form class="navbar-form navbar-nav text-center navbar-right"  action="" style="padding-top:6px;">
       <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <span class="glyphicon glyphicon-user"></span> 
                        <% if(role == 1){ %>
                        <strong> Welcome <%= user %> </strong>
                        <%}else{ %>
                         <strong> Welcome <%= user %> </strong>
                         <%} %>
                        <span class="glyphicon glyphicon-chevron-down"></span>
                    </a>
                    <ul class="dropdown-menu" style="background:white;">
                        <li>
                            <div class="navbar-login">
                                <div class="row">
                                    <div class="col-lg-8 text-left">
                                        <p class="text-center">
                                            <span class="glyphicon glyphicon-bell icon-size">&nbspNotifications</span><br>
                                        </p>
                                </div>
                            </div>
                        </li>                       
                    </ul>
                </li>
            </ul>     
    </form>

    
  </div>
</nav>
  


</body>
</html>
		