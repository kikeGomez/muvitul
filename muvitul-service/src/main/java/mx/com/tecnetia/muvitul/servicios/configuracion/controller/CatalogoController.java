package mx.com.tecnetia.muvitul.servicios.configuracion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.negocio.configuracion.business.CatalogoFormaPagoBO;
import mx.com.tecnetia.muvitul.negocio.configuracion.business.CatalogoPuntoVentaBO;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.FormaPagoVO;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.PuntoVentaVO;

@Service
public class CatalogoController {

	@Autowired
	private CatalogoFormaPagoBO catalogoFormaPagoBO;
	
	@Autowired
	private CatalogoPuntoVentaBO catalogoPuntoVentaBO;
	

	public List<FormaPagoVO> getFormasPagos() throws BusinessGlobalException {
		return catalogoFormaPagoBO.findAll();
	}

	public List<PuntoVentaVO> getPuntosVenta(Integer idCine)  throws BusinessGlobalException{
		return catalogoPuntoVentaBO.findByCine(idCine);
	}

}
