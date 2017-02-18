package mx.com.tecnetia.muvitul.negocio.taquilla.business;

import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Programacion;
import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;

public interface ProgramacionBo {
	List<ProgramacionVo> findByCineAndDay() throws BusinessGlobalException;
	
}
