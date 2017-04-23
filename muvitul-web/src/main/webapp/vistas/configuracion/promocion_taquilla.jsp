
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
								<label>Nombre Promoci�n <span class="required">*</span>
								</label>
								<div class="input-group">
									<span class="input-group-addon"><i
										class="fa fa-long-arrow-up"></i></span> <input type="text"
										id="nombre" required name="nombre"
										class="form-control col-md-7 col-xs-12"
										ng-model="promocion.nombre" placeholder="Nombre Promoci�n">
								</div>
								<div
									ng-show="formPromociones.nombre.$invalid && formPromociones.nombre.$dirty"
									ng-style="{color:'red'}">El campo es requerido.</div>
							</div>
						</div>

						<div class="col-sm-6">
							<div class="form-group"
								ng-class="{'has-error': formPromociones.descripcion.$invalid && formPromociones.descripcion.$dirty}">
								<label>Descripci�n Promoci�n <span class="required">*</span>
								</label>
								<div class="input-group">
									<span class="input-group-addon"><i
										class="fa fa-long-arrow-up"></i></span><input type="text"
										id="descripcion" required name="descripcion"
										class="form-control col-md-7 col-xs-12"
										ng-model="promocion.descripcion"
										placeholder="Descripci�n Promoci�n">
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
								<label>Promoci�n Para<span class="required">*</span>
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
								<label>Tipo Promoci�n<span class="required">*</span>
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
								ng-class="{'has-error': formPromociones.producto.$invalid && formPromociones.producto.$dirty}">
								<label>Productos<span class="required">*</span>
								</label>
								<div class="input-group">
									<span class="input-group-addon"><i
										class="fa fa-long-arrow-up"></i></span><select class="form-control"
										name="producto" required
										ng-options="producto  as producto.nombre for producto  in listaProductos"
										ng-model="promocion.detallePromocionVO.productoVO">
										<option value="" selected="selected">Selecciona
											Producto</option>
									</select>
								</div>
								<div
									ng-show="formPromociones.producto.$invalid && formPromociones.producto.$dirty"
									ng-style="{color:'red'}">El campo es requerido.</div>
							</div>
						</div>

						<div class="col-sm-6">
							<div class="form-group"
								ng-class="{'has-error': formPromociones.regalo.$invalid && formPromociones.regalo.$dirty}">
								<label>Regalos<span class="required">*</span>
								</label>
								<div class="input-group">
									<span class="input-group-addon"><i
										class="fa fa-gift"></i></span><select class="form-control"
										name="tipoPromocion" required
										ng-options="regalo as regalo.nombre for regalo  in listaRegalos"
										ng-model="promocion.detallePromocionVO.regaloVO">
										<option value="" selected="selected">Selecciona Tipo
											Regalo</option>
									</select>
								</div>
								<div
									ng-show="formPromociones.regalo.$invalid && formPromociones.regalo.$dirty"
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
										class="fa fa-usd"></i></span> <input type='text'
										class="form-control"   name="precio"
										ng-model="promocion.detallePromocionVO.precio" />
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
										class="fa fa-percent"></i></span> <input type='text'
										class="form-control"   name="porcentaje"
										ng-model="promocion.detallePromocionVO.porcentaje" />
								</div>
								<div
									ng-show="formPromociones.porcentaje.$invalid && formPromociones.porcentaje.$dirty"
									ng-style="{color:'red'}">El campo es requerido.</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-sm-6">
							<div class="form-group"
								ng-class="{'has-error': formPromociones.fechaInicio.$invalid && formPromociones.fechaInicio.$dirty}">
								<label>Fecha Inicio<span class="required">*</span>
								</label>
								<div class="input-group">
									<span class="input-calendar"><i
										class="glyphicon glyphicon-th"></i></span> <input type="text"
										calendar ng-model="promocion.fechaInicio" id="fechaInicio"  name="fechaInicio" 
										required="required" class="form-control col-md-7 col-xs-12">
								</div>
								<div
									ng-show="formPromociones.fechaInicio.$invalid && formPromociones.fechaInicio.$dirty"
									ng-style="{color:'red'}">El campo es requerido.</div>
							</div>
						</div>

						<div class="col-sm-6">
							<div class="form-group"
								ng-class="{'has-error': formPromociones.fechaFin.$invalid && formPromociones.fechaFin.$dirty}">
								<label>Fecha Fin <span class="required">*</span>
								</label>
								<div class="input-group">
									<span class="input-calendar"><i
										class="glyphicon glyphicon-th"></i></span> <input type="text"
										calendar ng-model="promocion.fechaFin" id="fechaFin" name="fechaFin"
										required class="form-control col-md-7 col-xs-12">
								</div>
								<div
									ng-show="formPromociones.fechaFin.$invalid && formPromociones.fechaFin.$dirty"
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
								<th class="text-center">Nombre Promoci�n</th>
								<th class="text-center">Para</th>
								<th class="text-center">Tipo Promoci�n</th>
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
