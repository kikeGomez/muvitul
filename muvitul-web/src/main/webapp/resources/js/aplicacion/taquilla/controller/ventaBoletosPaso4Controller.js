'use strict';

var VentaBoletosPaso4Controller = angular.module('indexModule').controller("VentaBoletosPaso4Controller", function($controller,$scope,ModalService,calculosFactory){
	
	$scope.listaPagos			=[];
 	$scope.pago				    ={subtotal:0, porPagar:0, pagado:0};
 	$controller('VentaBoletosPaso3Controller',{$scope : $scope });
    $controller('modalController',{$scope : $scope });
 
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

        	 if($scope.pago.subtotal < $scope.pago.pagado){
        		 $scope.listaPagos.pop();
  			     $scope.calcularTotalPagado($scope.listaPagos);
  	            $scope.showAviso("Estas pagando de mas  ");
        	 }
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
 
	
	 $scope.confirmacionVenta = function(venta){
		 /* Modal Confirmacion */
			$scope.showConfirmacion = function(messageTo){
				ModalService.showModal({
			    	templateUrl: 'vistas/templatemodal/templateModalConfirmacion.html',
			        controller: 'mensajeModalController',
			        	inputs:{ message: messageTo}
			    }).then(function(modal) {
			        modal.element.modal();
			        modal.close.then(function(result) {
			        	if(result){
			        		$scope.procesarVenta(venta);
			        	}
			        }); 
			    });
			};
		 
			$scope.showConfirmacion ("¿Est\u00e1 seguro de terminar la compra ?");
		 
	};
	//ProcesarVenta
	$scope.procesarVenta =function( venta ){
		$scope.asignarPaso(5);
		venta.pagoVO=$scope.listaPagos;
		console.log(venta);
		console.log( $scope.boletos);
	}
	
	 
});