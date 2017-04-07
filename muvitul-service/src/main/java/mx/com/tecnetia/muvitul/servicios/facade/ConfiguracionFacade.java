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
import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.infraservices.servicios.NotFoundException;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.ConfProgramacionVO;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.ConfPromocionVO;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.PaqueteVO;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.ProductoVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.ProgramacionVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.PromocionVO;
import mx.com.tecnetia.muvitul.servicios.configuracion.controller.ConfiguracionController;

@Service
public class ConfiguracionFacade implements ConfiguracionFacadeI{
	private static final Logger logger = LoggerFactory.getLogger(ConfiguracionFacade.class);
	
	@Autowired
	private ConfiguracionController configuracionController;
	
	@Override
	public ResponseEntity<List<ProductoVO>> getProductos(HttpServletRequest request)
			throws BusinessGlobalException, NotFoundException {
		
		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idCine = (Integer) claims.get(ClaimsEnum.CINE);
		
		logger.info("GetProductos:::IdCine[{}]",idCine);
		
		List<ProductoVO>  productosVO= configuracionController.findProductosByCine(idCine);
		
		if (productosVO == null || productosVO.isEmpty()) {
			throw new NotFoundException("No encontrado");
		}

		return new ResponseEntity<List<ProductoVO>>(productosVO, HttpStatus.OK);
		
	}
	

	@Override
	public ResponseEntity<List<PaqueteVO>> getPaquetes(HttpServletRequest request) throws BusinessGlobalException, NotFoundException {
		
		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idCine = (Integer) claims.get(ClaimsEnum.CINE);
		
		logger.info("GetPaquetes:::IdCine[{}]",idCine);
		
		List<PaqueteVO>  paqueteVO= configuracionController.findPaquetesByCine(idCine);
				
		return new ResponseEntity<List<PaqueteVO>>(paqueteVO, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<PaqueteVO> savePaquete(HttpServletRequest request, PaqueteVO paqueteVO) throws BusinessGlobalException, NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	@Override
	public ResponseEntity<List<ConfProgramacionVO>> getConfProgramacion()
			throws BusinessGlobalException, NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResponseEntity<ProgramacionVO> createProgramacion(ProgramacionVO programacionVO)
			throws BusinessGlobalException, NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResponseEntity<List<ConfPromocionVO>> getConfPromocion() throws BusinessGlobalException, NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResponseEntity<PromocionVO> createPromocion(PromocionVO promocionVO)
			throws BusinessGlobalException, NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
