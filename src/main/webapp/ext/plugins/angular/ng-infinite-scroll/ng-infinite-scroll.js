var mod;

mod = angular.module("infinite-scroll", []);

mod.directive("infiniteScroll", ["$rootScope", "$timeout", function($rootScope, $timeout) {
	return {
		link: function(scope, elem, attrs) {
			var checkWhenEnabled, handler, scrollDistance, scrollEnabled;
			scrollDistance = 0;
			if (attrs.infiniteScrollDistance != null) {
				scope.$watch(attrs.infiniteScrollDistance, function(value) {
					return scrollDistance = parseInt(value, 10);
				});
			}
			scrollEnabled = true;
			checkWhenEnabled = false;
			if (attrs.infiniteScrollDisabled != null) {
				scope.$watch(attrs.infiniteScrollDisabled, function(value) {
					scrollEnabled = !value;
					if (scrollEnabled && checkWhenEnabled) {
						checkWhenEnabled = false;
						return handler();
					}
				});
			}
			handler = function() {
				var _elem = elem[0];
				_elem.previousElementSibling.style.marginLeft = (_elem.scrollLeft * -1) + "px"
				var isScrollVisiable = _elem.scrollHeight > elem.height();
				if(isScrollVisiable){
					elem.parent().addClass("scroll-visiable");
				}else{
					elem.parent().removeClass("scroll-visiable");
				}
				var shouldScroll = elem.offset().top <= elem.height() * scrollDistance;
				if (shouldScroll && scrollEnabled) {
					if ($rootScope.$$phase) {
						return scope.$eval(attrs.infiniteScroll);
					} else {
						return scope.$apply(attrs.infiniteScroll);
					}
				} else if (shouldScroll) {
					return checkWhenEnabled = true;
				}
			};
			elem.on("scroll", handler);
			scope.$on("$destroy", function() {
				return elem.off("scroll", handler);
			});
			return $timeout((function() {
				if (attrs.infiniteScrollImmediateCheck) {
					if (scope.$eval(attrs.infiniteScrollImmediateCheck)) {
						return handler();
					}
				} else {
					return handler();
				}
			}), 0);
		}
	};
}]);
mod.directive("infiniteScrollRepeat", ["$rootScope", "$timeout", function($rootScope, $timeout) {
	return {
		link: function(scope, elem, attrs) {
			if(scope.$last){
				$timeout(function(){
					var infinit_scroll_container = elem.parent().parent().parent();
					var isScrollVisiable = infinit_scroll_container[0].scrollHeight > infinit_scroll_container.height();
					if(isScrollVisiable){
						infinit_scroll_container.parent().addClass("scroll-visiable");
					}else{
						infinit_scroll_container.parent().removeClass("scroll-visiable");
					}
				}, 0);
			} 
		}
	};
}]);