
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
			<form id="formPromociones" name="formPromociones" role="form"
				novalidate class="form-horizontal form-label-left">
				<div class="col-md-1"></div>
				<div class="col-md-10">

					<div class="row">
						<div class="col-sm-6">
							<div class="form-group"
								ng-class="{'has-error': formPromociones.nombre.$invalid && formPromociones.nombre.$dirty}">
								<label>Nombre Promoción <span class="required">*</span>
								</label>
								<div class="input-group">
									<span class="input-group-addon"><i
										class="fa fa-long-arrow-up"></i></span> <input type="text"
										id="nombre" required name="nombre"
										class="form-control col-md-7 col-xs-12"
										ng-model="promocion.nombre" placeholder="Nombre Promoción">
								</div>
								<div
									ng-show="formPromociones.nombre.$invalid && formPromociones.nombre.$dirty"
									ng-style="{color:'red'}">El campo es requerido.</div>
							</div>
						</div>

						<div class="col-sm-6">
							<div class="form-group"
								ng-class="{'has-error': formPromociones.descripcion.$invalid && formPromociones.descripcion.$dirty}">
								<label>Descripción Promoción <span class="required">*</span>
								</label>
								<div class="input-group">
									<span class="input-group-addon"><i
										class="fa fa-long-arrow-up"></i></span><input type="text"
										id="descripcion" required name="descripcion"
										class="form-control col-md-7 col-xs-12"
										ng-model="promocion.descripcion"
										placeholder="Descripción Promoción">
								</div>
								<div
									ng-show="formPromociones.descripcion.$invalid && formPromociones.descripcion.$dirty"
									ng-style="{color:'red'}">El campo es requerido.</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-sm-6">
							<div class="form-group"
								ng-class="{'has-error': formPromociones.promocionPara.$invalid && formPromociones.promocionPara.$dirty}">
								<label>Promoción Para<span class="required">*</span>
								</label>
								<div class="input-group">
									<span class="input-group-addon"><i
										class="fa fa-long-arrow-up"></i></span><select class="form-control"
										name="promocionPara" required
										ng-options="promocion  as promocion.nombre for promocion  in listaPromoPara"
										ng-model="promocion.promocionParaVO">
										<option value="" selected="selected">Selecciona
											promocion Para</option>
									</select>
								</div>
								<div
									ng-show="formPromociones.promocionPara.$invalid && formPromociones.promocionPara.$dirty"
									ng-style="{color:'red'}">El campo es requerido.</div>
							</div>
						</div>

						<div class="col-sm-6">
							<div class="form-group"
								ng-class="{'has-error': formPromociones.tipoPromocion.$invalid && formPromociones.tipoPromocion.$dirty}">
								<label>Tipo Promoción<span class="required">*</span>
								</label>
								<div class="input-group">
									<span class="input-group-addon"><i
										class="fa fa-long-arrow-up"></i></span><select class="form-control"
										name="tipoPromocion" required
										ng-options="tipoPromo as tipoPromo.nombre for tipoPromo  in listaTiposPromo"
										ng-model="promocion.tipoPromocionVO">
										<option value="" selected="selected">Selecciona Tipo
											Promocion</option>
									</select>
								</div>
								<div
									ng-show="formPromociones.tipoPromocion.$invalid && formPromociones.tipoPromocion.$dirty"
									ng-style="{color:'red'}">El campo es requerido.</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-sm-6">
							<div class="form-group"
								ng-class="{'has-error': formPromociones.varN.$invalid && formPromociones.varN.$dirty}">
								<label for="varN">Variable N <span class="required">*</span>
								</label>
								<div class="input-group">
									<span class="input-group-addon"><i
										class="fa fa-long-arrow-up"></i></span> <input type='text'
										class="form-control" name="varN" required
										ng-model="promocion.detallePromocionVO.varN" />
								</div>
								<div
									ng-show="formPromociones.varN.$invalid && formPromociones.varN.$dirty"
									ng-style="{color:'red'}">El campo es requerido.</div>
							</div>
						</div>

						<div class="col-sm-6">
							<div class="form-group"
								ng-class="{'has-error': formPromociones.varM.$invalid && formPromociones.varM.$dirty}">
								<label for="varM">Variable M <span class="required">*</span>
								</label>
								<div class="input-group">
									<span class="input-group-addon"><i
										class="fa fa-long-arrow-up"></i></span> <input type='text'
										class="form-control" id='varM' name="varM" required
										ng-model="promocion.detallePromocionVO.varM" />
								</div>
								<div
									ng-show="formPromociones.varM.$invalid && formPromociones.varM.$dirty"
									ng-style="{color:'red'}">El campo es requerido.</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-sm-6">
							<div class="form-group"
								ng-class="{'has-error': formPromociones.precio.$invalid && formPromociones.precio.$dirty}">
								<label>Precio<span class="required">*</span>
								</label>
								<div class="input-group">
									<span class="input-group-addon"><i
										class="fa fa-long-arrow-up"></i></span> <input type='text'
										class="form-control" required name="precio"
										ng-model="promocion.detallePromocionVO.precio" /> </span>
								</div>
								<div
									ng-show="formPromociones.precio.$invalid && formPromociones.precio.$dirty"
									ng-style="{color:'red'}">El campo es requerido.</div>
							</div>
						</div>

						<div class="col-sm-6">
							<div class="form-group"
								ng-class="{'has-error': formPromociones.porcentaje.$invalid && formPromociones.porcentaje.$dirty}">
								<label>Porcentaje <span class="required">*</span>
								</label>
								<div class="input-group">
									<span class="input-group-addon"><i
										class="fa fa-long-arrow-up"></i></span> <input type='text'
										class="form-control" required name="porcentaje"
										ng-model="promocion.detallePromocionVO.porcentaje" /> </span>
								</div>
								<div
									ng-show="formPromociones.porcentaje.$invalid && formPromociones.porcentaje.$dirty"
									ng-style="{color:'red'}">El campo es requerido.</div>
							</div>
						</div>
					</div>

					<br />
					<div class="form-group">
						<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-5">
							<button type="submit" class="btn btn-success"
								ng-click="crearPromocion(promocion)">
								<i class=""></i> Guardar
							</button>
						</div>
					</div>
				</div>
			</form>
		</div>
		<div class="x_panel">
			<div class="row">
				<div
					class="table-responsive col-lg-10 col-md-6 col-sm-12 col-xs-12 col-lg-offset-1 col-md-offset-2 col-sm-offset-1">
					<table id="datatable-responsive"
						class="table table-striped table-bordered dt-responsive nowrap"
						cellspacing="0" width="100%">
						<thead>
							<tr>
								<th class="text-center">Nombre Promoción</th>
								<th class="text-center">Para</th>
								<th class="text-center">Tipo Promoción</th>
								<th class="text-center">Vigencia</th>
								<th class="text-center">varN</th>
								<th class="text-center">varM</th>
								<th class="text-center">precio</th>
								<th class="text-center">porcentaje</th>
								<th class="text-center">Eliminar</th>
							</tr>
						</thead>

						<tbody>
							<tr class="odd pointer"
								ng-repeat="promocion in  listaPromociones ">
								<td>{{promocion.nombre}}</td>
								<td>{{promocion.promocionParaVO.nombre}}</td>
								<td>{{promocion.tipoPromocionVO.nombre}}</td>
								<td>{{promocion.fechaFin}}</td>
								<td>{{promocion.detallePromocionVO.varN}}</td>
								<td>{{promocion.detallePromocionVO.varM}}</td>
								<td>{{promocion.detallePromocionVO.precio}}</td>
								<td>{{promocion.detallePromocionVO.porcentaje}}</td>
								<td class="text-center">
									<button type="button" class="btn btn-round btn-default btn-md"
										ng-click="eliminarPromocion( promocion.idPromocion )">
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
