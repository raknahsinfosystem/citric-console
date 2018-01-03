<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.util.ConfigurationProperties"%>
<%@page import="com.util.AppConstants"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="org.apache.http.HttpResponse"%>
<%@page import="org.apache.http.entity.StringEntity"%>
<%@page import="org.apache.http.client.methods.HttpPost"%>
<%@page import="org.apache.http.impl.client.HttpClientBuilder"%>
<%@page import="org.apache.http.client.HttpClient"%>
<%@page import="org.json.JSONObject"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.Map"%>
<%@page import="org.json.JSONArray"%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome to Bonito</title>

<!-- <style> -->
<!-- /* @import url('https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700'); */ -->
<!-- </style>  -->
<link href="../../ext/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="../../ext/plugins/font-awesome/css/font-awesome.css" rel="stylesheet" type="text/css">
<link href="../../Singapp/vendor/toastr/css/toastr.css" rel="stylesheet">
<link href="../../css/main-edited.css" rel="stylesheet" type="text/css">
<style type="text/css">
.blur-all {
	-webkit-filter: blur(10px);
	-moz-filter: blur(10px);
	-o-filter: blur(10px);
	-ms-filter: blur(10px);
	filter: blur(10px);
}

.modal-body {
	max-height: 195px;
    overflow-y: auto;
}

.modal-body h4 {
	text-align: center;
	font-size: 12pt;
	margin-top: 42px;
}

.modal-header {
	padding: 9px 13px;
}

.modal-content {
	border-radius: 0px;
}

.modal-dialog {
	margin: 137px auto;
}
.page-loader {
    display:    none;
    position:   absolute;
    z-index:    1000;
    top:        0;
    left:       0;
    height:     100%;
    width:      100%;
    background: rgba( 255, 255, 255, .8 ) 
                url('../style/images/loader.gif') 
                50% 50% 
                no-repeat;
}/* url('http://sampsonresume.com/labs/pIkfp.gif')  */
</style>
<script type="text/javascript">
	if(window.self != window.top){
		window.top.location.href = window.self.location.href;
	}
	sessionStorage.clear();
</script>
</head>

<body ng-app="login" ng-controller="myCtrl">
	<div class="login_container">
		<div id="loginbox" class="loginbox">
			<form class="login-form mt-lg" id="loginForm" action="../../api/login" method="post">
				<img src="../../resources/images/logo.png"><br> 
				<input required="required" name="uname" type="text" placeholder="Username"><br>
				<input required="required" name="password" type="password" placeholder="Password">
				<p>
					<a href="#">Forgot Username?</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="#">Forgot Password?</a>
				</p>
				<a href="application.html"><input type="submit" name="Login" type="button" class="login" id="Login" value="Login"></a><br>
				<a href="signup"><input name="Sign up" type="button" class="login" id="Signup" value="Sign up" style="background-color:#f49419"></a>
			</form>
		</div>
		<div class="acount_list_container">
			<div class="col-md-12 acount_list_header">
				<h3>
					Please Select Account
					<button class="btn btn-link pull-right" ng-click="account.showCreateview()">Create New Account</button>
				</h3>
			</div>
			<div class="col-md-12" style="overflow: auto; max-height: calc(100% - 55px);">
				<!-- <ul class="list-group">
				  <li class="list-group-item" ng-repeat="acccount in accountList" ng-click="launchAccount(acccount)">{{acccount.name}}</li>
				</ul> -->
				<div class="col-md-12 text-center" ng-repeat="acccount in accountList">
					<a style="cursor: pointer;" ng-click="launchAccount(acccount)">
						<h4>{{acccount.accountFullName}}</h4>
					</a>
				</div>
			</div>
		</div>
		<div class="acount_list_container">
			<div class="col-md-12 acount_list_header">
				<h3>
					Create New Account
					<button class="btn btn-link pull-right" ng-click="account.showAcountListView()">Select Account</button>
				</h3>
			</div>
			<div class="col-md-12 loginbox">
				<input type="text" ng-model="account.accountFullName" placeholder="Account Name"><br>
				<input id="accountName" type="text" ng-model="account.name" placeholder="Account Short Name" maxlength="7"><br>
				<input type="text" ng-model="account.description" placeholder="Description"><br>
				<button class="btn btn-primary" style="margin-top: 30px;" ng-click="account.save()">Create Account</button>
			</div>
		</div>
	</div>
	
	<div class="page-loader"></div>

	<div id="accountList" class="modal fade" role="dialog"
		class="modal hide" data-backdrop="static" data-keyboard="false">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<!-- <button type="button" class="close" data-dismiss="modal">&times;</button> -->
					<h1 class="modal-title">Please select account!</h1>
				</div>
				<div class="modal-body">
					<div style="text-align: center" ng-repeat="acccount in accountList">
						<a style="cursor: pointer;" ng-click="launchAccount(acccount)">
							<span class=""><h3 ng-bind="acccount.name"></h3></span>
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%
	HttpSession httpSession = request.getSession(false);
	if(httpSession != null) {
		httpSession.invalidate();
	}
	%>
</body>
<script src="../../ext/browser-comp-prototypes.js"></script>
<script src="../../ext/plugins/jquery/jquery.js"></script>
<script src="../../Singapp/vendor/toastr/toastr.js"></script>
<script src="../../ext/plugins/jquery/jquery-ui.min.js"></script>
<script src="../../ext/plugins/js/angular.min.js"></script>
<script src="../../ext/plugins/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="../../ext/plugins/Crypto/aes.js"></script>
<script src="../../ext/bind-util.js"></script>
<script src="../../ext/defend-invokeapi.js"></script>
<script src="../../ext/login.js"></script>
<script type="text/javascript" class="notToDisplay">
	$(".notToDisplay").remove();
</script>
</html>