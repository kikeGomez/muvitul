package mx.com.tecnetia.muvitul.negocio.dulceria.assembler;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.TicketVenta;
import mx.com.tecnetia.muvitul.negocio.dulceria.vo.TicketVentaVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.assembler.UsuarioAssembler;

public class TicketVentaAssembler {

	public static TicketVenta getTicketVenta(TicketVentaVO ticketVentaVO){

		if(ticketVentaVO==null )
			return null;

		TicketVenta ticketVenta= new TicketVenta();
		ticketVenta.setPuntoVenta(PuntoVentaAssembler.getPuntoVenta(ticketVentaVO.getPuntoVentaVO()));
		ticketVenta.setUsuario(UsuarioAssembler.getUsuario(ticketVentaVO.getUsuarioFirmadoVO().getId()));
		ticketVenta.setFecha(ticketVenta.getFecha());
		ticketVenta.setDescuento(ticketVenta.getDescuento());
		ticketVenta.setImporte(ticketVenta.getImporte());
		//ticketVenta.setIva(ticketVenta.getIva());
		ticketVenta.setTotal(ticketVenta.getTotal());
		return ticketVenta;
		
	}
	
	
}
