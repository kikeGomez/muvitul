package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto;
// Generated 14-abr-2017 14:25:39 by Hibernate Tools 4.3.1.Final

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Promocion generated by hbm2java
 */
@Entity
@Table(name = "promocion", catalog = "muvitul")
public class Promocion implements java.io.Serializable {

	private Integer idPromocion;
	private Cine cine;
	private PromocionPara promocionPara;
	private TipoPromocion tipoPromocion;
	private String nombre;
	private String descripcion;
	private Date fechaInicio;
	private Date fechaFin;
	private boolean activo;
	private Set<DetallePromoXPromo> detallePromoXPromos = new HashSet<DetallePromoXPromo>(0);
	private Set<PromocionesXTicket> promocionesXTickets = new HashSet<PromocionesXTicket>(0);

	public Promocion() {
	}

	public Promocion(Cine cine, PromocionPara promocionPara, TipoPromocion tipoPromocion, String nombre,
			String descripcion, Date fechaInicio, Date fechaFin) {
		this.cine = cine;
		this.promocionPara = promocionPara;
		this.tipoPromocion = tipoPromocion;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}

	public Promocion(Cine cine, PromocionPara promocionPara, TipoPromocion tipoPromocion, String nombre,
			String descripcion, Date fechaInicio, Date fechaFin, Set<DetallePromoXPromo> detallePromoXPromos,
			Set<PromocionesXTicket> promocionesXTickets) {
		this.cine = cine;
		this.promocionPara = promocionPara;
		this.tipoPromocion = tipoPromocion;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.detallePromoXPromos = detallePromoXPromos;
		this.promocionesXTickets = promocionesXTickets;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_promocion", unique = true, nullable = false)
	public Integer getIdPromocion() {
		return this.idPromocion;
	}

	public void setIdPromocion(Integer idPromocion) {
		this.idPromocion = idPromocion;
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
	@JoinColumn(name = "id_promocion_para", nullable = false)
	public PromocionPara getPromocionPara() {
		return this.promocionPara;
	}

	public void setPromocionPara(PromocionPara promocionPara) {
		this.promocionPara = promocionPara;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipo_promocion", nullable = false)
	public TipoPromocion getTipoPromocion() {
		return this.tipoPromocion;
	}

	public void setTipoPromocion(TipoPromocion tipoPromocion) {
		this.tipoPromocion = tipoPromocion;
	}

	@Column(name = "nombre", nullable = false, length = 100)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "descripcion", nullable = false, length = 200)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_inicio", nullable = false, length = 19)
	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_fin", nullable = false, length = 19)
	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	@Column(name = "activo", nullable = false)
	public boolean isActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "promocion")
	public Set<DetallePromoXPromo> getDetallePromoXPromos() {
		return this.detallePromoXPromos;
	}

	public void setDetallePromoXPromos(Set<DetallePromoXPromo> detallePromoXPromos) {
		this.detallePromoXPromos = detallePromoXPromos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "promocion")
	public Set<PromocionesXTicket> getPromocionesXTickets() {
		return this.promocionesXTickets;
	}

	public void setPromocionesXTickets(Set<PromocionesXTicket> promocionesXTickets) {
		this.promocionesXTickets = promocionesXTickets;
	}

}
