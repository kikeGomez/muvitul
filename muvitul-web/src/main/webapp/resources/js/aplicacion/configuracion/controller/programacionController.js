'use strict';

var ProgramacionController = angular.module('indexModule').controller("ProgramacionController", function($scope,programacionesTaquillaService){
//	$('.input-group.date').datepicker({
//	    format: "dd/mm/yyyy",
//	    startDate: "01-05-2014",
//	    endDate: "31-12-2017",
//	    todayBtn: "linked",
//	    autoclose: true,
//	    todayHighlight: true
//	    });
	$scope.programacion={};
	  var oh_counties = [
	                     {name: "Franklin", zips: [111,222,333,444,555]},
	                     {name: "Adams", zips: [111,222,333,444]},
	                     {name: "Allen", zips: [111,222,333]}
	                     ],
	                     wi_counties = [
	                     {name: "Dane", zips: [111]},
	                     {name: "Adams", zips: [111,222,333,444]}
	                     ]

	                     $scope.states = [
	                       {name: "OH", counties: oh_counties},
	                       {name: "WI", counties: wi_counties},
	                       ];
	 
	$scope.consultaConfigProgramaciones =function(){
		programacionesTaquillaService.consultarConfigProgramacion().success(function(data) {
			console.log(data);
  			 $scope.listaDiasSemana= data.dias;
			 $scope.listaFormatos  = data.formatosVO;
			 $scope.listaPeliculas = data.peliculasVO;
			 
			 $scope.listaSalas     = data.salasVO;
			 $scope.listaVersiones = data.versionesVO;
		}).error(function(data) {

		});
	}
  
	 $scope.guardarProgramacion =function(programacion){
		 console.log(programacion);
	 }
	 
	 
	 
	 $scope.init =function(){
		$scope.salasVO= [
		                {
		                    "idSala": 5,
		                    "nombre": "Sala1",
		                    peliculasVO: [
		                      {
		                        "idPelicula": 1,
		                        "nombre": "Pelicula 1",
		                        programacionesVO: [
		                          {
		                            "idProgramacion": 1,
		                            "nombre": "L 2D 14:45 "
		                          },
		                          {
		                            "idProgramacion": 2,
		                            "nombre": "M 2D 14:45 "
		                          }
		                        ]
		                      },
		                      {
		                        "idPelicula": 2,
		                        "nombre": "Pelicula 2",
		                        programacionesVO: [
		                          {
		                            "idProgramacion": 1,
		                            "nombre": "L 2D 14:45 "
		                          },
		                          {
		                            "idProgramacion": 2,
		                            "nombre": "M 2D 14:45 "
		                          }
		                        ]
		                      }
		                    ]
		                  },
		                  {
		                    "idSala": 2,
		                    "nombre": "Sala2",
		                    peliculasVO: [
		                      {
		                        "idPelicula": 1,
		                        "nombre": "Pelicula 1",
		                        programacionesVO: [
		                          {
		                            "idProgramacion": 1,
		                            "nombre": "L 2D 14:45 "
		                          },
		                          {
		                            "idProgramacion": 2,
		                            "nombre": "M 2D 14:45 "
		                          }
		                        ]
		                      },
		                      {
		                        "idPelicula": 2,
		                        "nombre": "Pelicula 2",
		                        programacionesVO: [
		                          {
		                            "idProgramacion": 1,
		                            "nombre": "L 2D 14:45 "
		                          },
		                          {
		                            "idProgramacion": 2,
		                            "nombre": "M 2D 14:45 "
		                          }
		                        ]
		                      },
		                      {
			                        "idPelicula": 3,
			                        "nombre": "Pelicula 3",
			                        programacionesVO: [
			                          {
			                            "idProgramacion": 1,
			                            "nombre": "L 2D 14:45 "
			                          },
			                          {
			                            "idProgramacion": 2,
			                            "nombre": "M 2D 14:45 "
			                          },
			                          {
				                            "idProgramacion": 3,
				                            "nombre": "M 2D 14:45 "
				                          },
			                          {
				                            "idProgramacion": 4,
				                            "nombre": "M 2D 14:45 "
				                          }
			                        ]
			                      }
		                    ]
		                  }
		                ];
		
		console.log($scope.salasVO);
	 }
	
	 $scope.seleccion =function(dato, tipo){
		 if(tipo=='sala') 
			 $scope.programacion.salaVO=dato;
		 if(tipo=='dia') 
			 $scope.programacion.diaVO=dato;
		 if(tipo=='formato') 
			 $scope.programacion.formatoVO=dato;
		 if(tipo=='version')
			 $scope.programacion.versionVO=dato;
	 }
	 
	 $scope.consultaConfigProgramaciones();
	 $scope.init();
});



