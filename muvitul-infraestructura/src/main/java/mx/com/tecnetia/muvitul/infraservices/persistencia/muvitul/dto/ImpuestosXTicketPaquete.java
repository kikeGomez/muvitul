package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto;
// Generated 14-abr-2017 14:25:39 by Hibernate Tools 4.3.1.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * ImpuestosXTicketPaquete generated by hbm2java
 */
@Entity
@Table(name = "impuestos_x_ticket_paquete", catalog = "muvitul")
public class ImpuestosXTicketPaquete implements java.io.Serializable {

	private Integer idTicket;
	private TicketVenta ticketVenta;
	private BigDecimal importe;
	private BigDecimal porcentaje;

	public ImpuestosXTicketPaquete() {
	}

	public ImpuestosXTicketPaquete(TicketVenta ticketVenta, BigDecimal importe, BigDecimal porcentaje) {
		this.ticketVenta = ticketVenta;
		this.importe = importe;
		this.porcentaje = porcentaje;
	}

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "ticketVenta"))
	@Id
	@GeneratedValue(generator = "generator")

	@Column(name = "id_ticket", unique = true, nullable = false)
	public Integer getIdTicket() {
		return this.idTicket;
	}

	public void setIdTicket(Integer idTicket) {
		this.idTicket = idTicket;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
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

	@Column(name = "porcentaje", nullable = false, precision = 15)
	public BigDecimal getPorcentaje() {
		return this.porcentaje;
	}

	public void setPorcentaje(BigDecimal porcentaje) {
		this.porcentaje = porcentaje;
	}

}
