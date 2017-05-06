'use strict';

var VentaBoletosPaso4Controller = angular.module('indexModule').controller("VentaBoletosPaso4Controller", function($controller,$scope,$filter,ModalService,calculosFactory,taquillaService){
	
	$scope.listaPagos			=[];
	$scope.listaFormasPago		={};
	$scope.estatusPagoVO ={idEstatus:'1',nombre:'PAGADO'}
 	$scope.pago				    ={subtotalAux:0,subtotal:0, porPagar:0, pagado:0,estatusPagoVO:$scope.estatusPagoVO};
 	$controller('VentaBoletosPaso3Controller',{$scope : $scope });
 	$controller('VentaBoletosPaso5Controller',{$scope : $scope });

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
        	pago.fecha=new Date();
 			$scope.listaPagos.push(angular.copy(pago));
 			$scope.calcularTotalPagado($scope.listaPagos);

        	 if($scope.pago.subtotal < $scope.pago.pagado){
        		 $scope.listaPagos.pop();
  			     $scope.calcularTotalPagado($scope.listaPagos);
  	            $scope.showAviso("El monto que quieres pagar es menor al restante por pagar.");
        	 }
        	 $scope.resetObjetoPago();
        }
	}
	
	//Obtiene las formas de pago
	$scope.seleccionarFormaPago =function( formaPago, formPagos){
		formPagos.$setPristine();
 		$scope.pago.formaPagoVO = formaPago;
	}
	
	$scope.resetObjetoPago =function( ){
//  		$scope.pago.formaPagoVO = null;
//  		$scope.pago.importe = null;
//  		$scope.pago.pagoCon = null;
//  		$scope.pago.cambio = null;
//  		$scope.pago.noCuenta=null;
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
			     			$scope.complementarDatosPago();
			        		$scope.procesarVenta(venta);
			        	}
			        }); 
			    });
			};
			$scope.showConfirmacion ("¿Est\u00e1 seguro de cerrar la venta ?");
		 
	};
	
	//Consulta formas de pago
	$scope.consultarFormasPago =function(){
 		taquillaService.consultarFormasPago().success(function(data) {	
 			$scope.listaFormasPago=data;
 		  }).error(function(data) {
		  });
	}
	
	$scope.complementarDatosPago =function(   ){
		$scope.listaBoletosFilter = $filter('filter')($scope.boletos, {'tipoCliente': '!Promocion'});
 		$scope.objetosVenta.boletosXTicketVO=$scope.listaBoletosFilter;
 		$scope.promocion={ promocionVO:$scope.objetosVenta.promocion, cantidad:1, importe : ($scope.promocion ==null   ) ? 0: $scope.promocion.subtotal}
 		$scope.promo = [];
		$scope.promo.push($scope.promocion);
		$scope.objetosVenta.promocionesXTicketVO=$scope.promo;
  	}
	
	//ProcesarVenta
	$scope.procesarVenta =function( venta ){
		venta.pagosVO=$scope.listaPagos;
		taquillaService.procesarVenta(venta).success(function(data) {	
			$scope.asignarPaso(5);
			$scope.ticketVenta=data;
			 
 		  }).error(function(data) {
		  });
	}
	
	 
});