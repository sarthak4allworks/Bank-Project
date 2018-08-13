<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.tcs.bean.*" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 <link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/design.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
 <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Transactions</title>
</head>
<body>
<%@ page errorPage="Error404.jsp" %>
<jsp:include page="headerAfterLogin.jsp"></jsp:include>
		<div class="container">
		<div class="col-md-10"></div>
		<div class="col-md-2">
				
			</div><br/><br/>
			<div class="col-md-1"></div>
			<div class="col-md-10">
			<div class="content1"> 
				<div class="form-area">  
					<br style="clear:both"/>
					 <div class="panel panel-primary" style="margin: 10px;">
										<div class="panel-heading"><h4 style="margin: 10px; text-align: center;">History Of Transactions</h4></div>
									</div>
						<% 
							ArrayList<Transaction> tList = (ArrayList<Transaction>)(request.getAttribute("transactionList"));
							String account = (String)request.getAttribute("acc");
							if(tList.size() == 0)
							{
								%>
								<h1 style="color:red;"> There is no transaction related to this account </h1>
								<%
							}
							else
							{
								%>
								<table class="table table-hover table-bordered">
								<thead>
									<tr>
										<th>Transaction Id</th>
										<th>Source Account</th>
										<th>Target Account</th>
										<th>Transaction Date</th>
										<th>Transaction Date</th>
										<th>Amount</th>
										<th>Transaction Status</th>
									</tr>
								</thead>
								<%
							for(Transaction transaction: tList)
							{
						%>
						<tbody>
							<tr>
								<td><%= transaction.getTransactionId() %></td>
								<td><%= transaction.getSourceAccount() %></td>
								<td><%= transaction.getDestinationAccount() %></td>
								<td><%= transaction.getTransactionDate() %></td>
								<td><%= transaction.getAmount() %></td>
								<td><%= transaction.getStatus() %></td>
								<% if(account.equalsIgnoreCase(transaction.getSourceAccount())){ %>
								<td>Debit</td>
								 	<%}else{ %>
								 	<td>Credit</td>
								 	<%} %>
							</tr>
							</tbody>
							<%}} %>
						</table>
						</div>
				</div>
				<div class="col-md-1">
					
				</div>
			</div>
			</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>