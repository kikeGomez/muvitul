package mx.com.tecnetia.muvitul.negocio.dulceria.vo;

import java.util.List;

public class PaqueteVO {
	private Integer idPaquete;
	private PuntoVentaVO puntoVentaVO;
	private String nombre;
	private byte[] icono;
	private boolean activo;
	private List<ProductoVO> productos;
	private List<PrecioXPaqueteVO> preciosXPaquete;
	
	public Integer getIdPaquete() {
		return idPaquete;
	}
	public void setIdPaquete(Integer idPaquete) {
		this.idPaquete = idPaquete;
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
	public List<ProductoVO> getProductos() {
		return productos;
	}
	public void setProductos(List<ProductoVO> productos) {
		this.productos = productos;
	}
	public List<PrecioXPaqueteVO> getPreciosXPaquete() {
		return preciosXPaquete;
	}
	public void setPreciosXPaquete(List<PrecioXPaqueteVO> preciosXPaquete) {
		this.preciosXPaquete = preciosXPaquete;
	}

}
