package mx.com.tecnetia.muvitul.negocio.configuracion.assembler;

import java.util.ArrayList;
import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Paquete;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.PaqueteVO;

public class PaqueteAssembler {

	public static PaqueteVO getPaqueteVO(Paquete paquete){
		
		if(paquete==null)
			return null;
		
		PaqueteVO paqueteVO = new PaqueteVO();
		paqueteVO.setIdPaquete(paquete.getIdPaquete());
		paqueteVO.setCineVO(CineAssembler.getCineVO(paquete.getCine()));
		paqueteVO.setNombre(paquete.getNombre());
		paqueteVO.setIcono(paquete.getIcono());
		paqueteVO.setActivo(paquete.isActivo());
		
		return paqueteVO;
	}
	
	public static List<PaqueteVO> getPaquetes(List<Paquete> paquetes){

		if(paquetes==null)
			return null;
		
		List<PaqueteVO> paquetesVO = new ArrayList<PaqueteVO>();
		
		for (Paquete paquete : paquetes) {
			paquetesVO.add(PaqueteAssembler.getPaqueteVO(paquete));
		}

		return paquetesVO;
	}
	
}