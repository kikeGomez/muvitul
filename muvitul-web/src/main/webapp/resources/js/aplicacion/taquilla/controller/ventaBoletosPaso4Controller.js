'use strict';

var VentaBoletosPaso4Controller = angular.module('indexModule').controller("VentaBoletosPaso4Controller", function($controller,$scope){
	$scope.listaPagos			=[];
	$controller('VentaBoletosPaso3Controller',{$scope : $scope });
//	$controller('VentaBoletosPaso1Controller',{$scope : $scope });

	$scope.guardarPago =function(pago,formPagos){
		if ( formPagos.$invalid) {
            angular.forEach( formPagos.$error, function (field) {
              angular.forEach(field, function(errorField){
            	  errorField.$setDirty();
              })
            });
            return;
        }
	$scope.listaPagos.push(angular.copy(pago));
	}
	
	//Formas de pagos
	$scope.seleccionarFormaPago =function( formaPago, formPagos){
		formPagos.$setPristine();
 		$scope.pago.formaPago = formaPago;
	}
});