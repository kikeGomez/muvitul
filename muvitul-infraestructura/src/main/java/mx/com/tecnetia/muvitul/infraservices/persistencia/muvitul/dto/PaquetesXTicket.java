package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto;
// Generated 2/03/2017 11:59:13 PM by Hibernate Tools 4.3.1.Final

import java.math.BigDecimal;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * PaquetesXTicket generated by hbm2java
 */
@Entity
@Table(name = "paquetes_x_ticket", catalog = "muvitul")
public class PaquetesXTicket implements java.io.Serializable {

	private PaquetesXTicketId id;
	private Paquete paquete;
	private TicketVenta ticketVenta;
	private int cantidad;
	private BigDecimal importe;

	public PaquetesXTicket() {
	}

	public PaquetesXTicket(PaquetesXTicketId id, Paquete paquete, TicketVenta ticketVenta, int cantidad,
			BigDecimal importe) {
		this.id = id;
		this.paquete = paquete;
		this.ticketVenta = ticketVenta;
		this.cantidad = cantidad;
		this.importe = importe;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "idTicket", column = @Column(name = "id_ticket", nullable = false)),
			@AttributeOverride(name = "idPaquete", column = @Column(name = "id_paquete", nullable = false)) })
	public PaquetesXTicketId getId() {
		return this.id;
	}

	public void setId(PaquetesXTicketId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_paquete", nullable = false, insertable = false, updatable = false)
	public Paquete getPaquete() {
		return this.paquete;
	}

	public void setPaquete(Paquete paquete) {
		this.paquete = paquete;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_ticket", nullable = false, insertable = false, updatable = false)
	public TicketVenta getTicketVenta() {
		return this.ticketVenta;
	}

	public void setTicketVenta(TicketVenta ticketVenta) {
		this.ticketVenta = ticketVenta;
	}

	@Column(name = "cantidad", nullable = false)
	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Column(name = "importe", nullable = false, precision = 15)
	public BigDecimal getImporte() {
		return this.importe;
	}

	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}

}
