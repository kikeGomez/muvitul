package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Programacion;

@Repository
public class ProgramacionDaoImpl extends GlobalHibernateDAO<Programacion>  implements ProgramacionDao {

	@Override
	public List<Programacion> findByDay() {
		List<Programacion> list = null;
		
		try {

			StringBuilder hql = new StringBuilder();
			hql.append("from Programacion pgr join pgr.version vrs ");
			//hql.append("from Programacion pgr inner join pgr.pelicula plc inner join pgr.formato frm inner join pgr.version vrs inner join pgr.sala sla ");
			//hql.append("where plc.cine.idCine=1 and pgr.diaSemana='L'  and plc.activo=1 ");
			hql.append("where pgr.diaSemana='L' ");

			Query query= getSession().createQuery(hql.toString());
			list= (List<Programacion>) query.list();
					

			for (Programacion programacion : list) {
				System.out.println("*********: "+programacion.getIdProgramacion());
			}
			
			
//			Criteria criteria = getSession().createCriteria(getClazz());
//			criteria.add(Restrictions.eq("diaSemana", "M"));          
//			criteria.addOrder(Order.desc("idProgramacion"));       
//			criteria.setFetchMode("pelicula", FetchMode.JOIN);
//			return criteria.list();
			
		} catch (Exception e) {
			System.out.println("********************");
			e.printStackTrace();
			// TODO: handle exception
		}
		return list;

	}

}
