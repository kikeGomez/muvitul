
angular.module('indexModule').constant("config", {	
    
	baseUrl: "http://localhost:8080/muvitul-service/rest"
 
});

//angular.module('indexModule').factory('dataRest',['$http','$location',  function ($http,$location) {
//
//
//    var pro = $location.protocol();
//    var loc = $location.path();
//    var absUrl = $location.absUrl();
//    var array = $location.absUrl().split('/');
//    var path = '/' + array[3];
//    var urlWscproxy = '/WSCCPA/';
//    var urlWsc = '/WSCCAT/';
//    if(array[3] != '#'){
//        var urlWscproxy = path +'/WSCCPA/';
//        var urlWsc = path +'/WSCCAT/';
//        
//    }
//
//     dataRest = {x:"xxx"};
//
//    dataRest.getAttrDiseno = function () {
//        return dataRest;
//    };
//
//      return dataRest;
//    }]);