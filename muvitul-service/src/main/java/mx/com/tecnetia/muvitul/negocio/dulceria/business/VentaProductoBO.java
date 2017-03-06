package mx.com.tecnetia.muvitul.negocio.dulceria.business;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.PagoDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.PaqueteXTicketDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.ProductoXTicketDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.TicketVentaDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Pago;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.PaquetesXTicket;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.ProductosXTicket;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.TicketVenta;
import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.negocio.dulceria.assembler.PagoAssembler;
import mx.com.tecnetia.muvitul.negocio.dulceria.assembler.PaqueteXTicketAssembler;
import mx.com.tecnetia.muvitul.negocio.dulceria.assembler.ProductoXTicketAssembler;
import mx.com.tecnetia.muvitul.negocio.dulceria.assembler.TicketVentaAssembler;
import mx.com.tecnetia.muvitul.negocio.dulceria.vo.VentaVO;

@Service
@Transactional
public class VentaProductoBO {
	final static Log log = LogFactory.getLog(VentaProductoBO.class);

	@Autowired
	private TicketVentaDAOI ticketVentaDAO;
	
	@Autowired
	private PaqueteXTicketDAOI paqueteXTicketDAO;

	@Autowired
	private ProductoXTicketDAOI productoXTicketDAO;
	
	@Autowired
	private PagoDAOI pagoDAO;


	public Object createVenta(VentaVO ventaVO) throws BusinessGlobalException {

		TicketVenta ticketVenta = ticketVentaDAO.save(TicketVentaAssembler.getTicketVenta(ventaVO.getTicketVentaVO()));

		List<PaquetesXTicket> paquetesXTicket=PaqueteXTicketAssembler.getPaquetesXTicket(ventaVO.getPaquetesXTicketVO());
		
		for (PaquetesXTicket paqueteXTicket : paquetesXTicket) {
			paqueteXTicketDAO.save(paqueteXTicket);
		}

		List<ProductosXTicket> productosXTicket=ProductoXTicketAssembler.getProductosXTicket(ventaVO.getProductosXTicketVO());
		
		for (ProductosXTicket productoXTicket : productosXTicket) {
			productoXTicketDAO.save(productoXTicket);
		}
		
		List<Pago> pagos = PagoAssembler.getPagos(ventaVO.getPagos());
		for (Pago pago : pagos) {
			pago.setTicketVenta(ticketVenta);
			pagoDAO.save(pago);
		}
		
		
		return ventaVO;
	}

}
