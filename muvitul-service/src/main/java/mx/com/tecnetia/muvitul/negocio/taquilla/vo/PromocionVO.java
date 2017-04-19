package mx.com.tecnetia.muvitul.negocio.taquilla.vo;

import java.util.Date;
import java.util.List;

public class PromocionVO {
	private Integer idPromocion;
	private CineVO cineVO;
	private PromocionParaVO promocionParaVO;
	private TipoPromocionVO tipoPromocionVO;
	private String nombre;
	private String descripcion;
	private Date fechaInicio;
	private Date fechaFin;
	private boolean activo;

	private List<DetallePromocionVO> detallePromocionesVO;
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
	public List<DetallePromocionVO> getDetallePromocionesVO() {
		return detallePromocionesVO;
	}
	public void setDetallePromocionesVO(List<DetallePromocionVO> detallePromocionesVO) {
		this.detallePromocionesVO = detallePromocionesVO;
	}
}
