package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.ImpuestoXProducto;

@Repository 
public class ImpuestoXProductoDAO extends GlobalHibernateDAO<ImpuestoXProducto> implements ImpuestoXProductoDAOI {

	@Override
	public List<ImpuestoXProducto> findByIdCineAndIdProducto(Integer idCine, Integer idProducto) {
		StringBuilder hql = new StringBuilder();
		hql.append("select ixp  from ImpuestoXProducto ixp join ixp.cine cne join ixp.producto pdt ");
		hql.append("where cne.idCine=:idCine and pdt.idProducto=:idProducto and ixp.activo=1 " );
		hql.append("order by ixb.idImpuestoBoleto desc ");

		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idCine", idCine);
		query.setParameter("idProducto", idProducto);
		
		return query.list();
	}

}
