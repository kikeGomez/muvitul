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
 * Proveedor generated by hbm2java
 */
@Entity
@Table(name = "proveedor", catalog = "muvitul")
public class Proveedor implements java.io.Serializable {

	private Integer idProveedor;
	private Cine cine;
	private String nombre;
	private String razonSocial;
	private String rfc;
	private boolean activo;
	private Set<MovimientoInventario> movimientoInventarios = new HashSet<MovimientoInventario>(0);

	public Proveedor() {
	}

	public Proveedor(Cine cine, String nombre, String razonSocial, String rfc, boolean activo) {
		this.cine = cine;
		this.nombre = nombre;
		this.razonSocial = razonSocial;
		this.rfc = rfc;
		this.activo = activo;
	}

	public Proveedor(Cine cine, String nombre, String razonSocial, String rfc, boolean activo,
			Set<MovimientoInventario> movimientoInventarios) {
		this.cine = cine;
		this.nombre = nombre;
		this.razonSocial = razonSocial;
		this.rfc = rfc;
		this.activo = activo;
		this.movimientoInventarios = movimientoInventarios;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_proveedor", unique = true, nullable = false)
	public Integer getIdProveedor() {
		return this.idProveedor;
	}

	public void setIdProveedor(Integer idProveedor) {
		this.idProveedor = idProveedor;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cine", nullable = false)
	public Cine getCine() {
		return this.cine;
	}

	public void setCine(Cine cine) {
		this.cine = cine;
	}

	@Column(name = "nombre", nullable = false, length = 100)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "razon_social", nullable = false, length = 200)
	public String getRazonSocial() {
		return this.razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	@Column(name = "rfc", nullable = false, length = 13)
	public String getRfc() {
		return this.rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	@Column(name = "activo", nullable = false)
	public boolean isActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "proveedor")
	public Set<MovimientoInventario> getMovimientoInventarios() {
		return this.movimientoInventarios;
	}

	public void setMovimientoInventarios(Set<MovimientoInventario> movimientoInventarios) {
		this.movimientoInventarios = movimientoInventarios;
	}

}
