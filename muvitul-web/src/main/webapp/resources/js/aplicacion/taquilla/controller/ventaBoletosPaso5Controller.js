'use strict';

var VentaBoletosPaso5Controller = angular.module('indexModule').controller("VentaBoletosPaso5Controller", function($scope,$controller,taquillaService,ModalService){
    $controller('modalController',{$scope : $scope });
    $scope.ticketVenta={};
	 
	//Impresion de Boleto
	$scope.imprimirBoleto =function(){
//		$scope.showAviso("Imprimiendo Boletos... ");
//		
 		taquillaService.imprimirTickets($scope.ticketVenta.idTicket).success(function(data,status,headers) {	
 			var filename ="prueba";
			var contentType = headers('content-type');
			var file = new Blob([ data ], {
				type : 'application/pdf;base64,'
			});
			taquillaService.downloadfile(file, filename);
			
		}).error(function(data) {
		  });
	}

});