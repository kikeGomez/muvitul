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
 * TipoCliente generated by hbm2java
 */
@Entity
@Table(name = "tipo_cliente", catalog = "muvitul")
public class TipoCliente implements java.io.Serializable {

	private Integer idTipoCliente;
	private String nombre;
	private boolean activo;
	private Set<PrecioXFormato> precioXFormatos = new HashSet<PrecioXFormato>(0);
	private Set<BoletosXTicket> boletosXTickets = new HashSet<BoletosXTicket>(0);

	public TipoCliente() {
	}

	public TipoCliente(String nombre, boolean activo) {
		this.nombre = nombre;
		this.activo = activo;
	}

	public TipoCliente(String nombre, boolean activo, Set<PrecioXFormato> precioXFormatos,
			Set<BoletosXTicket> boletosXTickets) {
		this.nombre = nombre;
		this.activo = activo;
		this.precioXFormatos = precioXFormatos;
		this.boletosXTickets = boletosXTickets;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_tipo_cliente", unique = true, nullable = false)
	public Integer getIdTipoCliente() {
		return this.idTipoCliente;
	}

	public void setIdTipoCliente(Integer idTipoCliente) {
		this.idTipoCliente = idTipoCliente;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoCliente")
	public Set<PrecioXFormato> getPrecioXFormatos() {
		return this.precioXFormatos;
	}

	public void setPrecioXFormatos(Set<PrecioXFormato> precioXFormatos) {
		this.precioXFormatos = precioXFormatos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoCliente")
	public Set<BoletosXTicket> getBoletosXTickets() {
		return this.boletosXTickets;
	}

	public void setBoletosXTickets(Set<BoletosXTicket> boletosXTickets) {
		this.boletosXTickets = boletosXTickets;
	}

}