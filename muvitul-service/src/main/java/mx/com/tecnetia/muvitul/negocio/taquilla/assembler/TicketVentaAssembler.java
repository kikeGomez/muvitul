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
		ticketVO.setNombreCine("The Movie Company");
		ticketVO.setDireccion("Av. San Jeronimo Lidice No.777,Col. San Jeronimo Lidice Del. Alvaro ,Ciudad de Mexico");
		ticketVO.setRazonSocial("Tecnetia S.A de C.V");
 		ticketVO.setRfc ("PPL-9765456-F55F");
 		ticketVO.setTelefono("55-227-949-44");;
 		ticketVO.setFechaHoraCompra("05/05/2017");
		ticketVO.setIva(iva);
		ticketVO.setTotalPago(ticketVenta.getTotal());
		ticketVO.setCambio(new BigDecimal("111.00"));
		ticketVO.setRecibe(new BigDecimal("1000.00"));
 		//ticketVO.setFolioTicket((long)ticketVenta.getIdTicket());
		ticketVO.setNumeroOrdenTicket(new Long(1234567));
		ticketVO.setLeyenda("Aqui va la leyenda");
		ticketVO.setSlogan("SIN CINE NO HAY SUEÑOS !");
		ticketVO.setSugerencias("Si requiere factura entre al siguente portal de facturacion www.tecnetia.com.mx o llame al numero : (55) 234536345");

		return ticketVO;
	}
}
