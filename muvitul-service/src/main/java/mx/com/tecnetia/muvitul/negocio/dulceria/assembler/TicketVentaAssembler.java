package mx.com.tecnetia.muvitul.negocio.dulceria.assembler;

import java.math.BigDecimal;
import java.util.Date;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.TicketVenta;
import mx.com.tecnetia.muvitul.negocio.dulceria.vo.TicketVentaVO;

public class TicketVentaAssembler {

	public static TicketVenta getTicketVenta(Integer idUsuario, Integer idPuntoVenta, BigDecimal descuento,
			BigDecimal importe, BigDecimal total) {

		if (idUsuario == null || idPuntoVenta==null)
			return null;

		TicketVenta ticketVenta = new TicketVenta();
		ticketVenta.setPuntoVenta(PuntoVentaAssembler.getPuntoVenta(idPuntoVenta));
		ticketVenta.setUsuario(UsuarioAssembler.getUsuario(idUsuario));
		ticketVenta.setFecha(new Date());
		ticketVenta.setDescuento(descuento);
		ticketVenta.setImporte(importe);
		ticketVenta.setTotal(total);

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
