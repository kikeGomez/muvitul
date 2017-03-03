'use strict';
angular.module('indexModule').factory("calculosFactory",function() { 
	  return {
		    calcularSubtotal:function(cantidad,precio) {
		      return cantidad * precio;
		    },
		    calcularTotal:function(a,b) {
		      return a * b;
		    },
		    estatusPaso:function(paso) {
	    		 
	   		 var statusVenta = {};
	   			switch(paso) {
	   				
	   		    case 1:
	   		    	statusVenta.elegirPelicula ="selected";
	   		    	statusVenta.elegirPromocion="";
	   		    	statusVenta.elegirCantidad ="";
	   		    	statusVenta.registrarPago  ="";
	   		    	statusVenta.confirmarVenta ="";
	   	 	        break;
	   		    case 2:
	   		    	statusVenta.elegirPelicula = "done";
	   		    	statusVenta.elegirPromocion="selected";
	   		    	statusVenta.elegirCantidad ="";
	   		    	statusVenta.registrarPago  ="";
	   		    	statusVenta.confirmarVenta ="";
	   	 	        break;
	   		    case 3:
	   		    	statusVenta.elegirPelicula = "done";
	   		    	statusVenta.elegirPromocion="done";
	   		    	statusVenta.elegirCantidad ="selected";
	   		    	statusVenta.registrarPago  ="";
	   		    	statusVenta.confirmarVenta ="";
	   	 	        break;
	   		    case 4:
	   		    	statusVenta.elegirPelicula = "done";
	   		    	statusVenta.elegirPromocion="done";
	   		    	statusVenta.elegirCantidad ="done";
	   		    	statusVenta.registrarPago  ="selected";
	   		    	statusVenta.confirmarVenta ="";
	   	 	        break;
	   		    case 5:
	   		    	statusVenta.elegirPelicula = "done";
	   		    	statusVenta.elegirPromocion="done";
	   		    	statusVenta.elegirCantidad ="done";
	   		    	statusVenta.registrarPago  ="done";
	   		    	statusVenta.confirmarVenta ="selected";
	   	 	        break;
	   	 	        }
	   			return statusVenta;
	   		 
		    },
		    calcularTotal:function(a,b) {
			      return a * b;
			    }
		    
	  	}
	});

angular.module("indexModule").filter('groupBy', function($parse) {
	return _.memoize(function(items, filtro) {
		var getter = $parse(filtro);
		return _.groupBy(items, function(item) {
			return getter(item);
		});
	});
});

 
 
 
 