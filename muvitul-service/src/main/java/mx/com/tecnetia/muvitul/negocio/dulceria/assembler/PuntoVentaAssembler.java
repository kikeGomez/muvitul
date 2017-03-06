package mx.com.tecnetia.muvitul.negocio.dulceria.assembler;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.PuntoVenta;
import mx.com.tecnetia.muvitul.negocio.dulceria.vo.PuntoVentaVO;

public class PuntoVentaAssembler {

	public static PuntoVentaVO getPuntoVentaVO(PuntoVenta puntoVenta){

		if(puntoVenta==null )
			return null;
		
		PuntoVentaVO puntoVentaVO = new PuntoVentaVO();
		puntoVentaVO.setIdPuntoVenta(puntoVenta.getIdPuntoVenta());
		puntoVentaVO.setNombre(puntoVenta.getNombre());
		
		return puntoVentaVO;
	}
	
	
	public static PuntoVenta getPuntoVenta(PuntoVentaVO puntoVentaVO){

		if(puntoVentaVO==null )
			return null;

		PuntoVenta puntoVenta= new PuntoVenta();
		puntoVenta.setIdPuntoVenta(puntoVenta.getIdPuntoVenta());
		
		return puntoVenta;
	}
	
}
