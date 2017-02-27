package mx.com.tecnetia.muvitul.negocio.dulceria.assembler;

import java.util.ArrayList;
import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.PrecioXProducto;
import mx.com.tecnetia.muvitul.negocio.dulceria.vo.PrecioXProductoVO;

public class PrecioXProductoAssembler {

	public static PrecioXProductoVO getPrecioXProductoVO(PrecioXProducto precioXProducto){

		if(precioXProducto==null )
			return null;
		
		PrecioXProductoVO precioXProductoVO = new PrecioXProductoVO();
		precioXProductoVO.setIdPrecioXProducto(precioXProducto.getIdPrecioXProducto());
		precioXProductoVO.setProductoVO(ProductoAssembler.getProductoVO(precioXProducto.getProducto()));
		precioXProductoVO.setPrecio(precioXProducto.getPrecio());
		precioXProductoVO.setActivo(precioXProducto.isActivo());
		
		return precioXProductoVO;
	}
	
	public static List<PrecioXProductoVO> getPreciosXProductoVO(List<PrecioXProducto> preciosXProducto){

		if(preciosXProducto==null || preciosXProducto.isEmpty())
			return null;
		
		List<PrecioXProductoVO> preciosXProductoVO = new ArrayList<PrecioXProductoVO>();
		
		for (PrecioXProducto precioXProducto : preciosXProducto) {
			preciosXProductoVO.add(PrecioXProductoAssembler.getPrecioXProductoVO(precioXProducto));
		}

		return preciosXProductoVO;
	}
	
	
}
