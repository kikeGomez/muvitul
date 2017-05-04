package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.MovimientoInventario;

@Repository 
public class MovimientoInventarioDAO extends GlobalHibernateDAO<MovimientoInventario> implements MovimientoInventarioDAOI {

	@Override
	public MovimientoInventario findByCineArticuloAndTipoMov(Integer idCine, Integer idArticulo, Integer idTipoMovInv) {
		StringBuilder hql = new StringBuilder();
		hql.append("select moi  from MovimientoInventario moi join moi.usuario.cine cne join moi.articulo art join moi.tipoMovimientoInv tdm ");
		hql.append("where cne.idCine=:idCine and art.idArticulo=:idArticulo and tdm.idTipoMovimientoInv=:idTipoMovInv " );
		hql.append("order by moi.idImpuestoBoleto desc ");

		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idCine", idCine);
		query.setParameter("idArticulo", idArticulo);
		query.setParameter("idTipoMovInv", idTipoMovInv);
		
		List<MovimientoInventario>  movimientosInventario = query.list();
		
		if (movimientosInventario!= null && movimientosInventario.isEmpty()){
			return movimientosInventario.get(0);
		}
		
		return null;
		
	}


}
