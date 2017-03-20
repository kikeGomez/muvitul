'use strict';

angular.module('indexModule').service('taquillaService', ['$http','GlobalFactory','config', function($http,GlobalFactory,config) {
 
 	 this.consultarPeliculas = function(fechaExhibicion){
		 return $http.get(config.baseUrl+"/ventaBoleto/peliculas", {
				params : {"fechaExhibicion" : fechaExhibicion }
		  });
	 }
	 
	 this.consultarPromociones = function(fechaExhibicion){
		return $http.get(config.baseUrl+"/ventaBoleto/promociones", {
			params : {"fechaExhibicion" : fechaExhibicion }
		  });
	 }
 
	 this.consultarPreciosFormato = function(idFormato){
		 return $http.get(config.baseUrl+"/ventaBoleto/precios", {
				params : {"idFormato" : idFormato }
		  });
	 }
	 this.consultarFormasPago = function(){
 		 return $http.get(config.baseUrl+"/catalogo/formaspago");
	 }
	 
	 this.consultarExistenciaBoletos = function(paramsExistenciaBoleto){

		 return $http.get(config.baseUrl+"/ventaBoleto/existencias", {
				params : {
						"idProgramacion" : paramsExistenciaBoleto.idProgramacion ,
						"idSala" : paramsExistenciaBoleto.idSala ,
						"fechaExhibicion" : paramsExistenciaBoleto.fechaExhibicion 
					}
		  });
	 }
	 
	 this.updateExistenciaBoleto = function(existenciaBoletoVO){
 		 return $http.put(config.baseUrl+"/ventaBoleto/existencias",existenciaBoletoVO);
	 }
	 
	  
}]);