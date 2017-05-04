'use strict';

var VentaProductoPaso1Controller = angular.module('indexModule').controller("ventaProductoController", function($scope,$filter,dulceriaService){
	$scope.statusVenta = {
		elegirProducto : "selected",
		registrarPago : "",
		confirmarVenta : "",
		numeroPaso : 1
	}
	$scope.fechaActual = moment(new Date()).format('DD/MM/YYYY');
	$scope.paquetes= {};
	$scope.paquetesSeleccionados= [];
	$scope.ventaVo;
	$scope.total=0;
	
	$scope.asignarPaso = function(paso) {
		$scope.statusVenta=estatusPaso(paso);
		$scope.statusVenta.numeroPaso = paso;
	}
	
	function estatusPaso(paso) {
  		var status = {};
		switch (paso) {

		case 1:
			status.elegirProducto = "selected";
			status.registrarPago = "";
			status.confirmarVenta = "";
			break;
		case 2:
			status.elegirProducto = "done";
			status.registrarPago = "selected";
			status.confirmarVenta = "";
			break;
		case 3:
			status.elegirProducto = "done";
			status.registrarPago = "done";
			status.confirmarVenta = "selected";
			break;
		}
		
		return status;
	}
	
	
	$scope.consultarPaquetes = function() {
		dulceriaService.consultarPaquetes().success(function(data) {
			$scope.paquetes =data;
			 $scope.errorPaquetes=false;
			console.log(data);
		}).error(function(data) {
			 $scope.paquetes={};
 			 $scope.errorPaquetes=true;
		});
	}

	$scope.agregarPaquete = function(paquete) {
		//paquete.cantidad=paquete.cantidad+1;
		console.log("Agregar paquete");
//        angular.forEach($scope.paquetes, function(value, key){
//        	if(value.idPaquete ==  paquete.idPaquete && value.nombre ==  paquete.nombre ){
//        		value.cantidad=value.cantidad+1;
//        		value.importe=value.cantidad * value.precio;
//            	$scope.total=$scope.total + value.importe;
//        	}
//		});
        
		paquete.cantidad=paquete.cantidad+1;
		paquete.importe=paquete.importe + paquete.precio;

    	$scope.total=$scope.total + paquete.precio;
    	
    	
        $scope.found=false;
        angular.forEach($scope.paquetesSeleccionados, function(value, key){
        	if(value.idPaquete ==  paquete.idPaquete && value.nombre ==  paquete.nombre){
        		$scope.found=true;
        	}
		});
        
        if ($scope.found==false){
        	$scope.paquetesSeleccionados.push(paquete);
        }
	}
		   
	$scope.eliminarPaquete = function(paquete) {
		paquete.cantidad=paquete.cantidad-1;
		paquete.importe=paquete.importe - paquete.precio;
    	$scope.total=$scope.total - paquete.precio;
    	
        angular.forEach($scope.paquetesSeleccionados, function(value, key){
        	if(value.cantidad == 0 ){
        		$scope.paquetesSeleccionados.splice(key, 1);
        	}
		});
        
//        for (var i = $scope.paquetesSeleccionados.length - 1; i >= 0; i--) {
//            if (!$scope.paquetesSeleccionados[i].cantidad == 0) {
//                $scope.paquetesSeleccionados.splice(i, 1);
//            }
//        }
	}
	
	$scope.consultarPaquetes();

});