'use strict';

var VentaBoletosPaso2Controller = angular.module('indexModule').controller("VentaBoletosPaso2Controller", function($scope, taquillaService,$controller){
	$scope.listaPromociones		={};
	$scope.paramsExistenciaBoleto={};
	//Consulta de promociones
	$scope.consultarPromociones =function(){
 		taquillaService.consultarPromociones().success(function(data) {	
 			$scope.listaPromociones=data;
  		  }).error(function(data) {
		  });
	}
	
	$scope.configParamsCron =function(programacion,fechaExhibicion){

		$scope.paramsExistenciaBoleto.fechaExhibicion=fechaExhibicion;
		$scope.paramsExistenciaBoleto.idProgramacion=programacion.idProgramacion;
		$scope.paramsExistenciaBoleto.idSala=programacion.salaVO.idSala;

	}
	
 
});