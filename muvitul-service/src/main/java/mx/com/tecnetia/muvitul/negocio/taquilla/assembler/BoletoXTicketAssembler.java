package mx.com.tecnetia.muvitul.negocio.taquilla.assembler;

import java.util.ArrayList;
import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.BoletosXTicket;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.BoletosXTicketId;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.BoletoXTicketVO;

public class BoletoXTicketAssembler {

	public static BoletosXTicket getBoletoXTicket(BoletoXTicketVO boletoXTicketVO, Integer idTicket){

		if(boletoXTicketVO==null )
			return null;

		BoletosXTicket boletoXTicket= new BoletosXTicket();
		BoletosXTicketId id= new BoletosXTicketId();
		id.setIdTicket(idTicket);
		id.setIdTipoCliente(boletoXTicketVO.getTipoClienteVO().getIdTipoCliente());
		boletoXTicket.setId(id);
		boletoXTicket.setProgramacion(ProgramacionAssembler.getProgramacion(boletoXTicketVO.getProgramacionVO().getIdProgramacion()));
		boletoXTicket.setTicketVenta(TicketVentaAssembler.getTicketVenta(idTicket));
		boletoXTicket.setTipoCliente(TipoClienteAssembler.getTipoCliente(boletoXTicketVO.getTipoClienteVO().getIdTipoCliente()));
		boletoXTicket.setCantidad(boletoXTicketVO.getCantidad());
		boletoXTicket.setImporte(boletoXTicketVO.getImporte());
		boletoXTicket.setFechaExhibicion(boletoXTicketVO.getFechaExhibicion());
		
		return boletoXTicket;
	}
	
	public static List<BoletosXTicket> getBoletosXTicket(List<BoletoXTicketVO> boletosXTicketVO, Integer idTicket){

		if(boletosXTicketVO==null || boletosXTicketVO.isEmpty())
			return null;
		
		List<BoletosXTicket> boletosXTicket = new ArrayList<BoletosXTicket>();
		
		for (BoletoXTicketVO boletoXTicketVO : boletosXTicketVO) {
			boletosXTicket.add(BoletoXTicketAssembler.getBoletoXTicket(boletoXTicketVO,idTicket));
		}

		return boletosXTicket;
	}
	
}