'use strict';
 
var IndexModule = angular.module('indexModule',['ngRoute','globalModule','blockUI','angularModalService','angularUtils.directives.dirPagination']);

angular.module('indexModule').config(function($routeProvider){
	
        $routeProvider
            .when("/ventaBoletos", {
                controller: "ventaBoletos",
                controllerAs: "vm",
                templateUrl: "vistas/taquilla/venta_boletos.jsp" 
            
            })

            .when("/ventaProducto", {
                controller: "ventaProductoController",
                controllerAs: "vm",
                templateUrl: "vistas/dulceria/venta_producto.jsp"
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
            
             .when("/promocionesTaquilla", {
                controller: "PromocionesTaquillaController",
                controllerAs: "vm",
                templateUrl: "vistas/configuracion/promocion_taquilla.jsp"
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