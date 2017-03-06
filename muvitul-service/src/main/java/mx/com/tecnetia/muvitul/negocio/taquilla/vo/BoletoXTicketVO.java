package mx.com.tecnetia.muvitul.negocio.taquilla.vo;

import java.math.BigDecimal;
import java.util.Date;

public class BoletoXTicketVO {
	private TipoClienteVO tipoClienteVO;
	private int cantidad;
	private BigDecimal importe;
	private ProgramacionVO pagramacionVO;
	private Date fechaExhibicion;
	
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
	public ProgramacionVO getPagramacionVO() {
		return pagramacionVO;
	}
	public void setPagramacionVO(ProgramacionVO pagramacionVO) {
		this.pagramacionVO = pagramacionVO;
	}
	public Date getFechaExhibicion() {
		return fechaExhibicion;
	}
	public void setFechaExhibicion(Date fechaExhibicion) {
		this.fechaExhibicion = fechaExhibicion;
	}
	
}
