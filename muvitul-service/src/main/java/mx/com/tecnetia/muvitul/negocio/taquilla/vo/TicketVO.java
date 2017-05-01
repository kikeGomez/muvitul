package mx.com.tecnetia.muvitul.negocio.taquilla.vo;

import java.math.BigDecimal;

public class TicketVO {
	
	private String tituloTicket;
	private String  nombreEmpresa;
	private String avenidaEmpresa;
	private String coloniaEmpresa;
	private String rfcEmpresa;
	private BigDecimal iva;
	private BigDecimal totalPago;
	private Long folioTicket;
	private String leyenda;
	private DetalleTicketVO  detalleTicketVO;
	
	public String getTituloTicket() {
		return tituloTicket;
	}
	public void setTituloTicket(String tituloTicket) {
		this.tituloTicket = tituloTicket;
	}
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}
	public String getAvenidaEmpresa() {
		return avenidaEmpresa;
	}
	public void setAvenidaEmpresa(String avenidaEmpresa) {
		this.avenidaEmpresa = avenidaEmpresa;
	}
	public String getColoniaEmpresa() {
		return coloniaEmpresa;
	}
	public void setColoniaEmpresa(String coloniaEmpresa) {
		this.coloniaEmpresa = coloniaEmpresa;
	}
	public String getRfcEmpresa() {
		return rfcEmpresa;
	}
	public void setRfcEmpresa(String rfcEmpresa) {
		this.rfcEmpresa = rfcEmpresa;
	}
	public BigDecimal getIva() {
		return iva;
	}
	public void setIva(BigDecimal iva) {
		this.iva = iva;
	}
	public BigDecimal getTotalPago() {
		return totalPago;
	}
	public void setTotalPago(BigDecimal totalPago) {
		this.totalPago = totalPago;
	}
	public Long getFolioTicket() {
		return folioTicket;
	}
	public void setFolioTicket(Long folioTicket) {
		this.folioTicket = folioTicket;
	}
	public String getLeyenda() {
		return leyenda;
	}
	public void setLeyenda(String leyenda) {
		this.leyenda = leyenda;
	}
	public DetalleTicketVO getDetalleTicketVO() {
		return detalleTicketVO;
	}
	public void setDetalleTicketVO(DetalleTicketVO detalleTicketVO) {
		this.detalleTicketVO = detalleTicketVO;
	}
	
	
	
	 
}
