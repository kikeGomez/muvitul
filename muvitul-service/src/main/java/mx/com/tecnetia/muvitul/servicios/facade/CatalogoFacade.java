package mx.com.tecnetia.muvitul.servicios.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import mx.com.tecnetia.muvitul.infraservices.presentacion.seguridad.frontcontroller.UsuarioFirmadoBean;
import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.infraservices.servicios.NotFoundException;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.FormaPagoVO;
import mx.com.tecnetia.muvitul.servicios.configuracion.controller.CatalogoController;

@Service
public class CatalogoFacade implements CatalogoFacadeI{
	@Autowired
	UsuarioFirmadoBean usuarioFirmadoBean;
	@Autowired
	CatalogoController catalogoController;


	@Override
	public ResponseEntity<List<FormaPagoVO>> getFormasPago() throws BusinessGlobalException, NotFoundException {
		List<FormaPagoVO> formasPago= catalogoController.getFormasPagos();
		
		if (formasPago == null || formasPago.isEmpty()) {
			throw new NotFoundException("No encontrado");
		}

		return new ResponseEntity<List<FormaPagoVO>>(formasPago, HttpStatus.OK);
	}


}
