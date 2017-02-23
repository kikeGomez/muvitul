package mx.com.tecnetia.muvitul.negocio.taquilla.vo;

import java.math.BigDecimal;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Producto;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Regalo;

public class DetallePromocionVO {
	private Integer idDetallePromocion;
	//private Producto producto;
	private RegaloVO regaloVO;
	private BigDecimal varN;
	private BigDecimal varM;
	private BigDecimal precio;
	private BigDecimal porcentaje;
	
	public Integer getIdDetallePromocion() {
		return idDetallePromocion;
	}
	public void setIdDetallePromocion(Integer idDetallePromocion) {
		this.idDetallePromocion = idDetallePromocion;
	}
	public RegaloVO getRegaloVO() {
		return regaloVO;
	}
	public void setRegaloVO(RegaloVO regaloVO) {
		this.regaloVO = regaloVO;
	}
	public BigDecimal getVarN() {
		return varN;
	}
	public void setVarN(BigDecimal varN) {
		this.varN = varN;
	}
	public BigDecimal getVarM() {
		return varM;
	}
	public void setVarM(BigDecimal varM) {
		this.varM = varM;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	public BigDecimal getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(BigDecimal porcentaje) {
		this.porcentaje = porcentaje;
	}
	
	
}
