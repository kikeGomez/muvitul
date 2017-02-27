package mx.com.tecnetia.muvitul.negocio.taquilla.vo;

import java.math.BigDecimal;
import java.util.Date;

import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.UsuarioFirmadoVO;

public class TicketVentaVO {
	private PuntoVentaVO puntoVentaVO;
	private UsuarioFirmadoVO usuarioFirmadoVO;
	private Date fecha;
	private BigDecimal descuento;
	private BigDecimal importe;
	private BigDecimal iva;
	private BigDecimal total;
	
	public PuntoVentaVO getPuntoVentaVO() {
		return puntoVentaVO;
	}
	public void setPuntoVentaVO(PuntoVentaVO puntoVentaVO) {
		this.puntoVentaVO = puntoVentaVO;
	}
	public UsuarioFirmadoVO getUsuarioFirmadoVO() {
		return usuarioFirmadoVO;
	}
	public void setUsuarioFirmadoVO(UsuarioFirmadoVO usuarioFirmadoVO) {
		this.usuarioFirmadoVO = usuarioFirmadoVO;
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
