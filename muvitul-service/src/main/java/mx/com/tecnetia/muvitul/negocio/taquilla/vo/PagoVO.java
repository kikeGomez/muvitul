package mx.com.tecnetia.muvitul.negocio.taquilla.vo;

import java.math.BigDecimal;
import java.util.Date;

public class PagoVO {
	private Integer idPago;
	private EstatusPagoVO estatusPagoVO;
	private FormaPagoVO formaPagoVO;
	private String noCuenta;
	private BigDecimal importe;
	private Date fecha;
	
	public Integer getIdPago() {
		return idPago;
	}
	public void setIdPago(Integer idPago) {
		this.idPago = idPago;
	}
	public EstatusPagoVO getEstatusPagoVO() {
		return estatusPagoVO;
	}
	public void setEstatusPagoVO(EstatusPagoVO estatusPagoVO) {
		this.estatusPagoVO = estatusPagoVO;
	}
	public FormaPagoVO getFormaPagoVO() {
		return formaPagoVO;
	}
	public void setFormaPagoVO(FormaPagoVO formaPagoVO) {
		this.formaPagoVO = formaPagoVO;
	}
	public String getNoCuenta() {
		return noCuenta;
	}
	public void setNoCuenta(String noCuenta) {
		this.noCuenta = noCuenta;
	}
	public BigDecimal getImporte() {
		return importe;
	}
	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
}
