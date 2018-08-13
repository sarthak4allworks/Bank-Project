<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<head>
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/design.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ABOUT US</title>
</head>
<body>
<%@ page errorPage="Error404.jsp" %>
<%	String role = (String)session.getAttribute("currentsessionId");
if(role == null || role.equalsIgnoreCase("")){%>
	<jsp:include page="headerNew.jsp"></jsp:include>
	<%}else{ %>
	<jsp:include page="headerAfterLogin.jsp"></jsp:include>
	<%} %>
	<div class="content">
		<div class="container">
			<div class="panel panel-info">
		      <div class="panel-heading text-center">About Us</div>
		      <div class="panel-body" style="padding-left:10px;">
			<br><br>
			<p>ABC Bank is India's largest bank with a network of over 20000 branches located even in the remotest parts of India. ABC Bank offers a wide range of banking products and services to corporate and retail customers.</p>
			<p>ABC Bank is having total consolidated assets of Rs. 11,201.67 billion at March 31, 2018 and profit after tax of Rs. 56.05 billion for the year ended March 31, 2018. ABC Bank currently has a network of 4,578 Branches and 14,267 ATMs across India.</p>
			<p>The Retail banking application is an integration of several functional areas, and enables customers to:</p>
			<p>1.) Issue Demand Drafts online<br>
			2.) Transfer funds to own and third party accounts<br>
			3.) Credit beneficiary accounts using the VISA Money Transfer, RTGS/NEFT feature<br>
			4.) Generate account statements<br>
			5.) Setup Standing Instructions<br>
			6.) Configure profile settings<br>
			7.) Use eTax for online tax payment<br>
			8.) Use ePay for automatic bill payments
			</p>
			</div>
			</div>
			<div class="col-md-4"></div><img src="<%=request.getContextPath()%>/img/dream.png">
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>