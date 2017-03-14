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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * EstatusEmpresa generated by hbm2java
 */
@Entity
@Table(name = "estatus_empresa", catalog = "muvitul")
public class EstatusEmpresa implements java.io.Serializable {

	private Integer idEstatus;
	private String nombre;
	private Set<Empresa> empresas = new HashSet<Empresa>(0);

	public EstatusEmpresa() {
	}

	public EstatusEmpresa(String nombre) {
		this.nombre = nombre;
	}

	public EstatusEmpresa(String nombre, Set<Empresa> empresas) {
		this.nombre = nombre;
		this.empresas = empresas;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_estatus", unique = true, nullable = false)
	public Integer getIdEstatus() {
		return this.idEstatus;
	}

	public void setIdEstatus(Integer idEstatus) {
		this.idEstatus = idEstatus;
	}

	@Column(name = "nombre", nullable = false, length = 45)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "estatusEmpresa")
	public Set<Empresa> getEmpresas() {
		return this.empresas;
	}

	public void setEmpresas(Set<Empresa> empresas) {
		this.empresas = empresas;
	}

}
