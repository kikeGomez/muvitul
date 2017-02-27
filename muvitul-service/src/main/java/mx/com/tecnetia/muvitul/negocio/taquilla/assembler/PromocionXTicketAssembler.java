package mx.com.tecnetia.muvitul.negocio.taquilla.assembler;

import java.util.ArrayList;
import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.PromocionesXTicket;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.PromocionXTicketVO;

public class PromocionXTicketAssembler {

	public static PromocionesXTicket getPromocionXTicket(PromocionXTicketVO promocionXTicketVO){

		if(promocionXTicketVO==null )
			return null;
		
		PromocionesXTicket promocionXTicket = new PromocionesXTicket();


		return promocionXTicket;
	}
	
	
	public static List<PromocionesXTicket> getPromocionesXTicket(List<PromocionXTicketVO> promocionesXTicketVO){

		if(promocionesXTicketVO==null || promocionesXTicketVO.isEmpty())
			return null;
		
		List<PromocionesXTicket> promocionesXTicket = new ArrayList<PromocionesXTicket>();
		
		for (PromocionXTicketVO promocionXTicketVO : promocionesXTicketVO) {
			promocionesXTicket.add(PromocionXTicketAssembler.getPromocionXTicket(promocionXTicketVO));
		}

		return promocionesXTicket;
	}
	
}
