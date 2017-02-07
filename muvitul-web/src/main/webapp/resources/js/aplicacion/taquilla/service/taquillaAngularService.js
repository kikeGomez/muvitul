'use strict';

angular.module('indexModule').service('taquillaService', ['$http','GlobalFactory', function($http,GlobalFactory) {
 
 this.consultarPromociones = function(){
		 console.log("consultarPromociones");

		return $http.get("http://localhost:8080/muvitul-service/rest/ventaBoleto");
	}
}]);
