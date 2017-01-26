				<div class="x_panel">
					<div class="x_title">
						<h2><i class="fa fa-barcode"></i> Entradas de Inventario en Dulcer&iacute;a </h2>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
                      <br />
                      <div class="x_panel">
		                   <form id="demo-form2" data-parsley-validate class="form-horizontal form-label-left">

		                      <div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12" for="producto">Producto <span class="required">*</span>
									</label>
									<div class="col-md-6 col-sm-6 col-xs-12">
										<select class="select2_single form-control" tabindex="-1">
												<option>Palomitas CH</option>
												<option>Palomitas M</option>
												<option>Refresco CH</option>
												<option>Refresco M</option>
												<option>Nachos</option>
                          				</select>
									</div>
		                      </div>
		                      <div class="form-group">
		                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="cantidad">Cantidad <span class="required">*</span>
		                        </label>
		                        <div class="col-md-6 col-sm-6 col-xs-12">
		                          <input type="text" id="cantidad" required="required" class="form-control col-md-7 col-xs-12" placeholder="0">
		                        </div>
		                      </div>
	                      	  <br/>
		                      <div class="form-group">
		                        <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
		                          <button type="submit" class="btn btn-success"><i class="fa fa-line-chart"></i> Guardar </button>
		                        </div>
		                      </div>

							</form>
						</div>
		                <div class="x_panel">
		                    <div class="row">
										              <div class="table-responsive col-lg-6 col-md-6 col-sm-12 col-xs-12 col-lg-offset-3 col-md-offset-2 col-sm-offset-1">
									                      <table id="datatable-responsive" class="table table-striped table-bordered dt-responsive nowrap" cellspacing="0" width="100%">
									                        <thead>
									                          <tr>
									                            <th class="text-center">Producto </th>
									                            <th class="text-center">Cantidad </th>
									                            <th class="text-center">Eliminar </th>
															  </tr>
									                        </thead>

									                        <tbody>
									                          <tr>
									                            <td>Palomitas CH</td>
									                            <td class="text-center">24</td>
									                            <td class="text-center">
									                              <button type="button" class="btn btn-round btn-default btn-md"><i class="fa fa-trash-o"></i></button>
																</td>
									                          </tr>
									                          <tr>
									                            <td>Palomitas M</td>
									                            <td class="text-center">50</td>
									                            <td class="text-center">
									                              <button type="button" class="btn btn-round btn-default btn-md"><i class="fa fa-trash-o"></i></button>
																</td>
									                          </tr>
									                          <tr>
									                            <td>Refresco CH</td>
									                            <td class="text-center">100</td>
									                            <td class="text-center">
									                              <button type="button" class="btn btn-round btn-default btn-md"><i class="fa fa-trash-o"></i></button>
																</td>
									                          </tr>
									                        </tbody>
									                      </table>
									                  </div> <!-- table-responsive -->
								  </div> <!-- row -->
							</div><!-- x-panel -->
						</div> <!-- content -->
					</div> <!-- xpanel -->