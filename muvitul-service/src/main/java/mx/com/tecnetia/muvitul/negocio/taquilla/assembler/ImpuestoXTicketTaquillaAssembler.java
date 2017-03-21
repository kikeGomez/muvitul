package mx.com.tecnetia.muvitul.negocio.taquilla.assembler;

import java.math.BigDecimal;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.ImpuestosXTicketTaquilla;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.ImpuestosXTicketTaquillaId;

public class ImpuestoXTicketTaquillaAssembler {
	
	public static  ImpuestosXTicketTaquilla getImpuestosXTicketTaquilla(Integer idImpuestoBoleto, Integer idTicket, BigDecimal importe){
		
		if(idImpuestoBoleto==null && idTicket==null )
			return null;
		
		ImpuestosXTicketTaquilla impuestosXTicketTaquilla= new ImpuestosXTicketTaquilla();
		ImpuestosXTicketTaquillaId id= new ImpuestosXTicketTaquillaId();
		id.setIdImpuestoBoleto(idImpuestoBoleto);
		id.setIdTicket(idTicket);
		impuestosXTicketTaquilla.setId(id);
		impuestosXTicketTaquilla.setImpuestoBoleto(ImpuestoBoletoAssembler.getImpuestoBoleto(idImpuestoBoleto));
		impuestosXTicketTaquilla.setTicketVenta(TicketVentaAssembler.getTicketVenta(idTicket));
		impuestosXTicketTaquilla.setImporte(importe);
		
		return impuestosXTicketTaquilla;
	}

}
