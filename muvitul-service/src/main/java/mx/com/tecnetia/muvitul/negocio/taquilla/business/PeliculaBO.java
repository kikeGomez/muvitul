package mx.com.tecnetia.muvitul.negocio.taquilla.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.ProgramacionDAO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Programacion;
import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.negocio.taquilla.assembler.PeliculaAssembler;
import mx.com.tecnetia.muvitul.negocio.taquilla.assembler.ProgramacionAssembler;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.PeliculaVO;

@Service
@Transactional
public class PeliculaBO implements PeliculaBOI {
	final static Log log = LogFactory.getLog(PeliculaBO.class);
	@Autowired
	private ProgramacionDAO programacionDAO;
	@Override
	
	public List<PeliculaVO> findByCineAndDay(Integer idCine, String diaSemana) throws BusinessGlobalException {

		Map <Integer, PeliculaVO> mapPeliculas= new HashMap<Integer,PeliculaVO>();
		
		for (Programacion programacion : programacionDAO.findByCineAndDay(idCine,diaSemana)) {
			log.debug("Titulo: "+programacion.getPelicula().getTitulo()+ " --> "+ programacion.getHorario());
			
			if (!mapPeliculas.containsKey(programacion.getPelicula().getIdPelicula())){
				mapPeliculas.put(programacion.getPelicula().getIdPelicula(), PeliculaAssembler.getPeliculaVO(programacion.getPelicula()));
			}
			
			PeliculaVO peliculaVO = mapPeliculas.get(programacion.getPelicula().getIdPelicula());
			peliculaVO.addProgramacion(ProgramacionAssembler.getProgramacionVO(programacion));
		}
		List <PeliculaVO> peliculas = new ArrayList<PeliculaVO>(mapPeliculas.values());
		return peliculas;
	}

}