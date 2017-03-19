package mx.com.tecnetia.muvitul.negocio.taquilla.assembler;

import java.math.BigDecimal;
import java.util.Date;

import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.UsuarioFirmadoVO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.PuntoVenta;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.TicketVenta;

public class TicketVentaAssembler {

	public static TicketVenta getTicketVenta(UsuarioFirmadoVO usuarioVO, PuntoVenta puntoVenta, BigDecimal descuento,
			BigDecimal importe, BigDecimal total) {

		if (usuarioVO == null)
			return null;

		TicketVenta ticketVenta = new TicketVenta();
		ticketVenta.setPuntoVenta(puntoVenta);
		ticketVenta.setUsuario(UsuarioAssembler.getUsuario(usuarioVO));
		ticketVenta.setFecha(new Date());
		ticketVenta.setDescuento(descuento);
		ticketVenta.setImporte(importe);
		ticketVenta.setTotal(total);

		return ticketVenta;

	}

}
