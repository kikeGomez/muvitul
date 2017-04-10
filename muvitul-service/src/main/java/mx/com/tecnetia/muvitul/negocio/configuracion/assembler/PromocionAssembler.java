package mx.com.tecnetia.muvitul.negocio.configuracion.assembler;

import java.util.ArrayList;
import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Promocion;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.PromocionVO;

public class PromocionAssembler {

	
	public static Promocion getPromocion(PromocionVO promocionVO){

		if(promocionVO==null )
			return null;
		
		Promocion promocion = new Promocion();

		return promocion;
	}
	
	
	public static PromocionVO getPromocionVO(Promocion promocion){

		if(promocion==null )
			return null;
		
		PromocionVO promocionVO = new PromocionVO();
		promocionVO.setIdPromocion(promocion.getIdPromocion());
		promocionVO.setCineVO(CineAssembler.getCineVO(promocion.getCine()));
		promocionVO.setPromocionParaVO(PromocionParaAssembler.getPromocionPara(promocion.getPromocionPara()));
		promocionVO.setTipoPromocionVO(TipoPromocionAssembler.getTipoPromocion(promocion.getTipoPromocion()));
		promocionVO.setNombre(promocion.getNombre());
		promocionVO.setDescripcion(promocion.getDescripcion());
		promocionVO.setFechaInicio(promocion.getFechaInicio());
		promocionVO.setFechaFin(promocion.getFechaFin());
		promocionVO.setDetallePromocionesVO(DetallePromocionAssembler.getDetallePromocionesVO(promocion.getDetallePromocions()));
		
		return promocionVO;
	}
	
	
	public static List<PromocionVO> getPromocionesVO(List<Promocion> promociones){

		if(promociones==null || promociones.isEmpty())
			return null;
		
		List<PromocionVO> promocionesVO = new ArrayList<PromocionVO>();
		
		for (Promocion promocion : promociones) {
			promocionesVO.add(PromocionAssembler.getPromocionVO(promocion));
		}

		return promocionesVO;
	}
	
}