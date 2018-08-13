<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ABC Bank</title>
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/design.css">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
 <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 <script type="text/javascript" src="<%=request.getContextPath()%>/javascript/validate.js"></script>
 <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<%@ page errorPage="Error404.jsp" %>
	<jsp:include page="headerNew.jsp"></jsp:include>
	<div class="content"> 
		<div class="container">
  			<div class="container" ng-app="myApp">
				<div class="col-md-3"></div>
				<div class="col-md-6 bg-info" style="margin-top: -80px;">
				    <div class="form-area" ng-controller="formCtrl">  
				        <form role="form" name="inquiryForm" action="<%=request.getContextPath()%>/BankController" method="post" novalidate>
				        <br style="clear:both">
				                    <h3 style="margin-bottom: 25px; text-align: center;">Login</h3>
									<img class="loginimg" src="<%=request.getContextPath()%>/img/login.png" alt="login" style="width:80px; ">
									<div class="form-group">
										<b>User Name</b><input name="username" ng-model="username" id="eml" type="text" ng-pattern="eml_username" ng-required="true" autocomplete="off" placeholder="User Name" class="form-control" autofocus>
				            
				            			<span class="red-text" ng-if="inquiryForm.username.$error.required && inquiryForm.username.$dirty">User Name is a required field</span>
				            
				            				<span class="red-text" ng-show="inquiryForm.username.$error.pattern"></span>
									</div>
									<div class="form-group">
										<b>Password</b><input name="password" ng-model="password" id="c_num" type="password" ng-required="true" ng-pattern="eml_password" autocomplete="off" placeholder="Password" class="form-control">
				            
								            <span class="red-text" ng-if="inquiryForm.password.$error.required && inquiryForm.password.$dirty">Password is a required field</span>
								            <span class="red-text" ng-show="inquiryForm.password.$error.pattern">Please enter valid password</span>
									</div>				            
				        	<input type="submit" id="submit" name="action" value="login" class="btn btn-primary center-block" ng-disabled="inquiryForm.$invalid"/><br>
				        </form>
				    </div>
				</div>
			</div>			
 		 </div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>