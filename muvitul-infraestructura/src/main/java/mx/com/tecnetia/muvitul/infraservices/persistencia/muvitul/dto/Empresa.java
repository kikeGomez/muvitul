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
 * Empresa generated by hbm2java
 */
@Entity
@Table(name = "empresa", catalog = "muvitul")
public class Empresa implements java.io.Serializable {

	private Integer idEmpresa;
	private Contacto contacto;
	private EstatusEmpresa estatusEmpresa;
	private String nombre;
	private Set<Cine> cines = new HashSet<Cine>(0);

	public Empresa() {
	}

	public Empresa(Contacto contacto, EstatusEmpresa estatusEmpresa, String nombre) {
		this.contacto = contacto;
		this.estatusEmpresa = estatusEmpresa;
		this.nombre = nombre;
	}

	public Empresa(Contacto contacto, EstatusEmpresa estatusEmpresa, String nombre, Set<Cine> cines) {
		this.contacto = contacto;
		this.estatusEmpresa = estatusEmpresa;
		this.nombre = nombre;
		this.cines = cines;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_empresa", unique = true, nullable = false)
	public Integer getIdEmpresa() {
		return this.idEmpresa;
	}

	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_contacto", nullable = false)
	public Contacto getContacto() {
		return this.contacto;
	}

	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_estatus_empresa", nullable = false)
	public EstatusEmpresa getEstatusEmpresa() {
		return this.estatusEmpresa;
	}

	public void setEstatusEmpresa(EstatusEmpresa estatusEmpresa) {
		this.estatusEmpresa = estatusEmpresa;
	}

	@Column(name = "nombre", nullable = false, length = 45)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "empresa")
	public Set<Cine> getCines() {
		return this.cines;
	}

	public void setCines(Set<Cine> cines) {
		this.cines = cines;
	}

}
