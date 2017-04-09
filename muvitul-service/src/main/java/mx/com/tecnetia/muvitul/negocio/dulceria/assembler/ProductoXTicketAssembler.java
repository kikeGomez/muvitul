package mx.com.tecnetia.muvitul.negocio.dulceria.assembler;

import java.util.ArrayList;
import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.ProductosXTicket;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.ProductosXTicketId;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.TicketVenta;
import mx.com.tecnetia.muvitul.negocio.dulceria.vo.PaqueteVO;

public class ProductoXTicketAssembler {

	public static ProductosXTicket getProductoXTicket(PaqueteVO paqueteVO, TicketVenta  ticketVenta){

		if(paqueteVO==null )
			return null;
		
		ProductosXTicket productoXTicket = new ProductosXTicket();
		ProductosXTicketId id= new ProductosXTicketId();
		id.setIdProducto(paqueteVO.getIdPaquete());
		id.setIdTicket(ticketVenta.getIdTicket());

		productoXTicket.setProducto(ProductoAssembler.getProducto(paqueteVO.getIdPaquete()));
		productoXTicket.setTicketVenta(ticketVenta);
		productoXTicket.setCantidad(paqueteVO.getCantidad());
		productoXTicket.setImporte(paqueteVO.getImporte());
		
		return productoXTicket;
		
	}
	
	public static List<ProductosXTicket> getProductosXTicket(List<PaqueteVO> paquetesVO, TicketVenta  ticketVenta) {
		
		if(paquetesVO==null || paquetesVO.isEmpty())
			return null;
		
		List<ProductosXTicket> productosXTicket = new ArrayList<ProductosXTicket>();
		
		for (PaqueteVO paqueteVO : paquetesVO) {
			if(!paqueteVO.isPaquete() &&  paqueteVO.getCantidad() > 0){
				productosXTicket.add(ProductoXTicketAssembler.getProductoXTicket(paqueteVO, ticketVenta));
			}
		}

		return productosXTicket;
	}


}
