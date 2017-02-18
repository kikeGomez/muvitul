package mx.com.tecnetia.muvitul.servicios.taquilla.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Programacion;
import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.negocio.taquilla.business.PeliculaBo;

@RestController
@Transactional
public class VentaBoletoController {
	//@Autowired
	//private UsuarioLog usuarioLog;
	@Autowired
	private PeliculaBo peliculaBo;
	
	@RequestMapping(value = "/ventaBoletos", method = RequestMethod.GET)
	public ResponseEntity<List<Programacion>> historico() throws BusinessGlobalException {
		//System.out.println(usuarioLog.getUser());
		List<Programacion> programacion= peliculaBo.getProgramacionByCine();
		return new ResponseEntity<List<Programacion>>(programacion, HttpStatus.OK);
	}

}
