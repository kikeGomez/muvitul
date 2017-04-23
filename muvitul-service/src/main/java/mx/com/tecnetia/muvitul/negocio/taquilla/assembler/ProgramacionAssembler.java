package mx.com.tecnetia.muvitul.negocio.taquilla.assembler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Programacion;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.ProgramacionVO;
import mx.com.tecnetia.muvitul.servicios.util.Fecha;

public class ProgramacionAssembler {

	public static ProgramacionVO getProgramacionVO(Programacion programacion) {

		if (programacion == null)
			return null;

		ProgramacionVO programacionVO = new ProgramacionVO();
		programacionVO.setIdProgramacion(programacion.getIdProgramacion());
		programacionVO.setFormatoVO(FormatoAssembler.getFormatoVO(programacion.getFormato()));
		programacionVO.setSalaVO(SalaAssembler.getSalaVO(programacion.getSala()));
		programacionVO.setVersionVO(VersionAssembler.getVersionVO(programacion.getVersion()));
		programacionVO.setDiaSemana(programacion.getDiaSemana());
		programacionVO.setHorario(programacion.getHorario());
		programacionVO.setFechaVigencia(Fecha.formatddMMyyyy(programacion.getFechaVigencia()));
		programacionVO.setActivo(programacion.isActivo());

		return programacionVO;
	}

	public static Programacion getProgramacion(Integer idProgramacion) {

		if (idProgramacion == null)
			return null;

		Programacion programacion = new Programacion();
		programacion.setIdProgramacion(idProgramacion);

		return programacion;
	}

}
