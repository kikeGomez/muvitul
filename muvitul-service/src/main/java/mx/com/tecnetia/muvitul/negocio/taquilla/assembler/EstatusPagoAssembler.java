package mx.com.tecnetia.muvitul.negocio.taquilla.assembler;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.EstatusPago;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.EstatusPagoVO;

public class EstatusPagoAssembler {

	public static EstatusPago getEstatusPago(EstatusPagoVO estatusPagoVO){

		if(estatusPagoVO==null )
			return null;

		EstatusPago estatusPago= new EstatusPago();
		estatusPagoVO.setIdEstatus(estatusPagoVO.getIdEstatus());
		return estatusPago;
	}
	
	
}
