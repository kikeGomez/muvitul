package mx.com.tecnetia.muvitul.negocio.taquilla.business;

import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Pelicula;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Programacion;
import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;

public interface PeliculaBo {
	List<Pelicula> findAll() throws BusinessGlobalException;
	List<Programacion> getProgramacionByCine() throws BusinessGlobalException;
	
}
