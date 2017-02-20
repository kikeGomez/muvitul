package mx.com.tecnetia.muvitul.servicios.taquilla.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.com.tecnetia.muvitul.infraservices.presentacion.seguridad.frontcontroller.UsuarioFirmadoBean;
import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.negocio.taquilla.business.PeliculaBOI;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.PeliculaVO;
import mx.com.tecnetia.muvitul.servicios.util.Fecha;

@RestController
@Transactional
public class VentaBoletoController {
	private static Logger logger = LoggerFactory.getLogger(VentaBoletoController.class);

	@Autowired
	UsuarioFirmadoBean usuarioFirmadoBean;
	
	@Autowired
	private PeliculaBOI peliculaBo;
	
	@RequestMapping(value = "/ventaBoleto", method = RequestMethod.GET)
	public ResponseEntity<List<PeliculaVO>> findPeliculasByCine() throws BusinessGlobalException {
		logger.info("ID CINE: "+ usuarioFirmadoBean.getUser().getCineVO().getIdCine());
		List<PeliculaVO> peliculas= peliculaBo.findByCineAndDay(usuarioFirmadoBean.getUser().getCineVO().getIdCine(),Fecha.getDayOfWeek());
		return new ResponseEntity<List<PeliculaVO>>(peliculas, HttpStatus.OK);
	}

}
