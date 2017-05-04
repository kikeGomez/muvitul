package mx.com.tecnetia.muvitul.negocio.taquilla.assembler;

import java.math.BigDecimal;
import java.util.Date;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.TicketVenta;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.TicketVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.TicketVentaVO;

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
	
	public static TicketVO getTicketVO(TicketVenta ticketVenta) {
		
		if (ticketVenta == null)
			return null;

		BigDecimal iva= new BigDecimal(0);
		iva=iva.add(ticketVenta.getTotal());
		iva=iva.subtract(ticketVenta.getDescuento());
		iva=iva.subtract(ticketVenta.getImporte());
		TicketVO ticketVO = new TicketVO();
		ticketVO.setTituloTicket("The Movie Company");
		ticketVO.setAvenidaEmpresa("Av. San Jeronimo Lidice No.777 ");
		ticketVO.setNombreEmpresa("Tecnetia S.A de C.V");
		ticketVO.setColoniaEmpresa("Col. San Jeronimo Lidice Del. Alvaro");
		ticketVO.setRfcEmpresa("PPL-9765456-F55F");
		ticketVO.setIva(iva);
		ticketVO.setTotalPago(ticketVenta.getTotal());
		//ticketVO.setFolioTicket((long)ticketVenta.getIdTicket());
		ticketVO.setFolioTicket(new Long(1234567));
		ticketVO.setLeyenda("Si requiere factura entre al siguente portal de facturacion www.tecnetia.com.mx o llame al numero : (55) 234536345");

		return ticketVO;
	}
}
