package mx.com.tecnetia.muvitul.negocio.dulceria.vo;

import java.util.List;

public class PaqueteVO {
	private Integer idPaquete;
	private CineVO cineVO;
	private String nombre;
	private byte[] icono;
	private boolean activo;
	private List<ProductoXPaqueteVO> productosXPaquete;
	private List<PrecioXPaqueteVO> preciosXPaquete;
	
	public Integer getIdPaquete() {
		return idPaquete;
	}
	public void setIdPaquete(Integer idPaquete) {
		this.idPaquete = idPaquete;
	}
	public CineVO getCineVO() {
		return cineVO;
	}
	public void setCineVO(CineVO cineVO) {
		this.cineVO = cineVO;
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
	public List<ProductoXPaqueteVO> getProductosXPaquete() {
		return productosXPaquete;
	}
	public void setProductosXPaquete(List<ProductoXPaqueteVO> productosXPaquete) {
		this.productosXPaquete = productosXPaquete;
	}
	public List<PrecioXPaqueteVO> getPreciosXPaquete() {
		return preciosXPaquete;
	}
	public void setPreciosXPaquete(List<PrecioXPaqueteVO> preciosXPaquete) {
		this.preciosXPaquete = preciosXPaquete;
	}
	
}
