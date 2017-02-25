package mx.com.tecnetia.muvitul.negocio.dulceria.vo;

import java.util.Set;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.PrecioXPaquete;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Producto;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.PuntoVenta;

public class PaqueteVO {
	private Integer idPaquete;
	private PuntoVenta puntoVenta;
	private String nombre;
	private byte[] icono;
	private boolean activo;
	private Set<Producto> productos;
	private Set<PrecioXPaquete> precioXPaquetes;
	
	public Integer getIdPaquete() {
		return idPaquete;
	}
	public void setIdPaquete(Integer idPaquete) {
		this.idPaquete = idPaquete;
	}
	public PuntoVenta getPuntoVenta() {
		return puntoVenta;
	}
	public void setPuntoVenta(PuntoVenta puntoVenta) {
		this.puntoVenta = puntoVenta;
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
	public Set<Producto> getProductos() {
		return productos;
	}
	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}
	public Set<PrecioXPaquete> getPrecioXPaquetes() {
		return precioXPaquetes;
	}
	public void setPrecioXPaquetes(Set<PrecioXPaquete> precioXPaquetes) {
		this.precioXPaquetes = precioXPaquetes;
	}
	
	
	
}
