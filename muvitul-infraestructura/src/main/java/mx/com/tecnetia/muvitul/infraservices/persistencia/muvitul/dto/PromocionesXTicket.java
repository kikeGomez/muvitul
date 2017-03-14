package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto;
// Generated 13/03/2017 10:51:10 PM by Hibernate Tools 4.3.1.Final

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
 * PromocionesXTicket generated by hbm2java
 */
@Entity
@Table(name = "promociones_x_ticket", catalog = "muvitul")
public class PromocionesXTicket implements java.io.Serializable {

	private PromocionesXTicketId id;
	private Promocion promocion;
	private TicketVenta ticketVenta;
	private int cantidad;
	private BigDecimal importe;

	public PromocionesXTicket() {
	}

	public PromocionesXTicket(PromocionesXTicketId id, Promocion promocion, TicketVenta ticketVenta, int cantidad,
			BigDecimal importe) {
		this.id = id;
		this.promocion = promocion;
		this.ticketVenta = ticketVenta;
		this.cantidad = cantidad;
		this.importe = importe;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "idTicket", column = @Column(name = "id_ticket", nullable = false)),
			@AttributeOverride(name = "idPromocion", column = @Column(name = "id_promocion", nullable = false)) })
	public PromocionesXTicketId getId() {
		return this.id;
	}

	public void setId(PromocionesXTicketId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_promocion", nullable = false, insertable = false, updatable = false)
	public Promocion getPromocion() {
		return this.promocion;
	}

	public void setPromocion(Promocion promocion) {
		this.promocion = promocion;
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
