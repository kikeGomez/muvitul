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
			<form id="demo-form2" data-parsley-validate
				class="form-horizontal form-label-left">

				<div class="form-group">
					<label class="control-label col-md-3 col-sm-3 col-xs-12" for="sala">Sala
						<span class="required">*</span>
					</label>
					<div class="col-md-6 col-sm-6 col-xs-12">
						<div class="btn-group btn-group-justified" data-toggle="buttons">

							<label type="radio" class="btn btn-primary "
								ng-repeat="sala in listaSalas | orderBy:idSala: true "
								ng-click="seleccion(sala,'sala')"> <input type="radio"
								class="sr-only" id="sala" ng-model="programacion.salaVO"
								required name="sala" checked> <span class="docs-tooltip"
								title=" {{sala.nombre}}"> {{sala.nombre}} </span>
							</label>


						</div>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3 col-sm-3 col-xs-12" for="dia">D&iacute;a
						<span class="required">*</span>
					</label>
					<div class="col-md-6 col-sm-6 col-xs-12">
						<div class="btn-group btn-group-justified" data-toggle="buttons">
							<label class="btn btn-primary "
								ng-repeat="dia in listaDiasSemana"
								ng-click="seleccion(dia,'dia')"> <input type="radio"
								class="sr-only" id="dia" ng-model="programacion.diaVO" required
								name="dia" checked> <span class="docs-tooltip"
								title="{{dia}}"> {{dia }} </span>
							</label>
						</div>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-md-3 col-sm-3 col-xs-12"
						for="titulo-pelicula">Pel&iacute;cula<span
						class="required">*</span>
					</label>
					<div class="col-md-6 col-sm-6 col-xs-12">
						<select class="form-control"
							ng-options="pelicula as pelicula.titulo for pelicula  in listaPeliculas"
							ng-model="programacion.peliculaVO">
							<option value="" selected="selected">Selecciona la
								Pel&iacute;cula</option>
						</select>
					</div>
				</div>
				<div class="form-group">
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
				</div>
				<div class="form-group">
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
				</div>
				<div class="form-group">
					<label class="control-label col-md-3 col-sm-3 col-xs-12"
						for="horario">Horario <span class="required">*</span>
					</label>
					<div class="col-md-6 col-sm-6 col-xs-12">
						<div class='input-group date'>
							<input type='text' class="form-control" id='horario-pelicula'
								ng-model="horario " ng-change="cambiarHorario(horario)" /> <span
								class="input-group-addon"> <span
								class="glyphicon glyphicon-time"></span>
							</span>
						</div>
					</div>
					<script>
						$(function() {
							$('#horario-pelicula').datetimepicker({
								format : 'LT'
							});
						});
					</script>
				</div>
				<br />
				<div class="form-group">
					<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
						<button type="submit" class="btn btn-success"
							ng-click="guardarProgramacion(programacion)">
							<i class="fa fa-th"></i> Guardar
						</button>
					</div>
				</div>
			</form>
		</div>
		<div class="x_panel">
			<div class="row">
				<div class="table-responsive col-lg-9 col-md-10 col-sm-12 col-xs-12 col-lg-offset-1 col-md-offset-1">

					<table  class="table  table-fixed  table-hover table-striped table-bordered dt-responsive ">
						<thead>
							<tr>
								<th class="text-center">Sala</th>
								<th class="text-center">Pel&iacute;cula</th>
								<th class="text-center">Programaci&oacute;n</th>
							</tr>
						</thead>
						<tbody ng-repeat='sala in salasVO'>
							<td rowspan="{{sala.peliculasVO.length+1}}">{{sala.nombre}}</td>
							<tr ng-repeat='pelicula in sala.peliculasVO'>
								<td>{{pelicula.nombre}}</td>
								<td>
									<ul ng-repeat='programacionesVO in pelicula.programacionesVO'>
										<button type="button" class="btn btn-default btn-xs">
											{{programacionesVO.nombre}} <i class="fa fa-close"></i>
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