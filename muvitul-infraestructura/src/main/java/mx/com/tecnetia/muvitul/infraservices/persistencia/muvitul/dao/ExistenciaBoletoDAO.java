package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.ExistenciaBoletos;

@Repository 
public class ExistenciaBoletoDAO extends GlobalHibernateDAO<ExistenciaBoletos> implements ExistenciaBoletoDAOI {

	@Override
	public ExistenciaBoletos findByIdProgramacion(Integer idProgramacion) {
		StringBuilder hql = new StringBuilder();
		hql.append(" select exb from ExistenciaBoletos exb ");
		hql.append("where exb.programacion.idProgramacion=:idProgramacion and exb.activo=1 " );
		hql.append("order by exb.idExistenciaBoletos desc ");

		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idProgramacion", idProgramacion);
		List<ExistenciaBoletos> result =query.list();
		
		if (!result.isEmpty()){
			return result.get(0);
		}
		
		return null;
	}


}
