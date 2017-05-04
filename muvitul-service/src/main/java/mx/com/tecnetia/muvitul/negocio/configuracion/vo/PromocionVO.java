package mx.com.tecnetia.muvitul.negocio.configuracion.vo;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import mx.com.tecnetia.muvitul.servicios.util.DateStringToDateDeserializer;
import mx.com.tecnetia.muvitul.servicios.util.DateToDateStringSerializer;

public class PromocionVO {
	private Integer idPromocion;
	private CineVO cineVO;
	private PromocionParaVO promocionParaVO;
	private TipoPromocionVO tipoPromocionVO;
	private String nombre;
	private String descripcion;
	@JsonDeserialize(using = DateStringToDateDeserializer.class)
	@JsonSerialize(using = DateToDateStringSerializer.class)
	private Date fechaInicio;
	@JsonDeserialize(using = DateStringToDateDeserializer.class)
	@JsonSerialize(using = DateToDateStringSerializer.class)
	private Date fechaFin;
	private boolean activo;
	private DetallePromocionVO detallePromocionVO;

	//	private Set<DetallePromocion> detallePromocions = new HashSet<DetallePromocion>(0);
//	private Set<PromocionesXTicket> promocionesXTickets = new HashSet<PromocionesXTicket>(0);
//	
	public Integer getIdPromocion() {
		return idPromocion;
	}
	public void setIdPromocion(Integer idPromocion) {
		this.idPromocion = idPromocion;
	}
	public CineVO getCineVO() {
		return cineVO;
	}
	public void setCineVO(CineVO cineVO) {
		this.cineVO = cineVO;
	}
	public PromocionParaVO getPromocionParaVO() {
		return promocionParaVO;
	}
	public void setPromocionParaVO(PromocionParaVO promocionParaVO) {
		this.promocionParaVO = promocionParaVO;
	}
	public TipoPromocionVO getTipoPromocionVO() {
		return tipoPromocionVO;
	}
	public void setTipoPromocionVO(TipoPromocionVO tipoPromocionVO) {
		this.tipoPromocionVO = tipoPromocionVO;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public DetallePromocionVO getDetallePromocionVO() {
		return detallePromocionVO;
	}
	public void setDetallePromocionVO(DetallePromocionVO detallePromocionVO) {
		this.detallePromocionVO = detallePromocionVO;
	}
}
