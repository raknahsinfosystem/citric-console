
var ep = ep || {};
ep.pageUtil = {
		pageCompile : null,
		pageScope : null,
		httpService:null,
		setPageCompile : function($compile){
			this.pageCompile=$compile;
		},
		pageCtrl : function($scope,$compile,httpService){
			this.pageScope = $scope;
			if($compile!=undefined){
				this.pageCompile=$compile;
			}
			this.httpService=httpService;
			$scope.regElementToAngular = function(dom) {
		        var angDOM = angular.element(dom);
		        $compile(angDOM)($scope);
	        };
	        this.pageScope.hitBindService = function(options){
				//var options = JSON.parse(optionsStr);
				var scope=ep.pageUtil.pageScope;
				try{
					//var endPoint='http://localhost:8082/';
					var endPoint,parentSession;
					if(document.defaultView.frameElement!=null){
						var parentWindow=document.defaultView.frameElement.ownerDocument.defaultView;
						parentSession=parentWindow.sessionStorage;
						var encryptedAES=parentSession.ENDPOINT_APP_SERVICE_URL;
						var decrypted = parentWindow.CryptoJS.AES.decrypt(encryptedAES, "ZXAtcGxhdGZvcm0=");
						endPoint = decrypted.toString(parentWindow.CryptoJS.enc.Utf8);
					}else{
						endPoint=window.location.host.replace('8081','8082')+'/';
						parentSession=sessionStorage;
					}
					endPoint="http://"+endPoint;
					var cxtPath=window.location.pathname.replace('/','');
					cxtPath=cxtPath.substring(0,cxtPath.indexOf('/'));
					//endPoint='http://freedom-poc.getsandbox.com/';
					var url=(options.api.startsWith('http'))?options.api : endPoint+cxtPath+'/action/api'+options.api;
				//	var url=(options.api.startsWith('http'))?options.api : endPoint+options.api;
					var requestData=scope[options.reqModel];
					var methodType=options.method.toUpperCase();
					var produceType=options.produceType;
					var consumeType=options.consumeType;
					var httpService=ep.pageUtil.httpService;
					var currHTTPObj;
					//methodType=methodType.toUpperCase();
					switch(methodType.toUpperCase()){
					case 'GET':
						currHTTPObj=httpService({
						     url: url, 
						     method: methodType,
						     headers:{
									'ep-username':parentSession.getItem("ep-username"),
									'accessedTimezone':new Date(),
									'Content-Type':'application/json'
								  },
						     data: (requestData==undefined) ? {}:requestData  
						});
						break;
					case 'POST':
						currHTTPObj=httpService({
						     url: url, 
						     method: methodType,
						     'Content-Type': 'application/json',
						     data: (requestData==undefined) ? {}:requestData  
						});
						break;
					case 'PUT':
						currHTTPObj=httpService({
						     url: url, 
						     method: methodType,
						     'Content-Type': 'application/json',
						     data: (requestData==undefined) ? {}:requestData  
						});
						break;
					}
					currHTTPObj.then(function(response) {  // for success reponse
						scope[options.respModel+'_arr']=response.data;
						var callbackMethod=($.type(options.callbackMethod)=='string') ? eval(options.callbackMethod):options.callbackMethod;
						var callbackData=options.callbackData;
						if(callbackMethod!=undefined){
								var reqOptions={url:url,methodType:methodType,data:requestData};
								var resOptions=response;
								var callbackData=options.callbackData;
								var dataCol={request:reqOptions,response:resOptions,callbackData:callbackData,reqOptions:options};
								callbackMethod(dataCol);
						}
					},
					function(response) {  // for error reponse
						scope[options.respModel+'_arr']=response.data;
						var callbackMethod=($.type(options.callbackMethod)=='string') ? eval(options.callbackMethod):options.callbackMethod;
						var callbackData=options.callbackData;
						if(callbackMethod!=undefined){
								var reqOptions={url:url,methodType:methodType,data:requestData};
								var resOptions=response;
								var callbackData=options.callbackData;
								var dataCol={request:reqOptions,response:resOptions,callbackData:callbackData,reqOptions:options};
								callbackMethod(dataCol);
						}  
					});
				}catch(ex){
					console.log(ex);
				}
			
			};
			$scope.validationOptions = {
	    			rules: {
					},
					messages: {
					},
					errorElement: "em",
					errorPlacement: function ( error, element ) {
						// Add the `help-block` class to the error element
						error.addClass( "help-block" );

						// Add `has-feedback` class to the parent div.form-group
						// in order to add icons to inputs
						element.parents( "div.form-group" ).addClass( "has-feedback" );

						if ( element.prop( "type" ) === "checkbox" ) {
							error.insertAfter( element.parent( "label" ) );
						} else {
							error.insertAfter( element );
						}

						// Add the span element, if doesn't exists, and apply the icon classes to it.
						if ( !element.next( "span" )[ 0 ] ) {
							$( "<span class='glyphicon glyphicon-remove form-control-feedback'></span>" ).insertAfter( element );
						}
					},
					success: function ( label, element ) {
						// Add the span element, if doesn't exists, and apply the icon classes to it.
						if ( !$( element ).next( "span" )[ 0 ] ) {
							$( "<span class='glyphicon glyphicon-ok form-control-feedback'></span>" ).insertAfter( $( element ) );
						}
					},
					highlight: function ( element, errorClass, validClass ) {
						$( element ).parents( "div.form-group" ).addClass( "has-error" ).removeClass( "has-success" );
						$( element ).next( "span" ).addClass( "glyphicon-remove" ).removeClass( "glyphicon-ok" );
					},
					unhighlight: function ( element, errorClass, validClass ) {
						$( element ).parents( "div.form-group" ).addClass( "has-success" ).removeClass( "has-error" );
						$( element ).next( "span" ).addClass( "glyphicon-ok" ).removeClass( "glyphicon-remove" );
					}
	    		};
			$scope.subTempFn = function(form){
				if(form.validate()) {
	    	        alert("Validated.. :>")
	    	    }
			}
			$scope.validateInit = function(htmlTemplate){
				htmlTemplate = $(htmlTemplate).find("form");
				var iframeScope = ep.pageUtil.pageScope;
				var ngVal = $(htmlTemplate).attr("ng-validate");
				var ngSub = $(htmlTemplate).attr("ng-submit");
				ngSub = ngSub.split("(");
				var formId = $(htmlTemplate).attr("id");
				//$("#"+formId).validate();
				iframeScope[ngVal] = iframeScope.validationOptions;
				iframeScope[ngSub[0]] = iframeScope.subTempFn;
				iframeScope.$digest();
				iframeScope.regElementToAngular(htmlTemplate);
			}
	    		
	}
}
ep.actions={
		removeResizable:function(resizeSel){
			var elementList;
			if(resizeSel){
				elementList=$(resizeSel);
			}else{
				elementList=$('.resizableCont.ui-resizable');
			}
			elementList.each(function(resizeContIndex,resizeCont){
					try{
  					$(resizeCont).resizable("destroy");
  				}catch(ex){
  					console.log(ex);
  				}
			});
		},
		triggerResizeContEvent:function(event,target){
			if(ep.pageUtil.target){
				$(ep.pageUtil.target).stop();
				ep.pageUtil.target = undefined;
				//$(ep.pageUtil.target).off();
				//$(ep.pageUtil.target).off('drag,dragStart,click');
				//$('body').css('cursor','default');
			}
			target=target?target:event.target;
			ep.pageUtil.rowColFlag = event.target;
			//this=event.target;
//			ep.angular.pageScope.currElem = event.target;
			if(target){
				//var target = event.target;
				if(!$(target).is('#stud_Cont')){
					if($(target).hasClass('resizableCont') == false)
						return;
					$(document).find('.iframe-OutlineSelectedNode').hide();
			  		$('.resizableCont').not($(target)).removeClass('selectedCont');
			  		$(target).toggleClass('selectedCont');
			  		if($(target).hasClass('selectedCont') == true){
			  			if($('.resizableCont').hasClass("ui-resizable") == true){
			  				try{
			  					$('.resizableCont.ui-resizable').resizable("destroy");
			  				}catch(ex){
			  					console.log(ex);
			  				}										
						}
			  			$(target).resizable({
							handles: "s, e, se",
							resize : function(event, ui){
								$(".iframe-OutlineSelectedNode").css("display","none");
								$(target).css("height", "");
								$(target).css("min-height", ui.size.height+"px");
								ep.pageUtil.target=target;
							},
							stop : function(event, ui){
								var parentWidth = $(ui.element).parent().css("width");
								var wInPer = (ui.size.width / (parseInt(parentWidth))) * 100;  //converting width pixel value to percentage
								$(ui.element).css("width", wInPer+"%").css("left","").css("top", "");
//								$(".iframe-OutlineSelectedNode").css("display","none");
								$('#iframe-OutlineSelectedNode').remove();
								$('.iframe-OutlineSelectedNode').remove();
								parent.ps.editor.undoStackRefresh();
								ep.pageUtil.target=undefined;
								//alert('done');
							}
						});
			  			//event.stopPropagation();
			  		}
				}
			}
		}
};
$(document).ready(function(){
	$('body').css('overflow-x','hidden');
	
	/*$(document).on('click',function(event){
		var currentTag = $(event.target).prop('tagName');
		var tagArr = ['INPUT','LABEL','TEXTAREA','H1','H2','H3','H4','H5','H6','P','SPAN'];
		var tagIndex = $.inArray(currentTag,tagArr);
		if(tagIndex != -1){
//			if(!$(event.target).hasClass('ui-draggable'))
				$(event.target).draggabilly();
		}
	});
*/
	
	/*if($(".Div").hasClass("ui-sortable")){
		var elementList;
		elementList = $('.Div.ui-sortable');
		elementList.each(function(sortContIndex,sortCont){
			try{
				$(sortCont).sortable("destroy");
			}catch(ex){
				console.log(ex);
			}
	});
	}
	if($(".connectedDiv.borderedDiv").hasClass("ui-sortable")){
		var elementList;
		elementList = $('.connectedDiv.borderedDiv.ui-sortable');
		elementList.each(function(sortContIndex,sortCont){
			try{
				$(sortCont).sortable("destroy");
			}catch(ex){
				console.log(ex);
			}
	});
	}
	if($(".borderedDiv").hasClass("ui-sortable")){
		var elementList;
		elementList = $('.borderedDiv.ui-sortable');
		elementList.each(function(sortContIndex,sortCont){
			try{
				$(sortCont).sortable("destroy");
			}catch(ex){
				console.log(ex);
			}
	});
	}*/
	/*$(document).on("click", '.Div', function(){
		$( ".Div" ).sortable();
		$( ".Div" ).disableSelection();
		var elementList;
		if($(".connectedDiv.borderedDiv").hasClass("ui-sortable")){
			elementList = $('.connectedDiv.borderedDiv.ui-sortable');
			elementList.each(function(sortContIndex,sortCont){
				try{
					$(sortCont).sortable("destroy");
				}catch(ex){
					console.log(ex);
				}
		});
		}
		if($(".borderedDiv").hasClass("ui-sortable")){
			elementList = $('.borderedDiv.ui-sortable');
			elementList.each(function(sortContIndex,sortCont){
				try{
					$(sortCont).sortable("destroy");
				}catch(ex){
					console.log(ex);
				}
		});
		}
	});
	$(document).on("click", '.connectedDiv.borderedDiv', function(){
		var elementList;
		if($(".Div").hasClass("ui-sortable")){
			elementList = $('.Div.ui-sortable');
			elementList.each(function(sortContIndex,sortCont){
				try{
					$(sortCont).sortable("destroy");
				}catch(ex){
					console.log(ex);
				}
		});
		}
		if($(".borderedDiv").hasClass("ui-sortable")){
			elementList = $('.borderedDiv.ui-sortable');
			elementList.each(function(sortContIndex,sortCont){
				try{
					$(sortCont).sortable("destroy");
				}catch(ex){
					console.log(ex);
				}
		});
		}
		$( ".connectedDiv.borderedDiv" ).sortable();
		$( ".connectedDiv.borderedDiv" ).disableSelection();
	});
	$(document).on("click", '.borderedDiv', function(){
		var elementList;
		if($(".Div").hasClass("ui-sortable")){
			elementList = $('.Div.ui-sortable');
			elementList.each(function(sortContIndex,sortCont){
				try{
					$(sortCont).sortable("destroy");
				}catch(ex){
					console.log(ex);
				}
		});
		}
		if($(".connectedDiv.borderedDiv").hasClass("ui-sortable")){
			elementList = $('.connectedDiv.borderedDiv.ui-sortable');
			elementList.each(function(sortContIndex,sortCont){
				try{
					$(sortCont).sortable("destroy");
				}catch(ex){
					console.log(ex);
				}
		});
		}
		$( ".borderedDiv" ).sortable();
		$( ".borderedDiv" ).disableSelection();
	});*/
	/*$(document).on("click", '.resizableCont', function(event){
		if(ep.pageUtil.target){
			$(ep.pageUtil.target).stop();
			ep.pageUtil.target = undefined;
		}
		ep.pageUtil.rowColFlag = event.target;
//		ep.angular.pageScope.currElem = event.target;
		if(ep.pageUtil.rowColFlag == this && event.target!=event.currentTarget){
			var target = event.target;
			if(!$(target).is('#stud_Cont')){
				if($(target).hasClass('resizableCont') == false)
					return;
				$(document).find('.iframe-OutlineSelectedNode').hide();
		  		$('.resizableCont').not($(this)).removeClass('selectedCont');
		  		$(this).toggleClass('selectedCont');
		  		if($(this).hasClass('selectedCont') == true){
		  			if($('.resizableCont').hasClass("ui-resizable") == true){
		  				try{
		  					$('.resizableCont.ui-resizable').resizable("destroy");
		  				}catch(ex){
		  					console.log(ex);
		  				}										
					}
		  			$(target).resizable({
						handles: "s, e, se",
						resize : function(event, ui){
							$(".iframe-OutlineSelectedNode").css("display","none");
							$(this).css("height", "");
							$(this).css("min-height", ui.size.height+"px");
							ep.pageUtil.target=this;
						},
						stop : function(event, ui){
							var parentWidth = $(ui.element).parent().css("width");
							var wInPer = (ui.size.width / (parseInt(parentWidth))) * 100;  //converting width pixel value to percentage
							$(ui.element).css("width", wInPer+"%").css("left","").css("top", "");
//							$(".iframe-OutlineSelectedNode").css("display","none");
							$('#iframe-OutlineSelectedNode').remove();
							$('.iframe-OutlineSelectedNode').remove();
							parent.ps.editor.undoStackRefresh();
							ep.pageUtil.target=undefined;
							//alert('done');
						}
					});
		  			event.stopPropagation();
		  		}
			}
		}
	});*/
	/*$(document).on("click", '#stud_Cont', function(){
		if($(event.target).is('#stud_Cont')){
			if($('.resizableCont').hasClass("ui-resizable") == true){
			     $('.resizableCont.ui-resizable').resizable("destroy");										
			}
		}
	});*/
	$(document).on("click", 'a', function(ev){
		ev.preventDefault();
	});
});
//$(window).on('resize', function () {
//	var selector = "#pageframe";
//	var sel = $(selector).contents();
//	var parent = $(selector)[0].contentWindow;
//	ps.editor.handleElementSelector("delete");
//	ps.editor.handleElementSelector("insert");
//});