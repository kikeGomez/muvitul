package mx.com.tecnetia.muvitul.negocio.dulceria.business;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.ImpuestoXProductoDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.ImpuestosXTicketProductoDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.MovimientoInventarioDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.PagoDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.PaqueteXPuntoVentaDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.PaqueteXTicketDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.ProductoXPuntoVentaDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.ProductoXTicketDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.TicketVentaDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.ImpuestoXProducto;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Pago;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.PaquetesXPuntoVenta;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.PaquetesXTicket;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.ProductosXPuntoVenta;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.ProductosXTicket;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.TicketVenta;
import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.negocio.dulceria.assembler.ImpuestosXTicketProductoAssembler;
import mx.com.tecnetia.muvitul.negocio.dulceria.assembler.MovimientoInventarioAssembler;
import mx.com.tecnetia.muvitul.negocio.dulceria.assembler.PagoAssembler;
import mx.com.tecnetia.muvitul.negocio.dulceria.assembler.PaqueteAssembler;
import mx.com.tecnetia.muvitul.negocio.dulceria.assembler.PaqueteXTicketAssembler;
import mx.com.tecnetia.muvitul.negocio.dulceria.assembler.ProductoXTicketAssembler;
import mx.com.tecnetia.muvitul.negocio.dulceria.assembler.TicketVentaAssembler;
import mx.com.tecnetia.muvitul.negocio.dulceria.vo.PaqueteVO;
import mx.com.tecnetia.muvitul.negocio.dulceria.vo.TicketVentaVO;
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
	private ImpuestoXProductoDAOI impuestoXProductoDAO;

	@Autowired
	private ImpuestosXTicketProductoDAOI impuestosXTicketProductoDAO;
	
	@Autowired
	private MovimientoInventarioDAOI movimientoInventarioDAO;
	
	@Autowired
	private PagoDAOI pagoDAO;

	@Autowired
	private PaqueteXPuntoVentaDAOI paqueteXPuntoVentaDAO;

	@Autowired
	private ProductoXPuntoVentaDAOI productoXPuntoVentaDAO;
	
	
	public List<PaqueteVO> getPaquetes(Integer idPuntoVenta)  throws BusinessGlobalException {
		
		List<PaqueteVO> paquetesVO=new ArrayList<PaqueteVO>();
		List<PaquetesXPuntoVenta> paquetesXPuntoVenta= paqueteXPuntoVentaDAO.findByPuntoVenta(idPuntoVenta);
		List<ProductosXPuntoVenta> productosXPuntoVenta = productoXPuntoVentaDAO.findByPuntoVenta(idPuntoVenta);
		
		
		if(paquetesXPuntoVenta!=null && !paquetesXPuntoVenta.isEmpty()){
			paquetesVO.addAll(PaqueteAssembler.getPaquetesVO(paquetesXPuntoVenta));
		}

		if(productosXPuntoVenta!=null && !productosXPuntoVenta.isEmpty()){
			paquetesVO.addAll(PaqueteAssembler.getPaquetesVOXProducto(productosXPuntoVenta));
		}
		

		return paquetesVO ;
		
	}
	
	
	public TicketVentaVO createVenta(VentaVO ventaVO) throws BusinessGlobalException {
		BigDecimal total = new BigDecimal(0);
		BigDecimal subtotal = new BigDecimal(0);
		BigDecimal impuestos = new BigDecimal(0);
		
		for (PaqueteVO paqueteVO : ventaVO.getPaquetesVO()) {
			total = total.add(paqueteVO.getImporte());
		}

		TicketVenta ticketVenta = ticketVentaDAO.save(TicketVentaAssembler.getTicketVenta(ventaVO.getIdUsuario(),
				ventaVO.getIdPuntoVenta(), new BigDecimal(0), subtotal, total));

		List<PaquetesXTicket> paquetesXTicket = PaqueteXTicketAssembler.getPaquetesXTicket(ventaVO.getPaquetesVO(),
				ticketVenta);

		List<ProductosXTicket> productosXTicket = ProductoXTicketAssembler.getProductosXTicket(ventaVO.getPaquetesVO(),
				ticketVenta);

		for (ProductosXTicket productoXTicket : productosXTicket) {
			
			List<ImpuestoXProducto> impuestosXProducto = impuestoXProductoDAO
					.findByIdCineAndIdProducto(ventaVO.getIdCine(), productoXTicket.getProducto().getIdProducto());

			for (ImpuestoXProducto impuestoXProducto : impuestosXProducto) {
				
				BigDecimal porcentaje = new BigDecimal(0);
				porcentaje = porcentaje.add(impuestoXProducto.getPorcentaje());
				porcentaje = porcentaje.divide(new BigDecimal(100));
				
				BigDecimal impuesto = new BigDecimal(0);
				impuesto = impuesto.add(productoXTicket.getImporte());
				impuesto = impuesto.multiply(porcentaje);
				
				impuestos.add(impuesto);
				
				impuestosXTicketProductoDAO.save(ImpuestosXTicketProductoAssembler.getImpuestosXTicketProducto(impuestoXProducto, ticketVenta, impuesto));
			}
			
			productoXTicketDAO.save(productoXTicket);
		}

		// FALTA SALVAR LOS IMPUESTOS
		for (PaquetesXTicket paqueteXTicket : paquetesXTicket) {
			paqueteXTicketDAO.save(paqueteXTicket);
		}
		
		
		movimientoInventarioDAO.save(MovimientoInventarioAssembler.getMovimientoInventario());
		
		
		List<Pago> pagos = PagoAssembler.getPagos(ventaVO.getPagosVO(), ticketVenta);
		for (Pago pago : pagos) {
			pagoDAO.save(pago);
		}

		subtotal.add(total);
		subtotal.subtract(impuestos);
		ticketVenta.setImporte(subtotal);
		ticketVentaDAO.update(ticketVenta);
		
		return TicketVentaAssembler.getTicketVentaVO(ticketVenta);
	}

}
