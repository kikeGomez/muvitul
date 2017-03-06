'use strict';

angular.module('indexModule').service('dulceriaService', ['$http','GlobalFactory','config', function($http,GlobalFactory,config) {
 
	 this.consultarPromociones = function(){
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
			console.log("consultar formas pago");
		 return $http.get(config.baseUrl+"/catalogo/formaspago");
	 }
	 
		this.consultarPaquetes = function(){
			console.log("consultar paquetes");
			return $http.get(config.baseUrl+"/ventaProducto/paquetes", {
				params : {
					"idPuntoVenta" : 1
				}
			});
		}
 
}]);

