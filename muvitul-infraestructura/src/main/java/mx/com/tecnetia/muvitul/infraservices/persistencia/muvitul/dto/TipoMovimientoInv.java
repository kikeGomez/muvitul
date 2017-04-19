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
 * TipoMovimientoInv generated by hbm2java
 */
@Entity
@Table(name = "tipo_movimiento_inv", catalog = "muvitul")
public class TipoMovimientoInv implements java.io.Serializable {

	private Integer idTipoMovimientoInv;
	private String nombre;
	private boolean esEntrada;
	private boolean activo;
	private Set<MovimientoInventario> movimientoInventarios = new HashSet<MovimientoInventario>(0);

	public TipoMovimientoInv() {
	}

	public TipoMovimientoInv(String nombre, boolean esEntrada, boolean activo) {
		this.nombre = nombre;
		this.esEntrada = esEntrada;
		this.activo = activo;
	}

	public TipoMovimientoInv(String nombre, boolean esEntrada, boolean activo,
			Set<MovimientoInventario> movimientoInventarios) {
		this.nombre = nombre;
		this.esEntrada = esEntrada;
		this.activo = activo;
		this.movimientoInventarios = movimientoInventarios;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_tipo_movimiento_inv", unique = true, nullable = false)
	public Integer getIdTipoMovimientoInv() {
		return this.idTipoMovimientoInv;
	}

	public void setIdTipoMovimientoInv(Integer idTipoMovimientoInv) {
		this.idTipoMovimientoInv = idTipoMovimientoInv;
	}

	@Column(name = "nombre", nullable = false, length = 45)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "es_entrada", nullable = false)
	public boolean isEsEntrada() {
		return this.esEntrada;
	}

	public void setEsEntrada(boolean esEntrada) {
		this.esEntrada = esEntrada;
	}

	@Column(name = "activo", nullable = false)
	public boolean isActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoMovimientoInv")
	public Set<MovimientoInventario> getMovimientoInventarios() {
		return this.movimientoInventarios;
	}

	public void setMovimientoInventarios(Set<MovimientoInventario> movimientoInventarios) {
		this.movimientoInventarios = movimientoInventarios;
	}

}
