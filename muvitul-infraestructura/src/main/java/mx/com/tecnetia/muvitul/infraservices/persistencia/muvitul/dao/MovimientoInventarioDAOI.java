package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.MovimientoInventario;

public interface MovimientoInventarioDAOI extends GlobalHibernateDAOI<MovimientoInventario>{
	MovimientoInventario findByCineArticuloAndTipoMov(Integer idCine, Integer idArticulo, Integer idTipoMovInv);
}
