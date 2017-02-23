package mx.com.tecnetia.muvitul.negocio.taquilla.assembler;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.DetallePromocion;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.DetallePromocionVO;

public class DetallePromocionAssembler {

	public static DetallePromocionVO getDetallePromocionVO(DetallePromocion detallePromocion){

		if(detallePromocion==null )
			return null;
		
		DetallePromocionVO detallePromocionVO = new DetallePromocionVO();
		detallePromocionVO.setIdDetallePromocion(detallePromocion.getIdDetallePromocion());
		detallePromocionVO.setRegaloVO(RegaloAssembler.getRegaloVO(detallePromocion.getRegalo()));
		detallePromocionVO.setVarN(detallePromocion.getVarN());
		detallePromocionVO.setVarM(detallePromocion.getVarM());
		detallePromocionVO.setPrecio(detallePromocion.getPrecio());
		detallePromocion.setPorcentaje(detallePromocion.getPorcentaje());
		
		return detallePromocionVO;
	}
	
	
	public static List<DetallePromocionVO> getDetallePromocionesVO(Set<DetallePromocion> detallePromociones){

		if(detallePromociones==null || detallePromociones.isEmpty())
			return null;
		
		List<DetallePromocionVO> detallePromocionesVO = new ArrayList<DetallePromocionVO>();
		
		for (DetallePromocion detallePromocion : detallePromociones) {
			detallePromocionesVO.add(DetallePromocionAssembler.getDetallePromocionVO(detallePromocion));
		}

		return detallePromocionesVO;
	}
	
}
