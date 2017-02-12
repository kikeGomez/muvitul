package mx.com.tecnetia.muvitul.servicios.taquilla.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Promocion;
import mx.com.tecnetia.muvitul.infraservices.presentacion.seguridad.frontcontroller.UsuarioFirmadoBean;

@RestController
public class VentaBoletoRestController {
	@Autowired
	UsuarioFirmadoBean usuarioFirmadoBean;
	
	@RequestMapping(value = "/ventaBoleto", method = RequestMethod.GET)
	public ResponseEntity<Promocion> historicoDetalleInfraccion() {
		Promocion promocion = new Promocion();
		promocion.setFechaFin(new Date());
		promocion.setIdPromocion(1);
		System.out.println("/ventaBoleto: "+usuarioFirmadoBean.getUser());
		return new ResponseEntity<Promocion>(promocion, HttpStatus.OK);
	}

}
