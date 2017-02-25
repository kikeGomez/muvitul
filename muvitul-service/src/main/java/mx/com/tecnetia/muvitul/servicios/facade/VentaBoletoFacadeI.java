package mx.com.tecnetia.muvitul.servicios.facade;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.infraservices.servicios.NotFoundException;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.PeliculaVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.PrecioXFormatoVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.PromocionVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.VentaVO;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/ventaBoleto")
public interface VentaBoletoFacadeI {
	@RequestMapping(value = "/peliculas", method = RequestMethod.GET)
	public ResponseEntity<List<PeliculaVO>> getPeliculasByCine() throws BusinessGlobalException, NotFoundException;

	@RequestMapping(value = "/promociones", method = RequestMethod.GET)
	public ResponseEntity<List<PromocionVO>> getPromocionesByCine() throws BusinessGlobalException, NotFoundException;

	@RequestMapping(value = "/precios", method = RequestMethod.GET)
	public ResponseEntity<List<PrecioXFormatoVO>> getPreciosByFormato(
			@RequestParam(value = "idFormato") Integer idFormato) throws BusinessGlobalException, NotFoundException;

	@RequestMapping(value = "/pagos", method = RequestMethod.POST)
	public ResponseEntity<VentaVO> createVenta(@RequestBody VentaVO ventaVO)
			throws BusinessGlobalException, NotFoundException;
}
