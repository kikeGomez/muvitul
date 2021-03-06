'use strict';

var VentaBoletosPaso1Controller = angular.module('indexModule').controller('ventaBoletos', function($controller,$scope,$filter,taquillaService,calculosFactory,ModalService){

	$scope.statusVenta			= { elegirPelicula	:"selected", elegirPromocion :"", elegirCantidad	:"", 
						 		   registrarPago	:"", confirmarVenta  :"", numeroPaso:1	}
	$scope.fechaExhibicion 		= moment(new Date()).format('DD/MM/YYYY');
	$scope.listaPeliculas		={};
	$scope.boletos			    =[];
	$scope.objetosVenta			={};
	$scope.promocion			={ cantidad:0, tipoCliente:"Promocion", subtotal:0, precio:0, };
	$controller('VentaBoletosPaso2Controller',{$scope : $scope });
	$controller('VentaBoletosPaso3Controller',{$scope : $scope });
	$controller('VentaBoletosPaso4Controller',{$scope : $scope });
	$controller('VentaBoletosPaso5Controller',{$scope : $scope });
    $controller('modalController',{$scope : $scope });

	
 	$scope.seleccionarPelicula =function(pelicula,programacion){
 		$scope.objetosVenta.promocion=null;
 		$scope.promocionBoletoVO.promocionVO =null;
 		$scope.promocion=null;
 		$scope.listaPreciosXFormato ={};
 		$scope.statusVenta.numeroPaso		= 2;
		$scope.statusVenta.elegirPelicula	= "done";
    	$scope.statusVenta.elegirPromocion  = "selected";
		$scope.objetosVenta.programacion	= programacion;
		$scope.objetosVenta.pelicula		= pelicula;
		$scope.objetosVenta.fechaExhibicion		= $scope.fechaExhibicion;
		$scope.consultarPromociones($scope.fechaExhibicion);
		$scope.consultarPreciosFormato();
  		$scope.configParamsCron(programacion,$scope.fechaExhibicion);
	}
	
	$scope.seleccionarPromocion =function(promocion){
		
		angular.forEach($scope.listaPromociones, function(value, key){
			value.check = false;
		});
		promocion.check = true;
 		$scope.objetosVenta.promocion	= promocion;
		$scope.promocionBoletoVO.promocionVO = promocion;
		
		$scope.promocion={ cantidad:1, tipoCliente:"Promocion", subtotal:0, precio:0,promocionVO :promocion, importe:0 };
        angular.forEach($scope.boletos, function(value, key){
        	if(value.tipoCliente ==  'Promocion' ){
        		$scope.eliminar( $scope.boletos, key );
        	}
		});
        $scope.boletos.push($scope.promocion); 
    }
	
	$scope.quitarBoleto = function(boleto) { 
		
		$scope.asientosDisponibles.reservar =-1;
		$scope.reservarBoleto($scope.asientosDisponibles);
 		boleto.cantidad = boleto.cantidad-1;
 		$scope.pago.subtotal =0;
// 		if($scope.promocion==null){
	 		angular.forEach($scope.boletos, function(value, key){
	  			value.subtotal =calculosFactory.calcularSubtotal(value.cantidad,value.precio);
	  			value.importe = calculosFactory.calcularSubtotal(value.cantidad,value.precio);
	  			$scope.pago.subtotal += value.subtotal;
	  		}); 
// 		}
		angular.forEach($scope.listaPreciosXFormato, function(value, key){
			if(value.tipoClienteVO.nombre ===boleto.tipoCliente) 
				value.boletosSeleccionados =value.boletosSeleccionados-1;
  			value.importe = calculosFactory.calcularSubtotal(value.cantidad,value.precio);

		});
   			$scope.consultarDescuentos ($scope.promocionBoletoVO);
 	}
	
	$scope.agregarBoleto =function(tipoClienteVO, index){
		
		if($scope.asientosDisponibles.disponibles ==0){
			$scope.showAviso("No hay asientos disponibles ");
			return;
		}
		$scope.asientosDisponibles.reservar =1;
		$scope.reservarBoleto($scope.asientosDisponibles);
 		$scope.consultarExistenciaBoletos($scope.paramsExistenciaBoleto);

		$scope.pago.subtotal =0;

		tipoClienteVO.boletosSeleccionados = tipoClienteVO.boletosSeleccionados +1;
  		angular.forEach($scope.boletos, function(value, key){
  				value.fechaExhibicion =$scope.fechaExhibicion ;
  			if(tipoClienteVO.tipoClienteVO.nombre ===value.tipoCliente)
  				value.cantidad =value.cantidad + 1;
	  		
	  			value.subtotal =calculosFactory.calcularSubtotal(value.cantidad,value.precio);
	  			value.importe = calculosFactory.calcularSubtotal(value.cantidad,value.precio);
	  		if($scope.promocion==null){
	  			$scope.pago.subtotal += value.subtotal;
  			}
  		}); 
  		
  		$scope.promocionBoletoVO.boletosXTicketVO=$scope.boletos
   			$scope.consultarDescuentos ($scope.promocionBoletoVO);
    }

	$scope.asignarPaso =function( paso){
		$scope.statusVenta= calculosFactory.estatusPaso(paso);
		$scope.statusVenta.numeroPaso = paso;
	}
 
	//Consulta de programacion de peliculas
	$scope.consultarPeliculas =function(fechaExhibicion){
  		taquillaService.consultarPeliculas(fechaExhibicion).success(function(data) {	
 			$scope.listaPeliculas=data;
			$scope.errorPeliculas=false;
			console.log(data)
  		  }).error(function(data) {
 			 $scope.listaPeliculas={};
 			 $scope.errorPeliculas=true;
 		  });
	}

	$scope.calcularCambio =function(pagoCon,pagoImporte){
		$scope.pago.cambio=pagoCon-pagoImporte;
	}
	
	$scope.buscarPeliculasXFecha =function(){
		$scope.consultarPeliculas($scope.fechaExhibicion);
	}
	
	$scope.consultarPeliculas($scope.fechaExhibicion);
 });
 