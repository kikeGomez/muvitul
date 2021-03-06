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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * MotivoCancelacion generated by hbm2java
 */
@Entity
@Table(name = "motivo_cancelacion", catalog = "muvitul")
public class MotivoCancelacion implements java.io.Serializable {

	private Integer idMotivoCancelacion;
	private String nombre;
	private boolean activo;
	private Set<CancelacionPago> cancelacionPagos = new HashSet<CancelacionPago>(0);

	public MotivoCancelacion() {
	}

	public MotivoCancelacion(String nombre, boolean activo) {
		this.nombre = nombre;
		this.activo = activo;
	}

	public MotivoCancelacion(String nombre, boolean activo, Set<CancelacionPago> cancelacionPagos) {
		this.nombre = nombre;
		this.activo = activo;
		this.cancelacionPagos = cancelacionPagos;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_motivo_cancelacion", unique = true, nullable = false)
	public Integer getIdMotivoCancelacion() {
		return this.idMotivoCancelacion;
	}

	public void setIdMotivoCancelacion(Integer idMotivoCancelacion) {
		this.idMotivoCancelacion = idMotivoCancelacion;
	}

	@Column(name = "nombre", nullable = false, length = 45)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "activo", nullable = false)
	public boolean isActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "motivoCancelacion")
	public Set<CancelacionPago> getCancelacionPagos() {
		return this.cancelacionPagos;
	}

	public void setCancelacionPagos(Set<CancelacionPago> cancelacionPagos) {
		this.cancelacionPagos = cancelacionPagos;
	}

}
