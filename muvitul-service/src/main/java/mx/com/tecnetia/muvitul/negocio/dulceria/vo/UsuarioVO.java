package mx.com.tecnetia.muvitul.negocio.dulceria.vo;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Cine;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.EstatusUsuario;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.PuntoVenta;

public class UsuarioVO {
	private Integer idUsuario;
	private Cine cine;
	private EstatusUsuario estatusUsuario;
	private PuntoVenta puntoVenta;
	private String nombre;
	private String paterno;
	private String materno;
	private String correo;
	private String contrasenia;
	private String foto;
//	private Set<Cine> cines = new HashSet<Cine>(0);
//	private Set<TicketVenta> ticketVentas = new HashSet<TicketVenta>(0);
//	private Set<Perfil> perfils = new HashSet<Perfil>(0);
//	private Set<CancelacionPago> cancelacionPagos = new HashSet<CancelacionPago>(0);
//	private Set<AutorizacionMovimiento> autorizacionMovimientos = new HashSet<AutorizacionMovimiento>(0);
//	private Set<MovimientoInventario> movimientoInventarios = new HashSet<MovimientoInventario>(0);
	
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Cine getCine() {
		return cine;
	}
	public void setCine(Cine cine) {
		this.cine = cine;
	}
	public EstatusUsuario getEstatusUsuario() {
		return estatusUsuario;
	}
	public void setEstatusUsuario(EstatusUsuario estatusUsuario) {
		this.estatusUsuario = estatusUsuario;
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
	public String getPaterno() {
		return paterno;
	}
	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}
	public String getMaterno() {
		return materno;
	}
	public void setMaterno(String materno) {
		this.materno = materno;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}

	
}

