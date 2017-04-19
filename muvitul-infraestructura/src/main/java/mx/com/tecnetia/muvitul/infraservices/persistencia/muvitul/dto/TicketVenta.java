package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto;
// Generated 14-abr-2017 14:25:39 by Hibernate Tools 4.3.1.Final

import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TicketVenta generated by hbm2java
 */
@Entity
@Table(name = "ticket_venta", catalog = "muvitul")
public class TicketVenta implements java.io.Serializable {

	private Integer idTicket;
	private PuntoVenta puntoVenta;
	private Usuario usuario;
	private Date fecha;
	private BigDecimal descuento;
	private BigDecimal importe;
	private BigDecimal total;
	private Set<ProductosXTicket> productosXTickets = new HashSet<ProductosXTicket>(0);
	private Set<ImpuestosXTicketTaquilla> impuestosXTicketTaquillas = new HashSet<ImpuestosXTicketTaquilla>(0);
	private Set<PromocionesXTicket> promocionesXTickets = new HashSet<PromocionesXTicket>(0);
	private Set<BoletosXTicket> boletosXTickets = new HashSet<BoletosXTicket>(0);
	private Set<Pago> pagos = new HashSet<Pago>(0);
	private Set<PaquetesXTicket> paquetesXTickets = new HashSet<PaquetesXTicket>(0);
	private Set<ImpuestosXTicketProducto> impuestosXTicketProductos = new HashSet<ImpuestosXTicketProducto>(0);
	private ImpuestosXTicketPaquete impuestosXTicketPaquete;

	public TicketVenta() {
	}

	public TicketVenta(PuntoVenta puntoVenta, Usuario usuario, Date fecha, BigDecimal descuento, BigDecimal importe,
			BigDecimal total) {
		this.puntoVenta = puntoVenta;
		this.usuario = usuario;
		this.fecha = fecha;
		this.descuento = descuento;
		this.importe = importe;
		this.total = total;
	}

	public TicketVenta(PuntoVenta puntoVenta, Usuario usuario, Date fecha, BigDecimal descuento, BigDecimal importe,
			BigDecimal total, Set<ProductosXTicket> productosXTickets,
			Set<ImpuestosXTicketTaquilla> impuestosXTicketTaquillas, Set<PromocionesXTicket> promocionesXTickets,
			Set<BoletosXTicket> boletosXTickets, Set<Pago> pagos, Set<PaquetesXTicket> paquetesXTickets,
			Set<ImpuestosXTicketProducto> impuestosXTicketProductos, ImpuestosXTicketPaquete impuestosXTicketPaquete) {
		this.puntoVenta = puntoVenta;
		this.usuario = usuario;
		this.fecha = fecha;
		this.descuento = descuento;
		this.importe = importe;
		this.total = total;
		this.productosXTickets = productosXTickets;
		this.impuestosXTicketTaquillas = impuestosXTicketTaquillas;
		this.promocionesXTickets = promocionesXTickets;
		this.boletosXTickets = boletosXTickets;
		this.pagos = pagos;
		this.paquetesXTickets = paquetesXTickets;
		this.impuestosXTicketProductos = impuestosXTicketProductos;
		this.impuestosXTicketPaquete = impuestosXTicketPaquete;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_ticket", unique = true, nullable = false)
	public Integer getIdTicket() {
		return this.idTicket;
	}

	public void setIdTicket(Integer idTicket) {
		this.idTicket = idTicket;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_punto_venta", nullable = false)
	public PuntoVenta getPuntoVenta() {
		return this.puntoVenta;
	}

	public void setPuntoVenta(PuntoVenta puntoVenta) {
		this.puntoVenta = puntoVenta;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario", nullable = false)
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha", nullable = false, length = 19)
	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Column(name = "descuento", nullable = false, precision = 15)
	public BigDecimal getDescuento() {
		return this.descuento;
	}

	public void setDescuento(BigDecimal descuento) {
		this.descuento = descuento;
	}

	@Column(name = "importe", nullable = false, precision = 15)
	public BigDecimal getImporte() {
		return this.importe;
	}

	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}

	@Column(name = "total", nullable = false, precision = 15)
	public BigDecimal getTotal() {
		return this.total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ticketVenta")
	public Set<ProductosXTicket> getProductosXTickets() {
		return this.productosXTickets;
	}

	public void setProductosXTickets(Set<ProductosXTicket> productosXTickets) {
		this.productosXTickets = productosXTickets;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ticketVenta")
	public Set<ImpuestosXTicketTaquilla> getImpuestosXTicketTaquillas() {
		return this.impuestosXTicketTaquillas;
	}

	public void setImpuestosXTicketTaquillas(Set<ImpuestosXTicketTaquilla> impuestosXTicketTaquillas) {
		this.impuestosXTicketTaquillas = impuestosXTicketTaquillas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ticketVenta")
	public Set<PromocionesXTicket> getPromocionesXTickets() {
		return this.promocionesXTickets;
	}

	public void setPromocionesXTickets(Set<PromocionesXTicket> promocionesXTickets) {
		this.promocionesXTickets = promocionesXTickets;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ticketVenta")
	public Set<BoletosXTicket> getBoletosXTickets() {
		return this.boletosXTickets;
	}

	public void setBoletosXTickets(Set<BoletosXTicket> boletosXTickets) {
		this.boletosXTickets = boletosXTickets;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ticketVenta")
	public Set<Pago> getPagos() {
		return this.pagos;
	}

	public void setPagos(Set<Pago> pagos) {
		this.pagos = pagos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ticketVenta")
	public Set<PaquetesXTicket> getPaquetesXTickets() {
		return this.paquetesXTickets;
	}

	public void setPaquetesXTickets(Set<PaquetesXTicket> paquetesXTickets) {
		this.paquetesXTickets = paquetesXTickets;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ticketVenta")
	public Set<ImpuestosXTicketProducto> getImpuestosXTicketProductos() {
		return this.impuestosXTicketProductos;
	}

	public void setImpuestosXTicketProductos(Set<ImpuestosXTicketProducto> impuestosXTicketProductos) {
		this.impuestosXTicketProductos = impuestosXTicketProductos;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "ticketVenta")
	public ImpuestosXTicketPaquete getImpuestosXTicketPaquete() {
		return this.impuestosXTicketPaquete;
	}

	public void setImpuestosXTicketPaquete(ImpuestosXTicketPaquete impuestosXTicketPaquete) {
		this.impuestosXTicketPaquete = impuestosXTicketPaquete;
	}

}
