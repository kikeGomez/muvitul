package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import org.springframework.stereotype.Repository;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Pelicula;

@Repository 
public class PeliculaDaoImpl extends GlobalHibernateDAO<Pelicula> implements PeliculaDao {

}
