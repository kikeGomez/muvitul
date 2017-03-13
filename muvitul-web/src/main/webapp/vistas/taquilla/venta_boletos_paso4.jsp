 
<!-- bloque de PASO 4 de wizard - CANTIDAD -->
<div id="step-2">
	<div class="x_panel">
		<div class="x_title">
			<h2>
				<i class="fa fa-credit-card"></i> Registra el Pago
			</h2>
			<div class="row pull-right">
				<button type="button" class="btn btn-primary"
					ng-click="asignarPaso(3);StartTimer(paramsExistenciaBoleto)">
					<i class="fa fa-calculator"></i> Modificar Cantidades
				</button>
				<button type="button" class="btn btn-success"
					ng-click="asignarPaso(5)" ng-disabled="pago.porPagar > 0">
					Confirmar la Venta <i class="fa fa-thumbs-o-up"></i>
				</button>
			</div>
			<div class="clearfix"></div>
		</div>
		<div class="x_content">
			<!-- bloque de pelicula -->
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="row">
						<div
							class="animated flipInY col-lg-2 col-md-2 col-sm-2 col-xs-2 col-lg-offset-2 col-md-offset-1">
							<div class="tile">
								<h2>Total</h2>
								<h3>{{pago.subtotal}}</h3>
							</div>
						</div>
						<div class="animated flipInY col-lg-2 col-md-2 col-sm-2 col-xs-2">
							<div class="tile">
								<h2>Pagado</h2>
								<h3>{{pago.pagado}}</h3>
							</div>
						</div>
						<div class="animated flipInY col-lg-2 col-md-2 col-sm-2 col-xs-2">
							<div class="tile">
								<h2>Por Pagar</h2>
								<h3>{{pago.porPagar}}</h3>
							</div>
						</div>
					</div>
					<!-- row -->
					<br />
					<div class="row">
						<div
							class="table-responsive col-lg-6 col-md-6 col-sm-8 col-xs-12 col-lg-offset-2 col-md-offset-1">
							<table class="table table-striped jambo_table bulk_action">
								<thead>
									<tr class="headings">
										<th class="column-title text-center">Forma de Pago</th>
										<th class="column-title text-center">Importe</th>
										<th class="column-title text-center">Cuenta</th>
									</tr>
								</thead>

								<tbody>
									<tr class="even pointer" ng-repeat="pago in listaPagos">
										<td class=" ">{{pago.formaPago.nombre}}</td>
										<td class="text-center">{{pago.importe}}</td>
										<td class="text-center">{{pago.numeroCta}}</td>
									</tr>

								</tbody>
							</table>
						</div>
						<!-- table-responsive -->
					</div>
					<!-- row -->
				</div>
				<!-- xpanel -->
				<div class="x_panel">
					<br />
					<form id="formPagos" name="formPagos" role="form" novalidate
						class="form-horizontal form-label-left">
						<div class="form-group"
							ng-class="{'has-error': formPagos.formaPago.$invalid && formPagos.formaPago.$dirty}">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="forma-pago">Forma de Pago <span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<div class="btn-group btn-group-justified" data-toggle="buttons">


									<label class="btn btn-primary "
										ng-repeat="formaPago in listaFormasPago"
										ng-click="seleccionarFormaPago(formaPago, formPagos)">
										<input type="radio" class="sr-only" id="fp-efectivo"
										ng-model="pago.formaPago" required name="formaPago"
										name="forma-pago" checked> <span class="docs-tooltip"
										title="Pago {{formaPago.nombre}}"> {{formaPago.nombre}}
									</span>
									</label>
								</div>
							</div>
							<div
								ng-show="formPagos.formaPago.$invalid && formPagos.formaPago.$dirty"
								ng-style="{color:'red'}">El campo es requerido.</div>
						</div>
						<div class="form-group"
							ng-class="{'has-error': formPagos.importe.$invalid && formPagos.importe.$dirty}">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="monto">Importe <span class="required">*</span></label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input type="text" id="importe" name="importe" integer-number
									required ng-model="pago.importe"
									class="form-control col-md-7 col-xs-12" placeholder=" 00.00 ">
							</div>
							<div
								ng-show="formPagos.importe.$invalid && formPagos.importe.$dirty"
								ng-style="{color:'red'}">El campo es requerido.</div>
						</div>
						<div class="form-group"
							ng-class="{'has-error': formPagos.pagoCon.$invalid && formPagos.pagoCon.$dirty}"
							ng-if="!pago.formaPago.requiereNumCuenta ">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="monto">Pago Con <span class="required">*</span></label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input type="text" id="pagoCon" name="pagoCon" required
									ng-model="pago.pagoCon" integer-number
									ng-change="calcularCambio(pago.pagoCon,pago.importe)"
									class="form-control col-md-7 col-xs-12" placeholder=" 00.00 ">
							</div>
							<div
								ng-show="formPagos.pagoCon.$invalid && formPagos.pagoCon.$dirty"
								ng-style="{color:'red'}">El campo es requerido.</div>
						</div>
						<div class="form-group" ng-if="!pago.formaPago.requiereNumCuenta ">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="monto">Cambio <span class="required">*</span></label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input type="text" id="importe" ng-model="pago.cambio" disabled
									integer-number class="form-control col-md-7 col-xs-12"
									placeholder="  ">
							</div>
						</div>
						<div class="form-group" ng-if="pago.formaPago.requiereNumCuenta "
							ng-class="{'has-error': formPagos.numeroCta.$invalid && formPagos.numeroCta.$dirty}">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="numero-cuenta">N&uacute;mero de Cuenta <span
								class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input type="text" id="numero-cuenta" required
									class="form-control col-md-7 col-xs-12" integer-number
									ng-model="pago.numeroCta" name="numeroCta" maxlength="4"
									placeholder=" &Uacute;ltimos 4 d&iacute;gitos ">
							</div>
							<div
								ng-show="formPagos.numeroCta.$invalid && formPagos.numeroCta.$dirty"
								ng-style="{color:'red'}">El campo es requerido.</div>
						</div>
						<div class="form-group">
							<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
								<button type="button" class="btn btn-success"
									ng-click="guardarPago(pago,formPagos)">Guardar Pago</button>
							</div>
						</div>
					</form>

				</div>
				<!-- /xpanel formulario -->
			</div>
			<!-- /x12 columnas -->
		</div>
		<!-- /xcontent -->
	</div>
	<!-- /xpanel MODULO -->
</div> 