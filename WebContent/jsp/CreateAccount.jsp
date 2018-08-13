<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Account</title>
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/design.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://code.angularjs.org/1.2.1/angular.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/javascript/validate.js"></script>
</head>
<body>
<%@ page errorPage="Error404.jsp" %>
	<jsp:include page="headerAfterLogin.jsp"></jsp:include>
	<div class="content"> 
	<div class="container" ng-app="myApp">
	<div class="col-md-3"></div>
		<div class="col-md-6 bg-info" style="border-radius:15px;">
		    <div class="form-area " ng-controller="formCtrl">  
		        <form role="form" name="inquiryForm" action="<%=request.getContextPath()%>/ExecutiveController" method="post" novalidate>		        
		        <br style="clear:both">
		        <div class="panel panel-primary" style="margin: 10px;">
										<div class="panel-heading"><h4 style="margin: 10px; text-align: center;">Create Customer Account</h4></div>
									</div>	
						<div class="form-group">
								<b>Customer Id</b><input name="cust_id" ng-model="cust_id" id="c_no" type="text" ng-required="true" ng-pattern="c_id" autocomplete="off" placeholder="Enter Customer Id" class="form-control" autofocus>
		               			<span class="red-text" ng-if="inquiryForm.cust_id.$error.required && inquiryForm.cust_id.$dirty">Customer Id is a required field</span>
		            			<span class="red-text" ng-show="inquiryForm.cust_id.$error.pattern">Enter Valid Customer Id</span>
		           		</div>
						
						<div class="form-group">
						<b>Account Type</b><select name="acc_type" ng-required="true" autocomplete="off" class="form-control">
							<option value="SAVING">Saving Account</option>
							<option value="CURRENT">Current Account</option>
						</select>
						
						</div>
		           		
		           		<div class="form-group">
								<b>Deposit Amount</b><input name="dep_amount" ng-model="dep_amount" id="c_no" type="text" ng-required="true" ng-pattern="d_amount" autocomplete="off" placeholder="Enter Deposit Amount" class="form-control">
		               			<span class="red-text" ng-if="inquiryForm.dep_amount.$error.required && inquiryForm.dep_amount.$dirty">Deposit Amount is a required field</span>
		            			<span class="red-text" ng-show="inquiryForm.dep_amount.$error.pattern">Enter Valid Deposit Amount</span>
		           		</div>
		           						
		        <input type="submit" id="submit" name="action" value="AccountCreate" class="btn btn-primary center-block" ng-disabled="inquiryForm.$invalid"><br>
		      </form>    
		    </div>
		</div>
		<div class="col-md-3 text-center">
			
		</div>
		</div>
	 </div>
	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>