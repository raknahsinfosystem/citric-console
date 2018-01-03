<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" ng-app="ep-app">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="favicon.ico">

<title>Index</title>
<link id="active_theme" href="../css/theme/app.css" rel="stylesheet">
<link href="../../../ext/assets/css/layout.css" rel="stylesheet">
<link href="../css/template.css" rel="stylesheet">
<link href="../../../ext/plugins/loadingModal/jquery.loadingModal.css"
	rel="stylesheet">
<link href="../../../ext/plugins/font-awesome/css/font-awesome.css"
	rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="../../../ext/plugins/jstree/style.min.css">
<link rel="stylesheet"
	href="../../../ext/plugins/jstree/themes/proton/style.css">
<link
	href="../../../ext/plugins/datetimepicker-master/bootstrap-datetimepicker.css"
	rel="stylesheet" type="text/css" />
<!-- <link rel="stylesheet" href="../css/custom.css"> -->
<link ep-mode="design" rel="stylesheet"
	href="../../../Singapp/vendor/jquery-ui/themes/base/jquery-ui.css">
<link ep-mode="design" rel="stylesheet" href="../../../style/iframe.css">
<link rel="stylesheet"
	href="../../../ext/plugins/dataTable/css/jquery.dataTables.min.css">
<link rel="stylesheet"
	href="../../../ext/plugins/dataTable/css/select.dataTables.css">
<link rel="stylesheet"
	href="../../../ext/plugins/dataTable/css/buttons.dataTables.min.css">
<link rel="stylesheet" href="../../../ext/plugins/dataTable/css/colReorder.dataTables.min.css">
<link ep-mode="runtime"
	href="../../../Singapp/vendor/toastr/css/toastr.css" rel="stylesheet">
<link href="../../../ext/plugins/file-uploader/css/style.css" rel="stylesheet" type="text/css">
<link href="../../../ext/assets/css/select2.min.css" rel="stylesheet" type="text/css">

<!-- custom needs js plugins start-->
<script src="../../../ext/browser-comp-prototypes.js"></script>
<script src="../../../ext/assets/js/plugins/jquery/jquery.js"></script>
<script ep-mode="design"
	src="../../../ext/assets/js/plugins/jquery/jquery-ui.min.js"></script>
<script
	src="../../../ext/assets/js/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<script
	src="../../../ext/assets/js/plugins/validation/jquery.validate.min.js"></script>
<script
	src="../../../ext/assets/js/plugins/validation/additional-methods.min.js"></script>
<script
	src="../../../ext/plugins/loadingModal/jquery.loadingModal-mod.js"></script>
<script ep-mode="runtime" src="../../../ext/plugins/js/angular.min.js"></script>
<script ep-mode="runtime"
	src="../../../ext/plugins/js/angular-filter.js"></script>
<script ep-mode="runtime"
	src="../../../ext/assets/js/plugins/validation/angular-validate.js"></script>
<script ep-mode="runtime" src="../../../ext/ep-session.js"></script>
<script type="text/javascript" src="../../../ext/plugins/Crypto/aes.js"></script>
<script src="../../../ext/plugins/Crypto/easeljs-0.8.2.min.js"></script>
<script src="../../../ext/plugins/js/moment.js"></script>
<script
	src="../../../ext/plugins/datetimepicker-master/bootstrap-datetimepicker.min.js"></script>
<script
	src="../../../ext/plugins/dataTable/lib/jquery.dataTables.min.js"
	type="text/javascript"></script>
<script src="../../../ext/plugins/dataTable/lib/dataTables.select.js"
	type="text/javascript"></script>
<script
	src="../../../ext/plugins/dataTable/lib/dist/dataTables.buttons.min.js"
	type="text/javascript"></script>
<script src="../../../Singapp/datatable/src/angular-datatables.min.js"></script>
<script
	src="../../../Singapp/datatable/src/angular-datatables.buttons.min.js"></script>
<script src="../../../ext/plugins/dataTable/lib/dist/jszip.min.js"
	type="text/javascript"></script>
<script src="../../../ext/plugins/dataTable/lib/dist/buttons.colVis.js"
	type="text/javascript"></script>
<script src="../../../ext/plugins/dataTable/lib/dist/buttons.flash.js"
	type="text/javascript"></script>
