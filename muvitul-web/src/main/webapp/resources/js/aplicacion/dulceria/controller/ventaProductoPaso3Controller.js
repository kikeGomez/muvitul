'use strict';

var VentaProductoPaso3Controller = angular.module('indexModule').controller("VentaProductoPaso3Controller", function(){


	$scope.consultarPeliculas = function(fechaExhibicion) {
		dulceriaService.consultarPeliculas(fechaExhibicion).success(function(data) {
			console.log(data);
		}).error(function(data) {
			
		});
	}
		 
	$scope.consultarPromociones = function(fechaExhibicion) {
		dulceriaService.consultarPromociones(fechaExhibicion).success(function(data) {
			console.log(data);
		}).error(function(data) {

		});
	}
	
	$scope.consultarDescuentos = function(idPromocion, boletosXTicketVO) {
		dulceriaService.consultarDescuentos(idPromocion, boletosXTicketVO).success(function(data) {
			console.log(data);
		}).error(function(data) {

		});
	}
	
	$scope.consultarPrecios = function(idFormato) {
		dulceriaService.consultarPrecios(idFormato).success(function(data) {
			console.log(data);
		}).error(function(data) {

		});
	}
	
	$scope.consultarFormasPago = function() {
		dulceriaService.consultarFormasPago().success(function(data) {
			console.log(data);
		}).error(function(data) {

		});
	}

	$scope.consultarExistencias = function(idProgramacion, idSala, fechaExhibicion) {
		dulceriaService.consultarExistencias(idProgramacion,idSala,fechaExhibicion).success(function(data) {
			console.log(data);
			$scope.existenciaBoletoVo=data;
			$scope.existenciaBoletoVo.reservar=1;
			console.log($scope.existenciaBoletoVo.fechaExhibicion);
			$scope.actualizarExistencias($scope.existenciaBoletoVo);
		}).error(function(data) {

		});
	}

	$scope.actualizarExistencias = function(existenciaBoletoVo) {
		dulceriaService.actualizarExistencias(existenciaBoletoVo).success(function(data) {
			console.log(data);
		}).error(function(data) {

		});
	}
	
	$scope.consultarVentas = function() {
		dulceriaService.consultarVentas().success(function(data) {
			console.log(data);
			$scope.ventaVo=data;
			dulceriaService.crearVentas($scope.ventaVo);
		}).error(function(data) {

		});
	}
	
	$scope.consultarDescuentos = function() {
		dulceriaService.consultarDescuentos().success(function(data) {
			console.log(data);
			dulceriaService.crearDescuentos(data).success(function(data) {
				console.log(data);
				
			}).error(function(data) {

			});
			
		}).error(function(data) {

		});
	}
	
	
//	$scope.consultarPeliculas($scope.fechaExhibicion);
//	$scope.consultarPromociones($scope.fechaExhibicion);
//	$scope.consultarPrecios(1);
//	$scope.consultarFormasPago();
//	$scope.consultarExistencias(1,1,$scope.fechaExhibicion);
//	$scope.consultarDescuentos();
//	$scope.consultarVentas();
	
});