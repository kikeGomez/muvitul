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
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.ExistenciaBoletoVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.PeliculaVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.PrecioXFormatoVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.PromocionVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.VentaVO;
import mx.com.tecnetia.muvitul.servicios.taquilla.controller.VentaBoletoController;
import mx.com.tecnetia.muvitul.servicios.util.Fecha;

@Service
public class VentaBoletoFacade implements VentaBoletoFacadeI {
	@Autowired
	UsuarioFirmadoBean usuarioFirmadoBean;
	@Autowired
	VentaBoletoController ventaBoletoController;

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<List<PeliculaVO>> getPeliculasByCine() throws BusinessGlobalException, NotFoundException {
		List<PeliculaVO> peliculas = ventaBoletoController.getPeliculasByCine(
				usuarioFirmadoBean.getUser().getCineVO().getIdCine(), Fecha.getDayOfWeek(), new Date());

		if (peliculas == null || peliculas.isEmpty()) {
			throw new NotFoundException("No encontrado");
		}

		return new ResponseEntity<List<PeliculaVO>>(peliculas, HttpStatus.OK);

	}

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<List<PromocionVO>> getPromocionesByCine() throws BusinessGlobalException, NotFoundException {
		int ID_PROMOCION_PARA = 1;
		List<PromocionVO> promociones = ventaBoletoController.getPromocionesByCine(
				usuarioFirmadoBean.getUser().getCineVO().getIdCine(), ID_PROMOCION_PARA, new Date());

		if (promociones == null || promociones.isEmpty()) {
			throw new NotFoundException("No encontrado");
		}

		return new ResponseEntity<List<PromocionVO>>(promociones, HttpStatus.OK);

	}

	@Override
	public ResponseEntity<List<PrecioXFormatoVO>> getPreciosByFormato(Integer idFormato)
			throws BusinessGlobalException, NotFoundException {
		List<PrecioXFormatoVO> precios = ventaBoletoController
				.getPreciosByFormato(usuarioFirmadoBean.getUser().getCineVO().getIdCine(), idFormato);

		if (precios == null || precios.isEmpty()) {
			throw new NotFoundException("No encontrado");
		}

		return new ResponseEntity<List<PrecioXFormatoVO>>(precios, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ExistenciaBoletoVO> getExistenciaBoleto(Integer idProgramacion, Integer idSala)
			throws BusinessGlobalException, NotFoundException {

		ExistenciaBoletoVO existenciaBoletoVO = ventaBoletoController.getExistenciaBoleto(idProgramacion, idSala, new Date());

		if (existenciaBoletoVO == null) {
			throw new NotFoundException("No encontrado");
		}

		return new ResponseEntity<ExistenciaBoletoVO>(existenciaBoletoVO, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ExistenciaBoletoVO> updateExistenciaBoleto(ExistenciaBoletoVO existenciaBoletoVO)
			throws BusinessGlobalException, NotFoundException {
		return new ResponseEntity<ExistenciaBoletoVO>(ventaBoletoController.updateExistenciaBoleto(existenciaBoletoVO),
				HttpStatus.OK);

	}

	@Override
	public ResponseEntity<VentaVO> createVenta(VentaVO ventaVO) throws BusinessGlobalException, NotFoundException {
		ventaVO.getTicketVentaVO().setUsuarioFirmadoVO(usuarioFirmadoBean.getUser());
		ventaBoletoController.createVenta(ventaVO);
		return new ResponseEntity<VentaVO>(ventaVO, HttpStatus.CREATED);
	}

}
