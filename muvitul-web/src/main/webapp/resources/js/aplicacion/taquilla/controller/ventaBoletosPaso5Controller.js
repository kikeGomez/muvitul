'use strict';

var VentaBoletosPaso5Controller = angular.module('indexModule').controller("VentaBoletosPaso5Controller", function($scope,$controller,ModalService){
    $controller('modalController',{$scope : $scope });

	//Impresion de Boleto
	$scope.imprimirBoleto =function(){
		$scope.showAviso("Imprimiendo Boletos... ");
	}
});