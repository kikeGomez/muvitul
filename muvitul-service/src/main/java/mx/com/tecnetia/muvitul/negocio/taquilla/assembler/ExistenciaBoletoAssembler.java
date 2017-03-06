package mx.com.tecnetia.muvitul.negocio.taquilla.assembler;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.ExistenciaBoletos;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.ExistenciaBoletoVO;

public class ExistenciaBoletoAssembler {
	
	public static ExistenciaBoletoVO getExistenciaBoletoVO(ExistenciaBoletos existenciaBoleto){
		
		if(existenciaBoleto==null)
			return null;
		
		ExistenciaBoletoVO existenciaBoletoVO = new ExistenciaBoletoVO();
		existenciaBoletoVO.setIdExistenciaBoletos(existenciaBoleto.getIdExistenciaBoletos());
		existenciaBoletoVO.setFechaExhibicion(existenciaBoleto.getFechaExhibicion());
		existenciaBoletoVO.setIdExistenciaBoletos(existenciaBoleto.getIdExistenciaBoletos());

		return existenciaBoletoVO;
	}
	

}
