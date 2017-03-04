package mx.com.tecnetia.muvitul.negocio.dulceria.assembler;

import java.util.ArrayList;
import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Paquete;
import mx.com.tecnetia.muvitul.negocio.dulceria.vo.PaqueteVO;

public class PaqueteAssembler {

	
	public static PaqueteVO getPaqueteVO(Paquete paquete){

		if(paquete==null )
			return null;
		
		PaqueteVO paqueteVO = new PaqueteVO();
		paqueteVO.setIdPaquete(paquete.getIdPaquete());
		//paqueteVO.setPuntoVentaVO(PuntoVentaAssembler.getPuntoVentaVO(paquete.getPuntoVenta()));
		paqueteVO.setNombre(paquete.getNombre());
		paqueteVO.setIcono(paquete.getIcono());
		paqueteVO.setActivo(paquete.isActivo());
		//paqueteVO.setProductos(ProductoAssembler.getProductosVO(paquete.getProductos()));
		paqueteVO.setPreciosXPaquete(PrecioXPaqueteAssembler.getPreciosXPaqueteVO(paquete.getPrecioXPaquetes()));

		return paqueteVO;
	}
	
	
	public static List<PaqueteVO> getPaquetesVO(List<Paquete> paquetes){

		if(paquetes==null || paquetes.isEmpty())
			return null;
		
		List<PaqueteVO> paquetesVO = new ArrayList<PaqueteVO>();
		
		for (Paquete paquete : paquetes) {
			paquetesVO.add(PaqueteAssembler.getPaqueteVO(paquete));
		}

		return paquetesVO;
	}
	
}
