package mx.com.tecnetia.muvitul.servicios.facade;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import io.jsonwebtoken.Claims;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.enumeration.ClaimsEnum;
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
import mx.com.tecnetia.muvitul.servicios.util.Constantes;
import mx.com.tecnetia.muvitul.servicios.util.Fecha;

@Service
public class VentaBoletoFacade implements VentaBoletoFacadeI {
	private static final Logger logger = LoggerFactory.getLogger(VentaBoletoFacade.class);
	@Autowired
	VentaBoletoController ventaBoletoController;

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<List<PeliculaVO>> getPeliculasByCine(HttpServletRequest request, String fechaExhibicion)
			throws BusinessGlobalException, NotFoundException, ParseException {

		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idCine = (Integer) claims.get(ClaimsEnum.CINE);

		logger.info("GetPeliculasByCine:::IdCine[{}]:::FechaExhibicion[{}]", idCine, fechaExhibicion);
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date fecha = formatter.parse(fechaExhibicion);
		List<PeliculaVO> peliculas = ventaBoletoController.getPeliculasByCine(idCine, Fecha.getDayOfWeek(fecha), fecha);

		if (peliculas == null || peliculas.isEmpty()) {
			throw new NotFoundException("No encontrado");
		}

		return new ResponseEntity<List<PeliculaVO>>(peliculas, HttpStatus.OK);

	}

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<List<PromocionVO>> getPromocionesByCine(HttpServletRequest request, String fechaExhibicion)
			throws BusinessGlobalException, NotFoundException, ParseException {

		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idCine = (Integer) claims.get(ClaimsEnum.CINE);

		logger.info("GetPromocionesByCine:::IdCine[{}]:::FechaExhibicion[{}]", idCine, fechaExhibicion);

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date fecha = formatter.parse(fechaExhibicion);
		List<PromocionVO> promociones = ventaBoletoController.getPromocionesByCine(idCine,
				Constantes.ID_PROMOCION_PARA_BOLETOS, fecha);

		if (promociones == null || promociones.isEmpty()) {
			throw new NotFoundException("No encontrado");
		}

		return new ResponseEntity<List<PromocionVO>>(promociones, HttpStatus.OK);

	}

	@Override
	public ResponseEntity<BigDecimal> getDescuentoByPromocion(HttpServletRequest request,
			@RequestBody PromocionBoletoVO promocionBoletoVO) throws BusinessGlobalException, NotFoundException {

		if (promocionBoletoVO == null || promocionBoletoVO.getBoletosXTicketVO() == null
				|| promocionBoletoVO.getPromocionVO() == null)
			throw new NotFoundException("Parametros invalidos");

		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idCine = (Integer) claims.get(ClaimsEnum.CINE);

		logger.info("GetDescuentoByPromocion:::IdCine[{}]:::Promocion[{}]", idCine,
				promocionBoletoVO.getPromocionVO().getDescripcion());

		return new ResponseEntity<BigDecimal>(ventaBoletoController.getDescuentoByPromocion(promocionBoletoVO),
				HttpStatus.OK);

	}

	@Override
	public ResponseEntity<List<PrecioXFormatoVO>> getPreciosByFormato(HttpServletRequest request, Integer idFormato)
			throws BusinessGlobalException, NotFoundException {

		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idCine = (Integer) claims.get(ClaimsEnum.CINE);

		logger.info("GetPreciosByFormato:::IdCine[{}]:::IdFormato[{}]", idCine, idFormato);

		List<PrecioXFormatoVO> precios = ventaBoletoController.getPreciosByFormato(idCine, idFormato);

		if (precios == null || precios.isEmpty()) {
			throw new NotFoundException("No encontrado");
		}

		return new ResponseEntity<List<PrecioXFormatoVO>>(precios, HttpStatus.OK);

	}

	@Override
	public ResponseEntity<ExistenciaBoletoVO> getExistenciaBoleto(HttpServletRequest request, Integer idProgramacion,
			Integer idSala, String fechaExhibicion) throws BusinessGlobalException, NotFoundException, ParseException {

		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idCine = (Integer) claims.get(ClaimsEnum.CINE);

		logger.info("GetExistenciaBoleto:::IdCine[{}]:::IdProgramacion[{}]:::Idsala[{}]:::FechaExhibicion[{}]", idCine,
				idProgramacion, idSala, fechaExhibicion);

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date fecha = formatter.parse(fechaExhibicion);
		ExistenciaBoletoVO existenciaBoletoVO = ventaBoletoController.getExistenciaBoleto(idProgramacion, idSala,
				fecha);

		if (existenciaBoletoVO == null) {
			throw new NotFoundException("No encontrado");
		}

		return new ResponseEntity<ExistenciaBoletoVO>(existenciaBoletoVO, HttpStatus.OK);

	}

