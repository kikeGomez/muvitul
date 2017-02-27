package mx.com.tecnetia.muvitul.negocio.taquilla.assembler;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.PuntoVenta;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.PuntoVentaVO;

public class PuntoVentaAssembler {

	public static PuntoVenta getPuntoVenta(PuntoVentaVO puntoVentaVO){

		if(puntoVentaVO==null )
			return null;

		PuntoVenta puntoVenta= new PuntoVenta();
		puntoVenta.setIdPuntoVenta(puntoVenta.getIdPuntoVenta());
		
		return puntoVenta;
	}
	
	
}
