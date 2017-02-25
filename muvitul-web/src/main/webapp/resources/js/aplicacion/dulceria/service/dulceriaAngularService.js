'use strict';

angular.module('indexModule').service('dulceriaService', ['$http','GlobalFactory','config', function($http,GlobalFactory,config) {
 
	 this.consultar = function(){
			console.log("consultar");
		 return $http.get(config.baseUrl+"/ventaBoleto/promociones");
	 }
	 
	this.consultarPrecios = function(){
		console.log("consultar precios");
		return $http.get(config.baseUrl+"/ventaBoleto/precios", {
			params : {
				"idFormato" : 1
			}
		});
	}

	 this.consultarFormasPago = function(){
			console.log("consultar");
		 return $http.get(config.baseUrl+"/catalogo/formaspago");
	 }
	 
 
}]);