<script
	src="../../../ext/plugins/dataTable/lib/dist/buttons.html5.min.js"
	type="text/javascript"></script>
<script
	src="../../../ext/plugins/dataTable/lib/dist/buttons.print.min.js"
	type="text/javascript"></script>
<script src="../../../ext/plugins/dataTable/lib/dist/pdfmake.min.js"
	type="text/javascript"></script>
	<script src="../../../ext/plugins/dataTable/lib/dist/vfs_fonts.js" type="text/javascript"></script>
<script src="../../../ext/plugins/dataTable/lib/dist/dataTables.colReorder.min.js" type="text/javascript"></script>
<script src="../../../ext/plugins/file-uploader/js/jquery.knob.js" type="text/javascript"></script>
<script src="../../../ext/plugins/file-uploader/js/jquery.ui.widget.js" type="text/javascript"></script>
<script src="../../../ext/plugins/file-uploader/js/jquery.iframe-transport.js" type="text/javascript"></script>
<script src="../../../ext/plugins/file-uploader/js/jquery.fileupload.js" type="text/javascript"></script>
<script src="../../../ext/plugins/file-uploader/js/script.js" type="text/javascript"></script>
<script ep-mode="design" src="../../../script/custom.js"></script>
<script src="../../../ext/bind-util.js" type="text/javascript"></script>
<script src="../../../ext/lib-util.js" type="text/javascript"></script>
<script src="../../../ext/permission-mapping.js"></script>
<script src="../../../ext/assets/js/select2.full.min.js"></script>
<script ep-mode="runtime" src="../../../Singapp/vendor/toastr/toastr.js"></script>
<!-- <script ep-mode="runtime" src="../../../ext/plugins/angular/select2/select2.js"></script> -->

<!-- custom needs js plugins end-->
<style>
td.ep-expand {
	background: url('../../../resources/img/expand-left.png') no-repeat
		center center !important;
	cursor: pointer;
}

tr.details td.ep-expand {
	background: url('../../../resources/img/expand-down.png') no-repeat
		center center !important;
}
</style>
</head>

<body ng-controller="ep-ctrl" class="ep-body">
	<jsp:include page="header.jsp"></jsp:include>
<div id="stud_Cont" data-draggable="target"
		class="col-md-12 droppable notSelectable"
		style="min-height: 500px;!important"></div>

	<script type="text/javascript">
		bu.angular.readyEvent.saveReadyEvents();
		var papp = angular.module('ep-app', [ "ep-session", "angular.filter",
				"ngValidate", "datatables", "datatables.buttons"]);
		bu.angular.loadPageFilters(papp);
		papp.controller('ep-ctrl', function($scope, $compile, $http, $filter,
				DTOptionsBuilder) {
			bu.angular.pageCtrl($scope, undefined, $compile, $http, $filter,
					DTOptionsBuilder);
			bu.utils.setPreviousToscope();
			bu.angular.pageScope.initPage();
			bu.angular.readyEvent.callReadyEvents();
			//     	ep.pageUtil.pageCtrl($scope, $compile,$http);
		});
		$(document).ready(function() {
			$(document).on('click','#list', function(event){
	        	event.preventDefault();
	            $('#list').addClass('active');
	            $('#grid').removeClass('active');
	            $('#products .item').addClass('list-group-item');
	        });
	        $(document).on('click','#grid', function(event){
	        	event.preventDefault();
	            $('#list').removeClass('active');
	            $('#grid').addClass('active');
	            $('#products .item').removeClass('list-group-item');
	            $('#products .item').addClass('grid-group-item');
	        });
			bu.angular.pageScope.GET_PAGE_OBJECT_PERMISSION = {};
			bu.utils.invokeAPI("GET_PAGE_OBJECT_PERMISSION", function(resp){
	          	console.log(resp.response[0]);
				if(resp.response.length>0){
	          		bu.angular.pageScope.userPermission = resp.response[0];
	          		if(bu.angular.pageScope.$$phase == null){
	          			bu.angular.pageScope.$digest();
	          		}
	          		mapPer.control.mappings(bu.angular.pageScope.userPermission);
	          		delete bu.angular.pageScope.userPermission;
	          	}else{
	          		
	          	}
	          });
			if (self == top) {
				$("#stud_Cont").addClass("topVal");
			} else {
				$("#stud_Cont").removeClass("topVal");
			}
		});
	</script>
</body>
</html>