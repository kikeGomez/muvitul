package mx.com.tecnetia.muvitul.negocio.taquilla.assembler;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.BoletosXTicket;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.BoletosXTicketId;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.TicketVenta;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.BoletoXTicketVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.DetalleTicketVO;

public class BoletoXTicketAssembler {

	public static BoletosXTicket getBoletoXTicket(BoletoXTicketVO boletoXTicketVO, TicketVenta ticketVenta) {

		if (boletoXTicketVO == null)
			return null;

		BoletosXTicket boletoXTicket = new BoletosXTicket();
		BoletosXTicketId id = new BoletosXTicketId();
		id.setIdTicket(ticketVenta.getIdTicket());
		id.setIdTipoCliente(boletoXTicketVO.getTipoClienteVO().getIdTipoCliente());
		boletoXTicket.setId(id);
		boletoXTicket.setProgramacion(
				ProgramacionAssembler.getProgramacion(boletoXTicketVO.getProgramacionVO().getIdProgramacion()));
		boletoXTicket.setTicketVenta(ticketVenta);
		boletoXTicket.setTipoCliente(
				TipoClienteAssembler.getTipoCliente(boletoXTicketVO.getTipoClienteVO().getIdTipoCliente()));
		boletoXTicket.setCantidad(boletoXTicketVO.getCantidad());
		boletoXTicket.setImporte(boletoXTicketVO.getImporte());
		boletoXTicket.setFechaExhibicion(boletoXTicketVO.getFechaExhibicion());

		return boletoXTicket;
	}

	public static List<BoletosXTicket> getBoletosXTicket(List<BoletoXTicketVO> boletosXTicketVO,
			TicketVenta ticketVenta) {

		if (boletosXTicketVO == null || boletosXTicketVO.isEmpty())
			return null;

		List<BoletosXTicket> boletosXTicket = new ArrayList<BoletosXTicket>();

		for (BoletoXTicketVO boletoXTicketVO : boletosXTicketVO) {
			if (boletoXTicketVO.getCantidad() > 0) {
				boletosXTicket.add(BoletoXTicketAssembler.getBoletoXTicket(boletoXTicketVO, ticketVenta));
			}

		}

		return boletosXTicket;
	}

	public static DetalleTicketVO getDetalleTicketVO(BoletosXTicket boletoXTicket) {

		if (boletoXTicket == null)
			return null;

		BigDecimal precio = new BigDecimal(0);
		precio=	precio.add(boletoXTicket.getImporte());
		precio=precio.divide(new BigDecimal(boletoXTicket.getCantidad()), 2, BigDecimal.ROUND_HALF_EVEN);
		DetalleTicketVO detalleTicketVO = new DetalleTicketVO();
		detalleTicketVO.setCantidad(boletoXTicket.getCantidad());
		detalleTicketVO.setDescripcion(boletoXTicket.getTipoCliente().getNombre());
		detalleTicketVO.setPrecio(precio);
		detalleTicketVO.setSubtotal(boletoXTicket.getImporte());

		return detalleTicketVO;
	}

	public static List<DetalleTicketVO> getDetallesTicketVO(List<BoletosXTicket> boletosXTicket) {

		if (boletosXTicket == null || boletosXTicket.isEmpty())
			return null;

		List<DetalleTicketVO> detallesTicketVO = new ArrayList<DetalleTicketVO>();

		for (BoletosXTicket boletoXTicket : boletosXTicket) {
			detallesTicketVO.add(BoletoXTicketAssembler.getDetalleTicketVO(boletoXTicket));
		}

		return detallesTicketVO;
	}

}