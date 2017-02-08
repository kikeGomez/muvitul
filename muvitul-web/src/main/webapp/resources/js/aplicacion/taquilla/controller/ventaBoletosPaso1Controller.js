'use strict';

var VentaBoletosPaso1Controller = angular.module('indexModule').controller('ventaBoletos', function($scope,taquillaService){
	
	$scope.statusVenta={
			elegirPelicula	:"selected", elegirPromocion	:"", 
			elegirCantidad	:"", registrarPago	:"", 
			confirmarVenta  :"", numeroPaso:1
			}
	
	$scope.seleccionarPelicula =function(){
		$scope.statusVenta.numeroPaso=2;
		$scope.statusVenta.elegirPelicula="done"
	}
	
	$scope.seleccionarPromocion =function(){
 	}
	
	$scope.asignarPaso =function( paso){
		$scope.statusVenta.numeroPaso = paso;
		estatusPaso(paso);
	}
	
	
	//	CONSULTA CATALOGOS
	
	$scope.consultarPromociones =function(){
 		taquillaService.consultarPromociones().success(function(data) {	
 			 console.log(data);
		  }).error(function(data) {
		  	 
		  });
	}
 
	function  estatusPaso (paso){
		
		switch(paso) {
			
	    case 1:
	    	$scope.consultarPromociones();
	    	$scope.statusVenta.elegirPelicula ="selected";
	    	$scope.statusVenta.elegirPromocion="";
	    	$scope.statusVenta.elegirCantidad ="";
	    	$scope.statusVenta.registrarPago  ="";
	    	$scope.statusVenta.confirmarVenta ="";
 	        break;
	    case 2:
	    	$scope.statusVenta.elegirPelicula = "done";
	    	$scope.statusVenta.elegirPromocion="selected";
	    	$scope.statusVenta.elegirCantidad ="";
	    	$scope.statusVenta.registrarPago  ="";
	    	$scope.statusVenta.confirmarVenta ="";
 	        break;
	    case 3:
	    	$scope.statusVenta.elegirPelicula = "done";
	    	$scope.statusVenta.elegirPromocion="done";
	    	$scope.statusVenta.elegirCantidad ="selected";
	    	$scope.statusVenta.registrarPago  ="";
	    	$scope.statusVenta.confirmarVenta ="";
 	        break;
	    case 4:
	    	$scope.statusVenta.elegirPelicula = "done";
	    	$scope.statusVenta.elegirPromocion="done";
	    	$scope.statusVenta.elegirCantidad ="done";
	    	$scope.statusVenta.registrarPago  ="selected";
	    	$scope.statusVenta.confirmarVenta ="";
 	        break;
	    case 5:
	    	$scope.statusVenta.elegirPelicula = "done";
	    	$scope.statusVenta.elegirPromocion="done";
	    	$scope.statusVenta.elegirCantidad ="done";
	    	$scope.statusVenta.registrarPago  ="done";
	    	$scope.statusVenta.confirmarVenta ="selected";
 	        break;
 	        }
		}
  
 });