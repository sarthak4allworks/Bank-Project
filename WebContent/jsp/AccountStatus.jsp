<!DOCTYPE>

<html>
<head>
<title>Account Statement</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/design.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://code.angularjs.org/1.2.1/angular.min.js"></script>
<script>
	var app = angular.module("myApp", []);
	app.controller("formCtrl", ['$scope', function($scope) {
			
			$scope.number=[1,2,3,4,5,6,7,8,9,10];			
	        $scope.acc_id = /^[0-9\+\-\s]{10,100}$/;  //special charater bhi le raha h
	        $scope.startdate="";
	        $scope.enddate="";       
	}]);
</script>
</head>
<body>
<%@ page errorPage="Error404.jsp" %>
<jsp:include page="headerAfterLogin.jsp"></jsp:include>
	<div class="content"> 
		<div class="container" ng-app="myApp">
		<div class="col-md-3"></div>
			<div class="col-md-6 bg-info" style="border-radius:15px;">
		 	  <div class="form-area" ng-controller="formCtrl">  
		        <form role="form" name="inquiryForm" action="<%=request.getContextPath()%>/CashierController" method="post" novalidate>
		      		<br style="clear:both">
		               <div class="panel panel-primary" style="margin: 10px;">
										<div class="panel-heading"><h4 style="margin: 10px; text-align: center;">Get Account Transactions</h4></div>
									</div>
					   <div class="form-group">
							<b>Account ID</b><input name="account_id" ng-model="account_id" id="c_no" type="text" ng-required="true" ng-pattern="acc_id" autocomplete="off" placeholder="Account Id" class="form-control" autofocus>
	               			<span class="red-text" ng-if="inquiryForm.account_id.$error.required && inquiryForm.account_id.$dirty">Account ID is a required field</span>
		            		<span class="red-text" ng-show="inquiryForm.account_id.$error.pattern">Enter Valid Account Id</span>
		           		</div>
						
						<div class="form-group">
						<b>Number of Transaction</b><select name="transaction" ng-options="no for no in number" ng-model="transaction" ng-pattern="transaction_no" ng-required="true" autocomplete="off" class="form-control">
						<option value="no" disabled selected>Select</option>
						</select>
						
						</div>
						<div class="form-group">
								<b>Start Date</b><input name="start_date" ng-model="start_date" id="c_no" type="date" ng-required="true" ng-pattern="startdate" autocomplete="off" placeholder="dd/mm/yyyy" class="form-control">
		               			<span class="red-text" ng-if="inquiryForm.start_date.$error.required && inquiryForm.start_date.$dirty">Starting Date is a required field</span>
		            			<span class="red-text" ng-show="inquiryForm.start_date.$error.pattern"></span>
		           		</div>
		
						<div class="form-group">
								<b>End Date</b><input name="end_date" ng-model="end_date" id="c_no" type="date" ng-required="true" ng-pattern="enddate" autocomplete="off" placeholder="dd/mm/yyyy" class="form-control">
		               			<span class="red-text" ng-if="inquiryForm.end_date.$error.required && inquiryForm.end_date.$dirty">End Date is a required field</span>
		            			<span class="red-text" ng-show="inquiryForm.end_date.$error.pattern"></span>
		           		</div>
		           						
		       			 <input type="submit" id="submit" value="seeTransactions" name="action" class="btn btn-primary center-block" ng-disabled="inquiryForm.$invalid"><br>
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