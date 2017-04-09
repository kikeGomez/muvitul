'use strict';

var VentaProductoPaso1Controller = angular.module('indexModule').controller(
		"ventaProductoController", function($scope,$filter,dulceriaService) {
			$scope.fechaExhibicion = moment(new Date()).format('YYYY/MM/DD');
			$scope.paquetes= {};
			$scope.paquetesSeleccionados= [];
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
			
		
			$scope.consultarPaquetes = function() {
				dulceriaService.consultarPaquetes().success(function(data) {
					console.log(data);
					$scope.paquetes =data;
				}).error(function(data) {

				});
			}

			$scope.agregarPaquete = function(paquete) {
				//paquete.cantidad=paquete.cantidad+1;
		        angular.forEach($scope.paquetes, function(value, key){
		        	if(value.idPaquete ==  paquete.idPaquete ){
		        		value.cantidad=value.cantidad+1;
		        	}
				});
		        

			}
			
			$scope.consultarPaquetes();
			
			$scope.consultarProductos = function() {
				dulceriaService.consultarProductos().success(function(data) {
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
			
			//$scope.consultarProductos();
			//$scope.consultarPaquetes2();
			$scope.consultarConfigProgramaciones();
			$scope.consultarConfigPromociones();
			

		});