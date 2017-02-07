package mx.com.tecnetia.muvitul.servicios.taquilla.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Promocion;

@RestController
public class VentaBoletoRestController {

	@RequestMapping(value = "/ventaBoleto", method = RequestMethod.GET)
	public ResponseEntity<Promocion> historicoDetalleInfraccion() {
		Promocion promocion = new Promocion();
		promocion.setFechaFin(new Date());
		promocion.setNombre(1);
		promocion.setIdPromocion(1);
		return new ResponseEntity<Promocion>(promocion, HttpStatus.OK);
	}

}
