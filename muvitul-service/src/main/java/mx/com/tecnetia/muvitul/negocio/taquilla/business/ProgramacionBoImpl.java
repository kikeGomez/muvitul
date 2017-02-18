package mx.com.tecnetia.muvitul.negocio.taquilla.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.ProgramacionDao;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Programacion;
import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;

@Service
@Transactional
public class ProgramacionBoImpl implements ProgramacionBo {
	@Autowired
	private ProgramacionDao programacionDao;

	@Override
	public List<ProgramacionVo> findByCineAndDay() throws BusinessGlobalException {
		List <ProgramacionVo> programaciones = new ArrayList<ProgramacionVo>();
		
		//List<Programacion> list= programacionDao.findByCineAndDay();
		Integer idPelicula=0;
		ProgramacionVo programacionVo = null;
		
		for (Programacion programacion : programacionDao.findByCineAndDay()) {
			System.out.println("Titulo: "+programacion.getPelicula().getTitulo());
			if (!programacion.getPelicula().getIdPelicula().equals(idPelicula)){
				programacionVo= new ProgramacionVo();
				programacionVo.setNombrePelicula(programacion.getPelicula().getTitulo());
				programaciones.add(programacionVo);
			}		
			idPelicula=programacion.getPelicula().getIdPelicula();
//			Programacion copy= new Programacion();
//			ResponseConverter.copiarPropiedades(programacion, copy);
			Programacion pgr= new Programacion();
			pgr.setDiaSemana(programacion.getDiaSemana());
			pgr.setHorario(new Date());
			programacionVo.addProgramacion(pgr);

		}

		return programaciones;
	}
	
}
