package mx.com.tecnetia.muvitul.negocio.taquilla.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.PrecioXFormatoDAOI;
import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.negocio.taquilla.assembler.PrecioXFormatoAssembler;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.PrecioXFormatoVO;

@Service
@Transactional
public class PrecioXFormatoBO {

	@Autowired
	private PrecioXFormatoDAOI precioXFormatoDAO;

	public List<PrecioXFormatoVO> findPreciosByFormatoCine(Integer idCine, Integer idFormato)
			throws BusinessGlobalException {

		return PrecioXFormatoAssembler.getPreciosXFormatoVO(precioXFormatoDAO.findPreciosByFormatoCine(idCine, idFormato));

	}

}
