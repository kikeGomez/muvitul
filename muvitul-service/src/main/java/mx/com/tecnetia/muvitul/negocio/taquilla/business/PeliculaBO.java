package mx.com.tecnetia.muvitul.negocio.taquilla.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.ProgramacionDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Programacion;
import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.negocio.taquilla.assembler.PeliculaAssembler;
import mx.com.tecnetia.muvitul.negocio.taquilla.assembler.ProgramacionAssembler;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.ExistenciaBoletoVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.PeliculaVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.ProgramacionVO;

@Service
@Transactional
public class PeliculaBO {
	final static Log log = LogFactory.getLog(PeliculaBO.class);
	@Autowired
	private ProgramacionDAOI programacionDAO;

	@Autowired
	private ExistenciaBoletoBO existenciaBoletoBO;

	public List<PeliculaVO> findByCineDiaAndExhibicion(Integer idCine, String diaSemana, Date fechaExhibicion)
			throws BusinessGlobalException {
		Map<Integer, PeliculaVO> mapPeliculas = new HashMap<Integer, PeliculaVO>();

		List<Programacion> programaciones = programacionDAO.findByCineDiaAndExhibicion(idCine, diaSemana,
				fechaExhibicion);

		for (Programacion programacion : programaciones) {

			if (!mapPeliculas.containsKey(programacion.getPelicula().getIdPelicula())) {
				mapPeliculas.put(programacion.getPelicula().getIdPelicula(),
						PeliculaAssembler.getPeliculaVO(programacion.getPelicula()));
			}

			ExistenciaBoletoVO ExistenciaBoletoVO = existenciaBoletoBO.findByProgramacionSalaAndExhibicion(
					programacion.getIdProgramacion(), programacion.getSala().getIdSala(), fechaExhibicion);

			PeliculaVO peliculaVO = mapPeliculas.get(programacion.getPelicula().getIdPelicula());
			ProgramacionVO programacionVO = ProgramacionAssembler.getProgramacionVO(programacion);
			programacionVO.setExistenciaBoletoVO(ExistenciaBoletoVO);
			peliculaVO.addProgramacionVO(programacionVO);

		}

		return new ArrayList<PeliculaVO>(mapPeliculas.values());
	}

}
