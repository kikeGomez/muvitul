package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto;
// Generated 14-abr-2017 14:25:39 by Hibernate Tools 4.3.1.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * PuntoVenta generated by hbm2java
 */
@Entity
@Table(name = "punto_venta", catalog = "muvitul")
public class PuntoVenta implements java.io.Serializable {

	private Integer idPuntoVenta;
	private Cine cine;
	private TipoPuntoVenta tipoPuntoVenta;
	private String nombre;
	private Set<PaquetesXPuntoVenta> paquetesXPuntoVentas = new HashSet<PaquetesXPuntoVenta>(0);
	private Set<TicketVenta> ticketVentas = new HashSet<TicketVenta>(0);
	private Set<Usuario> usuarios = new HashSet<Usuario>(0);
	private Set<ProductosXPuntoVenta> productosXPuntoVentas = new HashSet<ProductosXPuntoVenta>(0);
	private Set<ArticulosXPuntoVenta> articulosXPuntoVentas = new HashSet<ArticulosXPuntoVenta>(0);

	public PuntoVenta() {
	}

	public PuntoVenta(Cine cine, TipoPuntoVenta tipoPuntoVenta, String nombre) {
		this.cine = cine;
		this.tipoPuntoVenta = tipoPuntoVenta;
		this.nombre = nombre;
	}

	public PuntoVenta(Cine cine, TipoPuntoVenta tipoPuntoVenta, String nombre,
			Set<PaquetesXPuntoVenta> paquetesXPuntoVentas, Set<TicketVenta> ticketVentas, Set<Usuario> usuarios,
			Set<ProductosXPuntoVenta> productosXPuntoVentas, Set<ArticulosXPuntoVenta> articulosXPuntoVentas) {
		this.cine = cine;
		this.tipoPuntoVenta = tipoPuntoVenta;
		this.nombre = nombre;
		this.paquetesXPuntoVentas = paquetesXPuntoVentas;
		this.ticketVentas = ticketVentas;
		this.usuarios = usuarios;
		this.productosXPuntoVentas = productosXPuntoVentas;
		this.articulosXPuntoVentas = articulosXPuntoVentas;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_punto_venta", unique = true, nullable = false)
	public Integer getIdPuntoVenta() {
		return this.idPuntoVenta;
	}

	public void setIdPuntoVenta(Integer idPuntoVenta) {
		this.idPuntoVenta = idPuntoVenta;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cine", nullable = false)
	public Cine getCine() {
		return this.cine;
	}

	public void setCine(Cine cine) {
		this.cine = cine;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipo_punto_venta", nullable = false)
	public TipoPuntoVenta getTipoPuntoVenta() {
		return this.tipoPuntoVenta;
	}

	public void setTipoPuntoVenta(TipoPuntoVenta tipoPuntoVenta) {
		this.tipoPuntoVenta = tipoPuntoVenta;
	}

	@Column(name = "nombre", nullable = false, length = 100)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "puntoVenta")
	public Set<PaquetesXPuntoVenta> getPaquetesXPuntoVentas() {
		return this.paquetesXPuntoVentas;
	}

	public void setPaquetesXPuntoVentas(Set<PaquetesXPuntoVenta> paquetesXPuntoVentas) {
		this.paquetesXPuntoVentas = paquetesXPuntoVentas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "puntoVenta")
	public Set<TicketVenta> getTicketVentas() {
		return this.ticketVentas;
	}

	public void setTicketVentas(Set<TicketVenta> ticketVentas) {
		this.ticketVentas = ticketVentas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "puntoVenta")
	public Set<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "puntoVenta")
	public Set<ProductosXPuntoVenta> getProductosXPuntoVentas() {
		return this.productosXPuntoVentas;
	}

	public void setProductosXPuntoVentas(Set<ProductosXPuntoVenta> productosXPuntoVentas) {
		this.productosXPuntoVentas = productosXPuntoVentas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "puntoVenta")
	public Set<ArticulosXPuntoVenta> getArticulosXPuntoVentas() {
		return this.articulosXPuntoVentas;
	}

	public void setArticulosXPuntoVentas(Set<ArticulosXPuntoVenta> articulosXPuntoVentas) {
		this.articulosXPuntoVentas = articulosXPuntoVentas;
	}

}
