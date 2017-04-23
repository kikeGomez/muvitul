package mx.com.tecnetia.muvitul.negocio.taquilla.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BoletoXTicketVO {
	private TipoClienteVO tipoClienteVO;
	private int cantidad;
	private BigDecimal importe;
	private ProgramacionVO programacionVO;
	@JsonFormat(pattern="dd/MM/yyyy")
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
	public ProgramacionVO getProgramacionVO() {
		return programacionVO;
	}
	public void setProgramacionVO(ProgramacionVO programacionVO) {
		this.programacionVO = programacionVO;
	}
	public Date getFechaExhibicion() {
		return fechaExhibicion;
	}
	public void setFechaExhibicion(Date fechaExhibicion) {
		this.fechaExhibicion = fechaExhibicion;
	}
	
}
