package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Programacion;

@Repository
public class ProgramacionDaoImpl extends GlobalHibernateDAO<Programacion> implements ProgramacionDao {

	@Override
	public List<Programacion> findByCineAndDay() {
		StringBuilder hql = new StringBuilder();
		hql.append("select pgr from Programacion pgr inner join pgr.pelicula plc inner join pgr.formato frm inner join pgr.version vrs inner join pgr.sala sla ");
		hql.append("where plc.cine.idCine=1 and pgr.diaSemana='L'  and plc.activo=1 ");
		hql.append("order by plc.cine.idCine asc ");
		
		return (List<Programacion>)getSession().createQuery(hql.toString()).list();
	}

}
