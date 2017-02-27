package mx.com.tecnetia.muvitul.servicios.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import mx.com.tecnetia.muvitul.infraservices.presentacion.seguridad.frontcontroller.UsuarioFirmadoBean;
import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.infraservices.servicios.NotFoundException;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.ConfProgramacionVO;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.ConfPromocionVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.ProgramacionVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.PromocionVO;
import mx.com.tecnetia.muvitul.servicios.configuracion.controller.CatalogoController;

@Service
public class ConfiguracionFacade implements ConfiguracionFacadeI{
	@Autowired
	UsuarioFirmadoBean usuarioFirmadoBean;
	@Autowired
	CatalogoController catalogoController;
	
	@Override
	public ResponseEntity<List<ConfProgramacionVO>> getConfProgramacion()
			throws BusinessGlobalException, NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResponseEntity<ProgramacionVO> createProgramacion(ProgramacionVO programacionVO)
			throws BusinessGlobalException, NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResponseEntity<List<ConfPromocionVO>> getConfPromocion() throws BusinessGlobalException, NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResponseEntity<PromocionVO> createPromocion(PromocionVO promocionVO)
			throws BusinessGlobalException, NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	

}
