package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Pelicula;

@Repository 
public class PeliculaDaoImpl extends GlobalHibernateDAO<Pelicula> implements PeliculaDao {

	@Override
	public List<Pelicula> findByDay() {
		StringBuilder hql = new StringBuilder();
		hql.append("from Pelicula pel join pel.cine cine ");
		hql.append("where pel.activo=1");
		List<Pelicula> result= getSession().createQuery(hql.toString()).list();
		for (Pelicula pelicula : result) {
			System.out.println(pelicula.getTitulo());
		}
		return result;
	}

}
