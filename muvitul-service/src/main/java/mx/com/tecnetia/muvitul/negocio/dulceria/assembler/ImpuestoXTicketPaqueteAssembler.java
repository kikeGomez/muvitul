package mx.com.tecnetia.muvitul.negocio.dulceria.assembler;

import java.math.BigDecimal;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.ImpuestosXTicketPaquete;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.TicketVenta;

public class ImpuestoXTicketPaqueteAssembler {

	public static ImpuestosXTicketPaquete getImpuestoXTicketPaquete(TicketVenta ticketVenta, BigDecimal importe,  BigDecimal porcentaje){

		if(ticketVenta==null || importe==null || porcentaje==null)
			return null;
		

		ImpuestosXTicketPaquete impuestoXTicketPaquete = new ImpuestosXTicketPaquete();
		impuestoXTicketPaquete.setTicketVenta(ticketVenta);
		impuestoXTicketPaquete.setImporte(importe);
		impuestoXTicketPaquete.setPorcentaje(porcentaje);

		return impuestoXTicketPaquete;
	}
	
}
