package mx.com.tecnetia.muvitul.negocio.taquilla.assembler;

import java.util.Date;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.ExistenciaBoletos;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Programacion;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.ExistenciaBoletoVO;

public class ExistenciaBoletoAssembler {
	
	public static ExistenciaBoletoVO getExistenciaBoletoVO(ExistenciaBoletos existenciaBoleto, long disponibles){
		
		if(existenciaBoleto==null)
			return null;
		
		ExistenciaBoletoVO existenciaBoletoVO = new ExistenciaBoletoVO();
		existenciaBoletoVO.setIdExistenciaBoletos(existenciaBoleto.getIdExistenciaBoletos());
		existenciaBoletoVO.setProgramacionVO(ProgramacionAssembler.getProgramacionVO(existenciaBoleto.getProgramacion()));
		existenciaBoletoVO.setFechaExhibicion(existenciaBoleto.getFechaExhibicion());
		existenciaBoletoVO.setFechaReserva(existenciaBoleto.getFechaReserva());
		existenciaBoletoVO.setBoletosReservados(existenciaBoleto.getBoletosReservados());
		existenciaBoletoVO.setDisponibles(disponibles);
		return existenciaBoletoVO;
	}
	
	public static ExistenciaBoletoVO getExistenciaBoletoVO(Programacion programacion, Date fechaExhibicion, long disponibles){
		
		if(programacion==null && fechaExhibicion==null)
			return null;
	
		ExistenciaBoletoVO existenciaBoleto = new ExistenciaBoletoVO();
		existenciaBoleto.setIdExistenciaBoletos(null);
		existenciaBoleto.setProgramacionVO(ProgramacionAssembler.getProgramacionVO(programacion));
		existenciaBoleto.setFechaExhibicion(fechaExhibicion);
		existenciaBoleto.setBoletosReservados(0);
		existenciaBoleto.setFechaReserva(new Date());
		existenciaBoleto.setDisponibles(disponibles);
		
		return existenciaBoleto;
	}

	public static ExistenciaBoletos getExistenciaBoleto(ExistenciaBoletoVO existenciaBoletoVO) {
		if(existenciaBoletoVO==null)
			return null;
		
		ExistenciaBoletos existenciaBoleto = new ExistenciaBoletos();
		existenciaBoleto.setIdExistenciaBoletos(existenciaBoletoVO.getIdExistenciaBoletos());
		existenciaBoleto.setProgramacion(ProgramacionAssembler.getProgramacion(existenciaBoletoVO.getProgramacionVO().getIdProgramacion()));
		existenciaBoleto.setFechaExhibicion(existenciaBoletoVO.getFechaExhibicion());
		existenciaBoleto.setBoletosReservados(existenciaBoletoVO.getBoletosReservados());
		existenciaBoleto.setFechaReserva(existenciaBoletoVO.getFechaReserva());
		return existenciaBoleto;
	}
	

}
