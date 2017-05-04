package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.TipoMovimientoInv;

public interface TipoMovimientoInvDAOI extends GlobalHibernateDAOI<TipoMovimientoInv>{
	
	TipoMovimientoInv findByClave(String clave);

}
