package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Promocion;

@Repository
public class PromocionDAO extends GlobalHibernateDAO<Promocion> implements PromocionDAOI{

	@Override
	public List<Promocion> findByCineAndDate(Integer idCine, Date today) {

		StringBuilder hql = new StringBuilder();
		hql.append("select prm from Promocion prm inner join prm.promocionPara prmp inner join prm.tipoPromocion tprm ");
		hql.append("where prm.cine.idCine=:idCine ");
		hql.append("order by prm.idPromocion desc");
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idCine", idCine);
		//query.setParameter("today", today);	
		return query.list();

	}

}
