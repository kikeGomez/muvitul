'use strict';

angular.module('indexModule').service('dulceriaService', ['$http','GlobalFactory', function($http,GlobalFactory) {
 
 this.consultar = function(){
		 console.log("consultar");

		return $http.get("http://localhost:8080/muvitul-service/rest/ventaBoleto");
	}
}]);
