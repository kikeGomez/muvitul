'use strict';

var VentaProductoPaso1Controller = angular.module('indexModule').controller(
		"ventaProducto", function($scope,$filter,dulceriaService) {

			$scope.paquetesSeleccionados= [];
			
			//={"ticketVentaVO":{"puntoVentaVO":null,"usuarioFirmadoVO":null,"fecha":null,"descuento":null,"importe":null,"total":null},"boletosXTicketVO":[{"tipoClienteVO":{"idTipoCliente":1,"nombre":null,"activo":false,"icono":null},"cantidad":2,"importe":200,"programacionVO":{"idProgramacion":1,"formatoVO":null,"salaVO":null,"versionVO":null,"diaSemana":null,"horario":null,"fechaVigencia":null,"existenciaBoletoVO":null},"fechaExhibicion":1489990050490}],"pagosVO":[{"formaPagoVO":{"idFormaPago":1,"nombre":null,"requiereNumCuenta":false,"activo":false},"noCuenta":"","importe":150,"estatusPagoVO":{"idEstatus":1,"nombre":null},"fecha":1489990050493}],"promocionesXTicketVO":[{"promocionVO":{"idPromocion":1,"cineVO":null,"promocionParaVO":null,"tipoPromocionVO":null,"nombre":null,"descripcion":null,"fechaInicio":null,"fechaFin":null,"detallePromocionesVO":null},"cantidad":1,"importe":50}]};
			


			

			$scope.consultarProductos = function() {
				dulceriaService.consultarProductos().success(function(data) {
					console.log(data);
				}).error(function(data) {

				});
			}
			
			$scope.consultarPuntoVenta = function() {
				dulceriaService.consultarPuntosVenta().success(function(data) {
					console.log(data);
				}).error(function(data) {

				});
			}
			
			
			$scope.consultarPaquetes2 = function() {
				dulceriaService.consultarPaquetes2().success(function(data) {
					console.log(data);
				}).error(function(data) {

				});
			}
			
			$scope.consultarConfigProgramaciones = function() {
				dulceriaService.consultarConfigProgramacion().success(function(data) {
					console.log(data);
				}).error(function(data) {

				});
			}
			
			$scope.consultarConfigPromociones = function() {
				dulceriaService.consultarConfigPromociones().success(function(data) {
					console.log(data);
				}).error(function(data) {

				});
			}
			
			
			$scope.crearProgramacion = function() {
				dulceriaService.consultarProgramaciones().success(function(data) {
					console.log(data);
					dulceriaService.crearProgramacion(data);
				}).error(function(data) {

				});
			}
			
			$scope.consultarProgramacion = function() {
				dulceriaService.consultarProgramaciones($scope.fechaExhibicion).success(function(data) {
					console.log(data);
					//dulceriaService.crearProgramaciones(data);
				}).error(function(data) {

				});
			}
			
			$scope.eliminarProgramacion = function() {
				dulceriaService.eliminarProgramaciones(5).success(function(data) {
					console.log(data);
				}).error(function(data) {

				});
			}
			
			$scope.consultarPromocion = function() {
				dulceriaService.consultarPromociones($scope.fechaExhibicion).success(function(data) {
					console.log(data);
					//dulceriaService.crearProgramaciones(data);
				}).error(function(data) {

				});
			}
			
			
			$scope.crearPromocion = function() {
				dulceriaService.consultarPromociones($scope.fechaExhibicion).success(function(data) {
					console.log(data);
					dulceriaService.crearPromociones(data[0]);
				}).error(function(data) {

				});
			}
			
			
			$scope.eliminarPromocion = function() {
				dulceriaService.eliminarPromociones(5).success(function(data) {
					console.log(data);
				}).error(function(data) {

				});
			}
			
			
			//$scope.consultarProductos();
			//$scope.consultarPaquetes2();
			//$scope.consultarConfigProgramaciones();
			//$scope.consultarConfigPromociones();
			console.log($scope.fechaActual);
			//$scope.consultarProgramacion();
			//$scope.crearProgramacion();
			//$scope.eliminarProgramacion();
			//$scope.consultarPromocion();
			//$scope.crearPromocion();
			$scope.consultarPuntoVenta();
			
		});