package mx.com.tecnetia.muvitul.negocio.dulceria.assembler;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.TicketVenta;
import mx.com.tecnetia.muvitul.negocio.dulceria.vo.TicketVentaVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.assembler.PuntoVentaAssembler;
import mx.com.tecnetia.muvitul.negocio.taquilla.assembler.UsuarioAssembler;

public class TicketVentaAssembler {

	public static TicketVenta getTicketVenta(TicketVentaVO ticketVentaVO){

		if(ticketVentaVO==null )
			return null;

		TicketVenta ticketVenta= new TicketVenta();
		//ticketVenta.setPuntoVenta(PuntoVentaAssembler.getPuntoVenta(ticketVentaVO.getPuntoVentaVO()));
		//ticketVenta.setUsuario(UsuarioAssembler.getUsuario(ticketVentaVO.getUsuarioFirmadoVO().getId()));
		ticketVenta.setFecha(ticketVenta.getFecha());
		ticketVenta.setDescuento(ticketVenta.getDescuento());
		ticketVenta.setImporte(ticketVenta.getImporte());
		//ticketVenta.setIva(ticketVenta.getIva());
		ticketVenta.setTotal(ticketVenta.getTotal());
		return ticketVenta;
		
	}
	
	public static TicketVentaVO getTicketVentaVO(TicketVenta ticketVenta) {
		if (ticketVenta == null)
			return null;

		TicketVentaVO ticketVentaVO = new TicketVentaVO();
		ticketVentaVO.setIdTicket(ticketVenta.getIdTicket());
		//ticketVentaVO.setPuntoVentaVO(PuntoVentaAssembler.getPuntoVentaVO(ticketVenta.getPuntoVenta()));
		//ticketVentaVO.setUsuarioVO(UsuarioAssembler.getUsuarioVO(ticketVenta.getUsuario().getIdUsuario()));
		ticketVentaVO.setFecha(ticketVenta.getFecha());
		ticketVentaVO.setDescuento(ticketVenta.getImporte());
		ticketVentaVO.setImporte(ticketVenta.getImporte());
		ticketVentaVO.setTotal(ticketVenta.getTotal());
		return ticketVentaVO;
	}
	
	
	
}
