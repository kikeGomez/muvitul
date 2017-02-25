package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import org.springframework.stereotype.Repository;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.TicketVenta;

@Repository 
public class TicketVentaDAO extends GlobalHibernateDAO<TicketVenta> implements TicketVentaDAOI {


}
