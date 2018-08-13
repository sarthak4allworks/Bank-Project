<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transfer Money</title>
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
		        <form role="form" name="inquiryForm" action="<%=request.getContextPath()%>/CashierController" method="post" novalidate>
		        
		        <br style="clear:both">
		                    <h3 style="margin-bottom: 25px; text-align: center;">Transfer Money</h3>
		
						<div class="form-group">
								<b>Transfer Amount</b><input name="tran_amount" ng-model="tran_amount" id="c_no" type="text" ng-required="true" ng-pattern="t_amount" autocomplete="off" placeholder="Enter Transfer Amount" class="form-control" autofocus>
		               			<span class="red-text" ng-if="inquiryForm.tran_amount.$error.required && inquiryForm.tran_amount.$dirty">Transfer Amount is a required field</span>
		            			<span class="red-text" ng-show="inquiryForm.tran_amount.$error.pattern">Enter Valid Transfer Amount</span>
		           		</div>
						
						<div class="form-group">
								<b>Source Account</b><input name="source_account" ng-model="source_account" id="c_no" type="text" ng-required="true" ng-pattern="s_account" autocomplete="off" placeholder="Enter Source Account" class="form-control">
		               			<span class="red-text" ng-if="inquiryForm.source_account.$error.required && inquiryForm.source_account.$dirty">Source Account is a required field</span>
		            			<span class="red-text" ng-show="inquiryForm.source_account.$error.pattern">Enter Valid Source Account</span>
		           		</div>
		           		
		           		<div class="form-group">
								<b>Target Account</b><input name="tar_account" ng-model="tar_account" id="c_no" type="text" ng-required="true" ng-pattern="t_account" autocomplete="off" placeholder="Enter Target Account" class="form-control">
		               			<span class="red-text" ng-if="inquiryForm.tar_account.$error.required && inquiryForm.tar_account.$dirty">Target Account is a required field</span>
		            			<span class="red-text" ng-show="inquiryForm.tar_account.$error.pattern">Enter Valid Target Account</span>
		           		</div>
		           						
		        <input type="submit" id="submit" name="action" value="TransferAmount" class="btn btn-primary center-block" ng-disabled="inquiryForm.$invalid"><br>      
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