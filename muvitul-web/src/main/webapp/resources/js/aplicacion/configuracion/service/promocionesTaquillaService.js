'use strict';

angular.module('indexModule').service('promocionesTaquillaService', ['$http','GlobalFactory','config', function($http,GlobalFactory,config) {

	this.consultarConfigPromociones = function(){
		console.log("consultar config promociones");
		return $http.get(config.baseUrl+"/configuracion/configPromociones");
	}
	
 
}]);

