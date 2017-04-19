package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.Date;
import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Programacion;

public interface ProgramacionDAOI  extends GlobalHibernateDAOI<Programacion>{
	List<Programacion> findByCineDiaAndExhibicion(Integer idCine, String diaSemana,  Date fechaExhibicion);
	List<Programacion> findByCineSalaAndExhibicion(Integer idCine, Integer idSala, Date fechaExhibicion);
}
