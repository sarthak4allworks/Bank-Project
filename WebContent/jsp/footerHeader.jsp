<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Footer Header</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/design.css">
</head>
<body>
<%@ page errorPage="Error404.jsp" %>
	<div class="foothead">
		 <div class="row">
		    <div class="col-sm-4">
		      <h3>About Us</h3>
		      <p>Careers</p>
		      <p>Service charges and frees</p>
		      <p>Important Messages</p>
		    </div>
		    <div class="col-sm-4">
		      <h3>Media Corner</h3>
		      <p>FAQs</p>
		      <p>Press Release</p>
		      <p>Announcements</p>
		    </div>
		    <div class="col-sm-4">
		      <h3>More Links</h3>        
		      <p>Customer Care</p>
		      <p>Online Complaints/Feedbacks</p>
		      <p>Business Reports</p>
		    </div>
 		 </div>
	</div>
</body>
</html>