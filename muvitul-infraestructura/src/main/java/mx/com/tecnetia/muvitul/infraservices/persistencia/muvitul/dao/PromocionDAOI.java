package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.Date;
import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Promocion;

public interface PromocionDAOI extends GlobalHibernateDAOI<Promocion>  {
	List<Promocion> findByCineAndDate(Integer idCine,Integer idPromocionPara,Date fechaExhibicion);
	List<Promocion> findByCineAndDate(Integer idCine,Date fechaExhibicion);
}
