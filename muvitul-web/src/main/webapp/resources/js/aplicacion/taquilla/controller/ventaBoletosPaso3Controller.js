'use strict';

var VentaBoletosPaso3Controller = angular.module('indexModule').controller("VentaBoletosPaso3Controller", function(taquillaService,$scope, $interval,$filter,$controller){
	
	$scope.Timer = null;
	$scope.asientosDisponibles   ={};
	$scope.promocionBoletoVO ={};
	$controller('VentaBoletosPaso2Controller',{$scope : $scope });
	
     $scope.StartTimer = function (paramsExistenciaBoleto) {
    	 console.log("Iniciando Cron...");
 		$scope.consultarExistenciaBoletos(paramsExistenciaBoleto);
        $scope.Timer = $interval(function () {	 $scope.consultarExistenciaBoletos(paramsExistenciaBoleto)  }, 10000);
     };

     $scope.StopTimer = function () {
    	 console.log("Deteniendo Cron...");
         if (angular.isDefined($scope.Timer)) {
             $interval.cancel($scope.Timer);
         }
     };
     
 	//Consulta la existencia de boletos
	$scope.consultarExistenciaBoletos = function(paramsExistenciaBoleto) {
 		taquillaService.consultarExistenciaBoletos( paramsExistenciaBoleto ).success(function(data) {
			$scope.asientosDisponibles =data;
		}).error(function(data) {
 	 	 
	 	});
	 }
	
 	//Actualiza los boletos disponibles
	$scope.reservarBoleto = function(existenciaBoletoVO) {
 		taquillaService.updateExistenciaBoleto( existenciaBoletoVO ).success(function(data) {
			$scope.asientosDisponibles =data;
	 	}).error(function(data) {
 	 	 
	 	});
	 }
	 
	//Consultar descuentos Promocion
	$scope.consultarDescuentos = function(promocionBoletoVO) {
		taquillaService.consultarDescuentos(promocionBoletoVO).success(function(data) {
			console.log(data);
		}).error(function(data) {

		});
	}
	
	$scope.eliminar = function(array,index){
		 array.splice(index, 1);
	}
	
	 
	
});