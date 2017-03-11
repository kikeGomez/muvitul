package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.Date;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.BoletosXTicket;

@Repository 
public class BoletosXTicketDAO extends GlobalHibernateDAO<BoletosXTicket> implements BoletosXTicketDAOI {

	@Override
	public long  sumByProgramacion(Integer idProgramacion, Date fechaExhibicion) {
		StringBuilder hql = new StringBuilder();
		hql.append("select sum(bxt.cantidad)  from BoletosXTicket bxt ");
		hql.append("where bxt.programacion.idProgramacion=:idProgramacion and bxt.fechaExhibicion=:fechaExhibicion " );

		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idProgramacion", idProgramacion);
		query.setParameter("fechaExhibicion", fechaExhibicion);
		Long result=(Long) query.uniqueResult();
		if (result==null){
			return 0;
		}
		return result ;
			
	}


}
