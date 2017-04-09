package mx.com.tecnetia.muvitul.negocio.configuracion.assembler;

import java.util.ArrayList;
import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Pelicula;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.PeliculaVO;

public class PeliculaAssembler {

	public static PeliculaVO getPeliculaVO(Pelicula pelicula) {
		if (pelicula == null)
			return null;

		PeliculaVO peliculaVO = new PeliculaVO();
		peliculaVO.setIdPelicula(pelicula.getIdPelicula());
		peliculaVO.setCineVO(CineAssembler.getCineVO(pelicula.getCine()));
		peliculaVO.setTitulo(pelicula.getTitulo());
		peliculaVO.setClasificacion(pelicula.getClasificacion());
		peliculaVO.setDuracion(pelicula.getDuracion());
		peliculaVO.setSinopsis(pelicula.getSinopsis());
		peliculaVO.setActivo(pelicula.isActivo());
		peliculaVO.setIcono(pelicula.getIcono());

		return peliculaVO;
	}

	public static List<PeliculaVO> getPeliculasVO(List<Pelicula> peliculas) {

		if (peliculas == null || peliculas.isEmpty())
			return null;

		List<PeliculaVO> peliculasVO = new ArrayList<PeliculaVO>();

		for (Pelicula pelicula : peliculas) {
			peliculasVO.add(PeliculaAssembler.getPeliculaVO(pelicula));
		}

		return peliculasVO;
	}
	

	public static Pelicula getPelicula(Integer idPelicula) {
		
		if (idPelicula == null)
			return null;

		Pelicula pelicula = new Pelicula();
		pelicula.setIdPelicula(idPelicula);

		return pelicula;
	}

	

}
