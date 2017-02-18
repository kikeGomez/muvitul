package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Programacion;

public interface ProgramacionDao  extends GlobalHibernateDAOI<Programacion>{

	List<Programacion> findByDay();

}
