$( document ).ready(function() {
	//sessionStorage.clear();
	/*var cookies = document.cookie.split(";");
    for (var i = 0; i < cookies.length; i++) {
        var cookie = cookies[i];
        var eqPos = cookie.indexOf("=");
        var name = eqPos > -1 ? cookie.substr(0, eqPos) : cookie;
        document.cookie = name + "=;expires=Thu, 01 Jan 1970 00:00:00 GMT";
    }*/
	delete_cookie('X-XSRF-TOKEN');
	delete_cookie('XSRF-TOKEN');
});
var delete_cookie = function(name) {
    document.cookie = name + '=;expires=Thu, 01 Jan 1970 00:00:01 GMT;';
};
var app = angular.module('login', []);
app.controller('myCtrl', ["$scope", "$compile", "$filter", "$http", function($scope, $compile, $filter, $http) {
	bu.angular.pageCtrl($scope, true, $compile);
	$scope.account = {
		name: "",
		accountFullName: "",
		description: "",
		showAcountListView: function(){
			loginbox.style.marginTop = "-350px";
		},
		showCreateview: function(){
			loginbox.style.marginTop = "-700px";
			this.name = "";
			this.accountFullName = "";
			this.description = "";
		},
		save: function(){
			this.name = this.name.toLowerCase();
			$scope.CREATE_ACCOUNT = {};
			$scope.CREATE_ACCOUNT.email = sessionStorage.getItem("ep-username");
			$scope.CREATE_ACCOUNT.accountFullName = this.accountFullName;
			$scope.CREATE_ACCOUNT.accountName = this.name;
			$scope.CREATE_ACCOUNT.description = this.description;
			bu.utils.invokeAPI("CREATE_ACCOUNT", function(resp){
				if(resp.response[0] == true){
					sessionStorage.setItem("ep-accountname", $scope.CREATE_ACCOUNT.accountName);
					location.href = window.location.origin + "/landing";
				}else{
					toastr.error("Account Creation Failed..");
				}
			});
		}
	};
	$('#accountName').keyup(function (e) {
		e.target.value = e.target.value.replace(/[^a-zA-Z0-9_]/g, "").toLowerCase();
	});
	$('#accountName').keypress(function (e) {
	    var regex = new RegExp("^[a-zA-Z0-9_]+$");
	    var str = String.fromCharCode(!e.charCode ? e.which : e.charCode);
	    if (regex.test(str)) {
	        return true;
	    }
	    e.preventDefault();
	    return false;
	});
	$scope.launchAccount = function(account) {
		var accountName = account.name;
		$scope.launchedAccount = angular.copy(account);
		$scope.LAUNCH_ACCOUNT = {};
		$scope.LAUNCH_ACCOUNT.accountName = accountName;
		/*bu.utils.invokeAPI("LAUNCH_ACCOUNT", function(data){
			// TODO
		});*/
		$scope.launchAccountCallback();
	}
	$scope.launchAccountCallback = function(){
		sessionStorage.setItem("ep-acct-id", $scope.launchedAccount.id);
		sessionStorage.setItem("ep-accountname", $scope.launchedAccount.name);
		var applications = $scope.accountDesc[$scope.launchedAccount.name];
		if (applications.length == 1) {
			sessionStorage.setItem("ep-proj-active", JSON.stringify(applications[0]));
			location.href = window.location.origin + "/" + $scope.LAUNCH_ACCOUNT.accountName + "/" + applications[0].contextPath + "/pages/dashboard.jsp";
		} else {
			location.href = window.location.origin + "/landing";
		}
}
}])
function launchAccountCallback() {}
$('#loginForm').submit(function() {
	$(".page-loader").fadeIn();
	$.ajax({
		url : $('#loginForm').attr('action'),
		type : 'post',
		data : $('#loginForm').serialize(),
		success : function(data) {
			$(".page-loader").fadeOut();
			if(typeof data =="string")
				data = JSON.parse(data);
			if (data.status == "success") {
				if(data.endpoints !=null){
					for (var key in data.endpoints) {
						sessionStorage.setItem(key, data.endpoints[key]);
					}
				}
				sessionStorage.setItem("ep-username", data["ep-username"]);
				sessionStorage.setItem("ep-userid", data["ep-userid"]);
				bu.angular.pageScope.accountDesc = data.accountDesc;
				var accountCount = data.account.length;
				var accountDetails = data.account[0];
				if (accountCount == 0) {
					toastr.error("Please Sign Up..");
				} else if (accountCount == 1) {
					sessionStorage.setItem( "ep-acct-id", accountDetails.id);
					var activeSession = sessionStorage.setItem("ep-accountname", data["ep-accountname"]);
					if (data.accountDesc[data.account[0].name].length == 1) {
						var appdetails = data.accountDesc[data.account[0].name][0];
						sessionStorage.setItem("launchedApplicationName", appdetails.name);
						sessionStorage.setItem("launchedApplicationId", appdetails.applicationId);
						sessionStorage.setItem("ep-proj-active", JSON.stringify(appdetails));
						location.href = window.location.origin + "/" + accountDetails.name + "/" + appdetails.contextPath + "/pages" + "/dashboard.jsp";
					} else {
						location.href = window.location.origin + "/landing";
						$.each(data.endpoints,function(key,val){
			        		sessionStorage.setItem(key, val);
			        	});
					}
				} else {
					bu.angular.pageScope.accountList = data.account;
					bu.angular.pageScope.$digest();
					bu.angular.pageScope.account.showAcountListView();
					/*$('form > *').wrap('<div class="blur-all">');
					$("#accountList").modal("show");*/
				}
			} else {
				toastr.error(data.status);
			}
		}
	});
	return false;
});
$('#accountLogin').submit(function() {
	$(".page-loader").fadeIn();
	$.ajax({
		url : $('#accountLogin').attr('action'),
		type : 'post',
		data : $('#accountLogin').serialize(),
		success : function(data) {
			$(".page-loader").fadeOut();
			if(typeof data =="string")
				data = JSON.parse(data);
			if (data.status == "success") {
				sessionStorage.setItem("ep-username", data["ep-username"]);
				bu.angular.pageScope.accountDesc = data.accountDesc;
				var accountCount = data.account.length;
				var accountDetails = data.account[0];
				if (accountCount == 0) {
					toastr.error("Please Sign Up..");
				} else if (accountCount == 1) {
					sessionStorage.setItem( "ep-acct-id", accountDetails.id);
					var activeSession = sessionStorage.setItem("ep-accountname", data["ep-accountname"]);
					if (data.accountDesc[data.account[0].name].length == 1) {
						var appdetails = data.accountDesc[data.account[0].name][0];
						sessionStorage.setItem("launchedApplicationName", appdetails.name);
						sessionStorage.setItem("launchedApplicationId", appdetails.applicationId);
						sessionStorage.setItem("ep-proj-active", JSON.stringify(appdetails));
						location.href = window.location.origin + "/" + accountDetails.name + "/" + appdetails.contextPath + "/pages" + "/dashboard.jsp";
					} else {
						location.href = window.location.origin + "/landing";
					}
				} else {
					$('form > *').wrap('<div class="blur-all">');
					bu.angular.pageScope.accountList = data.account;
					bu.angular.pageScope.$digest();
					$("#accountList").modal("show");
				}
			} else {
				toastr.error(data.status);
			}
		}
	});
	return false;
});