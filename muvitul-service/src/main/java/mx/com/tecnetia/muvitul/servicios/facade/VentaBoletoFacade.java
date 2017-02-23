package mx.com.tecnetia.muvitul.servicios.facade;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.tecnetia.muvitul.infraservices.presentacion.seguridad.frontcontroller.UsuarioFirmadoBean;
import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.infraservices.servicios.NotFoundException;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.PeliculaVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.PromocionVO;
import mx.com.tecnetia.muvitul.servicios.taquilla.controller.VentaBoletoController;
import mx.com.tecnetia.muvitul.servicios.util.Fecha;

@Service
public class VentaBoletoFacade implements VentaBoletoFacadeI{
	@Autowired
	UsuarioFirmadoBean usuarioFirmadoBean;
	@Autowired
	VentaBoletoController ventaBoletoController;

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<List<PeliculaVO>> findPeliculasByCine() throws BusinessGlobalException, NotFoundException {
		List<PeliculaVO> peliculas= ventaBoletoController.findPeliculasByCine(usuarioFirmadoBean.
				getUser().getCineVO().getIdCine(),Fecha.getDayOfWeek());
		
		if (peliculas == null || peliculas.isEmpty()) {
			throw new NotFoundException("No encontrado");
		}

		return new ResponseEntity<List<PeliculaVO>>(peliculas, HttpStatus.OK);

	}

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<List<PromocionVO>> findPromocionesByCine() throws BusinessGlobalException, NotFoundException {
		
		List<PromocionVO> promociones= ventaBoletoController.findPromocionesByCine(usuarioFirmadoBean.getUser().getCineVO().getIdCine(), new Date());

		if (promociones==null || promociones.isEmpty()) {
			throw new NotFoundException("No encontrado");
		}

		return new ResponseEntity<List<PromocionVO>>(promociones, HttpStatus.OK);

	}

}
