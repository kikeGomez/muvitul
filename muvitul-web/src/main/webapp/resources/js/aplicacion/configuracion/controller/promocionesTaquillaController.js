'use strict';

var MenusDulceriaController = angular.module('indexModule').controller("PromocionesTaquillaController", function($scope,$controller,promocionesTaquillaService,ModalService){
	$scope.promociones={};
	$scope.promocion={ activo:true};

	$scope.listaPromociones={};
    $controller('modalController',{$scope : $scope });

	$scope.consultaConfigPromociones =function(){
		promocionesTaquillaService.consultarConfigPromociones().success(function(data) {
			console.log(data)
   			 $scope.listaPromoPara= data.promocionesParaVO;
			 $scope.listaTiposPromo = data.tiposPromocionVO;
			 $scope.listaProductos=data.productosVO;
 			 $scope.listaRegalos =data.regalosVO;
 		}).error(function(data) {
		});
	}
	
	$scope.consultaPromociones=function(){
		$scope.fechaExhibicion = moment(new Date()).format('YYYY/MM/DD');
		promocionesTaquillaService.consultarPromociones($scope.fechaExhibicion).success(function(data) {
			console.log(data)
			$scope.listaPromociones=data;
 		}).error(function(data) {
		});
	}
 
	$scope.eliminarPromocion =function( idPromocion){
		promocionesTaquillaService.eliminarPromocion(idPromocion).success(function(data) {
			 $scope.consultaPromociones();
		}).error(function(data) {
		});
	 }
	
	$scope.crearPromocion =function( promocionVO){
		console.log(promocionVO)
		if ( $scope.formPromociones.$invalid) {
            angular.forEach( $scope.formPromociones.$error, function (field) {
              angular.forEach(field, function(errorField){
            	  errorField.$setDirty();
              })
            });
            $scope.showAviso("Es necesario llenar los campos obligatorios ");
         }else{
		promocionesTaquillaService.crearPromocion(promocionVO).success(function(data) {
	            //$scope.showAviso("La programación fue registrada correctamente.");
//				$scope.consultarProgramacion();
			}).error(function(data) {
			});
         }
	 }
	
	 $scope.init =function(){
		 $scope.consultaConfigPromociones();
		 $scope.consultaPromociones();
	 }
	 
	 $scope.init();
});