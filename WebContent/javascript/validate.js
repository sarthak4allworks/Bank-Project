var app = angular.module("myApp", []);
	app.controller("formCtrl", ['$scope', function($scope) {
//			this is for login validation
			$scope.eml_password = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$/;
	        $scope.eml_username = "";

//	        This is for create customer form validation
	        $scope.ssn_id = /^\+?\d{9,}$/;
	        $scope.cust_name = /^[a-zA-Z\s]*$/;
//	        $scope.cust_age= /^\+?\d{2}$/;
	        $scope.cust_age=/^(1[89]|[2-9][0-9])$/;
	        $scope.cust_address="";
	        $scope.cust_address1="";
	        $scope.cust_city="";
	        $scope.cust_state="";
	        
//	        This is create account validation
	        $scope.c_id="";
	        $scope.d_amount=/^[0-9]*$/;
	        
//	        This is for transfer the money from source account to target account
	        $scope.t_amount=/^[0-9]*$/;
	        $scope.s_account=/^[0-9]*$/;
	        $scope.t_account=/^[0-9]*$/;  
	}]);