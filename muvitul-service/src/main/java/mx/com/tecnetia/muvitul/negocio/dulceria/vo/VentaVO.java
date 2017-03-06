package mx.com.tecnetia.muvitul.negocio.dulceria.vo;

import java.util.List;

public class VentaVO {
	private TicketVentaVO ticketVentaVO;
	private List<PaqueteXTicketVO> paquetesXTicketVO;
	private List<ProductoXTicketVO> productosXTicketVO;
	private List<PagoVO> pagos;
	
	public TicketVentaVO getTicketVentaVO() {
		return ticketVentaVO;
	}
	public void setTicketVentaVO(TicketVentaVO ticketVentaVO) {
		this.ticketVentaVO = ticketVentaVO;
	}
	public List<PaqueteXTicketVO> getPaquetesXTicketVO() {
		return paquetesXTicketVO;
	}
	public void setPaquetesXTicketVO(List<PaqueteXTicketVO> paquetesXTicketVO) {
		this.paquetesXTicketVO = paquetesXTicketVO;
	}
	public List<ProductoXTicketVO> getProductosXTicketVO() {
		return productosXTicketVO;
	}
	public void setProductosXTicketVO(List<ProductoXTicketVO> productosXTicketVO) {
		this.productosXTicketVO = productosXTicketVO;
	}
	public List<PagoVO> getPagos() {
		return pagos;
	}
	public void setPagos(List<PagoVO> pagos) {
		this.pagos = pagos;
	}
	
}
