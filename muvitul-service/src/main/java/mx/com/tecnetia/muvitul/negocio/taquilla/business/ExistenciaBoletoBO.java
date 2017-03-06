package mx.com.tecnetia.muvitul.negocio.taquilla.business;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.CupoXSalaDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.ExistenciaBoletoDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.CupoXSala;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.ExistenciaBoletos;
import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.negocio.taquilla.assembler.ExistenciaBoletoAssembler;
import mx.com.tecnetia.muvitul.negocio.taquilla.assembler.ProgramacionAssembler;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.ExistenciaBoletoVO;

@Service
@Transactional
public class ExistenciaBoletoBO {
	@Autowired
	private ExistenciaBoletoDAOI existenciaBoletoDAO;
	
	@Autowired
	private CupoXSalaDAOI cupoXSalaDAO;

	public ExistenciaBoletoVO findByIdProgramacion(Integer idProgramacion, Integer idSala) throws BusinessGlobalException  {
		ExistenciaBoletos existenciaBoleto =existenciaBoletoDAO.findByIdProgramacion(idProgramacion);
		
		if (existenciaBoleto!=null){
			return ExistenciaBoletoAssembler.getExistenciaBoletoVO(existenciaBoleto);
		}
		
		CupoXSala cupoXSala = cupoXSalaDAO.findByIdSala(idSala);
		
		if (cupoXSala==null){
			throw new  BusinessGlobalException("Error al consultar existencia boletos.");
		}
		
		existenciaBoleto = new ExistenciaBoletos();
		existenciaBoleto.setProgramacion(ProgramacionAssembler.getProgramacion(idProgramacion));
		existenciaBoleto.setFechaExhibicion(new Date());
		existenciaBoleto.setBoletosReservados(cupoXSala.getNoAsientos());
		
		existenciaBoletoDAO.save(existenciaBoleto);
		
		return ExistenciaBoletoAssembler.getExistenciaBoletoVO(existenciaBoleto);
	}

	public ExistenciaBoletoVO update(ExistenciaBoletoVO existenciaBoletoVO)  throws BusinessGlobalException {
		ExistenciaBoletos existenciaBoletos= new ExistenciaBoletos();
		
		existenciaBoletoDAO.update(existenciaBoletos);
		return ExistenciaBoletoAssembler.getExistenciaBoletoVO(existenciaBoletos);
	}

}
