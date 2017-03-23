'use strict';

var VentaProductoPaso1Controller = angular.module('indexModule').controller(
		"ventaProductoController", function($scope,$filter,dulceriaService) {
			$scope.fechaExhibicion = moment(new Date()).format('YYYY/MM/DD');
			$scope.paquetes = {};
			$scope.existenciaBoletoVo;
			
			$scope.ventaVo;
			//={"ticketVentaVO":{"puntoVentaVO":null,"usuarioFirmadoVO":null,"fecha":null,"descuento":null,"importe":null,"total":null},"boletosXTicketVO":[{"tipoClienteVO":{"idTipoCliente":1,"nombre":null,"activo":false,"icono":null},"cantidad":2,"importe":200,"programacionVO":{"idProgramacion":1,"formatoVO":null,"salaVO":null,"versionVO":null,"diaSemana":null,"horario":null,"fechaVigencia":null,"existenciaBoletoVO":null},"fechaExhibicion":1489990050490}],"pagosVO":[{"formaPagoVO":{"idFormaPago":1,"nombre":null,"requiereNumCuenta":false,"activo":false},"noCuenta":"","importe":150,"estatusPagoVO":{"idEstatus":1,"nombre":null},"fecha":1489990050493}],"promocionesXTicketVO":[{"promocionVO":{"idPromocion":1,"cineVO":null,"promocionParaVO":null,"tipoPromocionVO":null,"nombre":null,"descripcion":null,"fechaInicio":null,"fechaFin":null,"detallePromocionesVO":null},"cantidad":1,"importe":50}]};
			
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
			
			$scope.crearVentas = function(ventaVO) {
				dulceriaService.crearVentas(ventaVO).success(function(data) {
					console.log(data);
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
			
			//console.log($scope.fechaExhibicion);
			//$scope.consultarPeliculas($scope.fechaExhibicion);
			//$scope.consultarPromociones($scope.fechaExhibicion);
			//$scope.consultarPrecios(1);
			//$scope.consultarFormasPago();
			//$scope.consultarExistencias(1,1,$scope.fechaExhibicion);
			//$scope.consultarVentas();
			$scope.consultarDescuentos();
			
		});