package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.FormaPago;

@Repository 
public class FormaPagoDAO extends GlobalHibernateDAO<FormaPago> implements FormaPagoDAOI {

	public List<FormaPago> findAll(){
		StringBuilder hql = new StringBuilder();
		hql.append("select fdp  from FormaPago fdp ");
		hql.append("where fdp.activo=1 " );
		hql.append("order by fdp.idFormaPago asc ");

		Query query = getSession().createQuery(hql.toString());
		return query.list();
	}

}
