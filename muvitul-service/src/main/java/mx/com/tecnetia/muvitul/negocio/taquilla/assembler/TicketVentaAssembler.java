package mx.com.tecnetia.muvitul.negocio.taquilla.assembler;

import java.math.BigDecimal;
import java.util.Date;

import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.UsuarioFirmadoVO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.PuntoVenta;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.TicketVenta;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.TicketVentaVO;

public class TicketVentaAssembler {

	public static TicketVenta getTicketVenta(UsuarioFirmadoVO usuarioVO, PuntoVenta puntoVenta, BigDecimal descuento,
			BigDecimal importe, BigDecimal total) {

		if (usuarioVO == null)
			return null;

		TicketVenta ticketVenta = new TicketVenta();
		ticketVenta.setPuntoVenta(puntoVenta);
		ticketVenta.setUsuario(UsuarioAssembler.getUsuario(usuarioVO.getId()));
		ticketVenta.setFecha(new Date());
		ticketVenta.setDescuento(descuento);
		ticketVenta.setImporte(importe);
		ticketVenta.setTotal(total);

		return ticketVenta;

	}
	
	public static TicketVenta getTicketVenta(Integer idTicket){

		if(idTicket==null )
			return null;
		
		TicketVenta ticketVenta = new TicketVenta();
		ticketVenta.setIdTicket(idTicket);

		return ticketVenta;
	}

	public static TicketVentaVO getTicketVentaVO(TicketVenta ticketVenta) {
		if (ticketVenta == null)
			return null;

		TicketVentaVO ticketVentaVO = new TicketVentaVO();
		ticketVentaVO.setIdTicket(ticketVenta.getIdTicket());
		ticketVentaVO.setPuntoVentaVO(PuntoVentaAssembler.getPuntoVentaVO(ticketVenta.getPuntoVenta()));
		ticketVentaVO.setUsuarioVO(UsuarioAssembler.getUsuarioVO(ticketVenta.getUsuario().getIdUsuario()));
		ticketVentaVO.setFecha(ticketVenta.getFecha());
		ticketVentaVO.setDescuento(ticketVenta.getImporte());
		ticketVentaVO.setImporte(ticketVenta.getImporte());
		ticketVentaVO.setTotal(ticketVenta.getTotal());
		return ticketVentaVO;
	}
	
}
