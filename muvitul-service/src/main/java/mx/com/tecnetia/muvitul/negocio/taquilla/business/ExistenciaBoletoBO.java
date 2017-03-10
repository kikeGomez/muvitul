package mx.com.tecnetia.muvitul.negocio.taquilla.business;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.CupoXSalaDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.ExistenciaBoletoDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.CupoXSala;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.ExistenciaBoletos;
import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.negocio.taquilla.assembler.ExistenciaBoletoAssembler;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.ExistenciaBoletoVO;

@Service
@Transactional
public class ExistenciaBoletoBO {
	@Autowired
	private ExistenciaBoletoDAOI existenciaBoletoDAO;
	
	@Autowired
	private CupoXSalaDAOI cupoXSalaDAO;

	public ExistenciaBoletoVO findByIdProgramacion(Integer idProgramacion, Integer idSala, Date today) throws BusinessGlobalException  {
		
		CupoXSala cupoXSala = cupoXSalaDAO.findByIdSala(idSala);
		
		if (cupoXSala==null){
			throw new  BusinessGlobalException("Error al consultar existencia boletos.");
		}
		
		ExistenciaBoletos existenciaBoleto =existenciaBoletoDAO.findByIdProgramacion(idProgramacion,today);
		
		if (existenciaBoleto==null){
			existenciaBoleto = ExistenciaBoletoAssembler.getExistenciaBoleto(idProgramacion);
			existenciaBoletoDAO.save(existenciaBoleto);
		}
		
		ExistenciaBoletoVO existenciaBoletoVO= ExistenciaBoletoAssembler.getExistenciaBoletoVO(existenciaBoleto);
		existenciaBoletoVO.setDisponbles(cupoXSala.getNoAsientos()-existenciaBoleto.getBoletosReservados());
		
		return  existenciaBoletoVO;
	}

	public ExistenciaBoletoVO update(ExistenciaBoletoVO existenciaBoletoVO)  throws BusinessGlobalException {
		
		CupoXSala cupoXSala = cupoXSalaDAO.findByIdSala(existenciaBoletoVO.getProgramacionVO().getSalaVO().getIdSala());
		
		if (cupoXSala==null){
			throw new  BusinessGlobalException("Error al actualizar existencia boletos.");
		}
		
//		if (cupoXSala.getNoAsientos()<=existenciaBoleto.getBoletosReservados() ){
//		throw new  BusinessGlobalException("Sala no disponible");
//	}
		
		
		ExistenciaBoletos existenciaBoleto =existenciaBoletoDAO.findByIdProgramacion(
				existenciaBoletoVO.getProgramacionVO().getIdProgramacion(),existenciaBoletoVO.getFechaExhibicion());
		
		if (existenciaBoleto==null){
			existenciaBoleto= ExistenciaBoletoAssembler.getExistenciaBoleto(existenciaBoletoVO);
		}
		
		existenciaBoleto.setBoletosReservados(existenciaBoleto.getBoletosReservados()+existenciaBoletoVO.getReservar());
		existenciaBoletoDAO.saveOrUpdate(existenciaBoleto);
		
		//existenciaBoletoVO.setDisponbles(cupoXSala.getNoAsientos()-existenciaBoleto.getBoletosReservados());
		
		return existenciaBoletoVO;
	}

}
