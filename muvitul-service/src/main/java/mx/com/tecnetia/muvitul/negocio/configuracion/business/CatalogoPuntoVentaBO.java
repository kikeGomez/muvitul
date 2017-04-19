package mx.com.tecnetia.muvitul.negocio.configuracion.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.PuntoVentaDAOI;
import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.PuntoVentaVO;

@Service
@Transactional
public class CatalogoPuntoVentaBO {
	@Autowired
	private PuntoVentaDAOI puntoVentaDAO;

	public List<PuntoVentaVO> findByCine(Integer idCine) throws BusinessGlobalException  {
		puntoVentaDAO.findByIdCine(idCine);
		return null;
	}

}
