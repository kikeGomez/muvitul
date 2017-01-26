'use strict';

var EntradasDulceriaController = angular.module('indexModule').controller("EntradasDulceriaController", function(){

});

$(document).ready(function() {
    $(".select2_single").select2({
      placeholder: "-- Seleccionar un Producto --",
      allowClear: true
    });
  });
