package mx.com.tecnetia.muvitul.servicios.facade;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.infraservices.servicios.NotFoundException;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.ConfProgramacionVO;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.ConfPromocionVO;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.PaqueteVO;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.ProductoVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.ProgramacionVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.PromocionVO;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/configuracion")
public interface ConfiguracionFacadeI {

	@RequestMapping(value = "/productos", method = RequestMethod.GET)
	public ResponseEntity<List<ProductoVO>> getProductos(HttpServletRequest request) throws BusinessGlobalException, NotFoundException;
	
	@RequestMapping(value = "/paquetes", method = RequestMethod.GET)
	public ResponseEntity<List<PaqueteVO>> getPaquetes(HttpServletRequest request) throws BusinessGlobalException, NotFoundException;
	
	@RequestMapping(value = "/paquetes", method = RequestMethod.POST)
	public ResponseEntity<PaqueteVO> savePaquete(HttpServletRequest request, @RequestBody PaqueteVO paqueteVO)
			throws BusinessGlobalException, NotFoundException;
	
	
	
	
	
	@RequestMapping(value = "/programaciones", method = RequestMethod.GET)
	public ResponseEntity<List<ConfProgramacionVO>> getConfProgramacion() throws BusinessGlobalException, NotFoundException;
	@RequestMapping(value = "/programaciones", method = RequestMethod.POST)
	public ResponseEntity<ProgramacionVO> createProgramacion(@RequestBody ProgramacionVO programacionVO) throws BusinessGlobalException, NotFoundException;
	@RequestMapping(value = "/promociones", method = RequestMethod.GET)
	public ResponseEntity<List<ConfPromocionVO>> getConfPromocion() throws BusinessGlobalException, NotFoundException;
	@RequestMapping(value = "/promociones", method = RequestMethod.POST)
	public ResponseEntity<PromocionVO> createPromocion(@RequestBody PromocionVO promocionVO) throws BusinessGlobalException, NotFoundException;
	
}
