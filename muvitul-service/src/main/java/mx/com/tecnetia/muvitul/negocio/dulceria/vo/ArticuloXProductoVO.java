package mx.com.tecnetia.muvitul.negocio.dulceria.vo;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.ArticulosXProductoId;

public class ArticuloXProductoVO {
	private ArticulosXProductoId id;
	private ArticuloVO articuloVO;
	//private Producto producto;
	private long cantidad;
	
	public ArticulosXProductoId getId() {
		return id;
	}
	public void setId(ArticulosXProductoId id) {
		this.id = id;
	}
	public ArticuloVO getArticuloVO() {
		return articuloVO;
	}
	public void setArticuloVO(ArticuloVO articuloVO) {
		this.articuloVO = articuloVO;
	}
	public long getCantidad() {
		return cantidad;
	}
	public void setCantidad(long cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
}
