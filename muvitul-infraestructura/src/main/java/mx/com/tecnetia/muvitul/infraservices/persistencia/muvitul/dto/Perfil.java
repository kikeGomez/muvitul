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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Perfil generated by hbm2java
 */
@Entity
@Table(name = "perfil", catalog = "muvitul")
public class Perfil implements java.io.Serializable {

	private Integer idPerfil;
	private String nombre;
	private Set<Usuario> usuarios = new HashSet<Usuario>(0);
	private Set<Recurso> recursos = new HashSet<Recurso>(0);

	public Perfil() {
	}

	public Perfil(String nombre) {
		this.nombre = nombre;
	}

	public Perfil(String nombre, Set<Usuario> usuarios, Set<Recurso> recursos) {
		this.nombre = nombre;
		this.usuarios = usuarios;
		this.recursos = recursos;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_perfil", unique = true, nullable = false)
	public Integer getIdPerfil() {
		return this.idPerfil;
	}

	public void setIdPerfil(Integer idPerfil) {
		this.idPerfil = idPerfil;
	}

	@Column(name = "nombre", nullable = false, length = 45)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "perfils")
	public Set<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "recursos_x_perfil", catalog = "muvitul", joinColumns = {
			@JoinColumn(name = "id_perfil", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "id_recurso", nullable = false, updatable = false) })
	public Set<Recurso> getRecursos() {
		return this.recursos;
	}

	public void setRecursos(Set<Recurso> recursos) {
		this.recursos = recursos;
	}

}
