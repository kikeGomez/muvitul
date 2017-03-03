'use strict';

var VentaBoletosPaso1Controller = angular.module('indexModule').controller('ventaBoletos', function($controller,$scope,$filter,taquillaService,calculosFactory){
	
	$scope.statusVenta			= { elegirPelicula	:"selected", elegirPromocion :"", elegirCantidad	:"", 
						 		   registrarPago	:"", confirmarVenta  :"", numeroPaso:1	}
	$scope.listaPromociones		={};
	$scope.listaFormasPago		={};
	$scope.listaPeliculas		={};
	$scope.listaPreciosXFormato	={};
	$scope.boletos			    =[];
 	$scope.pago				    ={};
	$scope.listaPagos			=[];
	$scope.objetosVenta			={};
	$scope.promocion			={ cantidad:0, tipoCliente:"Promocion", subtotal:0, precio:0, };
//	$controller('VentaBoletosPaso2Controller',{$scope : $scope });

	
 	$scope.seleccionarPelicula =function(pelicula,programacion){

 		$scope.statusVenta.numeroPaso		= 2;
		$scope.statusVenta.elegirPelicula	= "done";
    	$scope.statusVenta.elegirPromocion  = "selected";
		$scope.objetosVenta.programacion	= programacion;
		$scope.objetosVenta.pelicula		= pelicula;
		$scope.objetosVenta.fechaVenta		= new Date();
		$scope.consultarPromociones();
		$scope.consultarPreciosFormato();
//		$scope.init();
	}
	
	$scope.seleccionarPromocion =function(promocion){
		angular.forEach($scope.listaPromociones, function(value, key){
			value.check = false;
		});
		promocion.check = true;
		$scope.objetosVenta.promocion	= promocion;
//		$scope.promocion={ cantidad:0, tipoCliente:"Promocion", subtotal:0, precio:0 };
//		
//		$scope.isPromocion = $filter('filter')($scope.boletos, {'tipoCliente':'Promocion'});
//		if(promocion.tipoCliente ===$scope.promocion.tipoCliente)	 
//        $scope.promocion.cantidad +=1;
//        angular.forEach($scope.boletos, function(value, key){
//        	if(!$scope.isPromocion ){
//		});
//        if(!$scope.isPromocion ){
        	$scope.boletos.push({ cantidad:0, tipoCliente:"Promocion", subtotal:0, precio:0 })
//        }
// 
    }
	
	$scope.quitarBoleto = function(boleto) { 
		boleto.cantidad = boleto.cantidad-1;
		boleto.subtotal= calculosFactory.calcularSubtotal(boleto.cantidad,boleto.precio);
   
		angular.forEach($scope.listaPreciosXFormato, function(value, key){
			if(value.tipoClienteVO.nombre ===boleto.tipoCliente) 
				value.boletosSeleccionados =value.boletosSeleccionados-1;
		});
		$scope.pago.subtotal -= value.subtotal;
	}
	
	$scope.agregarBoleto =function(tipoClienteVO, index){
 
		tipoClienteVO.boletosSeleccionados = tipoClienteVO.boletosSeleccionados +1;
  		angular.forEach($scope.boletos, function(value, key){
 			 
  			if(tipoClienteVO.tipoClienteVO.nombre ===value.tipoCliente)
  				value.cantidad =value.cantidad + 1;
  				value.subtotal =calculosFactory.calcularSubtotal(value.cantidad,value.precio);
  				$scope.pago.subtotal += value.subtotal;
  		}); 
   	}

	$scope.asignarPaso =function( paso){
		$scope.statusVenta= calculosFactory.estatusPaso(paso);
		$scope.statusVenta.numeroPaso = paso;
//		$scope.boletos.push($scope.promocion);

	}
 
	$scope.seleccionarFormaPago =function( formaPago){
		$scope.pago.formaPago = formaPago;
	}
	
	//Consulta de programacion de peliculas
	$scope.consultarPeliculas =function(){
 		taquillaService.consultarPeliculas().success(function(data) {	
 			$scope.listaPeliculas=data;
 		  }).error(function(data) {
		  });
	}
	//Consulta de promociones
	$scope.consultarPromociones =function(){
 		taquillaService.consultarPromociones().success(function(data) {	
 			$scope.listaPromociones=data;
  		  }).error(function(data) {
		  });
	}
	//Consulta de precios por formato
	$scope.consultarPreciosFormato =function(){
		$scope.boletos=[];
 		taquillaService.consultarPreciosFormato($scope.objetosVenta.programacion.formatoVO.idFormato).success(function(data) {	
 			$scope.listaPreciosXFormato=data;
 			angular.forEach($scope.listaPreciosXFormato, function(value, key){
	 			 $scope.boletos.push({ cantidad:0, tipoCliente:value.tipoClienteVO.nombre, subtotal:0, precio:value.precio })
	 			  value.boletosSeleccionados =0;
 			});
 			$scope.listaPreciosXFormato.boletos=$scope.boletos;
  		  }).error(function(data) {
		  });
	}
	
	//Consulta formas de pago
	$scope.consultarFormasPago =function(){
 		taquillaService.consultarFormasPago().success(function(data) {	
 			$scope.listaFormasPago=data;
 		  }).error(function(data) {
		  });
	}
	
	$scope.guardarPago =function(pago){
		$scope.listaPagos.push(angular.copy(pago));
	}
	
	$scope.init =function(){
		$scope.boletos.push({ cantidad:0, tipoCliente:"Promocion", subtotal:0, precio:0 })
	}
	
	$scope.consultarPeliculas();
 });