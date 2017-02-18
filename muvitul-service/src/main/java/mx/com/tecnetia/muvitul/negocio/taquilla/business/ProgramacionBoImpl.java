package mx.com.tecnetia.muvitul.negocio.taquilla.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.ProgramacionDao;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Programacion;
import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;

@Service("programacionBo")
public class ProgramacionBoImpl {
	@Autowired
	private ProgramacionDao programacionDao;
	
	List<Programacion> findAll() throws BusinessGlobalException{
		return programacionDao.findByDay();
	}
	

}
