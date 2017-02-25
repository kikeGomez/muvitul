package mx.com.tecnetia.muvitul.negocio.dulceria.vo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Usuario;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.PagoVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.PuntoVentaVO;

public class VentaVO {
	private Usuario usuarioVO;
	private PuntoVentaVO puntoVentaVO;
	private List<PagoVO> pagosVO;
	private Date fecha;
	private BigDecimal descuento;
	private BigDecimal importe;
	private BigDecimal iva;
	private BigDecimal total;
	
	public Usuario getUsuarioVO() {
		return usuarioVO;
	}
	public void setUsuarioVO(Usuario usuarioVO) {
		this.usuarioVO = usuarioVO;
	}
	public PuntoVentaVO getPuntoVentaVO() {
		return puntoVentaVO;
	}
	public void setPuntoVentaVO(PuntoVentaVO puntoVentaVO) {
		this.puntoVentaVO = puntoVentaVO;
	}
	public List<PagoVO> getPagosVO() {
		return pagosVO;
	}
	public void setPagosVO(List<PagoVO> pagosVO) {
		this.pagosVO = pagosVO;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public BigDecimal getDescuento() {
		return descuento;
	}
	public void setDescuento(BigDecimal descuento) {
		this.descuento = descuento;
	}
	public BigDecimal getImporte() {
		return importe;
	}
	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}
	public BigDecimal getIva() {
		return iva;
	}
	public void setIva(BigDecimal iva) {
		this.iva = iva;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	
}
