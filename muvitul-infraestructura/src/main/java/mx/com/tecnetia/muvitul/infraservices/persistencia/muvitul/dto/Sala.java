package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto;
// Generated 13/03/2017 10:51:10 PM by Hibernate Tools 4.3.1.Final

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
 * Sala generated by hbm2java
 */
@Entity
@Table(name = "sala", catalog = "muvitul")
public class Sala implements java.io.Serializable {

	private Integer idSala;
	private Cine cine;
	private String nombre;
	private boolean activo;
	private Set<Programacion> programacions = new HashSet<Programacion>(0);
	private Set<CupoXSala> cupoXSalas = new HashSet<CupoXSala>(0);

	public Sala() {
	}

	public Sala(Cine cine, String nombre, boolean activo) {
		this.cine = cine;
		this.nombre = nombre;
		this.activo = activo;
	}

	public Sala(Cine cine, String nombre, boolean activo, Set<Programacion> programacions, Set<CupoXSala> cupoXSalas) {
		this.cine = cine;
		this.nombre = nombre;
		this.activo = activo;
		this.programacions = programacions;
		this.cupoXSalas = cupoXSalas;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_sala", unique = true, nullable = false)
	public Integer getIdSala() {
		return this.idSala;
	}

	public void setIdSala(Integer idSala) {
		this.idSala = idSala;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sala")
	public Set<Programacion> getProgramacions() {
		return this.programacions;
	}

	public void setProgramacions(Set<Programacion> programacions) {
		this.programacions = programacions;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sala")
	public Set<CupoXSala> getCupoXSalas() {
		return this.cupoXSalas;
	}

	public void setCupoXSalas(Set<CupoXSala> cupoXSalas) {
		this.cupoXSalas = cupoXSalas;
	}

}
