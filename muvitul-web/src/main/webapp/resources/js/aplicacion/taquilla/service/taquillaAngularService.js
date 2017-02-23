'use strict';

angular.module('indexModule').service('taquillaService', ['$http','GlobalFactory','config', function($http,GlobalFactory,config) {
 
 this.consultarPeliculas = function(){
	 return $http.get(config.baseUrl+"/ventaBoleto/peliculas");
 }
 
 this.consultarPromociones = function(){
	return $http.get(config.baseUrl+"/ventaBoleto/promociones");
}
}]);