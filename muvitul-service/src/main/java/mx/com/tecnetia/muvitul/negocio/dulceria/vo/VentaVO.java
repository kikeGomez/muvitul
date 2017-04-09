package mx.com.tecnetia.muvitul.negocio.dulceria.vo;

import java.util.List;

public class VentaVO {
	private Integer idUsuario;
	private Integer idPuntoVenta;
	private Integer idCine;
	private List<PaqueteVO> paquetesVO;
	private List<PagoVO> pagosVO;
	
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Integer getIdPuntoVenta() {
		return idPuntoVenta;
	}
	public void setIdPuntoVenta(Integer idPuntoVenta) {
		this.idPuntoVenta = idPuntoVenta;
	}
	public Integer getIdCine() {
		return idCine;
	}
	public void setIdCine(Integer idCine) {
		this.idCine = idCine;
	}
	public List<PaqueteVO> getPaquetesVO() {
		return paquetesVO;
	}
	public void setPaquetesVO(List<PaqueteVO> paquetesVO) {
		this.paquetesVO = paquetesVO;
	}
	public List<PagoVO> getPagosVO() {
		return pagosVO;
	}
	public void setPagosVO(List<PagoVO> pagosVO) {
		this.pagosVO = pagosVO;
	}
	
}
