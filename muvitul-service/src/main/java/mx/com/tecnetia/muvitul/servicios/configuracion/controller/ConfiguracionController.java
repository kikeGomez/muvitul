package mx.com.tecnetia.muvitul.servicios.configuracion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.tecnetia.muvitul.negocio.configuracion.business.PaqueteBO;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.PaqueteVO;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.ProductoVO;

@Service
public class ConfiguracionController {

	@Autowired
	private PaqueteBO paqueteBO;

	public List<ProductoVO> findProductosByCine(Integer idCine) {
		return paqueteBO.findProductosByCine(idCine);
	}

	public List<PaqueteVO> findPaquetesByCine(Integer idCine) {
		return paqueteBO.findPaquetesByCine(idCine);
	}


}
