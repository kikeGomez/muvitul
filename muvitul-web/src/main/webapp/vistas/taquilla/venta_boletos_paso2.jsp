<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- page content -->
<!-- bloque de wizard -->

<!-- bloque de PASO 2 de wizard - PROMOCION -->
<div id="step-2">
	<div class="x_panel">
		<div class="x_title">
			<h2>
				<i class="fa fa-star"></i> Selecciona la Promoci&oacute;n que Deseas
				Aplicar
			</h2>
			<div class="row pull-right">
				 
					<button type="button" class="btn btn-primary" ng-click="asignarPaso(1)">
						<i class="fa fa-film"></i> Regresar a Cartelera
					</button>
			 
					<button type="button" class="btn btn-success" ng-click="asignarPaso(3)">
						Elegir Cantidad <i class="fa fa-calculator"></i>
					</button>
				 
			</div>
			<div class="clearfix"></div>
		</div>
		<div class="row">
			<form id="demo-form2" data-parsley-validate
				class="form-horizontal form-label-left">
				<div class="col-md-12 col-sm-12 col-xs-12">
					<div class="x_content">

						<!-- Tabla de Promociones -->
						<div class="row">

							<div class="animated flipInY col-lg-4 col-md-4 col-sm-4 col-xs-6">
								<a href="javascript:void(0)" ng-click="seleccionarPromocion()">
									<div class="tile-stats" style="background-color: #F2F2F2">
										<div style="position: absolute; top: 10px; right: 10px">
											<img src="<c:url value='resources/img/ticket_icon.jpeg' />"
												width="50px" height="50px">
										</div>
										<div class="count">
											<img src="<c:url value='resources/img/check_icon.jpeg' />"
												width="50px" height="50px">
										</div>
										<br />
										<h3>2 X 1</h3>
										<br />
										<p>2 X 1 todos los mi&eacute;rcoles</p>
										<div class="text-center mtop20">
											<h2>$60.00</h2>
										</div>
									</div>
								</a>
							</div>
							<div class="animated flipInY col-lg-4 col-md-4 col-sm-4 col-xs-6">
								<a href="javascript:void(0)">
									<div class="tile-stats">
										<div style="position: absolute; top: 10px; right: 10px">
											<img src="<c:url value='resources/img/ticket_icon.jpeg' />"
												width="50px" height="50px">
										</div>
										<div class="count">
											<img src="<c:url value='resources/img/uncheck_icon.jpeg' />"
												width="50px" height="50px">
										</div>
										<br />
										<h3>Ni&ntilde;os Gratis</h3>
										<br />
										<p>Compra 1 adulto y entra 1 ni&ntilde;o gratis.</p>
										<div class="text-center mtop20">
											<h2>$55.00</h2>
										</div>
									</div>
								</a>
							</div>
							<div class="animated flipInY col-lg-4 col-md-4 col-sm-4 col-xs-6">
								<a href="javascript:void(0)">
									<div class="tile-stats">
										<div style="position: absolute; top: 10px; right: 10px">
											<img src="<c:url value='resources/img/ticket_icon.jpeg' />"
												width="50px" height="50px">

										</div>
										<div class="count">
											<img src="<c:url value='resources/img/uncheck_icon.jpeg' />"
												width="50px" height="50px">
										</div>
										<br />
										<h3>2 ni&ntilde;os X $70</h3>
										<br />
										<p>Compra 2 boletos de ni&ntilde;o por $70.00</p>
										<div class="text-center mtop20">
											<h2>$70.00</h2>
										</div>
									</div>
								</a>
							</div>
						</div>

						<!-- /Tabla de Promociones -->

					</div>
					<!-- X content -->
				</div>
				<!-- Col 12 -->

			</form>
		</div>
		<!-- /row -->
	</div>
</div>
<!-- /bloque de PASO 2 de wizard -->
<!-- /bloque de wizard -->