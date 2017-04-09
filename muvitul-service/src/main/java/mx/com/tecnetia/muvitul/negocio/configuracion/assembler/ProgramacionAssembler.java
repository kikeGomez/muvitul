package mx.com.tecnetia.muvitul.negocio.configuracion.assembler;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Programacion;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.ProgramacionVO;

public class ProgramacionAssembler {

	public static ProgramacionVO getProgramacionVO(Programacion programacion){
		
		if(programacion==null)
			return null;
		
		ProgramacionVO programacionVO = new ProgramacionVO();
		programacionVO.setIdProgramacion(programacion.getIdProgramacion());
		programacionVO.setFormatoVO(FormatoAssembler.getFormatoVO(programacion.getFormato()));
		programacionVO.setPeliculaVO(PeliculaAssembler.getPeliculaVO(programacion.getPelicula()));
		programacionVO.setSalaVO(SalaAssembler.getSalaVO(programacion.getSala()));
		programacionVO.setVersionVO(VersionAssembler.getVersionVO(programacion.getVersion()));
		programacionVO.setDiaSemana(programacion.getDiaSemana());
		programacionVO.setHorario(programacion.getHorario());
		programacionVO.setFechaVigencia(programacion.getFechaVigencia());
	
		return programacionVO;
	}

	public static Programacion getProgramacion(ProgramacionVO programacionVO) {
		
		if(programacionVO==null)
			return null;
		
		Programacion programacion = new Programacion();
		programacion.setSala(SalaAssembler.getSala(programacionVO.getSalaVO().getIdSala()));
		programacion.setDiaSemana(programacionVO.getDiaSemana());
		programacion.setPelicula(PeliculaAssembler.getPelicula(programacionVO.getIdProgramacion()));
		programacion.setFormato(FormatoAssembler.getFormato(programacionVO.getFormatoVO().getIdFormato()));
		programacion.setVersion(VersionAssembler.getVersion(programacionVO.getVersionVO().getIdVersion()));
		programacion.setHorario(programacionVO.getHorario());
		programacion.setFechaVigencia(programacionVO.getFechaVigencia());
		
		return programacion;
	}
	
}
