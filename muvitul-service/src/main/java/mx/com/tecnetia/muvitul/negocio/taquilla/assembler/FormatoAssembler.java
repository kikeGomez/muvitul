package mx.com.tecnetia.muvitul.negocio.taquilla.assembler;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Formato;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.FormatoVO;

public class FormatoAssembler {

	public static FormatoVO getFormatoVO(Formato formato){

		if(formato==null)
			return null;
		
		FormatoVO formatoVO = new FormatoVO();
		formatoVO.setIdFormato(formato.getIdFormato());
		//formatoVO.setCineVO(cineVO);
		formatoVO.setNombre(formato.getNombre());
		formatoVO.setActivo(formato.isActivo());
		return formatoVO;
	}
}
