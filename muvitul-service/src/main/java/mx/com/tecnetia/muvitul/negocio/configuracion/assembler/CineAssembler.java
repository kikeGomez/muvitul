package mx.com.tecnetia.muvitul.negocio.configuracion.assembler;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Cine;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.CineVO;

public class CineAssembler {

	public static CineVO getCineVO(Cine cine){
		if(cine==null)
			return null;
		
		CineVO cineVO = new CineVO();
		cineVO.setIdCine(cine.getIdCine());
		cineVO.setNombre(cine.getNombre());
		cineVO.setActivo(cine.isActivo());
		
		return cineVO;
	}
	
	public static Cine getCine(Integer idCine){
		
		if(idCine==null)
			return null;
		
		Cine cine = new Cine();
		cine.setIdCine(idCine);

		
		return cine;
	}
	
}
