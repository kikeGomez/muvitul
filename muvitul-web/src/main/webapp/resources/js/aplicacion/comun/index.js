'use strict';
 
var IndexModule = angular.module('indexModule',['ngRoute','globalModule']);

angular.module('indexModule').config(function($routeProvider){
	
        $routeProvider
            .when("/ventaBoletos", {
                controller: "ventaBoletos",
                controllerAs: "vm",
                templateUrl: "vistas/taquilla/venta_boletos.jsp"
            })
//            .when("/ventaBoletos2", {
//                controller: "VentaBoletosPaso2Controller",
//                controllerAs: "vm",
//                templateUrl: "vistas/taquilla/venta_boletos_paso2.jsp"
//            })
//            .when("/ventaBoletos3", {
//                controller: "VentaBoletosPaso3Controller",
//                controllerAs: "vm",
//                templateUrl: "vistas/taquilla/venta_boletos_paso3.jsp"
//            })
//            .when("/ventaBoletos4", {
//                controller: "VentaBoletosPaso4Controller",
//                controllerAs: "vm",
//                templateUrl: "vistas/taquilla/venta_boletos_paso4.jsp"
//            })
//            .when("/ventaBoletos5", {
//                controller: "VentaBoletosPaso5Controller",
//                controllerAs: "vm",
//                templateUrl: "vistas/taquilla/venta_boletos_paso5.jsp"
//            })
            .when("/ventaProducto", {
                controller: "VentaProductoPaso1Controller",
                controllerAs: "vm",
                templateUrl: "vistas/dulceria/venta_producto_paso1.jsp"
            })
            .when("/ventaProducto2", {
                controller: "VentaProductoPaso2Controller",
                controllerAs: "vm",
                templateUrl: "vistas/dulceria/venta_producto_paso2.jsp"
            })
            .when("/ventaProducto3", {
                controller: "VentaProductoPaso3Controller",
                controllerAs: "vm",
                templateUrl: "vistas/dulceria/venta_producto_paso3.jsp"
            })
            .when("/cupoSala", {
                controller: "CupoSalaController",
                controllerAs: "vm",
                templateUrl: "vistas/configuracion/cupo_x_sala.jsp"
            })
            .when("/programacion", {
                controller: "ProgramacionController",
                controllerAs: "vm",
                templateUrl: "vistas/configuracion/programacion.jsp"
            })
            .when("/preciosVenta", {
                controller: "PreciosVentaController",
                controllerAs: "vm",
                templateUrl: "vistas/configuracion/precio_x_formato.jsp"
            })
            .when("/peliculas", {
                controller: "PeliculasController",
                controllerAs: "vm",
                templateUrl: "vistas/configuracion/peliculas.jsp"
            })
            .when("/productosDulceria", {
                controller: "ProductosDulceriaController",
                controllerAs: "vm",
                templateUrl: "vistas/configuracion/productos_dulceria.jsp"
            })
            .when("/menusDulceria", {
                controller: "MenusDulceriaController",
                controllerAs: "vm",
                templateUrl: "vistas/configuracion/menus_dulceria.jsp"
            })
            .when("/entradasDulceria", {
                controller: "EntradasDulceriaController",
                controllerAs: "vm",
                templateUrl: "vistas/inventarios/entradas_dulceria_inventario.jsp"
            })
            .when("/cambiarContrasenia", {
                controller: "CambiarContraseniaController",
                controllerAs: "vm",
                templateUrl: "vistas/configuracion/cambiar_contrasenia.jsp"
            });
    });