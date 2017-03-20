'use strict';

var VentaBoletosPaso4Controller = angular.module('indexModule').controller("VentaBoletosPaso4Controller", function($controller,$scope,calculosFactory){
	
	$scope.listaPagos			=[];
	$controller('VentaBoletosPaso3Controller',{$scope : $scope });
 	$scope.pago				    ={subtotal:0, porPagar:0, pagado:0};

	$scope.guardarPago =function(pago,formPagos){
		if ( formPagos.$invalid) {
            angular.forEach( formPagos.$error, function (field) {
              angular.forEach(field, function(errorField){
            	  errorField.$setDirty();
              })
            });
            $scope.showAviso("Es necesario llenar los campos obligatorios ");
         }else{ 
			$scope.listaPagos.push(angular.copy(pago));
			$scope.calcularTotalPagado($scope.listaPagos);
        }
	}
	
	//Obtiene las formas de pago
	$scope.seleccionarFormaPago =function( formaPago, formPagos){
		formPagos.$setPristine();
 		$scope.pago.formaPago = formaPago;
	}
	
	$scope.calcularTotalPagado =function(listaPagos){
		$scope.pago.pagado=0;
		 angular.forEach( listaPagos, function (data) {
 			 $scope.pago.pagado  = calculosFactory.suma($scope.pago.pagado, data.importe);
		 });
		 $scope.pago.porPagar =calculosFactory.resta($scope.pago.subtotal,$scope.pago.pagado);
	}
		 
	 
});