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
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.ImpuestosXTicketPaqueteDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.ImpuestosXTicketProductoDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.MovimientoInventarioDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.PagoDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.PaqueteXPuntoVentaDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.PaqueteXTicketDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.ProductoXPuntoVentaDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.ProductoXTicketDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.TicketVentaDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.ImpuestoXProducto;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.ImpuestosXTicketPaquete;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.ImpuestosXTicketProducto;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Pago;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.PaquetesXPuntoVenta;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.PaquetesXTicket;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.ProductosXPuntoVenta;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.ProductosXTicket;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.TicketVenta;
import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.negocio.dulceria.assembler.ImpuestoXTicketPaqueteAssembler;
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
import mx.com.tecnetia.muvitul.servicios.util.Constantes;

@Service
@Transactional
public class VentaProductoBO {
	final static Log log = LogFactory.getLog(VentaProductoBO.class);

	@Autowired
	private PaqueteXPuntoVentaDAOI paqueteXPuntoVentaDAO;

	@Autowired
	private ProductoXPuntoVentaDAOI productoXPuntoVentaDAO;
	
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
	private ImpuestosXTicketPaqueteDAOI impuestosXTicketPaqueteDAO;
	
	@Autowired
	private MovimientoInventarioDAOI movimientoInventarioDAO;
	
	@Autowired
	private PagoDAOI pagoDAO;
	
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
		BigDecimal importeImpuestos = new BigDecimal(0);
		
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
				
				BigDecimal xcientoImpProducto= new BigDecimal(0);
				xcientoImpProducto.add(impuestoXProducto.getPorcentaje());
				xcientoImpProducto= xcientoImpProducto.divide(new BigDecimal(Constantes.CIEN));
				xcientoImpProducto = xcientoImpProducto.add(new BigDecimal(Constantes.UNO));
				
				
				BigDecimal subtotalProducto= new BigDecimal(0);
				subtotalProducto= subtotalProducto.add(productoXTicket.getImporte());
				subtotalProducto = subtotalProducto.divide(xcientoImpProducto, 3, BigDecimal.ROUND_HALF_EVEN);
				
				BigDecimal importeImpProducto = new BigDecimal(0);
				importeImpProducto= importeImpProducto.add(productoXTicket.getImporte());
				importeImpProducto.subtract(subtotalProducto);
				
				importeImpuestos.add(importeImpProducto);
				
				ImpuestosXTicketProducto impuestoXTicketProducto = 
						ImpuestosXTicketProductoAssembler.getImpuestosXTicketProducto(ticketVenta, impuestoXProducto, importeImpProducto);
				
				impuestosXTicketProductoDAO.save(impuestoXTicketProducto);
			}
			
			productoXTicketDAO.save(productoXTicket);
		}

		for (PaquetesXTicket paqueteXTicket : paquetesXTicket) {
			BigDecimal xcientoImpPaquete= new BigDecimal(Constantes.IMPUESTO_PAQUETE);
			xcientoImpPaquete= xcientoImpPaquete.divide(new BigDecimal(Constantes.CIEN));
			xcientoImpPaquete = xcientoImpPaquete.add(new BigDecimal(Constantes.UNO));
			
			BigDecimal subtotalPaquete = new BigDecimal(0);
			subtotalPaquete= subtotalPaquete.add(paqueteXTicket.getImporte());
			subtotalPaquete = subtotalPaquete.divide(xcientoImpPaquete, 3, BigDecimal.ROUND_HALF_EVEN);
			
			BigDecimal importeImpPaquete = new BigDecimal(0);
			importeImpPaquete= importeImpPaquete.add(paqueteXTicket.getImporte());
			importeImpPaquete.subtract(subtotalPaquete);
			
			importeImpuestos.add(importeImpPaquete);
			
			ImpuestosXTicketPaquete impuestosXTicketPaquete =
					ImpuestoXTicketPaqueteAssembler.getImpuestoXTicketPaquete(ticketVenta, importeImpPaquete, new BigDecimal(Constantes.IMPUESTO_PAQUETE));
			impuestosXTicketPaqueteDAO.save(impuestosXTicketPaquete);
			
			paqueteXTicketDAO.save(paqueteXTicket);
		}
		
		List<Pago> pagos = PagoAssembler.getPagos(ventaVO.getPagosVO(), ticketVenta);
		for (Pago pago : pagos) {
			pagoDAO.save(pago);
		}

		subtotal.add(total);
		subtotal.subtract(importeImpuestos);
		ticketVenta.setImporte(subtotal);
		ticketVentaDAO.update(ticketVenta);
		
		movimientoInventarioDAO.save(MovimientoInventarioAssembler.getMovimientoInventario());
		
		
		
		
		return TicketVentaAssembler.getTicketVentaVO(ticketVenta);
	}

}
