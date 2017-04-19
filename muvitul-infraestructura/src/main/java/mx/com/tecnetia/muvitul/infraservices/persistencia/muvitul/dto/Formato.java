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
 * Formato generated by hbm2java
 */
@Entity
@Table(name = "formato", catalog = "muvitul")
public class Formato implements java.io.Serializable {

	private Integer idFormato;
	private Cine cine;
	private String nombre;
	private boolean activo;
	private Set<PrecioXFormato> precioXFormatos = new HashSet<PrecioXFormato>(0);
	private Set<Programacion> programacions = new HashSet<Programacion>(0);

	public Formato() {
	}

	public Formato(Cine cine, String nombre, boolean activo) {
		this.cine = cine;
		this.nombre = nombre;
		this.activo = activo;
	}

	public Formato(Cine cine, String nombre, boolean activo, Set<PrecioXFormato> precioXFormatos,
			Set<Programacion> programacions) {
		this.cine = cine;
		this.nombre = nombre;
		this.activo = activo;
		this.precioXFormatos = precioXFormatos;
		this.programacions = programacions;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_formato", unique = true, nullable = false)
	public Integer getIdFormato() {
		return this.idFormato;
	}

	public void setIdFormato(Integer idFormato) {
		this.idFormato = idFormato;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cine", nullable = false)
	public Cine getCine() {
		return this.cine;
	}

	public void setCine(Cine cine) {
		this.cine = cine;
	}

	@Column(name = "nombre", nullable = false, length = 35)
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "formato")
	public Set<PrecioXFormato> getPrecioXFormatos() {
		return this.precioXFormatos;
	}

	public void setPrecioXFormatos(Set<PrecioXFormato> precioXFormatos) {
		this.precioXFormatos = precioXFormatos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "formato")
	public Set<Programacion> getProgramacions() {
		return this.programacions;
	}

	public void setProgramacions(Set<Programacion> programacions) {
		this.programacions = programacions;
	}

}
