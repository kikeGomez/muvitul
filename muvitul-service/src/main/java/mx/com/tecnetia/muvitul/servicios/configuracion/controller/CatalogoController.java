package mx.com.tecnetia.muvitul.servicios.configuracion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.negocio.configuracion.business.FormaPagoBO;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.FormaPagoVO;

@Service
public class CatalogoController {

	@Autowired
	private FormaPagoBO formaPagoBO;

	public List<FormaPagoVO> getFormasPagos() throws BusinessGlobalException {
		return formaPagoBO.findFormasPago();
	}

}
