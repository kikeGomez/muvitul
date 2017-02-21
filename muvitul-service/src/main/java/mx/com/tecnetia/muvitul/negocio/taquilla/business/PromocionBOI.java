package mx.com.tecnetia.muvitul.negocio.taquilla.business;

import java.util.Date;
import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.PromocionVO;

public interface PromocionBOI {
	List<PromocionVO> findByCineAndDate(Integer idCine, Date today) throws BusinessGlobalException;
}
