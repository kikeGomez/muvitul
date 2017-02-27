package mx.com.tecnetia.muvitul.servicios.taquilla.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.UsuarioFirmadoVO;
import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.negocio.taquilla.business.PeliculaBO;
import mx.com.tecnetia.muvitul.negocio.taquilla.business.PrecioXFormatoBO;
import mx.com.tecnetia.muvitul.negocio.taquilla.business.PromocionBO;
import mx.com.tecnetia.muvitul.negocio.taquilla.business.VentaBO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.PeliculaVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.PrecioXFormatoVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.PromocionVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.VentaVO;
import mx.com.tecnetia.muvitul.servicios.util.Fecha;

@Service
public class VentaBoletoController {
	
	@Autowired
	private PeliculaBO peliculaBO;
	@Autowired
	private PromocionBO promocionBO;
	@Autowired
	private PrecioXFormatoBO precioXFormatoBO;
	@Autowired
	private VentaBO ventaBO;
	
	
	public List<PeliculaVO> getPeliculasByCine(Integer idCine, String diaSemana ) throws BusinessGlobalException {
		return peliculaBO.findByCineAndDay(idCine,Fecha.getDayOfWeek());
	}
	
	public List<PromocionVO> getPromocionesByCine(Integer idCine, Date today) throws BusinessGlobalException {
		return promocionBO.findByCineAndDate(idCine, new Date());
	}

	public List<PrecioXFormatoVO> getPreciosByFormato(Integer idCine, Integer idFormato) throws BusinessGlobalException {
		return precioXFormatoBO.findPreciosByFormatoCine(idCine,idFormato);
	}

	public void createVenta(VentaVO ventaVO) throws BusinessGlobalException {
		ventaBO.createVenta(ventaVO);
	}
	
}