	@Override
	public ResponseEntity<ExistenciaBoletoVO> updateExistenciaBoleto(HttpServletRequest request,
			@RequestBody ExistenciaBoletoVO existenciaBoletoVO) throws BusinessGlobalException, NotFoundException {

		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idCine = (Integer) claims.get(ClaimsEnum.CINE);

		logger.info("UpdateExistenciaBoleto:::IdCine[{}]:::IdProgramacion[{}]:::FechaExhibicion[{}]", idCine,
				existenciaBoletoVO.getProgramacionVO().getIdProgramacion(), existenciaBoletoVO.getFechaExhibicion());

		return new ResponseEntity<ExistenciaBoletoVO>(ventaBoletoController.updateExistenciaBoleto(existenciaBoletoVO),
				HttpStatus.OK);

	}

	@Override
	public ResponseEntity<TicketVentaVO> createVenta(HttpServletRequest request, @RequestBody VentaVO ventaVO)
			throws BusinessGlobalException, NotFoundException {

		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idUsuario = (Integer) claims.get(ClaimsEnum.USUARIO);
		Integer idCine = (Integer) claims.get(ClaimsEnum.CINE);
		Integer idPuntoVenta = (Integer) claims.get(ClaimsEnum.PUNTO_VENTA);
		ventaVO.setIdUsuario(idUsuario);
		ventaVO.setIdCine(idCine);
		ventaVO.setIdPuntoVenta(idPuntoVenta);

		logger.info("CreateVenta:::IdUsuario[{}]:::IdCine[{}]:::IdPuntoVenta[{}]", idUsuario, idCine, idPuntoVenta);

		TicketVentaVO ticketVentaVO = ventaBoletoController.createVenta(ventaVO);
		return new ResponseEntity<TicketVentaVO>(ticketVentaVO, HttpStatus.CREATED);

	}

	/*********************** TEST **************************************/
	@Override
	public ResponseEntity<PromocionBoletoVO> getPromocionBoletos(HttpServletRequest request)
			throws BusinessGlobalException, NotFoundException {

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
		boletoXTicketVO2.setCantidad(2);
		boletoXTicketVO2.setImporte(new BigDecimal(160));
		boletoXTicketVO2.setProgramacionVO(programacionVO);
		boletoXTicketVO2.setFechaExhibicion(date);

		TipoClienteVO tipoClienteVO3 = new TipoClienteVO();
		tipoClienteVO3.setIdTipoCliente(3);

		BoletoXTicketVO boletoXTicketVO3 = new BoletoXTicketVO();
		boletoXTicketVO3.setTipoClienteVO(tipoClienteVO3);
		boletoXTicketVO3.setCantidad(2);
		boletoXTicketVO3.setImporte(new BigDecimal(80));
		boletoXTicketVO3.setProgramacionVO(programacionVO);
		boletoXTicketVO3.setFechaExhibicion(date);

		List<BoletoXTicketVO> boletosXTicketVO = new ArrayList<BoletoXTicketVO>();
		boletosXTicketVO.add(boletoXTicketVO1);
		boletosXTicketVO.add(boletoXTicketVO2);
		boletosXTicketVO.add(boletoXTicketVO3);

		/*************************************************************************/
		PromocionVO promocionVO = new PromocionVO();
		promocionVO.setIdPromocion(1);

		PromocionBoletoVO promocionBoletoVO = new PromocionBoletoVO();
		promocionBoletoVO.setPromocionVO(promocionVO);
		promocionBoletoVO.setBoletosXTicketVO(boletosXTicketVO);

		return new ResponseEntity<PromocionBoletoVO>(promocionBoletoVO, HttpStatus.OK);

	}

	@Override
	public ResponseEntity<VentaVO> getVenta(HttpServletRequest request)
			throws BusinessGlobalException, NotFoundException {
		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		logger.info("Claim IdUsuario::[{}]", (Integer) claims.get(ClaimsEnum.USUARIO));
		logger.info("Claim IdCine::[{}]", (Integer) claims.get(ClaimsEnum.CINE));
		logger.info("Claim Id Pto Venta::[{}]", (Integer) claims.get(ClaimsEnum.PUNTO_VENTA));

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

}
