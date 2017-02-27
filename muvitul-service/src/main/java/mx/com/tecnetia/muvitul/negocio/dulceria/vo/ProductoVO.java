package mx.com.tecnetia.muvitul.negocio.dulceria.vo;

import java.util.List;

public class ProductoVO {
	private Integer idProducto;
	private PuntoVentaVO puntoVentaVO;
	private String nombre;
	private byte[] icono;
	private boolean activo;
	private List<PrecioXProductoVO> preciosXProductoVO;
	
	public Integer getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}
	public PuntoVentaVO getPuntoVentaVO() {
		return puntoVentaVO;
	}
	public void setPuntoVentaVO(PuntoVentaVO puntoVentaVO) {
		this.puntoVentaVO = puntoVentaVO;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public byte[] getIcono() {
		return icono;
	}
	public void setIcono(byte[] icono) {
		this.icono = icono;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public List<PrecioXProductoVO> getPreciosXProductoVO() {
		return preciosXProductoVO;
	}
	public void setPreciosXProductoVO(List<PrecioXProductoVO> preciosXProductoVO) {
		this.preciosXProductoVO = preciosXProductoVO;
	}
	
}
