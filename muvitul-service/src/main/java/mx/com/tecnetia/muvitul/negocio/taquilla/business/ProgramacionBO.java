package mx.com.tecnetia.muvitul.negocio.taquilla.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.ProgramacionDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Programacion;
import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.PeliculaVO;

@Service
@Transactional
public class ProgramacionBO implements ProgramacionBOI {
	@Autowired
	private ProgramacionDAOI programacionDAO;

	@Override
	public List<PeliculaVO> findByCineAndDay() throws BusinessGlobalException {
		List <PeliculaVO> programaciones = new ArrayList<PeliculaVO>();
		
		//List<Programacion> list= programacionDao.findByCineAndDay();
		Integer idPelicula=0;
		PeliculaVO programacionVo = null;
		
		for (Programacion programacion : programacionDAO.findByCineAndDay()) {
//			System.out.println("Titulo: "+programacion.getPelicula().getTitulo());
//			if (!programacion.getPelicula().getIdPelicula().equals(idPelicula)){
//				programacionVo= new PeliculaVO();
//				programacionVo.setNombrePelicula(programacion.getPelicula().getTitulo());
//				programaciones.add(programacionVo);
//			}		
//			idPelicula=programacion.getPelicula().getIdPelicula();
////			Programacion copy= new Programacion();
////			ResponseConverter.copiarPropiedades(programacion, copy);
//			Programacion pgr= new Programacion();
//			pgr.setDiaSemana(programacion.getDiaSemana());
//			pgr.setHorario(new Date());
//			programacionVo.addProgramacion(pgr);

		}

		return null;
	}
	
}
