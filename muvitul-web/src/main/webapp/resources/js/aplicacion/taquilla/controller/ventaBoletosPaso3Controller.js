'use strict';

var VentaBoletosPaso3Controller = angular.module('indexModule').controller("VentaBoletosPaso3Controller", function(taquillaService,$scope, $interval,$filter,$controller){
	
	$scope.Timer = null;
	$scope.asientosDisponibles   ={};
	$controller('VentaBoletosPaso2Controller',{$scope : $scope });
	
     $scope.StartTimer = function (paramsExistenciaBoleto) {
 		$scope.consultarExistenciaBoletos(paramsExistenciaBoleto);
        $scope.Timer = $interval(function () {	 $scope.consultarExistenciaBoletos(paramsExistenciaBoleto)  }, 5000);
     };

     $scope.StopTimer = function () {
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
	 	}).error(function(data) {
 	 	 
	 	});
	 }
	
});