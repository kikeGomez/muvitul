package mx.com.tecnetia.muvitul.negocio.dulceria.assembler;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Paquete;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Producto;
import mx.com.tecnetia.muvitul.negocio.dulceria.vo.PaqueteVO;

public class PaqueteAssembler {

	
	public static PaqueteVO getPaqueteVO(Paquete paquete){

		if(paquete==null )
			return null;
		
		PaqueteVO paqueteVO = new PaqueteVO();
		paqueteVO.setIdPaquete(paquete.getIdPaquete());
		paqueteVO.setPaquete(true);
		paqueteVO.setCineVO(CineAssembler.getCineVO(paquete.getCine()));
		paqueteVO.setNombre(paquete.getNombre());
		paqueteVO.setIcono(paquete.getIcono());
		paqueteVO.setActivo(paquete.isActivo());
		paqueteVO.setProductosXPaqueteVO(ProductoXPaqueteAssembler.getProductoXPaqueteVO(paquete.getProductosXPaquetes()));
		paqueteVO.setPreciosXPaqueteVO(PrecioXPaqueteAssembler.getPreciosXPaqueteVO(paquete.getPrecioXPaquetes()));

		return paqueteVO;
	}
	
	
	public static List<PaqueteVO> getPaquetesVO(Set<Paquete> paquetes){

		if(paquetes==null || paquetes.isEmpty())
			return null;
		
		List<PaqueteVO> paquetesVO = new ArrayList<PaqueteVO>();
		
		for (Paquete paquete : paquetes) {
			paquetesVO.add(PaqueteAssembler.getPaqueteVO(paquete));
		}

		return paquetesVO;
	}
	
	
	public static PaqueteVO getPaqueteVO(Producto producto){

		if(producto==null )
			return null;
		
		PaqueteVO paqueteVO = new PaqueteVO();
		paqueteVO.setIdPaquete(producto.getIdProducto());
		paqueteVO.setCineVO(CineAssembler.getCineVO(producto.getCine()));
		paqueteVO.setNombre(producto.getNombre());
		paqueteVO.setIcono(producto.getIcono());
		paqueteVO.setActivo(producto.isActivo());
		//paqueteVO.setProductosXPaquete(productosXPaquete);
		paqueteVO.setPreciosXPaqueteVO(PrecioXPaqueteAssembler.getPreciosXPaqueteVOXProducto(producto.getPrecioXProductos()));

		return paqueteVO;
	}
	
	
	public static List<PaqueteVO> getPaquetesVOXProducto(Set<Producto> productos){

		if(productos==null || productos.isEmpty())
			return null;
		
		List<PaqueteVO> paquetesVO = new ArrayList<PaqueteVO>();
		
		for (Producto producto : productos) {
			paquetesVO.add(PaqueteAssembler.getPaqueteVO(producto));
		}

		return paquetesVO;
	}
	
	
	public static Paquete getPaquete(Integer idPaquete){

		if(idPaquete==null )
			return null;
		
		Paquete paquete = new Paquete();
		paquete.setIdPaquete(idPaquete);

		return paquete;
	}
	
	
}
