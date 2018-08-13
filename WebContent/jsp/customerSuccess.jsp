<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.tcs.bean.*" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 <link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/design.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
 <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Customer Success</title>
</head>
<body>
<%@ page errorPage="Error404.jsp" %>
<jsp:include page="headerAfterLogin.jsp"></jsp:include>
<% Customer cust = (Customer)request.getAttribute("customer"); %>
<div class="content"> 
		<div class="container">
			<div class="col-md-3"></div>
			<div class="col-md-6 bg-info">
   				 <div class="form-area">  
				        <br style="clear:both">
									<div class="panel panel-primary" style="margin: 10px;">
										<div class="panel-heading"><h4 style="margin: 10px; text-align: center;">Customer Registration Successful</h4></div>
									</div>
								<table class="table table-hover">
								    <tbody>
								      <tr>
								        <td>Customer Id: </td>
								        <td><%= cust.getCustomerId() %></td>							
								      </tr>
								      <tr>
								        <td>SSNId: </td>
								        <td><%= cust.getSsnId() %></td>
								      </tr>
								      <tr>
								        <td>Name: </td>
								        <td><%= cust.getCustomerName() %></td>
								      </tr>
								      <tr>
								      	<td>Age: </td>
								      	<td><%= cust.getCustomerAge() %></td>
								      </tr>
								      <tr>
									      <td>Address 1: </td>
									      <td><%= cust.getAddress1() %></td>
								      </tr>
								      <tr>
									      <td>Address 2: </td>
									      <td><%= cust.getAddress2() %></td>
								      </tr>
								      <tr>
									      <td>City: </td>
									      <td><%= cust.getCity() %></td>
								      </tr>
								      <tr>
									      <td>State: </td>
									      <td><%= cust.getState() %></td>
								      </tr>								      
								    </tbody>
  							</table>
 		 			  </div>
			</div>
			<div class="col-md-3 text-center">
				  
			</div>
		</div>
			
 	 </div>
	</div>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>