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
 <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 <script type="text/javascript" src="<%=request.getContextPath()%>/javascript/validate.js"></script>
</head>
<%@ page errorPage="Error404.jsp" %>
	<jsp:include page="headerAfterLogin.jsp"></jsp:include>
	<div class="content"> 
		<div class="container" ng-app="myApp">
			<div class="col-md-3">
				
			</div>
			<div class="col-md-6 bg-info">
   				 <div class="form-area" ng-controller="formCtrl">  
      				  <form role="form" name="inquiryForm" action="<%=request.getContextPath()%>/ExecutiveController" method="post" novalidate>
        
				        <br style="clear:both">
									<div class="panel panel-primary" style="margin: 10px;">
										<div class="panel-heading"><h4 style="margin: 10px; text-align: center;">Register New Customer</h4></div>
									</div>
								<div class="form-group">
										<b>SSN ID</b><input name="contact" ng-model="contact" id="c_no" type="text" ng-required="true" ng-pattern="ssn_id" autocomplete="off" placeholder="SSN ID" class="form-control" autofocus>
				               			<span class="red-text" ng-if="inquiryForm.contact.$error.required && inquiryForm.contact.$dirty">SSN ID is a required field</span>
				            			<span class="red-text" ng-show="inquiryForm.contact.$error.pattern">Please enter a 9 digit ssn id</span>
				           		</div>
				
								<div class="form-group">
										<b>Name</b><input name="name" ng-model="name" id="eml" type="text" ng-pattern="cust_name" ng-required="true" autocomplete="off" placeholder="Customer Name" class="form-control" >
				           	            <span class="red-text" ng-if="inquiryForm.name.$error.required && inquiryForm.name.$dirty">Customer Name is a required field</span>
				                        <span class="red-text" ng-show="inquiryForm.name.$error.pattern">Enter Valid Name</span>
								</div>
				            
				            	<div class="form-group">
										<b>Age</b><input name="age" ng-model="age" id="age" type="text" ng-pattern="cust_age" ng-required="true" autocomplete="off" placeholder="Age" class="form-control" >
				           	            <span class="red-text" ng-if="inquiryForm.age.$error.required && inquiryForm.age.$dirty">Age is a required field</span>
				                        <span class="red-text" ng-show="inquiryForm.age.$error.pattern">Enter Valid Age</span>
								</div>
								
								<div class="form-group">
										<b>Address 1</b><input name="address" ng-model="address" id="address" type="text" ng-pattern="cust_address" ng-required="true" autocomplete="off" placeholder="Address 1" class="form-control" >
				           	            <span class="red-text" ng-if="inquiryForm.address.$error.required && inquiryForm.address.$dirty">Address is a required field</span>
				                        <span class="red-text" ng-show="inquiryForm.address.$error.pattern"></span>
								</div>
								
								<div class="form-group">
										<b>Address 2</b><input name="address1" ng-model="address1" id="address1" type="text" ng-pattern="cust_address1" ng-required="true" autocomplete="off" placeholder="Address 2" class="form-control" >
				           	            <span class="red-text" ng-if="inquiryForm.address1.$error.required && inquiryForm.address1.$dirty">Address is a required field</span>
				                        <span class="red-text" ng-show="inquiryForm.address1.$error.pattern"></span>
								</div>
								
								<div class="form-group">
										<b>City</b><input name="city" ng-model="city" id="city" type="text" ng-pattern="cust_city" ng-required="true" autocomplete="off" placeholder="City" class="form-control" >
				           	            <span class="red-text" ng-if="inquiryForm.city.$error.required && inquiryForm.city.$dirty">City is a required field</span>
				                        <span class="red-text" ng-show="inquiryForm.city.$error.pattern"></span>
								</div>
								
								<div class="form-group">
										<b>State</b><input name="state" ng-model="state" id="state" type="text" ng-pattern="cust_state" ng-required="true" autocomplete="off" placeholder="State" class="form-control" >
				           	            <span class="red-text" ng-if="inquiryForm.state.$error.required && inquiryForm.state.$dirty">State is a required field</span>
				                        <span class="red-text" ng-show="inquiryForm.state.$error.pattern"></span>
								</div>
								
     							   <input type="submit" id="submit" name="action" value="create" class="btn btn-primary center-block" ng-disabled="inquiryForm.$invalid"/>

       					 </form>
       	 
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