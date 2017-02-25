package mx.com.tecnetia.muvitul.servicios.facade;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.infraservices.servicios.NotFoundException;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.FormaPagoVO;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/catalogo")
public interface CatalogoFacadeI {
	@RequestMapping(value = "/formaspago", method = RequestMethod.GET)
	public ResponseEntity<List<FormaPagoVO>> getFormasPago() throws BusinessGlobalException, NotFoundException;

}
