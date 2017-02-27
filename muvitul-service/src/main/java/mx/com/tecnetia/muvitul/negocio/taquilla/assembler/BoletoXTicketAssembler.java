package mx.com.tecnetia.muvitul.negocio.taquilla.assembler;

import java.util.ArrayList;
import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.BoletosXTicket;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.BoletoXTicketVO;

public class BoletoXTicketAssembler {

	public static BoletosXTicket getBoletoXTicket(BoletoXTicketVO boletoXTicketVO){

		if(boletoXTicketVO==null )
			return null;

		BoletosXTicket boletoXTicket= new BoletosXTicket();
		boletoXTicket.setFormato(FormatoAssembler.getFormato(boletoXTicketVO.getFormatoVO()));
		boletoXTicket.setTipoCliente(TipoClienteAssembler.getTipoCliente(boletoXTicketVO.getTipoClienteVO()));
		boletoXTicket.setCantidad(boletoXTicketVO.getCantidad());
		boletoXTicket.setImporte(boletoXTicketVO.getImporte());
		return boletoXTicket;
	}
	
	public static List<BoletosXTicket> getBoletosXTicket(List<BoletoXTicketVO> boletosXTicketVO){

		if(boletosXTicketVO==null || boletosXTicketVO.isEmpty())
			return null;
		
		List<BoletosXTicket> boletosXTicket = new ArrayList<BoletosXTicket>();
		
		for (BoletoXTicketVO boletoXTicketVO : boletosXTicketVO) {
			boletosXTicket.add(BoletoXTicketAssembler.getBoletoXTicket(boletoXTicketVO));
		}

		return boletosXTicket;
	}
	
}