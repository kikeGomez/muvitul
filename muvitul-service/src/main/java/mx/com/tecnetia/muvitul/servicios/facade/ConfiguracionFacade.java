package mx.com.tecnetia.muvitul.servicios.facade;

import java.util.Date;
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
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.ConfigProgramacionVO;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.ConfigPromocionVO;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.ConfigSalaVO;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.PaqueteVO;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.ProductoVO;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.ProgramacionVO;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.PromocionVO;
import mx.com.tecnetia.muvitul.servicios.configuracion.controller.ConfiguracionController;

@Service
public class ConfiguracionFacade implements ConfiguracionFacadeI {
	private static final Logger logger = LoggerFactory.getLogger(ConfiguracionFacade.class);

	@Autowired
	private ConfiguracionController configuracionController;

	@Override
	public ResponseEntity<ConfigProgramacionVO> getConfigProgramacion(HttpServletRequest request)
			throws BusinessGlobalException, NotFoundException {

		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idCine = (Integer) claims.get(ClaimsEnum.CINE);

		logger.info("GetConfigProgramacion:::IdCine[{}]", idCine);

		ConfigProgramacionVO configProgramacionVO = configuracionController.findConfigProgramacionByCine(idCine);

		if (configProgramacionVO == null) {
			throw new NotFoundException("No encontrado");
		}

		return new ResponseEntity<ConfigProgramacionVO>(configProgramacionVO, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<ConfigSalaVO>> getProgramacionOfSala(HttpServletRequest request, Date fecha)
			throws BusinessGlobalException, NotFoundException {
		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idCine = (Integer) claims.get(ClaimsEnum.CINE);

		logger.info("GetProgramacionOfSala:::IdCine[{}]:::Fecha[{}]", idCine, fecha);

		List<ConfigSalaVO> configsSalaVO = configuracionController.findProgramacionOfSala(idCine, fecha);

		if (configsSalaVO == null || configsSalaVO.isEmpty()) {
			throw new NotFoundException("No encontrado");
		}

		return new ResponseEntity<List<ConfigSalaVO>>(configsSalaVO, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ProgramacionVO> createProgramacion(HttpServletRequest request , ProgramacionVO programacionVO)
			throws BusinessGlobalException, NotFoundException {

		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idUsuario=(Integer) claims.get(ClaimsEnum.USUARIO);
		Integer idCine = (Integer) claims.get(ClaimsEnum.CINE);

		logger.info("CreateProgramacion:::IdUsuario[{}]:::IdCine[{}]",idUsuario,idCine);
		
		programacionVO = configuracionController.createProgramacion(programacionVO);
		return new ResponseEntity<ProgramacionVO>(programacionVO, HttpStatus.CREATED);

	}

	@Override
	public ResponseEntity<Integer> deleteProgramacion(HttpServletRequest request ,Integer id)
			throws BusinessGlobalException, NotFoundException {
		
		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idUsuario=(Integer) claims.get(ClaimsEnum.USUARIO);
		Integer idCine = (Integer) claims.get(ClaimsEnum.CINE);

		
		logger.info("DeleteProgramacion:::IdUsuario[{}]:::IdCine[{}]",idUsuario,idCine);
		
		configuracionController.deleteProgramacion(id);
		
		return new ResponseEntity<Integer>(id, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ConfigPromocionVO> getConfigPromocion(HttpServletRequest request)
			throws BusinessGlobalException, NotFoundException {
		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idCine = (Integer) claims.get(ClaimsEnum.CINE);

		logger.info("GetConfigPromocion:::IdCine[{}]", idCine);

		ConfigPromocionVO configPromocionVO = configuracionController.findConfigPromocionByCine(idCine);

		if (configPromocionVO == null) {
			throw new NotFoundException("No encontrado");
		}

		return new ResponseEntity<ConfigPromocionVO>(configPromocionVO, HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<List<PromocionVO>> getPromociones(HttpServletRequest request, Date fecha)
			throws BusinessGlobalException, NotFoundException {
		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idCine = (Integer) claims.get(ClaimsEnum.CINE);

		logger.info("GetPromociones:::IdCine[{}]:::Fecha[{}]", idCine, fecha);

		List<PromocionVO> promocionVO = configuracionController.findPromociones(idCine, fecha);

		if (promocionVO == null || promocionVO.isEmpty()) {
			throw new NotFoundException("No encontrado");
		}

		return new ResponseEntity<List<PromocionVO>>(promocionVO, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<PromocionVO> createPromocion(HttpServletRequest request, PromocionVO promocionVO)
			throws BusinessGlobalException, NotFoundException {
		
		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idUsuario=(Integer) claims.get(ClaimsEnum.USUARIO);
		Integer idCine = (Integer) claims.get(ClaimsEnum.CINE);

		logger.info("CreatePromocion:::IdUsuario[{}]:::IdCine[{}]",idUsuario,idCine);
		
		promocionVO = configuracionController.createPromocion(promocionVO);
		return new ResponseEntity<PromocionVO>(promocionVO, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<Integer> deletePromocion(HttpServletRequest request, Integer id)
			throws BusinessGlobalException, NotFoundException {
		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idUsuario=(Integer) claims.get(ClaimsEnum.USUARIO);
		Integer idCine = (Integer) claims.get(ClaimsEnum.CINE);
		
		logger.info("DeletePromocion:::IdUsuario[{}]:::IdCine[{}]",idUsuario,idCine);
		
		configuracionController.deletePromocion(id);
		
		return new ResponseEntity<Integer>(id, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<ProductoVO>> getProductos(HttpServletRequest request)
			throws BusinessGlobalException, NotFoundException {

		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idCine = (Integer) claims.get(ClaimsEnum.CINE);

		logger.info("GetProductos:::IdCine[{}]", idCine);

		List<ProductoVO> productosVO = configuracionController.findProductosByCine(idCine);

		if (productosVO == null || productosVO.isEmpty()) {
			throw new NotFoundException("No encontrado");
		}

		return new ResponseEntity<List<ProductoVO>>(productosVO, HttpStatus.OK);

	}

	@Override
	public ResponseEntity<List<PaqueteVO>> getPaquetes(HttpServletRequest request)
			throws BusinessGlobalException, NotFoundException {

		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idCine = (Integer) claims.get(ClaimsEnum.CINE);

		logger.info("GetPaquetes:::IdCine[{}]", idCine);

		List<PaqueteVO> paquetesVO = configuracionController.findPaquetesByCine(idCine);

		if (paquetesVO == null || paquetesVO.isEmpty()) {
			throw new NotFoundException("No encontrado");
		}

		return new ResponseEntity<List<PaqueteVO>>(paquetesVO, HttpStatus.OK);
	}

}
