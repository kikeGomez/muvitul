package mx.com.tecnetia.muvitul.negocio.dulceria.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.PaqueteDAOI;
import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.negocio.dulceria.assembler.PaqueteAssembler;
import mx.com.tecnetia.muvitul.negocio.dulceria.vo.PaqueteVO;

@Service
@Transactional
public class PaqueteBO {
	@Autowired
	private PaqueteDAOI paqueteDAO;

	public List<PaqueteVO> findByPuntoVenta(Integer idPuntoVenta)  throws BusinessGlobalException {
		return PaqueteAssembler.getPaquetesVO(paqueteDAO.findByPuntoVenta(idPuntoVenta));
	}
	


}
