
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!-- bloque de PASO de wizard -->
<div id="step-1">
	<div class="x_panel">
		<div class="x_title">
			<h2>
				<i class="fa fa-shopping-cart"></i> Selecciona el Producto
			</h2>
			<div class="title_right">
				<div class="row pull-right">

					<button type="button" ng-click="asignarPaso(2)"
						class="btn btn-success">
						Registrar el Pago <i class="fa fa-credit-card"></i>
					</button>

				</div>

				<div class="clearfix"></div>
			</div>
		</div>
		<div class="x_content">

			<!-- bloque de 12 col -->
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<!-- begin product table -->
					<div class="col-lg-7 col-md-7 col-sm-7 col-xs-12">
						<div class="row">
							<div
								class="col-lg-8 col-md-8 col-sm-8 col-xs-12 form-group pull-left top_search">
								<div class="input-group">
									<input type="text" class="form-control"
										placeholder="Buscar producto..."> <span
										class="input-group-btn">
										<button class="btn btn-default" type="button" ng-click="">Ir!</button>

									</span>
								</div>
							</div>
						</div>

						<div class="alert   alert-danger" ng-if="errorPaquetes">
							<strong>Cuidado! </strong> No se encuentran paquetes disponibles.
						</div>

						<div class="row">

							<div dir-paginate="paquete in paquetes | itemsPerPage: 10">
								<div
									class="animated flipInY col-lg-4 col-md-4 col-sm-6 col-xs-6">
									<a href="javascript:void(0)" ng-click="agregarPaquete(paquete)">
										<div class="tile-stats" style="background-color: #F6CECE">
											<div style="position: absolute; top: 10px; right: 10px">
												<img class="img-responsive avatar-view"
													ng-src="data:image/png;base64,{{paquete.icono}}"
													width="50px" height="50px">
											</div>
											<div class="count">{{paquete.cantidad}}</div>
											<h3>{{paquete.nombre}}</h3>
											<div ng-if="paquete.paquete">
												<p
													ng-repeat="produtoXPaquete in paquete.productosXPaqueteVO">
													{{produtoXPaquete.cantidad}}
													{{produtoXPaquete.productoVO.nombre}}(s)</p>
											</div>
											<div class="text-center mtop20">
												<h2>{{paquete.precio | currency }}</h2>
											</div>
										</div>
									</a>
								</div>
							</div>
							<dir-pagination-controls></dir-pagination-controls>
						</div>
						<!-- /row -->

					</div>
					<!-- finish product table -->

					<!-- empieza sidebar - resumen de venta -->
					<div class="table-responsive col-lg-5 col-md-5 col-sm-5 col-xs-12">
						<h3 class="text-center">Resumen de Venta</h3>
						<table class="table table-striped jambo_table bulk_action">
							<thead>
								<tr class="headings">
									<th class="column-title text-center">Cant.</th>
									<th class="column-title text-center">Producto</th>
									<th class="column-title text-center">Precio</th>
									<th class="column-title text-center no-link last">Quitar</th>
								</tr>
							</thead>

							<tbody>
								<tr class="odd pointer"
									ng-repeat="paquete in  paquetesSeleccionados"
									ng-if="paquete.cantidad >0">
									<td class="text-center">{{paquete.cantidad}}</td>
									<td>{{paquete.nombre}}</td>
									<td class="text-center">{{paquete.importe | currency }}</td>
									<td class="text-center"><a href=""
										ng-click="eliminarPaquete(paquete)" title="Quitar Boleto"><i
											class="success fa fa-minus-square-o"></i></a></td>
								</tr>

							</tbody>

						</table>
						<div class="x_content">
							<div class="row" align="center">
								<h3>TOTAL = {{total}}</h3>
							</div>
						</div>
					</div>
					<!-- end sidebar - resumen de venta -->

				</div>
				<!-- /x panel -->
			</div>
			<!-- /12 col -->
		</div>
		<!-- /content -->
	</div>
	<!-- /x panel global -->
</div>
<!-- /step div	 -->
