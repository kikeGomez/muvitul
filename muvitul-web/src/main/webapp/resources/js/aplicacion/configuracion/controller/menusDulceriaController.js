'use strict';

var MenusDulceriaController = angular.module('indexModule').controller("MenusDulceriaController", function($scope,menusDulceriaService,ModalService){

	$scope.paquete={};
	$scope.listaPaquetes={};
	$scope.listaProductos={};
	 
	$scope.guardarPaquete =function( paquete){
		console.log(paquete);
	}
	
	$scope.eliminarPaquete =function( array,objeto,index){
		console.log(array);
		console.log(objeto);
		console.log(index);

		 array.splice(index, 1);
 

	}
	$scope.onChange = function (e, file) {
		var data = file[0];
		 console.log(file)
	  };
	//Consultar productos 
	$scope.consultarProductos =function( ){
		
		
		menusDulceriaService.consultarProductos().success(function(data) {	
				console.log(data);
				$scope.listaProductos=data;
 		  }).error(function(data) {
 				console.log(data);

		  });
		
//		$scope.listaProductos =[
//		   		             {
//		   		            	    "index": 0,
//		   		            	    "nombre": "Nachos"
//		   		            	  },
//		   		            	  {
//		   		            	    "index": 1,
//		   		            	    "nombre": "Chocolates M&M"
//		   		            	  },
//		   		            	  {
//		   		            	    "index": 2,
//		   		            	    "nombre": "Refresco CH"
//		   		            	  },
//		   		            	  {
//		   		            	    "index": 3,
//		   		            	    "nombre": "Refresco M "
//		   		            	  },
//		   		            	  {
//		   		            	    "index": 4,
//		   		            	    "nombre": " Palomitas M"
//		   		            	  }
//		   		            	];
	
	}
	
	$scope.consultarPaquetes =function( ){
		menusDulceriaService.consultarPaquetes().success(function(data) {	
			console.log(data);
			$scope.listaPaquetes=data;
		  }).error(function(data) {
				console.log(data);

	  });
//		$scope.listaPaquetes=[
//		                 {
//		            	    "index": 0,
//		            	    "productos": "2 Refresco CH, 1 Palomitas M",
//		            	    "nombre": "Combo  Nachos2",
//		            	    "precio": "$ 109.00"
//		            	  },
//		            	  {
//		            	    "index": 1,
//		            	    "productos": "2 Refresco M, 1 Nachos ",
//		            	    "nombre": "Combo Pareja 2",
//		            	    "precio": "$ 100.00"
//		            	  },
//		            	  {
//		            	    "index": 2,
//		            	    "productos": "2 Refresco CH, 1 Palomitas M",
//		            	    "nombre": "Combo Nachos",
//		            	    "precio": "$ 100.00"
//		            	  },
//		            	  {
//		            	    "index": 3,
//		            	    "productos": "2 Refresco CH, 1 Palomitas M",
//		            	    "nombre": "Combo  Nachos2",
//		            	    "precio": "$ 110.00"
//		            	  },
//		            	  {
//		            	    "index": 4,
//		            	    "productos": "2 Refresco M, 1 Nachos ",
//		            	    "nombre": "Combo Pareja 2",
//		            	    "precio": "$ 110.00"
//		            	  }
//		            	];
		
//		console.log($scope.listaPaquetes)
//		menusDulceriaService.consultarPaquetes().success(function(data) {	
//				console.log(data);
// 		  }).error(function(data) {
// 				console.log(data);
//
//		  });
	}

	 $scope.guardarPaqueteConfirm = function(paquete){
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
			        		$scope.guardarPaquete(paquete);
			        	}
			        }); 
			    });
			};
		 
			$scope.showConfirmacion ("¿Estas seguro de guardar el paquete ?");
		 
	};
	
	$scope.consultarPaquetes ();
	$scope.consultarProductos();
	
});