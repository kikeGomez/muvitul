package mx.com.tecnetia.muvitul.negocio.configuracion.assembler;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Programacion;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.ProgramacionVO;
import mx.com.tecnetia.muvitul.servicios.util.Fecha;

public class ProgramacionAssembler {

	public static ProgramacionVO getProgramacionVO(Programacion programacion) {

		if (programacion == null)
			return null;

		DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
		ProgramacionVO programacionVO = new ProgramacionVO();
		programacionVO.setIdProgramacion(programacion.getIdProgramacion());
		programacionVO.setFormatoVO(FormatoAssembler.getFormatoVO(programacion.getFormato()));
		programacionVO.setPeliculaVO(PeliculaAssembler.getPeliculaVO(programacion.getPelicula()));
		programacionVO.setSalaVO(SalaAssembler.getSalaVO(programacion.getSala()));
		programacionVO.setVersionVO(VersionAssembler.getVersionVO(programacion.getVersion()));
		programacionVO.setDiaSemana(programacion.getDiaSemana());
		programacionVO.setHorario(hourFormat.format(programacion.getHorario()));
		programacionVO.setFechaVigencia(programacion.getFechaVigencia());
		programacionVO.setActivo(programacion.isActivo());
		
		return programacionVO;
	}

	public static Programacion getProgramacion(ProgramacionVO programacionVO) {

		if (programacionVO == null)
			return null;


		Programacion programacion = new Programacion();
		programacion.setSala(SalaAssembler.getSala(programacionVO.getSalaVO().getIdSala()));
		programacion.setDiaSemana(programacionVO.getDiaSemana());
		programacion.setPelicula(PeliculaAssembler.getPelicula(programacionVO.getPeliculaVO().getIdPelicula()));
		programacion.setFormato(FormatoAssembler.getFormato(programacionVO.getFormatoVO().getIdFormato()));
		programacion.setVersion(VersionAssembler.getVersion(programacionVO.getVersionVO().getIdVersion()));
		programacion.setHorario(Fecha.getTime(programacionVO.getHorario()));
		programacion.setFechaVigencia(programacionVO.getFechaVigencia());
		programacion.setActivo(programacionVO.isActivo());

		return programacion;
	}

}
