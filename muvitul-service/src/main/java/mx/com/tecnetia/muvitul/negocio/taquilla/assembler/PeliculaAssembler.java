package mx.com.tecnetia.muvitul.negocio.taquilla.assembler;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Pelicula;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.PeliculaVO;

public class PeliculaAssembler {

	public static PeliculaVO getPeliculaVO(Pelicula pelicula){

		if(pelicula==null)
			return null;
		
		PeliculaVO peliculaVO = new PeliculaVO();
		peliculaVO.setIdPelicula(pelicula.getIdPelicula());
		peliculaVO.setTitulo(pelicula.getTitulo());
		peliculaVO.setClasificacion(pelicula.getClasificacion());
		peliculaVO.setDuracion(pelicula.getDuracion());
		peliculaVO.setSinopsis(pelicula.getSinopsis());
		peliculaVO.setActivo(pelicula.isActivo());
		return peliculaVO;
	}

	
}
