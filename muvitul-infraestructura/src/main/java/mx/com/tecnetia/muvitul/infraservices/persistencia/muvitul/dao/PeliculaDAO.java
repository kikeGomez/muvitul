package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Pelicula;

@Repository 
public class PeliculaDAO extends GlobalHibernateDAO<Pelicula> implements PeliculaDAOI {

	@Override
	public List<Pelicula> findByIdCine(Integer idCine) {
		
		StringBuilder hql = new StringBuilder();
		hql.append("select pla from Pelicula pla join pla.cine cne ");
		hql.append("where cne.idCine=:idCine and pla.activo=1 ");
		hql.append("order by pla.titulo asc");
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idCine", idCine);
		
		return query.list();
		
	}

}
