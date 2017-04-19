package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto;
// Generated 14-abr-2017 14:25:39 by Hibernate Tools 4.3.1.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * PrecioXFormato generated by hbm2java
 */
@Entity
@Table(name = "precio_x_formato", catalog = "muvitul", uniqueConstraints = @UniqueConstraint(columnNames = {
		"id_formato", "id_tipo_cliente" }))
public class PrecioXFormato implements java.io.Serializable {

	private Integer idPrecioXFormato;
	private Formato formato;
	private TipoCliente tipoCliente;
	private BigDecimal precio;
	private boolean activo;

	public PrecioXFormato() {
	}

	public PrecioXFormato(Formato formato, TipoCliente tipoCliente, BigDecimal precio, boolean activo) {
		this.formato = formato;
		this.tipoCliente = tipoCliente;
		this.precio = precio;
		this.activo = activo;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_precio_x_formato", unique = true, nullable = false)
	public Integer getIdPrecioXFormato() {
		return this.idPrecioXFormato;
	}

	public void setIdPrecioXFormato(Integer idPrecioXFormato) {
		this.idPrecioXFormato = idPrecioXFormato;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_formato", nullable = false)
	public Formato getFormato() {
		return this.formato;
	}

	public void setFormato(Formato formato) {
		this.formato = formato;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipo_cliente", nullable = false)
	public TipoCliente getTipoCliente() {
		return this.tipoCliente;
	}

	public void setTipoCliente(TipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	@Column(name = "precio", nullable = false, precision = 15)
	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	@Column(name = "activo", nullable = false)
	public boolean isActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
