package mx.com.tecnetia.muvitul.servicios.facade;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.infraservices.servicios.NotFoundException;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.ExistenciaBoletoVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.PeliculaVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.PrecioXFormatoVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.PromocionBoletoVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.PromocionVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.TicketVentaVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.VentaVO;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/ventaBoleto")
public interface VentaBoletoFacadeI {

	@RequestMapping(value = "/peliculas", method = RequestMethod.GET)
	public ResponseEntity<List<PeliculaVO>> getPeliculasByCine(HttpServletRequest request, String fechaExhibicion)
			throws BusinessGlobalException, NotFoundException, ParseException;

	@RequestMapping(value = "/promociones", method = RequestMethod.GET)
	public ResponseEntity<List<PromocionVO>> getPromocionesByCine(HttpServletRequest request, String fechaExhibicion)
			throws BusinessGlobalException, NotFoundException, ParseException;

	@RequestMapping(value = "/descuentos", method = RequestMethod.POST)
	public ResponseEntity<BigDecimal> getDescuentoByPromocion(HttpServletRequest request,
			@RequestBody PromocionBoletoVO promocionBoletoVO) throws BusinessGlobalException, NotFoundException;

	@RequestMapping(value = "/precios", method = RequestMethod.GET)
	public ResponseEntity<List<PrecioXFormatoVO>> getPreciosByFormato(HttpServletRequest request,
			@RequestParam(value = "idFormato") Integer idFormato) throws BusinessGlobalException, NotFoundException;

	@RequestMapping(value = "/existencias", method = RequestMethod.GET)
	public ResponseEntity<ExistenciaBoletoVO> getExistenciaBoleto(HttpServletRequest request,
			@RequestParam(value = "idProgramacion") Integer idProgramacion,
			@RequestParam(value = "idSala") Integer idSala,
			@RequestParam(value = "fechaExhibicion") String fechaExhibicion)
			throws BusinessGlobalException, NotFoundException, ParseException;

	@RequestMapping(value = "/existencias", method = RequestMethod.PUT)
	public ResponseEntity<ExistenciaBoletoVO> updateExistenciaBoleto(HttpServletRequest request,
			@RequestBody ExistenciaBoletoVO existenciaBoletoVO) throws BusinessGlobalException, NotFoundException;

	@RequestMapping(value = "/ventas", method = RequestMethod.POST)
	public ResponseEntity<TicketVentaVO> createVenta(HttpServletRequest request, @RequestBody VentaVO ventaVO)
			throws BusinessGlobalException, NotFoundException;

	@RequestMapping(value = "/tickets", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getTicketsPdf(HttpServletRequest request, Integer idTicket)
			throws BusinessGlobalException, NotFoundException;

	/*********************** TEST **************************************/
	@RequestMapping(value = "/descuentos", method = RequestMethod.GET)
	public ResponseEntity<PromocionBoletoVO> getPromocionBoletos(HttpServletRequest request)
			throws BusinessGlobalException, NotFoundException;

	@RequestMapping(value = "/ventas", method = RequestMethod.GET)
	public ResponseEntity<VentaVO> getVenta(HttpServletRequest request)
			throws BusinessGlobalException, NotFoundException;

}
