package mx.com.tecnetia.muvitul.servicios.facade;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import mx.com.tecnetia.muvitul.infraservices.presentacion.seguridad.frontcontroller.UsuarioFirmadoBean;
import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.infraservices.servicios.NotFoundException;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.ExistenciaBoletoVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.PeliculaVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.PrecioXFormatoVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.PromocionVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.VentaVO;
import mx.com.tecnetia.muvitul.servicios.taquilla.controller.VentaBoletoController;
import mx.com.tecnetia.muvitul.servicios.util.Fecha;

@Service
public class VentaBoletoFacade implements VentaBoletoFacadeI {
	private static final Logger logger = LoggerFactory.getLogger(VentaBoletoFacade.class);
	@Autowired
	UsuarioFirmadoBean usuarioFirmadoBean;
	@Autowired
	VentaBoletoController ventaBoletoController;

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<List<PeliculaVO>> getPeliculasByCine(Date fechaExhibicion)
			throws BusinessGlobalException, NotFoundException, ParseException {
		logger.info("GetPeliculasByCine::[{}]", fechaExhibicion.toString());
		List<PeliculaVO> peliculas = ventaBoletoController.getPeliculasByCine(
				usuarioFirmadoBean.getUser().getCineVO().getIdCine(), Fecha.getDayOfWeek(fechaExhibicion),
				fechaExhibicion);

		if (peliculas == null || peliculas.isEmpty()) {
			throw new NotFoundException("No encontrado");
		}

		return new ResponseEntity<List<PeliculaVO>>(peliculas, HttpStatus.OK);

	}

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<List<PromocionVO>> getPromocionesByCine(Date fechaExhibicion)
			throws BusinessGlobalException, NotFoundException {
		logger.info("GetPromocionesByCine::[{}]", fechaExhibicion.toString());
		int ID_PROMOCION_PARA = 1;
		List<PromocionVO> promociones = ventaBoletoController.getPromocionesByCine(
				usuarioFirmadoBean.getUser().getCineVO().getIdCine(), ID_PROMOCION_PARA, fechaExhibicion);

		if (promociones == null || promociones.isEmpty()) {
			throw new NotFoundException("No encontrado");
		}

		return new ResponseEntity<List<PromocionVO>>(promociones, HttpStatus.OK);

	}

	@Override
	public ResponseEntity<List<PrecioXFormatoVO>> getPreciosByFormato(Integer idFormato)
			throws BusinessGlobalException, NotFoundException {
		logger.info("GetPreciosByFormato:: [{}]", idFormato);
		List<PrecioXFormatoVO> precios = ventaBoletoController
				.getPreciosByFormato(usuarioFirmadoBean.getUser().getCineVO().getIdCine(), idFormato);

		if (precios == null || precios.isEmpty()) {
			throw new NotFoundException("No encontrado");
		}

		return new ResponseEntity<List<PrecioXFormatoVO>>(precios, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ExistenciaBoletoVO> getExistenciaBoleto(Integer idProgramacion, Integer idSala,
			Date fechaExhibicion) throws BusinessGlobalException, NotFoundException, ParseException {
		logger.info("GetExistenciaBoleto:: [{}] :: [{}]", idProgramacion, fechaExhibicion);
		ExistenciaBoletoVO existenciaBoletoVO = ventaBoletoController.getExistenciaBoleto(idProgramacion, idSala,
				fechaExhibicion);

		if (existenciaBoletoVO == null) {
			throw new NotFoundException("No encontrado");
		}

		return new ResponseEntity<ExistenciaBoletoVO>(existenciaBoletoVO, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ExistenciaBoletoVO> updateExistenciaBoleto(@RequestBody ExistenciaBoletoVO existenciaBoletoVO)
			throws BusinessGlobalException, NotFoundException {
		logger.info("UpdateExistenciaBoleto:: [{}] :: [{}]" + existenciaBoletoVO.getDisponibles(),
				existenciaBoletoVO.getProgramacionVO().getHorario());
		ventaBoletoController.updateExistenciaBoleto(existenciaBoletoVO);
		return new ResponseEntity<ExistenciaBoletoVO>(existenciaBoletoVO,
				HttpStatus.OK);

	}

	@Override
	public ResponseEntity<VentaVO> createVenta(VentaVO ventaVO) throws BusinessGlobalException, NotFoundException {
		ventaVO.getTicketVentaVO().setUsuarioFirmadoVO(usuarioFirmadoBean.getUser());
		ventaBoletoController.createVenta(ventaVO);
		return new ResponseEntity<VentaVO>(ventaVO, HttpStatus.CREATED);
	}

}
