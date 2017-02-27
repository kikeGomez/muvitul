package mx.com.tecnetia.muvitul.servicios.dulceria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.negocio.dulceria.business.PaqueteBO;
import mx.com.tecnetia.muvitul.negocio.dulceria.vo.PaqueteVO;

@Service
public class VentaProductoController {
	@Autowired
	private PaqueteBO paqueteBO;

	public List<PaqueteVO> getByPuntoVenta(Integer idPuntoVenta) throws BusinessGlobalException {
		return paqueteBO.findByPuntoVenta(idPuntoVenta);
	}
	
	
}
