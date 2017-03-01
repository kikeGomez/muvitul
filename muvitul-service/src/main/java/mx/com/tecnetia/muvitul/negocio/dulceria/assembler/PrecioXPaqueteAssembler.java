package mx.com.tecnetia.muvitul.negocio.dulceria.assembler;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.PrecioXPaquete;
import mx.com.tecnetia.muvitul.negocio.dulceria.vo.PrecioXPaqueteVO;

public class PrecioXPaqueteAssembler {

	public static PrecioXPaqueteVO getPrecioXPaqueteVO(PrecioXPaquete precioXPaquete){

		if(precioXPaquete==null )
			return null;
		
		PrecioXPaqueteVO precioXPaqueteVO = new PrecioXPaqueteVO();
		precioXPaqueteVO.setIdPrecioXPaquete(precioXPaquete.getIdPrecioXPaquete());
		//precioXPaqueteVO.setPaqueteVO(PaqueteAssembler.getPaqueteVO(precioXPaquete.getPaquete()));
		precioXPaqueteVO.setPrecio(precioXPaquete.getPrecio());
		precioXPaqueteVO.setActivo(precioXPaquete.isActivo());
		
		return precioXPaqueteVO;
	}
	
	public static List<PrecioXPaqueteVO> getPreciosXPaqueteVO(Set<PrecioXPaquete> preciosXPaquete){

		if(preciosXPaquete==null || preciosXPaquete.isEmpty())
			return null;
		
		List<PrecioXPaqueteVO> preciosXPaqueteVO = new ArrayList<PrecioXPaqueteVO>();
		
		for (PrecioXPaquete precioXPaquete : preciosXPaquete) {
			preciosXPaqueteVO.add(PrecioXPaqueteAssembler.getPrecioXPaqueteVO(precioXPaquete));
		}

		return preciosXPaqueteVO;
	}
	
}
