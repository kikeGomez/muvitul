package mx.com.tecnetia.muvitul.negocio.taquilla.vo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Usuario;

public class VentaVO {
	private Usuario usuarioVO;
	private PuntoVentaVO puntoVentaVO;
	private List<BoletoVO> boletosVO;
	private List<PagoVO> pagosVO;
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
	public List<BoletoVO> getBoletosVO() {
		return boletosVO;
	}
	public void setBoletosVO(List<BoletoVO> boletosVO) {
		this.boletosVO = boletosVO;
	}
	public List<PagoVO> getPagosVO() {
		return pagosVO;
	}
	public void setPagosVO(List<PagoVO> pagosVO) {
		this.pagosVO = pagosVO;
	}
	public List<PromocionVO> getPromocionesVO() {
		return promocionesVO;
	}
	public void setPromocionesVO(List<PromocionVO> promocionesVO) {
		this.promocionesVO = promocionesVO;
	}
	public DescuentoVO getDescuentoVO() {
		return descuentoVO;
	}
	public void setDescuentoVO(DescuentoVO descuentoVO) {
		this.descuentoVO = descuentoVO;
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
	private List<PromocionVO> promocionesVO;
	private DescuentoVO descuentoVO;
	private Date fecha;
	private BigDecimal descuento;
	private BigDecimal importe;
	private BigDecimal iva;
	private BigDecimal total;
	

}
