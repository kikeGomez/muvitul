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
	 
	 this.consultarDescuentos = function(){
			console.log("Consultar descuentos");
		 return $http.get(config.baseUrl+"/ventaBoleto/descuentos");
	 }
	 
	 
	 this.crearDescuentos = function(promocionBoletoVO ){
		 console.log("consultar descuentos");
		 return $http.post(config.baseUrl + "/ventaBoleto/descuentos",promocionBoletoVO  );
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
		
		
	this.consultarPaquetes = function(){
		console.log("consultar paquetes");
		return $http.get(config.baseUrl+"/ventaProducto/paquetes");
	}
 
	this.consultarProductos = function(){
		console.log("consultar productos");
		return $http.get(config.baseUrl+"/configuracion/productos");
	}
 
	this.consultarPaquetes2 = function(){
		console.log("consultar paquetes");
		return $http.get(config.baseUrl+"/configuracion/paquetes");
	}
	
	this.consultarConfigProgramacion = function(){
		console.log("consultar config programacion");
		return $http.get(config.baseUrl+"/configuracion/configProgramaciones");
	}
	
	this.consultarConfigPromociones = function(){
		console.log("consultar config promociones");
		return $http.get(config.baseUrl+"/configuracion/configPromociones");
	}	
	
	this.consultarProgramaciones = function(fechaExhibicion){
		console.log("consultar programacion");

		 return $http.get(config.baseUrl+"/configuracion/programaciones", {
			 params : {
				 "fechaExhibicion":fechaExhibicion
				}
		 });
		 
	}	
	
	
	 this.crearProgramaciones = function( programacionVo ) {
		 console.log("crear programacion");
		 return $http.post(config.baseUrl + "/configuracion/programaciones", programacionVo );
	 }
	 
	this.eliminarProgramaciones = function( id ) {
		 console.log("eliminar programacion");
	 		return $http.delete(config.baseUrl + "/configuracion/programaciones", {
	 				params : {
	 	 				"id" : id
	 	 			}
	 			}
	 				
	 		);
	 }
		
	
}]);

