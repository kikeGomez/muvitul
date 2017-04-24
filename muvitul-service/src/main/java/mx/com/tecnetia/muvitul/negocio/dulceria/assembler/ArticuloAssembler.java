package mx.com.tecnetia.muvitul.negocio.dulceria.assembler;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Articulo;
import mx.com.tecnetia.muvitul.negocio.dulceria.vo.ArticuloVO;

public class ArticuloAssembler {

	public static ArticuloVO getArticuloVO(Articulo articulo){

		if(articulo==null )
			return null;
		
		ArticuloVO  articuloVO = new ArticuloVO();
		articuloVO.setIdArticulo(articulo.getIdArticulo());
		articuloVO.setCineVO(CineAssembler.getCineVO(articulo.getCine()));
		articuloVO.setClasificacionArtVO(ClasificacionArtAssembler.getClasificacionArtVO(articulo.getClasificacionArt()));
		articuloVO.setUnidadMedidaVO(UnidadMedidaAssembler.getUnidadMedidaVO(articulo.getUnidadMedida()));
		articuloVO.setNombre(articulo.getNombre());
		articuloVO.setActivo(articulo.isActivo());
		articuloVO.setPuntoReorden(articulo.getPuntoReorden());		

		return articuloVO;
	}
	

	
}
