package mx.com.tecnetia.muvitul.negocio.dulceria.vo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Cine;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.PaquetesXTicket;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.PrecioXPaquete;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.ProductosXPaquete;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.PuntoVenta;

public class PaqueteVO {
	private Integer idPaquete;
	private boolean paquete;
	private CineVO cineVO;
	private String nombre;
	private byte[] icono;
	private boolean activo;
	private List<ProductoXPaqueteVO> productosXPaquete;
	private List<PrecioXPaqueteVO> preciosXPaquete;

//	private Set<PuntoVenta> puntoVentas = new HashSet<PuntoVenta>(0);
//	private Set<PaquetesXTicket> paquetesXTickets = new HashSet<PaquetesXTicket>(0);
	
	public Integer getIdPaquete() {
		return idPaquete;
	}
	public void setIdPaquete(Integer idPaquete) {
		this.idPaquete = idPaquete;
	}
	public boolean isPaquete() {
		return paquete;
	}
	public void setPaquete(boolean paquete) {
		this.paquete = paquete;
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
