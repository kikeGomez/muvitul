package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Pelicula;

@Repository 
public class PeliculaDAO extends GlobalHibernateDAO<Pelicula> implements PeliculaDAOI {

	@Override
	public List<Pelicula> findByCineAndDay() {

		List<Pelicula> result = getSession().createCriteria(Pelicula.class)
			    .add( Restrictions.like("name", "Fritz%") )
			    .add( Restrictions.or( Restrictions.eq( "age", new Integer(0) ),
			        Restrictions.isNull("age")
			    ) )
			    .list();
		
		return result;
		
	}

}
