package mx.com.tecnetia.muvitul.negocio.taquilla.vo;

import java.math.BigDecimal;

public class BoletoXTicketVO {
	private FormatoVO formatoVO;
	private TipoClienteVO tipoClienteVO;
	private int cantidad;
	private BigDecimal importe;
	
	public FormatoVO getFormatoVO() {
		return formatoVO;
	}
	public void setFormatoVO(FormatoVO formatoVO) {
		this.formatoVO = formatoVO;
	}
	public TipoClienteVO getTipoClienteVO() {
		return tipoClienteVO;
	}
	public void setTipoClienteVO(TipoClienteVO tipoClienteVO) {
		this.tipoClienteVO = tipoClienteVO;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public BigDecimal getImporte() {
		return importe;
	}
	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}
	
}
