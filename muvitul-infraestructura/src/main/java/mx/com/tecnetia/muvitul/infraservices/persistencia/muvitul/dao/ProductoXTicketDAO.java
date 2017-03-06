package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import org.springframework.stereotype.Repository;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.ProductosXTicket;

@Repository 
public class ProductoXTicketDAO extends GlobalHibernateDAO<ProductosXTicket> implements ProductoXTicketDAOI {


}
