angular.module('indexModule').constant("constante", {

	// baseUrl: "http://localhost:8080/muvitul-service/rest"
	urlWs : "/muvitul-service/rest"

});

angular.module('indexModule').factory(
		'config',
		[ '$http', '$location', 'constante', '$rootScope',
				function($http, $location, constante, $rootScope) {

					var protocol = $location.protocol() + "://";
					var host = location.host;
					var url = protocol + host + constante.urlWs;
					var absUrl = $location.absUrl();
					var arrayLocation = $location.absUrl().split('/');
					var path = '/' + arrayLocation[3];
					$rootScope.applet_route = url;

					return {
						baseUrl : url,
						host : host,
						path : path,
						absUrl : absUrl,
						arrayLocation : arrayLocation
					}
				} ]);

angular.module('indexModule').directive('calendar', function() {
	return {
		require : 'ngModel',
		link : function(scope, el, attr, ngModel) {
			$(el).datepicker({
				format : 'dd/mm/yyyy',
				autoclose : true,
				calender_style : "picker_3",
				startDate : new Date(),
				todayHighlight : true,
				todayBtn : "linked",
				onSelect : function(dateText) {
					scope.$apply(function() {
						ngModel.$setViewValue(dateText);
					});
				}
			});
		}
	}
});
