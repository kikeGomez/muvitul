package mx.com.tecnetia.muvitul.negocio.taquilla.business;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.PromocionDAOI;
import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.negocio.taquilla.assembler.PromocionAssembler;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.PromocionVO;

@Service
@Transactional
public class PromocionBO implements PromocionBOI {
	@Autowired
	private PromocionDAOI promocionDAO;

	@Override
	public List<PromocionVO> findByCineAndDate(Integer idCine, Date today) throws BusinessGlobalException {
		return PromocionAssembler.getPromocionesVO(promocionDAO.findByCineAndDate(idCine, today));
	}

}
