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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Regalo generated by hbm2java
 */
@Entity
@Table(name = "regalo", catalog = "muvitul")
public class Regalo implements java.io.Serializable {

	private Integer idRegalo;
	private String nombre;
	private String descripcion;
	private Set<DetallePromocion> detallePromocions = new HashSet<DetallePromocion>(0);

	public Regalo() {
	}

	public Regalo(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public Regalo(String nombre, String descripcion, Set<DetallePromocion> detallePromocions) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.detallePromocions = detallePromocions;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_regalo", unique = true, nullable = false)
	public Integer getIdRegalo() {
		return this.idRegalo;
	}

	public void setIdRegalo(Integer idRegalo) {
		this.idRegalo = idRegalo;
	}

	@Column(name = "nombre", nullable = false, length = 100)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "descripcion", nullable = false, length = 250)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "regalo")
	public Set<DetallePromocion> getDetallePromocions() {
		return this.detallePromocions;
	}

	public void setDetallePromocions(Set<DetallePromocion> detallePromocions) {
		this.detallePromocions = detallePromocions;
	}

}
