package mx.com.tecnetia.muvitul.negocio.configuracion.vo;

import java.util.List;

import mx.com.tecnetia.muvitul.negocio.dulceria.vo.ProductoVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.PromocionVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.RegaloVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.TipoPromocionVO;

public class ConfPromocionVO {
	List<TipoPromocionVO> tiposPromocionVO;
	List<PromocionVO> promocionesVO;
	List<RegaloVO> regalosVO;
	List<ProductoVO> productosVO;
	public List<TipoPromocionVO> getTiposPromocionVO() {
		return tiposPromocionVO;
	}
	public void setTiposPromocionVO(List<TipoPromocionVO> tiposPromocionVO) {
		this.tiposPromocionVO = tiposPromocionVO;
	}
	public List<PromocionVO> getPromocionesVO() {
		return promocionesVO;
	}
	public void setPromocionesVO(List<PromocionVO> promocionesVO) {
		this.promocionesVO = promocionesVO;
	}
	public List<RegaloVO> getRegalosVO() {
		return regalosVO;
	}
	public void setRegalosVO(List<RegaloVO> regalosVO) {
		this.regalosVO = regalosVO;
	}
	public List<ProductoVO> getProductosVO() {
		return productosVO;
	}
	public void setProductosVO(List<ProductoVO> productosVO) {
		this.productosVO = productosVO;
	}

}
