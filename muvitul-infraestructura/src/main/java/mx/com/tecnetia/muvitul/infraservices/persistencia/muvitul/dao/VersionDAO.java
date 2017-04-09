package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Version;

@Repository 
public class VersionDAO extends GlobalHibernateDAO<Version> implements VersionDAOI {

	@Override
	public List<Version> findByIdCine(Integer idCine) {
		StringBuilder hql = new StringBuilder();
		hql.append("select vra from Version vrs join vrs.cine cne ");
		hql.append("where cne.idCine=:idCine and vra.activo=1 ");
		hql.append("order by vra.idVersion desc");
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idCine", idCine);
		
		return query.list();
	}

}
