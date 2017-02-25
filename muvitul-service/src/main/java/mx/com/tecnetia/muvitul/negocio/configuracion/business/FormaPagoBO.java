package mx.com.tecnetia.muvitul.negocio.configuracion.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.FormaPagoDAOI;
import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.negocio.configuracion.assembler.FormaPagoAssembler;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.FormaPagoVO;

@Service
@Transactional
public class FormaPagoBO {
	@Autowired
	private FormaPagoDAOI formaPagoDAO;

	public List<FormaPagoVO> findFormasPago() throws BusinessGlobalException {
		return FormaPagoAssembler.getFormasPagosVO(formaPagoDAO.findAll());
	}

}
