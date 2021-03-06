
<!-- Bootstrap -->
<!-- page content -->
<!-- bloque de wizard -->
<!-- bloque de PASO de wizard - CARTELERA -->
<div id="step-1">

	<div class="x_panel">
		<div class="x_title">
			<h2>
				<i class="fa fa-film"></i> Cartelera
			</h2>
			<div class="clearfix"></div>

		</div>
		<div class="x_content">
			<div class="row">
				 
				<div class="col-md-2 col-md-offset-9">
					<label>Fecha Funci�n:</label>

					<div class="input-group" id='horario-pelicula'>
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-th"></i></span> <input type="text" calendar
							id="fechaInicio" ng-change="buscarPeliculasXFecha()"
							ng-model="fechaExhibicion" required="required"
							class="form-control col-md-7 col-xs-12">
						<!-- 						<input type="text" class="form-control" ng-model="fechaExhibicion" -->
						<!-- 							ng-change="buscarPeliculasXFecha()"><span -->
						<!-- 							class="input-group-addon"><i -->
						<!-- 							class="glyphicon glyphicon-th"></i></span> -->
					</div>
				</div>

			</div>
			<div class="alert   alert-danger" ng-if="errorPeliculas">
				<strong>Cuidado! </strong> No se encuentran funciones en cartelera.
			</div>



			<!-- bloque de pelicula -->
			<div dir-paginate="pelicula in listaPeliculas | itemsPerPage: 5">
				<div class="col-md-12 col-sm-12 col-xs-12">
					<div class="x_panel">
						<div class="x_title">
							<h2>
								<i class="fa fa-film"></i> {{pelicula.titulo}}
							</h2>
							<div class="clearfix"></div>
						</div>
						<div class="x_content">
							<div class="" role="tabpanel" data-example-id="togglable-tabs">
								<ul id="myTab" class="nav nav-tabs bar_tabs" role="tablist">
									<li role="presentation" class="active"><a
										ng-href="ventaBoletos#tab_horarios{{pelicula.idPelicula}}"
										id="horarios1-tab" role="tab" data-toggle="tab"
										aria-expanded="true">Horarios</a></li>
									<li role="presentation" class=""><a
										href="ventaBoletos#tab_sinopsis{{pelicula.idPelicula}}"
										role="tab" id="sinopsis1-tab" data-toggle="tab"
										aria-expanded="false">Sinopsis</a></li>
								</ul>
								<div id="myTabContent1" class="tab-content">
									<div role="tabpanel" class="tab-pane fade active in"
										id="tab_horarios{{pelicula.idPelicula}}"
										aria-labelledby="horarios1-tab">
										<div class="col-md-3">
											<div class="profile_img">
												<div id="crop-avatar">
													<img class="img-responsive avatar-view"
														ng-src="data:image/png;base64,{{pelicula.icono}}"
														width="90%">
												</div>
											</div>
										</div>
										<div class="col-md-9">
											<br />
											<div class="row">
												<div class="">

													<p>
														<button type="button" class="btn btn-round btn-info">{{pelicula.clasificacion}}</button>
														<button type="button" class="btn btn-round btn-info">{{pelicula.duracion}}
															min</button>
													</p>

													<div class="row col-md-12">
														<p ng-if="pelicula.esp2d.length > 0">ESP 2D
														<ul id="1" class="col-md-2 col-xs-6"
															ng-repeat="esp2d in pelicula.esp2d">
															<button type="button"
																ng-click="seleccionarPelicula(pelicula,esp2d)"
																ng-class="esp2d.existenciaBoletoVO.color"
																ng-disabled="esp2d.existenciaBoletoVO.disponibles ==0"
																title="Disponibles: {{esp2d.existenciaBoletoVO.disponibles}}">{{esp2d.horario}}</button>
														</ul>
														</p>
													</div>
													<div class="row col-md-12">
														<p ng-if="pelicula.esp3d.length > 0">ESP 3D
														<ul id="2" class="col-md-2 col-xs-6"
															ng-repeat="esp3d in pelicula.esp3d">
															<button type="button"
																ng-click="seleccionarPelicula(pelicula,esp3d)"
																ng-class="esp3d.existenciaBoletoVO.color"
																ng-disabled="esp3d.existenciaBoletoVO.disponibles ==0"
																title="Disponibles: {{esp3d.existenciaBoletoVO.disponibles}}">{{esp3d.horario}}</button>
														</ul>
														</p>
													</div>

													<div class="row col-md-12">
														<p ng-if="pelicula.esp4d.length > 0">ESP 4D
														<ul id="2" class="col-md-2 col-xs-6"
															ng-repeat="esp4d in pelicula.esp4d">
															<button type="button"
																ng-click="seleccionarPelicula(pelicula,esp4d)"
																ng-class="esp4d.existenciaBoletoVO.color"
																ng-disabled="esp4d.existenciaBoletoVO.disponibles ==0"
																title="Disponibles: {{esp4d.existenciaBoletoVO.disponibles}}">{{esp4d.horario}}</button>
														</ul>
														</p>
													</div>


													<div class="row col-md-12">
														<p ng-if="pelicula.sub2d.length > 0">SUB 2D
														<ul id="2" class="col-md-2 col-xs-6"
															ng-repeat="sub2d in pelicula.sub2d">
															<button type="button"
																ng-click="seleccionarPelicula(pelicula,sub2d)"
																ng-class="sub2d.existenciaBoletoVO.color"
																ng-disabled="sub2d.existenciaBoletoVO.disponibles ==0"
																title="Disponibles: {{sub2d.existenciaBoletoVO.disponibles}}">{{sub2d.horario}}</button>
														</ul>
														</p>
													</div>
													<div class="row col-md-12">
														<p ng-if="pelicula.sub3d.length > 0">SUB 3D
														<ul id="2" class="col-md-2 col-xs-6"
															ng-repeat="sub3d in pelicula.sub3d">
															<button type="button"
																ng-click="seleccionarPelicula(pelicula,sub3d)"
																ng-class="sub3d.existenciaBoletoVO.color"
																ng-disabled="sub3d.existenciaBoletoVO.disponibles ==0"
																title="Disponibles: {{sub3d.existenciaBoletoVO.disponibles}}">{{sub3d.horario}}</button>
														</ul>
														</p>
													</div>
													<div class="row col-md-12">
														<p ng-if="pelicula.sub4d.length > 0">SUB 4D
														<ul id="2" class="col-md-2 col-xs-6"
															ng-repeat="sub4d in pelicula.sub4d">
															<button type="button"
																ng-click="seleccionarPelicula(pelicula,sub4d)"
																ng-class="sub4d.existenciaBoletoVO.color"
																ng-disabled="sub4d.existenciaBoletoVO.disponibles ==0"
																title="Disponibles: {{sub4d.existenciaBoletoVO.disponibles}}">{{sub4d.horario}}</button>
														</ul>
														</p>
													</div>

												</div>
											</div>
											<!-- /row -->
										</div>
									</div>
									<div role="tabpanel" class="tab-pane fade"
										id="tab_sinopsis{{pelicula.idPelicula}}"
										aria-labelledby="sinopsis1-tab">
										<div class="col-md-4 col-xs-12">
											<div class="profile_img">
												<div id="crop-avatar">
													<img class="img-responsive avatar-view" width="250px"
														height="200px"
														ng-src="data:image/png;base64,{{pelicula.icono}}">
												</div>
											</div>
										</div>
										<div class="col-md-6 col-xs-12">
											<p>
												<button type="button" class="btn btn-round btn-info">{{pelicula.distribuidoraVO.nombre}}</button>
												<button type="button" class="btn btn-round btn-info">{{pelicula.paisVO.nombre}}</button>
											</p>
											<br /> <br />
											<p>{{pelicula.sinopsis}}</p>
										</div>
									</div>
								</div>
							</div>

						</div>
					</div>
				</div>
			</div>
			<dir-pagination-controls></dir-pagination-controls>
		</div>
	</div>
	<script>
		var dateToday = new Date();

		$(function() {
			$('.input-group.date').datepicker({
				format : "yyyy/mm/dd",
				startDate : '+0d',
				autoclose : true,
				todayBtn : 'linked',
				todayHighlight : true
			});
		});
	</script>

</div>

<!-- /bloque de PASO de wizard -->
<!-- /bloque de wizard -->