package mx.com.tecnetia.muvitul.negocio.dulceria.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.PuntoVentaDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.PuntoVenta;
import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.negocio.dulceria.assembler.PaqueteAssembler;
import mx.com.tecnetia.muvitul.negocio.dulceria.vo.PaqueteVO;

@Service
@Transactional
public class PuntoVentaBO {
	@Autowired
	private PuntoVentaDAOI puntoVentaDAO;
	
	public List<PaqueteVO> getPaquetes(Integer idPuntoVenta)  throws BusinessGlobalException {
		
		List<PaqueteVO> paquetesVO=new ArrayList<PaqueteVO>();
		PuntoVenta puntoVenta= puntoVentaDAO.findById(idPuntoVenta);
//		if(puntoVenta.getPaquetes()!=null && !puntoVenta.getPaquetes().isEmpty()){
//			paquetesVO.addAll(PaqueteAssembler.getPaquetesVO(puntoVenta.getPaquetes()));
//		}
//
//		if(puntoVenta.getProductos()!=null && !puntoVenta.getProductos().isEmpty()){
//			paquetesVO.addAll(PaqueteAssembler.getPaquetesVOXProducto(puntoVenta.getProductos()));
//		}
		

		return paquetesVO ;
		
	}
	


}
