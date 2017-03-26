package mx.com.tecnetia.muvitul.negocio.taquilla.assembler;

import java.math.BigDecimal;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.ImpuestosXTicketTaquilla;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.ImpuestosXTicketTaquillaId;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.TicketVenta;

public class ImpuestoXTicketTaquillaAssembler {
	
	public static  ImpuestosXTicketTaquilla getImpuestosXTicketTaquilla(Integer idImpuestoBoleto,TicketVenta  ticketVenta, BigDecimal importe){
		
		if(idImpuestoBoleto==null && ticketVenta==null )
			return null;
		
		ImpuestosXTicketTaquilla impuestosXTicketTaquilla= new ImpuestosXTicketTaquilla();
		ImpuestosXTicketTaquillaId id= new ImpuestosXTicketTaquillaId();
		id.setIdImpuestoBoleto(idImpuestoBoleto);
		id.setIdTicket(ticketVenta.getIdTicket());
		impuestosXTicketTaquilla.setId(id);
		impuestosXTicketTaquilla.setImpuestoBoleto(ImpuestoBoletoAssembler.getImpuestoBoleto(idImpuestoBoleto));
		impuestosXTicketTaquilla.setTicketVenta(ticketVenta);
		impuestosXTicketTaquilla.setImporte(importe);
		
		return impuestosXTicketTaquilla;
	}

}
