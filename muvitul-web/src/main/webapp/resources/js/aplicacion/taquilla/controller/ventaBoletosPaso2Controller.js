'use strict';

var VentaBoletosPaso2Controller = angular.module('indexModule').controller("VentaBoletosPaso2Controller", function($scope, taquillaService,$controller){
	console.log(taquillaService.getMapObjects());
	
 	$scope.mapObjects ={objeto:"YYYYYY"};
 	 
 	 function y(){
 		 taquillaService.setMapObjects($scope.mapObjects);
 		console.log(taquillaService.getMapObjects());

 	 }
 	 y();
	
});