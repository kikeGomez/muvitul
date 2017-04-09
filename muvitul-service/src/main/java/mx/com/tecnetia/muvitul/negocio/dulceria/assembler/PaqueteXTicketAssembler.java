package mx.com.tecnetia.muvitul.negocio.dulceria.assembler;

import java.util.ArrayList;
import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.PaquetesXTicket;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.PaquetesXTicketId;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.TicketVenta;
import mx.com.tecnetia.muvitul.negocio.dulceria.vo.PaqueteVO;

public class PaqueteXTicketAssembler {
	
	public static PaquetesXTicket getPaqueteXTicket(PaqueteVO paqueteVO, TicketVenta  ticketVenta){

		if(paqueteVO==null )
			return null;
		
		PaquetesXTicket paqueteXTicket = new PaquetesXTicket();
		PaquetesXTicketId id= new PaquetesXTicketId();
		id.setIdPaquete(paqueteVO.getIdPaquete());
		id.setIdTicket(ticketVenta.getIdTicket());
		paqueteXTicket.setId(id);
		paqueteXTicket.setPaquete(PaqueteAssembler.getPaquete(paqueteVO.getIdPaquete()));
		paqueteXTicket.setTicketVenta(ticketVenta);
		paqueteXTicket.setCantidad(paqueteVO.getCantidad());
		paqueteXTicket.setImporte(paqueteVO.getImporte());

		return paqueteXTicket;
		
	}
	

	public static List<PaquetesXTicket> getPaquetesXTicket(List<PaqueteVO> paquetesVO, TicketVenta  ticketVenta) {
		
		if(paquetesVO==null || paquetesVO.isEmpty())
			return null;
		
		List<PaquetesXTicket> paquetesXTicket = new ArrayList<PaquetesXTicket>();
		
		for (PaqueteVO paqueteVO : paquetesVO) {
			if(paqueteVO.isPaquete() &&  paqueteVO.getCantidad() > 0){
				paquetesXTicket.add(PaqueteXTicketAssembler.getPaqueteXTicket(paqueteVO, ticketVenta));
			}
		}

		return paquetesXTicket;
	}

}
