package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Pelicula;

public interface PeliculaDao extends GlobalHibernateDAOI<Pelicula>{

	List<Pelicula> findByDay();

}
