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
 * TipoPuntoVenta generated by hbm2java
 */
@Entity
@Table(name = "tipo_punto_venta", catalog = "muvitul")
public class TipoPuntoVenta implements java.io.Serializable {

	private Integer idTipoPuntoVenta;
	private String nombre;
	private String descripcion;
	private Set<PuntoVenta> puntoVentas = new HashSet<PuntoVenta>(0);

	public TipoPuntoVenta() {
	}

	public TipoPuntoVenta(String nombre) {
		this.nombre = nombre;
	}

	public TipoPuntoVenta(String nombre, String descripcion, Set<PuntoVenta> puntoVentas) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.puntoVentas = puntoVentas;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_tipo_punto_venta", unique = true, nullable = false)
	public Integer getIdTipoPuntoVenta() {
		return this.idTipoPuntoVenta;
	}

	public void setIdTipoPuntoVenta(Integer idTipoPuntoVenta) {
		this.idTipoPuntoVenta = idTipoPuntoVenta;
	}

	@Column(name = "nombre", nullable = false, length = 100)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "descripcion", length = 250)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoPuntoVenta")
	public Set<PuntoVenta> getPuntoVentas() {
		return this.puntoVentas;
	}

	public void setPuntoVentas(Set<PuntoVenta> puntoVentas) {
		this.puntoVentas = puntoVentas;
	}

}
