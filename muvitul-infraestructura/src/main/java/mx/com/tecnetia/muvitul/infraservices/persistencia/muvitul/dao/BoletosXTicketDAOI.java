package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.Date;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.BoletosXTicket;

public interface BoletosXTicketDAOI extends GlobalHibernateDAOI<BoletosXTicket>{
	long sumByProgramacion(Integer idProgramacion, Date fechaExhibicion );
}
