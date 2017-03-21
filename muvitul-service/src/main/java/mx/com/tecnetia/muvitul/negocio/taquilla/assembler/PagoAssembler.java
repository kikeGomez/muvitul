package mx.com.tecnetia.muvitul.negocio.taquilla.assembler;

import java.util.ArrayList;
import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Pago;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.PagoVO;

public class PagoAssembler {

	public static Pago getPago(PagoVO pagoVO, Integer idTicket){

		if(pagoVO==null )
			return null;

		Pago pago= new Pago();
		pago.setEstatusPago(EstatusPagoAssembler.getEstatusPago(pagoVO.getEstatusPagoVO().getIdEstatus()));
		pago.setFormaPago(FormaPagoAssembler.getFormaPago(pagoVO.getFormaPagoVO().getIdFormaPago()));
		pago.setTicketVenta(TicketVentaAssembler.getTicketVenta(idTicket));
		pago.setNoCuenta(pagoVO.getNoCuenta());
		pago.setImporte(pagoVO.getImporte());
		pago.setFecha(pagoVO.getFecha());
		
		return pago;
	}
	
	public static List<Pago> getPagos(List<PagoVO> pagosVO,Integer idTicket){

		if(pagosVO==null || pagosVO.isEmpty())
			return null;
		
		List<Pago> pagos = new ArrayList<Pago>();
		
		for (PagoVO pagoVO : pagosVO) {
			pagos.add(PagoAssembler.getPago(pagoVO,idTicket));
		}

		return pagos;
	}
	
}
