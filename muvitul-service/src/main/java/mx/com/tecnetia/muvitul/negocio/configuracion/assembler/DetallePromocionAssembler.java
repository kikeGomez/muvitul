package mx.com.tecnetia.muvitul.negocio.configuracion.assembler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.DetallePromocion;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.DetallePromocionVO;

public class DetallePromocionAssembler {

	public static DetallePromocionVO getDetallePromocionVO(DetallePromocion detallePromocion){

		if(detallePromocion==null )
			return null;
		
		DetallePromocionVO detallePromocionVO = new DetallePromocionVO();
		detallePromocionVO.setIdDetallePromocion(detallePromocion.getIdDetallePromocion());
		detallePromocionVO.setProductoVO(ProductoAssembler.getProductoVO(detallePromocion.getProducto()));
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
	
	
	public static DetallePromocion getDetallePromocion(DetallePromocionVO detallePromocionVO){

		if(detallePromocionVO==null )
			return null;
		
		DetallePromocion detallePromocion = new DetallePromocion();
		detallePromocion.setProducto(ProductoAssembler.getProducto(detallePromocionVO.getProductoVO().getIdProducto()));
		detallePromocion.setRegalo(RegaloAssembler.getRegalo(detallePromocionVO.getRegaloVO().getIdRegalo()));
		detallePromocion.setVarN(detallePromocionVO.getVarN());
		detallePromocion.setVarM(detallePromocionVO.getVarM());
		detallePromocion.setPrecio(detallePromocionVO.getPrecio());
		detallePromocion.setPorcentaje(detallePromocionVO.getPorcentaje());
		
		return detallePromocion;
	}
	
	
	public static Set<DetallePromocion> getDetallePromociones(List<DetallePromocionVO> detallePromocionesVO){

		if(detallePromocionesVO==null || detallePromocionesVO.isEmpty())
			return null;
		
		Set<DetallePromocion> detallePromociones = new HashSet<DetallePromocion>();
		
		for (DetallePromocionVO detallePromocionVO : detallePromocionesVO) {
			detallePromociones.add(DetallePromocionAssembler.getDetallePromocion(detallePromocionVO));
		}

		return detallePromociones;
	}
	
	
}
