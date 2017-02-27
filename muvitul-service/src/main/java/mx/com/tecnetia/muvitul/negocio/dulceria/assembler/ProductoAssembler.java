package mx.com.tecnetia.muvitul.negocio.dulceria.assembler;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Producto;
import mx.com.tecnetia.muvitul.negocio.dulceria.vo.ProductoVO;

public class ProductoAssembler {

	public static ProductoVO getProductoVO(Producto producto){

		if(producto==null )
			return null;
		
		ProductoVO productoVO = new ProductoVO();
		productoVO.setIdProducto(producto.getIdProducto());
		productoVO.setPuntoVentaVO(PuntoVentaAssembler.getPuntoVentaVO(producto.getPuntoVenta()));
		productoVO.setNombre(producto.getNombre());
		productoVO.setIcono(producto.getIcono());
		productoVO.setActivo(producto.isActivo());
		//productoVO.setPreciosXProductoVO(PrecioXProductoAssembler.getPreciosXProductoVO(producto.getPrecioXProductos()));

		return productoVO;
	}
	
	public static List<ProductoVO> getProductosVO(Set<Producto> productos){

		if(productos==null || productos.isEmpty())
			return null;
		
		List<ProductoVO> productosVO = new ArrayList<ProductoVO>();
		
		for (Producto producto : productos) {
			productosVO.add(ProductoAssembler.getProductoVO(producto));
		}

		return productosVO;
	}
	
}
