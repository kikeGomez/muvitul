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
import mx.com.tecnetia.muvitul.negocio.taquilla.business.ProgramacionBo;
import mx.com.tecnetia.muvitul.negocio.taquilla.business.ProgramacionVo;

@RestController
@Transactional
public class VentaBoletoController {
	private static Logger logger = LoggerFactory.getLogger(VentaBoletoController.class);

	@Autowired
	UsuarioFirmadoBean usuarioFirmadoBean;
	
	@Autowired
	private ProgramacionBo programacionBo;
	
	@RequestMapping(value = "/ventaBoleto", method = RequestMethod.GET)
	public ResponseEntity<List<ProgramacionVo>> historico() throws BusinessGlobalException {
		logger.info("USUARIO: "+usuarioFirmadoBean.getUser());
		List<ProgramacionVo> programacion= programacionBo.findByCineAndDay();
		return new ResponseEntity<List<ProgramacionVo>>(programacion, HttpStatus.OK);
	}

}
