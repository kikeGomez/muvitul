<style type="text/css">
.table-fixed thead {
	width: 97%;
}

.table-fixed tbody {
	height: 230px;
	overflow-y: auto;
	width: 100%;
}
</style>
<div class="x_panel">
	<div class="x_title">
		<h2>
			<i class="fa fa-cog"></i> Programaci&oacute;n
		</h2>
		<div class="clearfix"></div>
	</div>
	<div class="x_content">
		<br />
		<div class="x_panel">
			<form id="formProgramaciones" name="formProgramaciones" role="form"
				novalidate class="form-horizontal form-label-left">

				<div class="form-group"
					ng-class="{'has-error': formProgramaciones.sala.$invalid && formProgramaciones.sala.$dirty}">
					<label class="control-label col-md-3 col-sm-3 col-xs-12" for="sala">Sala
						<span class="required">*</span>
					</label>
					<div class="col-md-6 col-sm-6 col-xs-12">
						<div class="btn-group btn-group-justified" data-toggle="buttons">

							<label class="btn btn-primary "
								ng-repeat="sala in listaSalas | orderBy:idSala: true "
								ng-click="seleccion(sala,'sala')"> <input type="radio"
								class="sr-only" id="sala" ng-model="programacion.salaVO"
								required name="sala" checked> <span class="docs-tooltip"
								title=" {{sala.nombre}}"> {{sala.nombre}} </span>
							</label>


						</div>
					</div>
					<div
						ng-show="formProgramaciones.sala.$invalid && formProgramaciones.sala.$dirty"
						ng-style="{color:'red'}">El campo es requerido.</div>
				</div>

				<div class="form-group"
					ng-class="{'has-error': formProgramaciones.dia.$invalid && formProgramaciones.dia.$dirty}">
					<label class="control-label col-md-3 col-sm-3 col-xs-12" for="dia">D&iacute;a
						<span class="required">*</span>
					</label>
					<div class="col-md-6 col-sm-6 col-xs-12">
						<div class="btn-group btn-group-justified" data-toggle="buttons">

							<label class="btn btn-primary "
								ng-repeat="dia in listaDiasSemana"
								ng-click="seleccion(dia,'dia')"> <input type="radio"
								class="sr-only" id="dia" ng-model="programacion.diaSemana"
								required name="dia" checked> <span class="docs-tooltip"
								title=" {{dia}}"> {{dia}} </span>
							</label>


						</div>
					</div>
					<div
						ng-show="formProgramaciones.dia.$invalid && formProgramaciones.dia.$dirty"
						ng-style="{color:'red'}">El campo es requerido.</div>
				</div>


				<div class="form-group"
					ng-class="{'has-error': formProgramaciones.pelicula.$invalid && formProgramaciones.pelicula.$dirty}">
					<label class="control-label col-md-3 col-sm-3 col-xs-12"
						for="titulo-pelicula">Pel&iacute;cula<span
						class="required">*</span>
					</label>
					<div class="col-md-6 col-sm-6 col-xs-12">
						<select class="form-control" id="pelicula"
							ng-options="pelicula as pelicula.titulo for pelicula  in listaPeliculas"
							ng-model="programacion.peliculaVO" required name="pelicula">
							<option value="" selected="selected">Selecciona la
								Pel&iacute;cula</option>
						</select>
					</div>
					<div
						ng-show="formProgramaciones.pelicula.$invalid && formProgramaciones.pelicula.$dirty"
						ng-style="{color:'red'}">El campo es requerido.</div>
				</div>
				<div class="form-group"
					ng-class="{'has-error': formProgramaciones.formato.$invalid && formProgramaciones.formato.$dirty}">
					<label class="control-label col-md-3 col-sm-3 col-xs-12"
						for="formato">Formato<span class="required">*</span>
					</label>
					<div class="col-md-6 col-sm-6 col-xs-12">
						<div class="btn-group btn-group-justified" data-toggle="buttons">
							<label class="btn btn-primary "
								ng-repeat="formato in listaFormatos"
								ng-click="seleccion(formato,'formato')"> <input
								type="radio" class="sr-only" id="formato"
								ng-model="programacion.formatoVO" required name="formato"
								checked> <span class="docs-tooltip"
								title="{{formato.nombre}}"> {{formato.nombre}} </span>
							</label>

						</div>
					</div>
					<div
						ng-show="formProgramaciones.formato.$invalid && formProgramaciones.formato.$dirty"
						ng-style="{color:'red'}">El campo es requerido.</div>
				</div>
				<div class="form-group"
					ng-class="{'has-error': formProgramaciones.version.$invalid && formProgramaciones.version.$dirty}">
					<label class="control-label col-md-3 col-sm-3 col-xs-12"
						for="formato">Versi&oacute;n<span class="required">*</span>
					</label>
					<div class="col-md-6 col-sm-6 col-xs-12">
						<div class="btn-group btn-group-justified" data-toggle="buttons">
							<label class="btn btn-primary "
								ng-repeat="version in listaVersiones"
								ng-click="seleccion(version,'version')"> <input
								type="radio" class="sr-only" id="version"
								ng-model="programacion.versionVO" required name="version"
								checked> <span class="docs-tooltip"
								title="{{version.nombre}}"> {{version.nombre}} </span>
							</label>
						</div>
					</div>
					<div
						ng-show="formProgramaciones.version.$invalid && formProgramaciones.version.$dirty"
						ng-style="{color:'red'}">El campo es requerido.</div>
				</div>
				<div class="form-group"
					ng-class="{'has-error': formProgramaciones.horario.$invalid && formProgramaciones.horario.$dirty}">
					<label class="control-label col-md-3 col-sm-3 col-xs-12"
						for="horario">Horario <span class="required">*</span>
					</label>
					<div class="col-md-6 col-sm-6 col-xs-12">
						<div class='input-group'>
							<input type='text' class="form-control" id='horario-pelicula'
								value="12:49 AM" ng-model="programacion.horario" required
								name="horario" ng-change="cambiarHorario(horario)" /> <span
								class="input-group-addon"> <span
								class="glyphicon glyphicon-time"></span>
							</span>
						</div>
					</div>
					<!-- 					<script> 
 						$(function() {
 							$('#horario-pelicula').datetimepicker({
 								format : 'LT'
 							});
 						});
 					</script> -->
					<div
						ng-show="formProgramaciones.horario.$invalid && formProgramaciones.horario.$dirty"
						ng-style="{color:'red'}">El campo es requerido.</div>
				</div>
				<div class="form-group"
					ng-class="{'has-error': formProgramaciones.fechaVigencia.$invalid && formProgramaciones.fechaVigencia.$dirty}">
					<label class="control-label col-md-3 col-sm-3 col-xs-12"
						for="fechaVigencia">Vigencia  <span class="required">*</span>
					</label>
					<div class="col-md-6 col-sm-6 col-xs-12">
						<div class="control-group">
							<div class="controls">
								<div class="col-md-11 xdisplay_inputx form-group has-feedback">
									<input type="text" class="form-control has-feedback-left"
										id="fechaVigencia" placeholder="Vigencia" name="fechaVigencia"
										ng-model="programacion.fechaVigencia" required
										aria-describedby="inputSuccess2Status3"> <span
										class="fa fa-calendar-o form-control-feedback left"
										aria-hidden="true"></span> <span id="inputSuccess2Status3"
										class="sr-only">(success)</span>
								</div>
							</div>
						</div>
					</div>
					<div
						ng-show="formProgramaciones.fechaVigencia.$invalid && formProgramaciones.fechaVigencia.$dirty"
						ng-style="{color:'red'}">El campo es requerido.</div>
				</div>
				<br />
				<div class="form-group">
					<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
						<button type="submit" class="btn btn-success"
							ng-click="crearProgramacion(programacion)">
							<i class="fa fa-th"></i> Guardar
						</button>
					</div>
				</div>
			</form>
		</div>
		<div class="x_panel">
			<div class="row">
				<div
					class="table-responsive col-lg-9 col-md-10 col-sm-12 col-xs-12 col-lg-offset-1 col-md-offset-1">

					<table class="table  table-fixed  table-hover   table-bordered  ">
						<thead>
							<tr>
								<th class="text-center">Sala</th>
								<th class="text-center">Pel&iacute;cula</th>
								<th class="text-center">Programaci&oacute;n</th>
							</tr>
						</thead>
						<tbody ng-repeat="sala in listaSalasProgramaciones"
							ng-if="sala.peliculasVO.length > 0">
							<td rowspan="{{sala.peliculasVO.length+1}}">{{sala.nombre}}</td>
							<tr ng-repeat='pelicula in sala.peliculasVO'>
								<td>{{pelicula.titulo}}</td>
								<td>
									<ul ng-repeat='programacion in pelicula.programacionesVO'>
										<button type="button" class="btn btn-default btn-xs"
											ng-click="eliminarProgramacion(programacion.idProgramacion)">
											{{programacion.diaSemana}} {{programacion.formatoVO.nombre}}
											{{programacion.horario}} <i class="fa fa-close"></i>
										</button>
									</ul>


								</td>
							</tr>
						</tbody>
					</table>


				</div>
				<!-- table-responsive -->
			</div>
			<!-- row -->
		</div>
		<!-- x-panel -->
	</div>
	<!-- content -->
</div>


<!-- xpanel -->