
<div class="x_panel">
	<div class="x_title">
		<h2>
			<i class="fa fa-money"></i> Promocion Taquilla
		</h2>
		<div class="clearfix"></div>
	</div>
	<div class="x_content">
		<br />
		<div class="x_panel">
			<form id="demo-form2" data-parsley-validate
				class="form-horizontal form-label-left">


				<div class="form-group">
					<label class="control-label col-md-3 col-sm-3 col-xs-12"
						for="nombre">Nombre Promoción <span class="required">*</span>
					</label>
					<div class="col-md-6 col-sm-6 col-xs-12">
						<input type="text" id="nombre" required="required"
							class="form-control col-md-7 col-xs-12"
							ng-model="promocion.nombre" placeholder="Nombre Promoción">
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-md-3 col-sm-3 col-xs-12"
						for="descripcion">Descripción Promoción <span
						class="required">*</span>
					</label>
					<div class="col-md-6 col-sm-6 col-xs-12">
						<input type="text" id="descripcion" required="required"
							class="form-control col-md-7 col-xs-12"
							ng-model="promocion.descripcion"
							placeholder="Descripción Promoción">
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-md-3 col-sm-3 col-xs-12"
						for="promocion-para">Promoción Para<span class="required">*</span>
					</label>
					<div class="col-md-6 col-sm-6 col-xs-12">
						<select class="form-control"
							ng-options="promocion  as promocion.nombre for promocion  in listaPromoPara"
							ng-model="promocion.promocionParaVO">
							<option value="" selected="selected">Selecciona
								promocion Para</option>

						</select>

					</div>
				</div>


				<div class="form-group">
					<label class="control-label col-md-3 col-sm-3 col-xs-12"
						for="tipo-promocion ">Tipo Promoción<span class="required">*</span>
					</label>
					<div class="col-md-6 col-sm-6 col-xs-12">
						<select class="form-control"
							ng-options="tipoPromo as tipoPromo.nombre for tipoPromo  in listaTiposPromo"
							ng-model="promocion.tipoPromoVO">
							<option value="" selected="selected">Selecciona Tipo
								Promocion</option>
						</select>


					</div>
				</div>
				<fieldset class="scheduler-border">
				<div class="form-group">
					
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="varN">Variable N <span class="required">*</span>
						</label>
						<div class="col-md-2 col-sm-2 col-xs-5">
							<div class='input-group date' id='varN'>
								<input type='text' class="form-control" ng-model="promocion.n" />
								<span class="input-group-addon"> <span class=""></span>
								</span>
							</div>
						</div>
						<label class="control-label col-md-2 col-sm-3 col-xs-12"
							for="varM">Variable M <span class="required">*</span>
						</label>
						<div class="col-md-2 col-sm-2 col-xs-5">
							<div class='input-group date' id='varM'>
								<input type='text' class="form-control" ng-model="promocion.m" />
								<span class="input-group-addon"> <span class=" "></span>
								</span>
							</div>
						</div>
				</div>

					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="precio">Precio<span class="required">*</span>
						</label>
						<div class="col-md-2 col-sm-2 col-xs-5">
							<div class='input-group date' id='precio'>
								<input type='text' class="form-control"
									ng-model="promocion.precio" /> <span class="input-group-addon">
									<span class=" "></span>
								</span>
							</div>
						</div>
						<label class="control-label col-md-2 col-sm-3 col-xs-12"
							for="porcentaje">Porcentaje <span class="required">*</span>
						</label>
						<div class="col-md-2 col-sm-2 col-xs-5">
							<div class='input-group date' id='porcentaje'>
								<input type='text' class="form-control"
									ng-model="promocion.porcentaje" /> <span
									class="input-group-addon"> <span class=" "></span>
								</span>
							</div>
						</div>

					</div>
				</fieldset>


				<br />
				<div class="form-group">
					<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
						<button type="submit" class="btn btn-success"
							ng-click="guardarPromocion(promocion)">
							<i class=""></i> Guardar
						</button>
					</div>
				</div>

			</form>
		</div>
		<div class="x_panel">
			<div class="row">
				<div
					class="table-responsive col-lg-6 col-md-6 col-sm-12 col-xs-12 col-lg-offset-3 col-md-offset-2 col-sm-offset-1">
					<table id="datatable-responsive"
						class="table table-striped table-bordered dt-responsive nowrap"
						cellspacing="0" width="100%">
						<thead>
							<tr>
								<th class="text-center">Formato</th>
								<th class="text-center">Precio</th>
								<th class="text-center">Horario</th>
								<th class="text-center">Eliminar</th>
							</tr>
						</thead>

						<tbody>
							<tr>
								<td class="text-center">2D</td>
								<td class="text-center">$ 38.00</td>
								<td class="text-center">10:00 AM a 13:00 PM</td>
								<td class="text-center">
									<button type="button" class="btn btn-round btn-default btn-md">
										<i class="fa fa-trash-o"></i>
									</button>
								</td>
							</tr>
							<tr>
								<td class="text-center">2D</td>
								<td class="text-center">$ 42.00</td>
								<td class="text-center">13:00 PM a 23:00 PM</td>
								<td class="text-center">
									<button type="button" class="btn btn-round btn-default btn-md">
										<i class="fa fa-trash-o"></i>
									</button>
								</td>
							</tr>
							<tr>
								<td class="text-center">3D</td>
								<td class="text-center">$ 50.00</td>
								<td class="text-center">10:00 AM a 23:00 PM</td>
								<td class="text-center">
									<button type="button" class="btn btn-round btn-default btn-md">
										<i class="fa fa-trash-o"></i>
									</button>
								</td>
							</tr>
							<tr>
								<td class="text-center">4D</td>
								<td class="text-center">$ 55.00</td>
								<td class="text-center">10:00 AM a 23:00 PM</td>
								<td class="text-center">
									<button type="button" class="btn btn-round btn-default btn-md">
										<i class="fa fa-trash-o"></i>
									</button>
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
