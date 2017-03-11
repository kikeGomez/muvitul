'use strict';

var VentaProductoPaso1Controller = angular.module('indexModule').controller(
		"ventaProductoController", function($scope,$filter,dulceriaService) {
			$scope.paquetes = {};
			$scope.existenciaBoletoVo;
			
			$scope.statusVenta = {
				elegirProducto : "selected",
				registrarPago : "",
				confirmarVenta : "",
				numeroPaso : 1
			}

			$scope.asignarPaso = function(paso) {
				$scope.statusVenta.numeroPaso = paso;
				estatusPaso(paso);
			}

			function estatusPaso(paso) {

				switch (paso) {

				case 1:
					$scope.statusVenta.elegirProducto = "selected";
					$scope.statusVenta.registrarPago = "";
					$scope.statusVenta.confirmarVenta = "";
					break;
				case 2:
					$scope.statusVenta.elegirProducto = "done";
					$scope.statusVenta.registrarPago = "selected";
					$scope.statusVenta.confirmarVenta = "";
					break;
				case 3:
					$scope.statusVenta.elegirProducto = "done";
					$scope.statusVenta.registrarPago = "done";
					$scope.statusVenta.confirmarVenta = "selected";
					break;
				}
			}
			
			$scope.consultarPeliculas = function() {
				dulceriaService.consultarPeliculas().success(function(data) {
					console.log(data);
				}).error(function(data) {
					
				});
			}
				 
			$scope.consultarPromociones = function() {
				dulceriaService.consultarPromociones().success(function(data) {
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
				// console.log("consultar existencias"+ getFechaActual());
				dulceriaService.consultarExistencias(idProgramacion,idSala,fechaExhibicion).success(function(data) {
					console.log(data);
				}).error(function(data) {

				});
			}

			$scope.actualizarExistenciaBoleto = function(existenciaBoletoVo) {
				// console.log("consultar existencias"+ getFechaActual());
				dulceriaService.actualizarExistenciaBoleto(existenciaBoletoVo).success(function(data) {
					console.log(data);
					existenciaBoletoVo=data;
				}).error(function(data) {

				});
			}
			
			$scope.consultarPaquetes = function(idPuntoVenta) {
				dulceriaService.consultarPaquetes(idPuntoVenta).success(function(data) {
					console.log(data);
					$scope.paquetes = data;
				}).error(function(data) {

				});
			}

			$scope.consultarPeliculas();
			$scope.consultarPromociones();
			$scope.consultarPrecios(1);
			$scope.consultarFormasPago();
			$scope.consultarExistencias(1,1,new Date());
			$scope.actualizarExistenciaBoleto($scope.existenciaBoletoVo);
			//$scope.consultarPaquetes();
		});