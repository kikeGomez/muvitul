package mx.com.tecnetia.muvitul.servicios.facade;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.BoletoXTicketVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.EstatusPagoVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.ExistenciaBoletoVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.FormaPagoVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.PagoVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.PeliculaVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.PrecioXFormatoVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.ProgramacionVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.PromocionBoletoVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.PromocionVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.PromocionXTicketVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.TicketVentaVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.TipoClienteVO;
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
	public ResponseEntity<PromocionBoletoVO> getPromocionBoletos() throws BusinessGlobalException, NotFoundException {

		ProgramacionVO programacionVO = new ProgramacionVO();
		programacionVO.setIdProgramacion(1);

		TipoClienteVO tipoClienteVO1 = new TipoClienteVO();
		tipoClienteVO1.setIdTipoCliente(1);

		BoletoXTicketVO boletoXTicketVO1 = new BoletoXTicketVO();
		boletoXTicketVO1.setTipoClienteVO(tipoClienteVO1);
		boletoXTicketVO1.setCantidad(0);
		boletoXTicketVO1.setImporte(new BigDecimal(200));
		boletoXTicketVO1.setProgramacionVO(programacionVO);

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date date = null;
		try {
			date = sdf.parse("21-03-2017");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		boletoXTicketVO1.setFechaExhibicion(date);

		TipoClienteVO tipoClienteVO2 = new TipoClienteVO();
		tipoClienteVO2.setIdTipoCliente(2);
		
		BoletoXTicketVO boletoXTicketVO2 = new BoletoXTicketVO();
		boletoXTicketVO2.setTipoClienteVO(tipoClienteVO2);
		boletoXTicketVO2.setCantidad(0);
		boletoXTicketVO2.setImporte(new BigDecimal(160));
		boletoXTicketVO2.setProgramacionVO(programacionVO);
		boletoXTicketVO2.setFechaExhibicion(date);


		TipoClienteVO tipoClienteVO3 = new TipoClienteVO();
		tipoClienteVO3.setIdTipoCliente(3);
		
		BoletoXTicketVO boletoXTicketVO3 = new BoletoXTicketVO();
		boletoXTicketVO3.setTipoClienteVO(tipoClienteVO3);
		boletoXTicketVO3.setCantidad(2);
		boletoXTicketVO3.setImporte(new BigDecimal(100));
		boletoXTicketVO3.setProgramacionVO(programacionVO);
		boletoXTicketVO3.setFechaExhibicion(date);

		List<BoletoXTicketVO> boletosXTicketVO = new ArrayList<BoletoXTicketVO>();
		boletosXTicketVO.add(boletoXTicketVO1);
		boletosXTicketVO.add(boletoXTicketVO2);
		boletosXTicketVO.add(boletoXTicketVO3);

		/*************************************************************************/
		PromocionVO promocionVO = new PromocionVO();
		promocionVO.setIdPromocion(1);


		PromocionBoletoVO  promocionBoletoVO = new PromocionBoletoVO();
		promocionBoletoVO.setPromocionVO(promocionVO);
		promocionBoletoVO.setBoletosXTicketVO(boletosXTicketVO);
		
		return new ResponseEntity<PromocionBoletoVO>(promocionBoletoVO, HttpStatus.OK);

	}

	@Override
	public ResponseEntity<BigDecimal> getDescuentoByPromocion(@RequestBody PromocionBoletoVO promocionBoletoVO)
			throws BusinessGlobalException, NotFoundException {
	
		return new ResponseEntity<BigDecimal>(ventaBoletoController.getDescuentoByPromocion(promocionBoletoVO),
				HttpStatus.OK);
		
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
		logger.info("UpdateExistenciaBoleto:: [{}] :: [{}]", existenciaBoletoVO.getProgramacionVO().getIdProgramacion(),
				existenciaBoletoVO.getFechaExhibicion());

		return new ResponseEntity<ExistenciaBoletoVO>(ventaBoletoController.updateExistenciaBoleto(existenciaBoletoVO),
				HttpStatus.OK);

	}

	@Override
	public ResponseEntity<VentaVO> getVenta() throws BusinessGlobalException, NotFoundException {
		TicketVentaVO ticketVentaVO = new TicketVentaVO();

		ProgramacionVO programacionVO = new ProgramacionVO();
		programacionVO.setIdProgramacion(1);

		TipoClienteVO tipoClienteVO1 = new TipoClienteVO();
		tipoClienteVO1.setIdTipoCliente(1);

		BoletoXTicketVO boletoXTicketVO1 = new BoletoXTicketVO();
		boletoXTicketVO1.setTipoClienteVO(tipoClienteVO1);
		boletoXTicketVO1.setCantidad(2);
		boletoXTicketVO1.setImporte(new BigDecimal(200));
		boletoXTicketVO1.setProgramacionVO(programacionVO);

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date date = null;
		try {
			date = sdf.parse("21-03-2017");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		boletoXTicketVO1.setFechaExhibicion(date);

		TipoClienteVO tipoClienteVO2 = new TipoClienteVO();
		tipoClienteVO2.setIdTipoCliente(2);
		
		BoletoXTicketVO boletoXTicketVO2 = new BoletoXTicketVO();
		boletoXTicketVO2.setTipoClienteVO(tipoClienteVO2);
		boletoXTicketVO2.setCantidad(2);
		boletoXTicketVO2.setImporte(new BigDecimal(160));
		boletoXTicketVO2.setProgramacionVO(programacionVO);
		boletoXTicketVO2.setFechaExhibicion(date);

		TipoClienteVO tipoClienteVO3 = new TipoClienteVO();
		tipoClienteVO3.setIdTipoCliente(3);
		
		BoletoXTicketVO boletoXTicketVO3 = new BoletoXTicketVO();
		boletoXTicketVO3.setTipoClienteVO(tipoClienteVO3);
		
		boletoXTicketVO3.setCantidad(2);
		boletoXTicketVO3.setImporte(new BigDecimal(100));
		boletoXTicketVO3.setProgramacionVO(programacionVO);
		boletoXTicketVO3.setFechaExhibicion(date);

		List<BoletoXTicketVO> boletosXTicketVO = new ArrayList<BoletoXTicketVO>();
		boletosXTicketVO.add(boletoXTicketVO1);
		boletosXTicketVO.add(boletoXTicketVO2);
		boletosXTicketVO.add(boletoXTicketVO3);

		/*************************************************************************/
		PromocionVO promocionVO = new PromocionVO();
		promocionVO.setIdPromocion(1);

		PromocionXTicketVO promocionXTicketVO1 = new PromocionXTicketVO();
		promocionXTicketVO1.setPromocionVO(promocionVO);
		promocionXTicketVO1.setCantidad(1);
		promocionXTicketVO1.setImporte(new BigDecimal(50));

		List<PromocionXTicketVO> promocionesXTicketVO = new ArrayList<PromocionXTicketVO>();
		promocionesXTicketVO.add(promocionXTicketVO1);

		/*************************************************************************/
		FormaPagoVO formaPagoVO = new FormaPagoVO();
		formaPagoVO.setIdFormaPago(1);

		EstatusPagoVO estatusPagoVO = new EstatusPagoVO();
		estatusPagoVO.setIdEstatus(1);

		PagoVO pagoVO1 = new PagoVO();
		pagoVO1.setFormaPagoVO(formaPagoVO);
		pagoVO1.setNoCuenta("");
		pagoVO1.setImporte(new BigDecimal(150));
		pagoVO1.setEstatusPagoVO(estatusPagoVO);
		pagoVO1.setFecha(new Date());

		List<PagoVO> pagosVO = new ArrayList<PagoVO>();
		pagosVO.add(pagoVO1);

		VentaVO ventaVO = new VentaVO();
		// ventaVO.setTicketVentaVO(ticketVentaVO);
		ventaVO.setBoletosXTicketVO(boletosXTicketVO);
		ventaVO.setPromocionesXTicketVO(promocionesXTicketVO);
		ventaVO.setPagosVO(pagosVO);

		return new ResponseEntity<VentaVO>(ventaVO, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<TicketVentaVO> createVenta(@RequestBody VentaVO ventaVO)
			throws BusinessGlobalException, NotFoundException {
		TicketVentaVO ticketVentaVO = ventaBoletoController.createVenta(ventaVO, usuarioFirmadoBean.getUser());
		return new ResponseEntity<TicketVentaVO>(ticketVentaVO, HttpStatus.CREATED);
	}
}
