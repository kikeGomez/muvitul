package mx.com.tecnetia.muvitul.negocio.dulceria.assembler;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.ProductosXPaquete;
import mx.com.tecnetia.muvitul.negocio.dulceria.vo.ProductoXPaqueteVO;

public class ProductoXPaqueteAssembler {

	public static ProductoXPaqueteVO getProductoXPaqueteVO(ProductosXPaquete productoXPaquete){

		if(productoXPaquete==null )
			return null;
		
		ProductoXPaqueteVO  productoXPaqueteVO = new ProductoXPaqueteVO();
		productoXPaqueteVO.setId(productoXPaquete.getId());
		productoXPaqueteVO.setProductoVO(ProductoAssembler.getProductoVO(productoXPaquete.getProducto()));
		productoXPaqueteVO.setCantidad(productoXPaquete.getCantidad());

		return productoXPaqueteVO;
	}
	
	public static List<ProductoXPaqueteVO> getProductoXPaqueteVO(Set<ProductosXPaquete> productosXPaquete){

		if(productosXPaquete==null || productosXPaquete.isEmpty())
			return null;
		
		List<ProductoXPaqueteVO> productosXPaqueteVO = new ArrayList<ProductoXPaqueteVO>();
		
		for (ProductosXPaquete productoXPaquete : productosXPaquete) {
			productosXPaqueteVO.add(ProductoXPaqueteAssembler.getProductoXPaqueteVO(productoXPaquete));
		}
		
		return productosXPaqueteVO;
	}
	
}
