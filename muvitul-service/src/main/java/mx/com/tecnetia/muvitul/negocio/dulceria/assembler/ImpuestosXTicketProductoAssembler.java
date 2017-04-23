package mx.com.tecnetia.muvitul.negocio.dulceria.assembler;

import java.math.BigDecimal;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.ImpuestoXProducto;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.ImpuestosXTicketProducto;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.ImpuestosXTicketProductoId;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.TicketVenta;

public class ImpuestosXTicketProductoAssembler {

	public static ImpuestosXTicketProducto getImpuestosXTicketProducto(TicketVenta ticketVenta, ImpuestoXProducto impuestoXProducto, BigDecimal importeImpProducto){

		if(impuestoXProducto==null || ticketVenta==null || importeImpProducto==null )
			return null;
		
		ImpuestosXTicketProductoId id= new ImpuestosXTicketProductoId();
		id.setIdImpuestoXProducto(impuestoXProducto.getIdImpuestoXProducto());
		id.setIdTicket(ticketVenta.getIdTicket());
		ImpuestosXTicketProducto impuestoXTicketProducto = new ImpuestosXTicketProducto();
		impuestoXTicketProducto.setId(id);
		impuestoXTicketProducto.setImpuestoXProducto(impuestoXProducto);
		impuestoXTicketProducto.setTicketVenta(ticketVenta);
		impuestoXTicketProducto.setImporte(importeImpProducto);

		return impuestoXTicketProducto;
	}
	
	
}
