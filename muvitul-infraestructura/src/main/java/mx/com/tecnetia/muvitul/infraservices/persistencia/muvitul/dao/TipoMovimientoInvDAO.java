package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.TipoMovimientoInv;

@Repository 
public class TipoMovimientoInvDAO extends GlobalHibernateDAO<TipoMovimientoInv> implements TipoMovimientoInvDAOI {

	@Override
	public TipoMovimientoInv findByClave(String clave) {
		StringBuilder hql = new StringBuilder();
		hql.append("select tmi from TipoMovimientoInv tmi  ");
		hql.append("where tmi.clave=:clave and tmi.activo=1 ");
		hql.append("order by tmi.idTipoMovimientoInv desc");
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("clave", clave);
		
		List<TipoMovimientoInv>  tipoMovimientosInv = query.list();
		
		if (tipoMovimientosInv!= null && tipoMovimientosInv.isEmpty()){
			return tipoMovimientosInv.get(0);
		}
		
		return null;
		
	}


}
