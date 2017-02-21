package mx.com.tecnetia.muvitul.servicios.taquilla.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.com.tecnetia.muvitul.infraservices.presentacion.seguridad.frontcontroller.UsuarioFirmadoBean;
import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.infraservices.servicios.NotFoundException;
import mx.com.tecnetia.muvitul.negocio.taquilla.business.PeliculaBOI;
import mx.com.tecnetia.muvitul.negocio.taquilla.business.PromocionBOI;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.PeliculaVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.PromocionVO;
import mx.com.tecnetia.muvitul.servicios.util.Fecha;

@RestController
@RequestMapping("/ventaBoleto")
public class VentaBoletoController {
	private static Logger logger = LoggerFactory.getLogger(VentaBoletoController.class);

	@Autowired
	UsuarioFirmadoBean usuarioFirmadoBean;
	@Autowired
	private PeliculaBOI peliculaBO;
	@Autowired
	private PromocionBOI promocionBO;
	
	
	@RequestMapping(value = "/peliculas", method = RequestMethod.GET)
	public ResponseEntity<List<PeliculaVO>> findPeliculasByCine() throws BusinessGlobalException, NotFoundException {
		logger.info("ID CINE: "+ usuarioFirmadoBean.getUser().getCineVO().getIdCine());
		List<PeliculaVO> peliculas= peliculaBO.findByCineAndDay(usuarioFirmadoBean.getUser().getCineVO().getIdCine(),Fecha.getDayOfWeek());

		if (peliculas.isEmpty()) {
			throw new NotFoundException("No encontrado");
		}

		return new ResponseEntity<List<PeliculaVO>>(peliculas, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/promociones", method = RequestMethod.GET)
	public ResponseEntity<List<PromocionVO>> findPromocionesByCine() throws BusinessGlobalException, NotFoundException {
		
		List<PromocionVO> promociones= promocionBO.findByCineAndDate(usuarioFirmadoBean.getUser().getCineVO().getIdCine(), new Date());

		if (promociones.isEmpty()) {
			throw new NotFoundException("No encontrado");
		}

		return new ResponseEntity<List<PromocionVO>>(promociones, HttpStatus.OK);
	}
	
}
