package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto;
// Generated 12/02/2017 04:03:11 PM by Hibernate Tools 4.3.1.Final

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
 * Pelicula generated by hbm2java
 */
@Entity
@Table(name = "pelicula", catalog = "muvitul")
public class Pelicula implements java.io.Serializable {

	private Integer idPelicula;
	private Cine cine;
	private Distribuidora distribuidora;
	private Pais pais;
	private String titulo;
	private String clasificacion;
	private int duracion;
	private String sinopsis;
	private boolean activo;
	private Set<Programacion> programacions = new HashSet<Programacion>(0);

	public Pelicula() {
	}

	public Pelicula(Cine cine, Distribuidora distribuidora, Pais pais, String titulo, String clasificacion,
			int duracion, String sinopsis, boolean activo) {
		this.cine = cine;
		this.distribuidora = distribuidora;
		this.pais = pais;
		this.titulo = titulo;
		this.clasificacion = clasificacion;
		this.duracion = duracion;
		this.sinopsis = sinopsis;
		this.activo = activo;
	}

	public Pelicula(Cine cine, Distribuidora distribuidora, Pais pais, String titulo, String clasificacion,
			int duracion, String sinopsis, boolean activo, Set<Programacion> programacions) {
		this.cine = cine;
		this.distribuidora = distribuidora;
		this.pais = pais;
		this.titulo = titulo;
		this.clasificacion = clasificacion;
		this.duracion = duracion;
		this.sinopsis = sinopsis;
		this.activo = activo;
		this.programacions = programacions;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_pelicula", unique = true, nullable = false)
	public Integer getIdPelicula() {
		return this.idPelicula;
	}

	public void setIdPelicula(Integer idPelicula) {
		this.idPelicula = idPelicula;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cine", nullable = false)
	public Cine getCine() {
		return this.cine;
	}

	public void setCine(Cine cine) {
		this.cine = cine;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_distribuidora", nullable = false)
	public Distribuidora getDistribuidora() {
		return this.distribuidora;
	}

	public void setDistribuidora(Distribuidora distribuidora) {
		this.distribuidora = distribuidora;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pais", nullable = false)
	public Pais getPais() {
		return this.pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	@Column(name = "titulo", nullable = false, length = 250)
	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Column(name = "clasificacion", nullable = false, length = 3)
	public String getClasificacion() {
		return this.clasificacion;
	}

	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}

	@Column(name = "duracion", nullable = false)
	public int getDuracion() {
		return this.duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	@Column(name = "sinopsis", nullable = false, length = 65535)
	public String getSinopsis() {
		return this.sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	@Column(name = "activo", nullable = false)
	public boolean isActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pelicula")
	public Set<Programacion> getProgramacions() {
		return this.programacions;
	}

	public void setProgramacions(Set<Programacion> programacions) {
		this.programacions = programacions;
	}

}
