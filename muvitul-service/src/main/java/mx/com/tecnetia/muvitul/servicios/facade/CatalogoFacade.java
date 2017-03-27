package mx.com.tecnetia.muvitul.servicios.facade;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.enumeration.ClaimsEnum;
import mx.com.tecnetia.muvitul.infraservices.presentacion.seguridad.frontcontroller.UsuarioFirmadoBean;
import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.infraservices.servicios.NotFoundException;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.FormaPagoVO;
import mx.com.tecnetia.muvitul.servicios.configuracion.controller.CatalogoController;

@Service
public class CatalogoFacade implements CatalogoFacadeI{
	
	private static final Logger logger = LoggerFactory.getLogger(VentaBoletoFacade.class);

	@Autowired
	UsuarioFirmadoBean usuarioFirmadoBean;
	@Autowired
	CatalogoController catalogoController;


	@Override
	public ResponseEntity<List<FormaPagoVO>> getFormasPago(HttpServletRequest request) throws BusinessGlobalException, NotFoundException {
		
		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idUsuario=(Integer) claims.get(ClaimsEnum.USUARIO);
		Integer idCine = (Integer) claims.get(ClaimsEnum.CINE);
		Integer idPuntoVenta=(Integer) claims.get(ClaimsEnum.PUNTO_VENTA);
		
		logger.info("GetFormasPago:::IdUsuario[{}]:::IdCine[{}]:::IdPuntoVenta[{}]",idUsuario,idCine,idPuntoVenta);
		
		List<FormaPagoVO> formasPago= catalogoController.getFormasPagos();
		
		if (formasPago == null || formasPago.isEmpty()) {
			throw new NotFoundException("No encontrado");
		}

		return new ResponseEntity<List<FormaPagoVO>>(formasPago, HttpStatus.OK);
	}


}
