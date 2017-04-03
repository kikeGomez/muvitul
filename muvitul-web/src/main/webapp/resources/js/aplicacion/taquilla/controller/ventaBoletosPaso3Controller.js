'use strict';

var VentaBoletosPaso3Controller = angular.module('indexModule').controller("VentaBoletosPaso3Controller", function(taquillaService,$scope, $interval,$filter,$controller){
	$scope.listaPreciosXFormato	={};
	$scope.totalDescuento ={};
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
			console.log(data);
		}).error(function(data) {
 	 	 
	 	});
	 }
	
 	//Actualiza los boletos disponibles
	$scope.reservarBoleto = function(existenciaBoletoVO) {
		console.log(existenciaBoletoVO);
 		taquillaService.updateExistenciaBoleto( existenciaBoletoVO ).success(function(data) {
			$scope.asientosDisponibles =data;
			console.log(data);
	 	}).error(function(data) {
 	 	 
	 	});
	 }
	
	//Consulta de precios por formato
	$scope.consultarPreciosFormato =function(){
		$scope.boletos=[];
 		taquillaService.consultarPreciosFormato($scope.objetosVenta.programacion.formatoVO.idFormato).success(function(data) {	
 			$scope.listaPreciosXFormato=data;
 			angular.forEach($scope.listaPreciosXFormato, function(value, key){
	 			 $scope.boletos.push({ cantidad:0, tipoCliente:value.tipoClienteVO.nombre,tipoClienteVO:value.tipoClienteVO,  subtotal:0, precio:value.precio, importe:value.precio, programacionVO : $scope.objetosVenta.programacion,fechaExhibicion: new Date($scope.fechaExhibicion) })
	 			  value.boletosSeleccionados =0;
 			});
 			$scope.listaPreciosXFormato.boletos=$scope.boletos;
 	  		$scope.promocionBoletoVO.boletosXTicketVO=$scope.boletos

  		  }).error(function(data) {
		  });
	}
	 
	//Consultar descuentos Promocion
	$scope.consultarDescuentos = function(promocionBoletoVO) {
		taquillaService.consultarDescuentos(promocionBoletoVO).success(function(data) {
 
			$scope.totalDescuento=data;
	  		$scope.pago.subtotal -=$scope.totalDescuento;

 			angular.forEach($scope.boletos, function(value, key){
	  			if(value.tipoCliente ==="Promocion")
	  				value.subtotal =data;
			});
		}).error(function(data) {

		});
	}
	
	$scope.eliminar = function(array,index){
		 array.splice(index, 1);
	}
	
	 
	
});