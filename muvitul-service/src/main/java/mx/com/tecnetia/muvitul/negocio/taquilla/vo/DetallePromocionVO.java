package mx.com.tecnetia.muvitul.negocio.taquilla.vo;

import java.math.BigDecimal;

public class DetallePromocionVO {
	private Integer idDetallePromocion;
	private ProductoVO productoVO;
	private RegaloVO regaloVO;
	private BigDecimal varN;
	private BigDecimal varM;
	private BigDecimal precio;
	private BigDecimal porcentaje;
//	private Set<Promocion> promocions = new HashSet<Promocion>(0);
	
	public Integer getIdDetallePromocion() {
		return idDetallePromocion;
	}
	public void setIdDetallePromocion(Integer idDetallePromocion) {
		this.idDetallePromocion = idDetallePromocion;
	}
	public ProductoVO getProductoVO() {
		return productoVO;
	}
	public void setProductoVO(ProductoVO productoVO) {
		this.productoVO = productoVO;
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
