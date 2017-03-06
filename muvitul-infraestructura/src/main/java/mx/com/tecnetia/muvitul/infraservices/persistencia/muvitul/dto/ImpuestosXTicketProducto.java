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
 * ImpuestosXTicketProducto generated by hbm2java
 */
@Entity
@Table(name = "impuestos_x_ticket_producto", catalog = "muvitul")
public class ImpuestosXTicketProducto implements java.io.Serializable {

	private ImpuestosXTicketProductoId id;
	private ImpuestoXProducto impuestoXProducto;
	private TicketVenta ticketVenta;
	private BigDecimal importe;

	public ImpuestosXTicketProducto() {
	}

	public ImpuestosXTicketProducto(ImpuestosXTicketProductoId id, ImpuestoXProducto impuestoXProducto,
			TicketVenta ticketVenta, BigDecimal importe) {
		this.id = id;
		this.impuestoXProducto = impuestoXProducto;
		this.ticketVenta = ticketVenta;
		this.importe = importe;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "idTicket", column = @Column(name = "id_ticket", nullable = false)),
			@AttributeOverride(name = "idImpuestoXProducto", column = @Column(name = "id_impuesto_x_producto", nullable = false)) })
	public ImpuestosXTicketProductoId getId() {
		return this.id;
	}

	public void setId(ImpuestosXTicketProductoId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_impuesto_x_producto", nullable = false, insertable = false, updatable = false)
	public ImpuestoXProducto getImpuestoXProducto() {
		return this.impuestoXProducto;
	}

	public void setImpuestoXProducto(ImpuestoXProducto impuestoXProducto) {
		this.impuestoXProducto = impuestoXProducto;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_ticket", nullable = false, insertable = false, updatable = false)
	public TicketVenta getTicketVenta() {
		return this.ticketVenta;
	}

	public void setTicketVenta(TicketVenta ticketVenta) {
		this.ticketVenta = ticketVenta;
	}

	@Column(name = "importe", nullable = false, precision = 15)
	public BigDecimal getImporte() {
		return this.importe;
	}

	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}

}