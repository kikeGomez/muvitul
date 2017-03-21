package mx.com.tecnetia.muvitul.negocio.taquilla.assembler;

import java.util.ArrayList;
import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.PromocionesXTicket;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.PromocionesXTicketId;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.PromocionXTicketVO;

public class PromocionXTicketAssembler {

	public static PromocionesXTicket getPromocionXTicket(PromocionXTicketVO promocionXTicketVO, Integer idTicket){

		if(promocionXTicketVO==null )
			return null;
		
		PromocionesXTicket promocionXTicket = new PromocionesXTicket();
		PromocionesXTicketId id= new PromocionesXTicketId();
		id.setIdPromocion(promocionXTicketVO.getPromocionVO().getIdPromocion());
		id.setIdTicket(idTicket);
		promocionXTicket.setId(id);
		promocionXTicket.setPromocion(PromocionAssembler.getPromocion(promocionXTicketVO.getPromocionVO().getIdPromocion()));
		promocionXTicket.setTicketVenta(TicketVentaAssembler.getTicketVenta(idTicket));
		promocionXTicket.setCantidad(promocionXTicketVO.getCantidad());
		promocionXTicket.setImporte(promocionXTicketVO.getImporte());

		return promocionXTicket;
		
	}
	
	
	public static List<PromocionesXTicket> getPromocionesXTicket(List<PromocionXTicketVO> promocionesXTicketVO,Integer idTicket){

		if(promocionesXTicketVO==null || promocionesXTicketVO.isEmpty())
			return null;
		
		List<PromocionesXTicket> promocionesXTicket = new ArrayList<PromocionesXTicket>();
		
		for (PromocionXTicketVO promocionXTicketVO : promocionesXTicketVO) {
			promocionesXTicket.add(PromocionXTicketAssembler.getPromocionXTicket(promocionXTicketVO, idTicket));
		}

		return promocionesXTicket;
	}
	
}
