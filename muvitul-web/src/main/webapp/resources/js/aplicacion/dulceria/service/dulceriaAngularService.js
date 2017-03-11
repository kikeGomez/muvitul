'use strict';

angular.module('indexModule').service('dulceriaService', ['$http','GlobalFactory','config', function($http,GlobalFactory,config) {
 
	 this.consultarPeliculas = function(){
		 console.log("consultar peliculas");
		 return $http.get(config.baseUrl+"/ventaBoleto/peliculas");
	 }
	 
	 this.consultarPromociones = function(){
		 console.log("consultar promociones");
		 return $http.get(config.baseUrl+"/ventaBoleto/promociones");
	 }
	 
	this.consultarPrecios = function(idFormato){
		console.log("consultar precios");
		return $http.get(config.baseUrl+"/ventaBoleto/precios", {
			params : {
				"idFormato" : idFormato
			}
		});
	}

	 this.consultarFormasPago = function(){
			console.log("consultar formas pago");
		 return $http.get(config.baseUrl+"/catalogo/formaspago");
	 }
	
	 this.consultarExistencias = function(idProgramacion, idSala, fechaExhibicion){
		 console.log("consultar existencias");
		 return $http.get(config.baseUrl+"/ventaBoleto/existencias", {
			 params : {
				 "idProgramacion" : idProgramacion,
				 "idSala"	: idSala,
				 "fechaExhibicion":fechaExhibicion
				}
		 });
	 }
	
	this.actualizarExistenciaBoleto = function( existenciaBoletoVo ) {
		 console.log("actualizar existencias");
		return $http.put(config.baseUrl + "/ventaBoleto/existencias", existenciaBoletoVo );
	}
		
	this.consultarPaquetes = function(idPuntoVenta){
		console.log("consultar paquetes");
		return $http.get(config.baseUrl+"/ventaProducto/paquetes", {
			params : {
				"idPuntoVenta" : idPuntoVenta
			}
		});
	}
 
}]);

