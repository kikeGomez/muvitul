'use strict';

var MenusDulceriaController = angular.module('indexModule').controller("PromocionesTaquillaController", function($scope,promocionesTaquillaService,ModalService){
	$scope.promocion={};
	
	$scope.consultaConfigProgramaciones =function(){
		promocionesTaquillaService.consultarConfigPromociones().success(function(data) {
  			console.log(data);
  			 $scope.listaPromoPara= data.promocionesParaVO;
			 $scope.listaTiposPromo = data.tiposPromocionVO;
 		}).error(function(data) {

		});
	}
	
	 $scope.guardarPromocion =function(prmocion){
		 console.log(prmocion);
	 }
	 
	 
	
	 $scope.init =function(){
		 $scope.consultaConfigProgramaciones();
	 }
	
	 $scope.seleccion =function(dato, tipo){
		 if(tipo=='sala') 
			 $scope.programacion.salaVO=dato;
		 if(tipo=='dia') 
			 $scope.programacion.diaVO=dato;
		 if(tipo=='formato') 
			 $scope.programacion.formatoVO=dato;
		 if(tipo=='version')
			 $scope.programacion.versionVO=dato;
	 }
	 
	 $scope.init();
	
});