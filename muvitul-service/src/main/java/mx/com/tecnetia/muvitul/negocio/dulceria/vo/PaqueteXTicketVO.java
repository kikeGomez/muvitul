package mx.com.tecnetia.muvitul.negocio.dulceria.vo;

import java.math.BigDecimal;

public class PaqueteXTicketVO {
	private PaqueteVO paqueteVO;
	private int cantidad;
	private BigDecimal importe;
	
	public PaqueteVO getPaqueteVO() {
		return paqueteVO;
	}
	public void setPaqueteVO(PaqueteVO paqueteVO) {
		this.paqueteVO = paqueteVO;
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
