package mx.com.tecnetia.muvitul.negocio.taquilla.business;

import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.PeliculaVO;

public interface ProgramacionBOI {
	List<PeliculaVO> findByCineAndDay() throws BusinessGlobalException;
	
}
