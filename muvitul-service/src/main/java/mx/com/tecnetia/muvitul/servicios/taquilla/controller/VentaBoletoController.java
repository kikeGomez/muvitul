package mx.com.tecnetia.muvitul.servicios.taquilla.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.negocio.taquilla.business.ExistenciaBoletoBO;
import mx.com.tecnetia.muvitul.negocio.taquilla.business.PeliculaBO;
import mx.com.tecnetia.muvitul.negocio.taquilla.business.PrecioXFormatoBO;
import mx.com.tecnetia.muvitul.negocio.taquilla.business.PromocionBO;
import mx.com.tecnetia.muvitul.negocio.taquilla.business.VentaBoletoBO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.ExistenciaBoletoVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.PeliculaVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.PrecioXFormatoVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.PromocionVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.VentaVO;

@Service
public class VentaBoletoController {
	
	@Autowired
	private PeliculaBO peliculaBO;
	@Autowired
	private PromocionBO promocionBO;
	@Autowired
	private PrecioXFormatoBO precioXFormatoBO;
	@Autowired
	private VentaBoletoBO ventaBoletoBO;
	@Autowired
	private ExistenciaBoletoBO existenciaBoletoBO;
	
	
	public List<PeliculaVO> getPeliculasByCine(Integer idCine,String diaSemana, Date today ) throws BusinessGlobalException {
		return peliculaBO.findByCineAndDay(idCine,diaSemana, today);
	}
	
	public List<PromocionVO> getPromocionesByCine(Integer idCine, Integer idPromocionPara, Date today) throws BusinessGlobalException {
		return promocionBO.findByCineAndDate(idCine,idPromocionPara,today);
	}

	public List<PrecioXFormatoVO> getPreciosByFormato(Integer idCine, Integer idFormato) throws BusinessGlobalException {
		return precioXFormatoBO.findPreciosByFormatoCine(idCine,idFormato);
	}

	public ExistenciaBoletoVO getExistenciaBoleto(Integer idProgramacion, Integer idSala, Date fechaExhibicion) throws BusinessGlobalException{
		return existenciaBoletoBO.findByIdProgramacion(idProgramacion, idSala, fechaExhibicion);
	}
	
	public ExistenciaBoletoVO updateExistenciaBoleto(ExistenciaBoletoVO existenciaBoletoVO) throws BusinessGlobalException {
		return existenciaBoletoBO.update(existenciaBoletoVO);
	}
	

	public void createVenta(VentaVO ventaVO) throws BusinessGlobalException {
		ventaBoletoBO.createVenta(ventaVO);
	}

}
