package mx.com.tecnetia.muvitul.servicios.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.tecnetia.muvitul.infraservices.presentacion.seguridad.frontcontroller.UsuarioFirmadoBean;
import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.infraservices.servicios.NotFoundException;
import mx.com.tecnetia.muvitul.negocio.dulceria.vo.PaqueteVO;
import mx.com.tecnetia.muvitul.negocio.dulceria.vo.VentaVO;
import mx.com.tecnetia.muvitul.servicios.dulceria.controller.VentaProductoController;

@Service
public class VentaProductoFacade implements VentaProductoFacadeI {
	@Autowired
	UsuarioFirmadoBean usuarioFirmadoBean;
	
	@Autowired
	VentaProductoController ventaProductoController;

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<List<PaqueteVO>> getByPuntoVenta(Integer idPuntoVenta) throws BusinessGlobalException, NotFoundException {
		List<PaqueteVO> paquetes = ventaProductoController.getByPuntoVenta(idPuntoVenta);

		if (paquetes == null || paquetes.isEmpty()) {
			throw new NotFoundException("No encontrado");
		}

		return new ResponseEntity<List<PaqueteVO>>(paquetes, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<VentaVO> createVenta(VentaVO ventaVO) throws BusinessGlobalException, NotFoundException {
		
		return new ResponseEntity<VentaVO>(ventaVO, HttpStatus.CREATED);
	}

}
