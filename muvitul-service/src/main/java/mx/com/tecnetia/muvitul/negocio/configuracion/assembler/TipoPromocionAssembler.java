package mx.com.tecnetia.muvitul.negocio.configuracion.assembler;

import java.util.ArrayList;
import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.TipoPromocion;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.TipoPromocionVO;

public class TipoPromocionAssembler {

	public static TipoPromocionVO getTipoPromocion(TipoPromocion tipoPromocion){

		if(tipoPromocion==null)
			return null;
		
		TipoPromocionVO tipoPromocionVO = new TipoPromocionVO();
		tipoPromocion.setIdTipoPromocion(tipoPromocion.getIdTipoPromocion());
		tipoPromocion.setNombre(tipoPromocion.getNombre());
		tipoPromocion.setDescripcion(tipoPromocion.getDescripcion());
		
		return tipoPromocionVO;
	}
	
	
	public static List<TipoPromocionVO> getTiposPromocionVO(List<TipoPromocion> tiposPromocion) {

		if (tiposPromocion == null || tiposPromocion.isEmpty())
			return null;

		List<TipoPromocionVO> tiposPromocionVO = new ArrayList<TipoPromocionVO>();

		for (TipoPromocion tipoPromocion : tiposPromocion) {
			tiposPromocionVO.add(TipoPromocionAssembler.getTipoPromocion(tipoPromocion));
		}

		return tiposPromocionVO;
	}
	
	
}
