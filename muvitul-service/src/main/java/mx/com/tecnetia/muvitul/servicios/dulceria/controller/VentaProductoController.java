package mx.com.tecnetia.muvitul.servicios.dulceria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.negocio.dulceria.business.PaqueteBO;
import mx.com.tecnetia.muvitul.negocio.dulceria.business.VentaProductoBO;
import mx.com.tecnetia.muvitul.negocio.dulceria.vo.PaqueteVO;
import mx.com.tecnetia.muvitul.negocio.dulceria.vo.TicketVentaVO;
import mx.com.tecnetia.muvitul.negocio.dulceria.vo.VentaVO;

@Service
public class VentaProductoController {
	@Autowired
	private PaqueteBO paqueteBO;
	
	@Autowired
	private VentaProductoBO ventaProductoBO;

	public List<PaqueteVO> getPaquetes(Integer idPuntoVenta) throws BusinessGlobalException {
		return paqueteBO.findByPuntoVenta(idPuntoVenta);
	}

	public TicketVentaVO createVenta(VentaVO ventaVO) throws BusinessGlobalException {
		return ventaProductoBO.createVenta(ventaVO);
	}
	
}
