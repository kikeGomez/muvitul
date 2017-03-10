package mx.com.tecnetia.muvitul.negocio.taquilla.assembler;

import java.util.Date;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.ExistenciaBoletos;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Programacion;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.ExistenciaBoletoVO;

public class ExistenciaBoletoAssembler {
	
	public static ExistenciaBoletoVO getExistenciaBoletoVO(ExistenciaBoletos existenciaBoleto){
		
		if(existenciaBoleto==null)
			return null;
		
		ExistenciaBoletoVO existenciaBoletoVO = new ExistenciaBoletoVO();
		existenciaBoletoVO.setIdExistenciaBoletos(existenciaBoleto.getIdExistenciaBoletos());
		existenciaBoletoVO.setProgramacionVO(ProgramacionAssembler.getProgramacionVO(existenciaBoleto.getProgramacion()));
		existenciaBoletoVO.setFechaExhibicion(existenciaBoleto.getFechaExhibicion());
		existenciaBoletoVO.setIdExistenciaBoletos(existenciaBoleto.getIdExistenciaBoletos());

		return existenciaBoletoVO;
	}
	
	public static ExistenciaBoletos getExistenciaBoleto(Integer idProgramacion){
		
		if(idProgramacion==null)
			return null;
		
		ExistenciaBoletos existenciaBoleto = new ExistenciaBoletos();
		existenciaBoleto.setProgramacion(ProgramacionAssembler.getProgramacion(idProgramacion));
		existenciaBoleto.setFechaExhibicion(new Date());
		existenciaBoleto.setIdExistenciaBoletos(0);

		return existenciaBoleto;
	}

	public static ExistenciaBoletos getExistenciaBoleto(ExistenciaBoletoVO existenciaBoletoVO) {
		if(existenciaBoletoVO==null)
			return null;
		
		ExistenciaBoletos existenciaBoleto = new ExistenciaBoletos();
		existenciaBoleto.setProgramacion(ProgramacionAssembler.getProgramacion(existenciaBoletoVO.getProgramacionVO().getIdProgramacion()));
		existenciaBoleto.setFechaExhibicion(existenciaBoletoVO.getFechaExhibicion());
		existenciaBoleto.setIdExistenciaBoletos(0);
		return existenciaBoleto;
	}

}
