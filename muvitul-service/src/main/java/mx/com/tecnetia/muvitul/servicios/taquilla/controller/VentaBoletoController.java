package mx.com.tecnetia.muvitul.servicios.taquilla.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.negocio.taquilla.business.PeliculaBO;
import mx.com.tecnetia.muvitul.negocio.taquilla.business.PromocionBO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.PeliculaVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.PromocionVO;
import mx.com.tecnetia.muvitul.servicios.util.Fecha;

@Service
public class VentaBoletoController {
	
	@Autowired
	private PeliculaBO peliculaBO;
	@Autowired
	private PromocionBO promocionBO;
	
	
	public List<PeliculaVO> findPeliculasByCine(Integer idCine, String diaSemana ) throws BusinessGlobalException {
		return peliculaBO.findByCineAndDay(idCine,Fecha.getDayOfWeek());
	}
	
	public List<PromocionVO> findPromocionesByCine(Integer idCine, Date today) throws BusinessGlobalException {
		return promocionBO.findByCineAndDate(idCine, new Date());
	}
	
}
