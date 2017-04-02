<html>
<head>
<meta charset="utf-8">
<title>Alta de Infracción</title>
</head>
<body>
<!-- bloque de PASO 5 de wizard - CANTIDAD -->
<div id="step-2">
	<div class="x_panel">
		<div class="x_title">
			<h2>
				<i class="fa fa-thumbs-o-up"></i> Confirma la Venta
			</h2>
			<div class="row pull-right">

<!-- 				<button type="button" class="btn btn-primary" -->
<!-- 					ng-click="asignarPaso(4)"> -->
<!-- 					<i class="fa fa-credit-card"></i> Regresar al Pago -->
<!-- 				</button> -->

			</div>
			<div class="clearfix"></div>
		</div>
		<div class="x_content">
			<!-- bloque de pelicula -->
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="row">
						<h5 class="text-center">Al imprimir los boletos se
							cerrar&aacute; la venta. Val&iacute;da que todos los datos sean
							correctos.</h5>
						<div
							class="col-lg-12 col-md-12 col-sm-12 col-xs-12 col-lg-offset-5 col-md-offset-5 col-sm-offset-5">
							<a class="btn btn-app" title="Cerrar venta e imprimir boletos" ng-click="imprimirBoleto()">
								<i class="fa fa-print"></i> Imprimir Boletos
							</a>
						</div>
					</div>
				</div>

				<div class="x_panel">
					<div class="x_title">
						<h2>
							<i class="fa fa-film"></i> {{objetosVenta.pelicula.titulo}}
						</h2>
						<div class="row pull-right">
							<h3>TOTAL = {{pago.subtotal}}</h3>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="col-md-3 col-sm-3 col-xs-3">
						<br /> <br />
						<div class="profile_img">
							<div id="crop-avatar">
								<img class="img-responsive avatar-view"
									ng-src="data:image/png;base64,{{objetosVenta.pelicula.icono}}"
									width="90%">

							</div>
						</div>
					</div>
					<div class="col-md-9 col-sm-9 col-xs-9">
						<div class="row">
							<div class="col-md-4 col-sm-4 col-xs-4">
								<br /> <br />
								<div class="row">
									<div class="col-md-12 col-sm-12 col-xs-12">
										<label>CINE: {{objetosVenta.pelicula.cineVO.nombre}} </label>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12 col-sm-12 col-xs-12">
										<label>FECHA: {{objetosVenta.fechaExhibicion |
											date:'dd-MM-yyyy'}} </label>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12 col-sm-12 col-xs-12">
										<label>HORARIO: {{objetosVenta.programacion.horario}}
											{{objetosVenta.programacion.versionVO.nombre}}
											{{objetosVenta.programacion.formatoVO.nombre}} </label>
									</div>
								</div>
							</div>
							<!-- /col md 4 -->
							<div class="col-md-8 col-sm-8 col-xs-8">
								<br />
								<div
									class="animated flipInY col-lg-4 col-md-12 col-sm-12 col-xs12">

									<div class="tile-stats">
										<h2 class="text-center">Promoci&oacute;n</h2>
										<br />
										<h3>{{objetosVenta.promocion.nombre}}</h3>
										<p>{{objetosVenta.promocion.descripcion}}</p>
									</div>

								</div>

								<div
									class="animated flipInY col-lg-4 col-md-12 col-sm-12 col-xs12">

									<div class="tile-stats">
										<h2 class="text-center">Sala</h2>
										<br />
										<h3>{{objetosVenta.programacion.salaVO.nombre}}</h3>

									</div>

								</div>

							</div>


							<!-- /div col-md-8 -->
						</div>
						<!-- /row -->
						<br />
						<div class="row">
							<div
								class="table-responsive col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<h3 class="text-center">Boletos</h3>
								<table class="table table-striped jambo_table bulk_action">
									<thead>
										<tr class="headings">
											<th class="column-title text-center">Tipo</th>
											<th class="column-title text-center">Cant.</th>
											<th class="column-title text-center">Subtotal</th>
										</tr>
									</thead>


									<tbody>
										<tr class="odd pointer" ng-repeat="boleto in  boletos "
											ng-if="boleto.cantidad >0">
											<td class=" ">{{boleto.tipoCliente}}</td>
											<td class="text-center">{{boleto.cantidad}}</td>
											<td class="text-center">{{boleto.subtotal}}</td>

										</tr>

									</tbody>

								</table>
							</div>
							<!-- table-responsive -->
							<div
								class="table-responsive col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<h3 class="text-center">Pagos</h3>
								<table class="table table-striped jambo_table bulk_action">
									<thead>
										<tr class="headings">
											<th class="column-title text-center">Forma de Pago</th>
											<th class="column-title text-center">Importe</th>
											<th class="column-title text-center">Cuenta</th>
										</tr>
									</thead>

									<tbody>
									<tbody>
										<tr class="even pointer" ng-repeat="pago in listaPagos">
											<td class=" ">{{pago.formaPagoVO.nombre}}</td>
											<td class="text-center">{{pago.importe}}</td>
											<td class="text-center">{{pago.noCuenta}}</td>
										</tr>

									</tbody>
									</tbody>

								</table>
							</div>
							<!-- table-responsive -->
						</div>
						<!-- row -->

					</div>
					<!-- /div 9 columnas -->

				</div>
				<!-- /xpanel -->
			</div>
			<!-- /col-md-12 -->

		</div>
		<!-- /xcontent -->
	</div>
	<!-- /xpanel MODULO -->
</div>

</body>
</html>