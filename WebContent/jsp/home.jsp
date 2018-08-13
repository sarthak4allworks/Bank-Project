<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ABC Bank</title>
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/design.css">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<%@ page errorPage="Error404.jsp" %>
	<jsp:include page="headerNew.jsp"></jsp:include>
	<div class="content"> 
		<div class="container">
		<div class="col-md-2"></div>
		<div class="col-md-8">
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">

      <div class="item active">
        <img src="<%=request.getContextPath()%>/img/image2.jpg" alt="Cash Depopsit" style="width:100%;">
      </div>

      <div class="item">
        <img src="<%=request.getContextPath()%>/img/image2.jpg" alt="Global Bank" style="width:100%;">
      </div>
    
      <div class="item">
        <img src="<%=request.getContextPath()%>/img/image3.jpg" alt="Save Money" style="width:100%;">
      </div>
  
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div></div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>