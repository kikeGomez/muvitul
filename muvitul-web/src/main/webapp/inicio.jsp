<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title> Muvitul | Inicio </title>
	
    <!-- Bootstrap -->
    <link href="<c:url value='/resources/css/vendors/bootstrap/dist/css/bootstrap.min.css' />" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="<c:url value='/resources/css/vendors/font-awesome/css/font-awesome.min.css' />" rel="stylesheet">
    <!-- NProgress -->
    <link href="<c:url value='/resources/css/vendors/nprogress/nprogress.css' />" rel="stylesheet">
    <!-- Custom Theme Style -->
    <link href="<c:url value='/resources/css/build/custom.min.css' />" rel="stylesheet">
	<!-- global project Style -->
    <link href="<c:url value='/resources/css/global.css' />" rel="stylesheet">
	<!-- fileupload -->
  	<link href="<c:url value='/resources/css/vendors/bootstrap/dist/css/fileinput.css' />" rel="stylesheet">
  	<!-- Select2 -->
    <link href="<c:url value='/resources/css/vendors/select2/dist/css/select2.min.css' />" rel="stylesheet">
	
  </head>

  <body class="nav-md" ng-app="indexModule" >	    
    <div class="container body">
      <div class="main_container">
        <div class="col-md-3 left_col">

		   <!-- AQUÍ VA EL MENÚ DE LA APLICACIÓN -->
          <div class="left_col scroll-view">
            <div class="navbar nav_title" style="border: 0;">
              <a href="inicio.jsp" class="site_title"><i class="fa "></i> <span>MUVITUL</span></a>
            </div>

            <div class="clearfix"></div>

            <!-- menu profile quick info -->
            <div class="profile">
              <div class="profile_pic">
                <img src="<c:url value='/resources/img/img.jpg' />" alt="..." class="img-circle profile_img">
              </div>
              <div class="profile_info">
                <span>Bienvenido,</span>
                <h2>Aldo Hern�ndez</h2>
              </div>
            </div>
            <!-- /menu profile quick info -->

            <br />
            <!-- sidebar menu -->
            <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">

              <div class="menu_section">
                <h3>General</h3>
                <ul class="nav side-menu">
                  <li><a href="inicio.jsp"><i class="fa fa-home"></i> Inicio </a></li>
                  <li><a><i class="fa fa-ticket"></i> Taquilla <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="#/ventaBoletos">Venta de Boletos</a></li>
                      <li><a href="#cancelacionesaut">Cancelaciones/Autorizaciones</a></li>
                    </ul>
                  </li>
                  <li><a><i class="fa fa-cutlery"></i> Dulcer�a/Cafeter�a <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="#/ventaProducto">Venta de Producto</a></li>
                      <li><a href="#cancelacionesaut">Cancelaciones/Autorizaciones</a></li>
                    </ul>
                  </li>
                </ul>
              </div>

              <div class="menu_section">
                <h3>Administraci�n</h3>
                <ul class="nav side-menu">
                  <li><a><i class="fa fa-line-chart"></i> Reportes/Estad�sticas <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="#">Reporte de COMSCORE</a></li>
                      <li><a href="#">Reporte de Distribuidoras</a></li>
                    </ul>
                  </li>    
                  <li><a><i class="fa fa-barcode"></i> Inventarios <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="#/entradasDulceria">Entradas en Dulcer�a</a></li>
                    </ul>
                  </li>                 	
                  <li><a><i class="fa fa-cogs"></i> Configuraciones <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="#/cupoSala">Cupo por Sala</a></li>
                      <li><a href="#/preciosVenta">Precios de Venta</a></li>
                      <li><a href="#/peliculas">Pel�culas</a></li>
                      <li><a href="#/programacion">Programaci�n</a></li>
                      <li><a href="#/productosDulceria">Productos de Dulcer�a</a></li>
                      <li><a href="#/menusDulceria">Paquetes de Dulcer�a</a></li>                      
                    </ul>
                  </li>                 	                  
                </ul>
              </div>

            </div>
            <!-- /sidebar menu -->

          </div>

        </div>

        <!-- top navigation -->
    	
		<div class="top_nav">
			<!-- AQUÍ VA EL HEADER DE LA APLICACION -->
         <div class="nav_menu">
            <nav>
              <div class="nav toggle">
                <a id="menu_toggle"><i class="fa fa-bars"></i></a>
              </div>

              <ul class="nav navbar-nav navbar-right">
                <li class="">
                  <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                    <img src="<c:url value='/resources/img/img.jpg' />" alt="">Aldo Hern�ndez
                    <span class=" fa fa-angle-down"></span>
                  </a>
                  <ul class="dropdown-menu dropdown-usermenu pull-right">
                    <li>
                      <a href="#/cambiarContrasenia">
                        <span>Cambiar Contrase&ntilde;a</span>
                      </a>
                    </li>
                    <li><a href="login.html"><i class="fa fa-sign-out pull-right"></i> Cerrar Sesi�n </a></li>
                  </ul>
                </li>
		<!--  
                <li role="presentation" class="dropdown">
                  <a href="javascript:;" class="dropdown-toggle info-number" data-toggle="dropdown" aria-expanded="false">
                    <i class="fa fa-envelope-o"></i>
                    <span class="badge bg-green">8</span>
                  </a>
                  <ul id="menu1" class="dropdown-menu list-unstyled msg_list" role="menu">
                    <li>
                      <a>
                        <span class="image"><img src="resources/images/img.jpg" alt="Profile Image" /></span>
                        <span>
                          <span>Aldo H.</span>
                          <span class="time">Hace 3 min.</span>
                        </span>
                        <span class="message">
                          Ojo! EstÃ¡s por superar el límite de Merma mensual en...
                        </span>
                      </a>
                    </li>
                    <li>
                      <a>
                        <span class="image"><img src="resources/images/img.jpg" alt="Profile Image" /></span>
                        <span>
                          <span>Aldo H.</span>
                          <span class="time">Hace 1 hr.</span>
                        </span>
                        <span class="message">
                          MaÃ±ana empieza promociÃ³n NIÃ‘OS GRATIS en la compra de...
                        </span>
                      </a>
                    </li>
                    <li>
                      <a>
                        <span class="image"><img src="resources/images/img.jpg" alt="Profile Image" /></span>
                        <span>
                          <span>Aldo H.</span>
                          <span class="time">Hace 3 dÃ­as</span>
                        </span>
                        <span class="message">
                          Ojo! Tu inventario de SALCHICHAS estÃ¡ prÃ³ximo a terminarse...
                        </span>
                      </a>
                    </li>
                    <li>
                      <div class="text-center">
                        <a>
                          <strong>Ver todos...</strong>
                          <i class="fa fa-angle-right"></i>
                        </a>
                      </div>
                    </li>
                  </ul>
                </li>
                -->
              </ul>
            </nav>
          </div>
  			
		</div>
        <!-- /top navigation -->

        <!-- page content -->
        <div class="right_col" role="main">
 			<!-- AQUÍ VA LA PÁGINA QUE QUEREMOS SE INSERTE EN EL BODY - FRAME PRINCIPAL DEL SISTEMA -->
			 <div ng-view> </div>
       </div>
        <!-- /page content -->

        <!-- footer content -->
        <footer>

 			<!-- AQUÍ VA EL FOOTER DE LA APLICACIÓN -->   
          <div class="pull-right">
            2017. Grupo Tecnetia SA de CV. <a href="http://tecnetia.com.mx/aviso-de-privacidad/" target="_blank">Aviso de Privacidad.</a>
          </div>
          <div class="clearfix"></div>

        </footer>
        <!-- /footer content -->
      </div>
    </div>
    
     <!-- jQuery -->
    <script src="<c:url value='/resources/js/vendors/jquery/dist/jquery.min.js' />"></script>
    <!-- Bootstrap -->
    <script src="<c:url value='/resources/js/vendors/bootstrap/dist/js/bootstrap.min.js' />"></script>
    <!-- FastClick -->
    <script src="<c:url value='/resources/js/vendors/fastclick/lib/fastclick.js' />"></script>
    <!-- NProgress -->
    <script src="<c:url value='/resources/js/vendors/nprogress/nprogress.js' />"></script>	
    <!-- Custom Theme Scripts -->
    <script src="<c:url value='/resources/js/build/custom.min.js' />"></script>
	<!-- Angular -->
    <script src="<c:url value='/resources/js/vendors/angular/angular.min.js' />"></script>
	<!-- Angular Route -->
    <script src="<c:url value='/resources/js/vendors/angular/angular-route.js' />"></script>
    <!-- Para manejo de horas y fechas -->
	<script src="<c:url value='/resources/js/vendors/bootstrap/moment.min.js' />" charset="utf-8"></script>
	<script src="<c:url value='/resources/js/datepicker/datetime-inputs.min.js' />"></script>
	<script src="<c:url value='/resources/js/vendors/bootstrap/moment-with-locales.js' />"></script>
	<script src="<c:url value='/resources/js/vendors/bootstrap/bootstrap-datetimepicker.js' />"></script>
	<!-- Manejo de carga de archivos -->
    <script src="<c:url value='/resources/js/vendors/bootstrap/fileinput.js' />"></script>
    <script src="<c:url value='/resources/js/vendors/bootstrap/locales/es.js' />"></script>
    <!-- Select2 -->
    <script src="<c:url value='/resources/js/vendors/select2/dist/js/select2.full.min.js' />"></script>
	
	<script src="<c:url value='/resources/js/comun/global.js' />"></script> 
	<script src="<c:url value='/resources/js/comun/service/globalService.js' />"></script>
	
	<!---------- LIBRERIAS DEL MODULO DE INDEX PARA LA APLICACION ------------>
    <script src="<c:url value='/resources/js/aplicacion/comun/index.js' />"></script>
    <script src="<c:url value='/resources/js/aplicacion/comun/controller/indexController.js' />"></script>
 
    <!-- Controller del modulo de taquilla - venta boletos -->
    <script src="<c:url value='/resources/js/aplicacion/taquilla/service/taquillaAngularService.js'/>"></script>
     
    <script src="<c:url value='/resources/js/aplicacion/taquilla/controller/ventaBoletosPaso1Controller.js' />"></script>
    <script src="<c:url value='/resources/js/aplicacion/taquilla/controller/ventaBoletosPaso2Controller.js' />"></script>
    <script src="<c:url value='/resources/js/aplicacion/taquilla/controller/ventaBoletosPaso3Controller.js' />"></script>
    <script src="<c:url value='/resources/js/aplicacion/taquilla/controller/ventaBoletosPaso4Controller.js' />"></script>
    <script src="<c:url value='/resources/js/aplicacion/taquilla/controller/ventaBoletosPaso5Controller.js' />"></script>
    <script src="<c:url value='/resources/js/comun/directivas/directivasVentaBoleto.js' />"></script> 


	<!-- Controller del modulo de dulceria -->
	<script src="<c:url value='/resources/js/aplicacion/dulceria/controller/ventaProductoPaso1Controller.js' />"></script>
    <script src="<c:url value='/resources/js/aplicacion/dulceria/controller/ventaProductoPaso2Controller.js' />"></script>
    <script src="<c:url value='/resources/js/aplicacion/dulceria/controller/ventaProductoPaso3Controller.js' />"></script>

	<!-- Modulos de Inventarios -->
	<script src="<c:url value='/resources/js/aplicacion/inventarios/controller/entradasDulceriaController.js' />"></script>

	<!-- Modulos de Configuración -->
	<script src="<c:url value='/resources/js/aplicacion/configuracion/controller/cupoSalaController.js' />"></script>
	<script src="<c:url value='/resources/js/aplicacion/configuracion/controller/menusDulceriaController.js' />"></script>
	<script src="<c:url value='/resources/js/aplicacion/configuracion/controller/peliculasController.js' />"></script>
	<script src="<c:url value='/resources/js/aplicacion/configuracion/controller/preciosVentaController.js' />"></script>
	<script src="<c:url value='/resources/js/aplicacion/configuracion/controller/productosDulceriaController.js' />"></script>
	<script src="<c:url value='/resources/js/aplicacion/configuracion/controller/programacionController.js' />"></script>
	    
    <!-- Controller del modulo de cambio de contraseña -->
    <script src="<c:url value='/resources/js/aplicacion/configuracion/controller/cambiarContraseniaController.js' />"></script>
 
   </body>
</html>
