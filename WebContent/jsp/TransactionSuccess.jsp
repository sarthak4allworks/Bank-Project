<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.tcs.bean.*" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Transaction Success</title>
</head>
<body>
<%@ page errorPage="Error404.jsp" %>
<jsp:include page="headerAfterLogin.jsp"></jsp:include>
<div class="container">
<div class="col-md-12"></div><br/><br/>
<div class="col-md-1"></div>
<div class="col-md-4">
	<% 
		long amount = (Long)(request.getAttribute("amount"));
		ArrayList<Customer> customerList = (ArrayList<Customer>)(request.getAttribute("customerList"));
		int i = 0;
		for(Customer customer: customerList)
		{
			if(i == 0)
			{
				i++;
	%>
	<div class="content1">
		<div class="form-area">  
					<br style="clear:both"/>
					<div class="panel panel-primary" style="margin: 10px;">
						<div class="panel-heading"><h4 style="margin: 10px; text-align: center;">Source Account Information</h4></div>
					</div>
		<table class="table table-hover">
			<tr>
				<td>CustomerId: </td>
				<td><%= customer.getCustomerId() %></td>
			</tr>
			<tr>
				<td>Name: </td>
				<td><%= customer.getCustomerName() %></td>
			</tr>
			<tr>
				<td>Account Id: </td>
				<td><%
					ArrayList<Account> accountList = customer.getAccountList();
					for(Account account: accountList)
					{
				%>
				<%= account.getAccountNo() %></td>
			</tr>
			<tr>
				<td>Account Type: </td>
				<td><%= account.getType() %></td>
			</tr>
			<tr>
				<td>Account Balance Before Transfer: </td>
				<td><%= account.getBalance() %></td>
			</tr>
			<tr>
				<td>Account Balanace After Transfer: </td>
				<td><%= account.getBalance()-amount %></td>
			</tr>
		</table>
	</div>
	</div>
	</div>
	<div class="col-md-1"></div>
	<%}}else{ %>
	<div class="col-md-4">
		<div class="form-area content1">  
					<br style="clear:both"/>
					<div class="panel panel-primary" style="margin: 10px;">
						<div class="panel-heading"><h4 style="margin: 10px; text-align: center;">Target Account Information</h4></div>
					</div>
		<table class="table table-hover">
			<tr>
				<td>CustomerId: </td>
				<td><%= customer.getCustomerId() %></td>
			</tr>
			<tr>
				<td>Name: </td>
				<td><%= customer.getCustomerName() %></td>
			</tr>
			<tr>
				<td>Account Id: </td>
				<td><%
					ArrayList<Account> accountList = customer.getAccountList();
					for(Account account: accountList)
					{
				%><%= account.getAccountNo() %></td>
			</tr>
			<tr>
				<td>Account Type: </td>
				<td><%= account.getType() %></td>
			</tr>
			<tr>
				<td>Account Balance Before Transfer: </td>
				<td><%= account.getBalance() %></td>
			</tr>
			<tr>
				<td>Account Balanace After Transfer: </td>
				<td><%= account.getBalance()+amount %></td>
			</tr>
		</table>
	</div>
	</div>
	<%}} }%>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>