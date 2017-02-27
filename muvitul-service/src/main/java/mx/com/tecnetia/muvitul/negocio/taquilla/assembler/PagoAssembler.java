package mx.com.tecnetia.muvitul.negocio.taquilla.assembler;

import java.util.ArrayList;
import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Pago;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.PagoVO;

public class PagoAssembler {

	public static Pago getPago(PagoVO pagoVO){

		if(pagoVO==null )
			return null;

		Pago pago= new Pago();
		pago.setFormaPago(FormaPagoAssembler.getFormaPago(pagoVO.getFormaPagoVO()));
		pago.setNoCuenta(pagoVO.getNoCuenta());
		pago.setImporte(pagoVO.getImporte());
		pago.setEstatusPago(EstatusPagoAssembler.getEstatusPago(pagoVO.getEstatusPagoVO()));
		pago.setFecha(pago.getFecha());
		
		return pago;
	}
	
	
	
	
	public static List<Pago> getPagos(List<PagoVO> pagosVO){

		if(pagosVO==null || pagosVO.isEmpty())
			return null;
		
		List<Pago> pagos = new ArrayList<Pago>();
		
		for (PagoVO pagoVO : pagosVO) {
			pagos.add(PagoAssembler.getPago(pagoVO));
		}

		return pagos;
	}
	
	
}
