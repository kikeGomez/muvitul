'use strict';

angular.module('indexModule').service('programacionesTaquillaService', ['$http','GlobalFactory','config', function($http,GlobalFactory,config) {

	this.consultarConfigProgramacion = function(){
		console.log("consultar config programacion");
		return $http.get(config.baseUrl+"/configuracion/configProgramaciones");
	}
	
 
}]);

