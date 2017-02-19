package mx.com.tecnetia.muvitul.negocio.taquilla.business;

import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.PeliculaVO;

public interface PeliculaBOI {
	List<PeliculaVO> findByCineAndDay(Integer idCine, String diaSemana) throws BusinessGlobalException;
	
}
