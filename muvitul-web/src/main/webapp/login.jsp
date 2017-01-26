<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html ng-app="loginModule">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <title>MUVITUL | Punto de Venta para Cines</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">
    	
	<link rel="stylesheet" href="<c:url value='/resources/css/vendors/bootstrap/dist/css/bootstrap.css' />"></link>
</head>
<body ng-controller='LoginController'>
<div class="container">  
  <div class="row" id="pwd-container">
    <div class="col-md-4"></div>
    
    <div class="col-md-4">
      <section class="login-form">
		<form ng-submit="login()" role="login">
          <img src="resources/img/tecnetia.png" class="img-responsive" alt="" />

          <input type="email" ng-model="userName" placeholder="Correo Electr�nico" required="required" class="form-control input-lg" value="" />     
          <input type="password" ng-model="password" placeholder="Contrase�a" required="required" class="form-control input-lg" value="" />          
          
          <div class="pwstrength_viewport_progress"></div>

          <input type="submit" value="Entrar" class="btn btn-lg btn-primary btn-block">
		  
		  <div class="alert alert-danger" role="alert" ng-show="error">	  
		  	<span  class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
		    {{error}}
          </div>
          <br/>
		  <div class="text-center">
		  	    <a class="reset_pass" href="vistas/configuracion/recuperar_contrasenia.jsp"><u>Olvidaste tu contrase�a?</u></a>
		  </div>  
		  <br/>
          
        </form>
        
        <div class="text-center">
             <img src="resources/img/tecnetia.png" height="75px" width="150px" class="center-block" alt="" >
             <h6>2017. Grupo Tecnetia SA de CV. <a href="http://tecnetia.com.mx/aviso-de-privacidad/" target="_blank"><u>Aviso de Privacidad.</u></a></h6>
 		</div>
      </section>  
      </div>
      
      <div class="col-md-4"></div>
      

  </div>
    
</div>

    <script src="<c:url value='/resources/js/vendors/jquery/dist/jquery.js' />"></script>
    <script src="<c:url value='/resources/js/vendors/bootstrap/dist/js/bootstrap.js' />"></script>
    <script src="<c:url value='/resources/js/vendors/angular/angular.min.js' />"></script>

    <script src="<c:url value='/resources/js/comun/global.js' />"></script>
    <script src="<c:url value='/resources/js/comun/service/globalService.js' />"></script>
    <script src="<c:url value='/resources/js/comun/service/errorService.js' />"></script>
    
    <script src="<c:url value='/resources/js/comun/loginAngular.js' />"></script>
    <script src="<c:url value='/resources/js/comun/controller/loginAngularController.js' />"></script>
    <script src="<c:url value='/resources/js/comun/service/loginAngularService.js' />"></script>

</body>
</html>
