<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/design.css"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Error Page</title>
</head>
<body>
<% 
if(session != null && session.getAttribute("currentsessionId") != null){ %>
<jsp:include page="headerAfterLogin.jsp"></jsp:include>
<%}else{ %>
<jsp:include page="headerNew.jsp"></jsp:include>
<%} %>
	<div class="container">
	<div class="col-md-2"></div>
		<div class="col-md-6" style="height: 380px;">
			<h1 style="color:red;"><p><%=request.getAttribute("msg")%></p></h1>
		</div>
	
	</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>