package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto;
// Generated 12/02/2017 04:03:11 PM by Hibernate Tools 4.3.1.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * AuditoriaConfigExpresion generated by hbm2java
 */
@Entity
@Table(name = "auditoria_config_expresion", catalog = "muvitul")
public class AuditoriaConfigExpresion implements java.io.Serializable {

	private int idExpresion;
	private AuditoriaConfigAtributo auditoriaConfigAtributo;
	private String expresion;
	private String descripcion;
	private Date fechaModificacion;
	private boolean activo;

	public AuditoriaConfigExpresion() {
	}

	public AuditoriaConfigExpresion(int idExpresion, AuditoriaConfigAtributo auditoriaConfigAtributo, String expresion,
			String descripcion, Date fechaModificacion, boolean activo) {
		this.idExpresion = idExpresion;
		this.auditoriaConfigAtributo = auditoriaConfigAtributo;
		this.expresion = expresion;
		this.descripcion = descripcion;
		this.fechaModificacion = fechaModificacion;
		this.activo = activo;
	}

	@Id

	@Column(name = "id_expresion", unique = true, nullable = false)
	public int getIdExpresion() {
		return this.idExpresion;
	}

	public void setIdExpresion(int idExpresion) {
		this.idExpresion = idExpresion;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_atributo", nullable = false)
	public AuditoriaConfigAtributo getAuditoriaConfigAtributo() {
		return this.auditoriaConfigAtributo;
	}

	public void setAuditoriaConfigAtributo(AuditoriaConfigAtributo auditoriaConfigAtributo) {
		this.auditoriaConfigAtributo = auditoriaConfigAtributo;
	}

	@Column(name = "expresion", nullable = false, length = 200)
	public String getExpresion() {
		return this.expresion;
	}

	public void setExpresion(String expresion) {
		this.expresion = expresion;
	}

	@Column(name = "descripcion", nullable = false, length = 100)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion", nullable = false, length = 19)
	public Date getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	@Column(name = "activo", nullable = false)
	public boolean isActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
