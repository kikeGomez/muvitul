'use strict';

angular.module('indexModule').service('dulceriaService', ['$http','GlobalFactory','config', function($http,GlobalFactory,config) {
 
	 this.consultarPeliculas = function(fechaExhibicion){
		 console.log("consultar peliculas");
		 return $http.get(config.baseUrl+"/ventaBoleto/peliculas", {
			 params : {
				 "fechaExhibicion" : fechaExhibicion
			}
		});
	 }
	 
	 this.consultarPromociones = function(fechaExhibicion){
		 console.log("consultar promociones");
		 return $http.get(config.baseUrl+"/ventaBoleto/promociones", {
			 params : {
				 "fechaExhibicion" : fechaExhibicion
			}
		});
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
	
	this.actualizarExistencias = function( existenciaBoletoVo ) {
		 console.log("actualizar existencias");
		return $http.put(config.baseUrl + "/ventaBoleto/existencias", existenciaBoletoVo );
	}
	
	 this.consultarVentas = function(){
			console.log("Consultar ventas");
		 return $http.get(config.baseUrl+"/ventaBoleto/ventas");
	 }
	 
	 this.crearVentas = function( ventaVo ) {
		 console.log("actualizar existencias");
		 return $http.post(config.baseUrl + "/ventaBoleto/ventas", ventaVo );
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

