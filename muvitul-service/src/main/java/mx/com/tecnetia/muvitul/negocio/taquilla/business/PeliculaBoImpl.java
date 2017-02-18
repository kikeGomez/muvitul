package mx.com.tecnetia.muvitul.negocio.taquilla.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.PeliculaDao;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.ProgramacionDao;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Pelicula;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Programacion;
import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;

@Service
@Transactional
public class PeliculaBoImpl implements PeliculaBo {

	@Autowired
	private PeliculaDao peliculaDao;
	
	@Autowired
	private ProgramacionDao programacionDao;
	
	public List<Pelicula> findAll() throws BusinessGlobalException{
		List<Pelicula> list= peliculaDao.findByDay();
		
		for (Pelicula pelicula : list) {
			System.out.println("Titulo: "+pelicula.getTitulo());
		}
		
		return list;
	}

	@Override
	public List<Programacion> getProgramacionByCine() throws BusinessGlobalException {

		peliculaDao.findByDay();
//		List<Programacion> list= programacionDao.findByDay();
//		
//		for (Programacion programacion : list) {
//			System.out.println("Titulo: "+programacion.getIdProgramacion());
//		}
//		
		return null;
		
	}
	
}
