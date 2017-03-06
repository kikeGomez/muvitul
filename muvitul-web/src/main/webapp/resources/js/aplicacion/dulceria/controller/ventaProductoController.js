'use strict';

var VentaProductoPaso1Controller = angular.module('indexModule').controller(
		"ventaProductoController", function($scope, dulceriaService) {
			$scope.paquetes={};
			
			
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

			$scope.consultar = function() {
				dulceriaService.consultarPromociones().success(function(data) {
					console.log(data);
					$scope.paquetes=data;
				}).error(function(data) {

				});
			}
			
			
			$scope.consultarPaquetes = function() {
				dulceriaService.consultarPaquetes().success(function(data) {
					console.log(data);
					$scope.paquetes=data;
				}).error(function(data) {

				});
			}
			
			
			$scope.consultarPaquetes();

});