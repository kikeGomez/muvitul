package mx.com.tecnetia.muvitul.negocio.taquilla.vo;

import java.util.List;

public class VentaVO {
	//private TicketVentaVO ticketVentaVO;
	private List<BoletoXTicketVO> boletosXTicketVO;
	private List<PromocionXTicketVO> promocionesXTicketVO;
	private List<PagoVO> pagosVO;
	
	public List<BoletoXTicketVO> getBoletosXTicketVO() {
		return boletosXTicketVO;
	}
	public void setBoletosXTicketVO(List<BoletoXTicketVO> boletosXTicketVO) {
		this.boletosXTicketVO = boletosXTicketVO;
	}
	public List<PagoVO> getPagosVO() {
		return pagosVO;
	}
	public void setPagosVO(List<PagoVO> pagosVO) {
		this.pagosVO = pagosVO;
	}
	public List<PromocionXTicketVO> getPromocionesXTicketVO() {
		return promocionesXTicketVO;
	}
	public void setPromocionesXTicketVO(List<PromocionXTicketVO> promocionesXTicketVO) {
		this.promocionesXTicketVO = promocionesXTicketVO;
	}
}
