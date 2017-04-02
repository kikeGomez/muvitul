package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Paquete;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Producto;

@Repository 
public class ProductoDAO extends GlobalHibernateDAO<Producto> implements ProductoDAOI {

	@Override
	public List<Producto> findByPuntoVenta(Integer idPuntoVenta) {
		
		StringBuilder hql = new StringBuilder();
		hql.append(" select paq  from Paquete paq inner join paq.puntoVenta pdv ");
		hql.append("where pdv.idPuntoVenta=:idPuntoVenta and paq.activo=1 " );
		hql.append("order by paq.idPaquete desc ");

		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idPuntoVenta", idPuntoVenta);
		return query.list();
	}

}