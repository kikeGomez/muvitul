package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Programacion;

@Repository
public class ProgramacionDAO extends GlobalHibernateDAO<Programacion> implements ProgramacionDAOI {

	@Override
	public List<Programacion> findByCineDiaAndExhibicion(Integer idCine, String diaSemana, Date fechaExhibicion) {
		StringBuilder hql = new StringBuilder();
		hql.append("select pgr from Programacion pgr inner join pgr.pelicula plc inner join pgr.formato frm inner join pgr.version vrs inner join pgr.sala sla ");
		hql.append("where plc.cine.idCine=:idCine and pgr.diaSemana=:diaSemana and pgr.fechaVigencia>=:fechaExhibicion and pgr.activo=1 and plc.activo=1 ");
		hql.append("order by pgr.horario asc");
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idCine", idCine);
		query.setParameter("diaSemana", diaSemana);	
		query.setParameter("fechaExhibicion", fechaExhibicion);	
		
		return query.list();
	}

	@Override
	public List<Programacion> findByCineSalaAndExhibicion(Integer idCine,Integer idSala, Date fechaExhibicion) {
		StringBuilder hql = new StringBuilder();
		hql.append("select pgr from Programacion pgr inner join pgr.pelicula plc inner join pgr.formato frm inner join pgr.version vrs inner join pgr.sala sla ");
		hql.append("where plc.cine.idCine=:idCine and sla.idSala=:idSala  and pgr.fechaVigencia>=:fechaExhibicion and pgr.activo=1 and plc.activo=1 ");
		hql.append("order by pgr.horario asc");
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idCine", idCine);
		query.setParameter("idSala", idSala);
		query.setParameter("fechaExhibicion", fechaExhibicion);	
		
		return query.list();
	}

}
