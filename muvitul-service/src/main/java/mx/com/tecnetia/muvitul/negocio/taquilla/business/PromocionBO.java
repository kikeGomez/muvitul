package mx.com.tecnetia.muvitul.negocio.taquilla.business;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.PromocionDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.DetallePromocion;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Promocion;
import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.negocio.taquilla.assembler.PromocionAssembler;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.BoletoXTicketVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.PromocionBoletoVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.PromocionVO;
import mx.com.tecnetia.muvitul.servicios.util.Constantes;

@Service
@Transactional
public class PromocionBO {
	@Autowired
	private PromocionDAOI promocionDAO;

	public List<PromocionVO> findByCineAndDate(Integer idCine, Integer idPromocionPara, Date fechaExhibicion)
			throws BusinessGlobalException {
		return PromocionAssembler
				.getPromocionesVO(promocionDAO.findByCineAndDate(idCine, idPromocionPara, fechaExhibicion));
	}

	public BigDecimal getDescuentoByPromocion(PromocionBoletoVO promocionBoletoVO) throws BusinessGlobalException {
		BigDecimal descuento = new BigDecimal(0);
		BigDecimal total = new BigDecimal(0);
		int cantidadBoletos = 0;
		List<BigDecimal> importes = new ArrayList<BigDecimal>();
		for (BoletoXTicketVO boletoXTicketVO : promocionBoletoVO.getBoletosXTicketVO()) {
			total = total.add(boletoXTicketVO.getImporte());
			cantidadBoletos = cantidadBoletos + boletoXTicketVO.getCantidad();
			BigDecimal precioBoleto = new BigDecimal(0);
			precioBoleto = precioBoleto.add(boletoXTicketVO.getImporte());
			if (boletoXTicketVO.getCantidad() <= 0 || boletoXTicketVO.getImporte().intValue() <= 0)
				continue;
			precioBoleto = precioBoleto.divide(new BigDecimal(boletoXTicketVO.getCantidad()), 3, BigDecimal.ROUND_HALF_EVEN);
			for (int i = 0; i < boletoXTicketVO.getCantidad(); i++) {
				importes.add(precioBoleto);
			}
		}

		Collections.sort(importes);
		if (promocionBoletoVO != null) {
			Promocion promocion = promocionDAO.findById(promocionBoletoVO.getPromocionVO().getIdPromocion());

			if (promocion.getDetallePromocions() != null) {

				DetallePromocion detallePromocion = promocion.getDetallePromocions().iterator().next();

				switch (promocion.getTipoPromocion().getIdTipoPromocion()) {
				case Constantes.PROMOCION_NXM:
					if (detallePromocion.getVarN().intValue() <= cantidadBoletos) {
						int limit = detallePromocion.getVarN().intValue() - detallePromocion.getVarM().intValue();
						for (int i = 0; i < limit; i++) {
							descuento = descuento.add(importes.get(i));
						}

					}
					break;
				case Constantes.PROMOCION_NXFIJO:
					descuento = descuento.add(detallePromocion.getPrecio());
					break;
				case Constantes.PROMOCION_PORCIENTO:
					BigDecimal porcentaje = new BigDecimal(0);
					porcentaje = porcentaje.add(detallePromocion.getPorcentaje());
					porcentaje = porcentaje.divide(new BigDecimal(100));
					descuento = descuento.add(total);
					descuento = descuento.multiply(porcentaje);

					break;
				case Constantes.PROMOCION_REGALOX:
					break;
				default:
					break;
				}

			}
		}

		return descuento;
	}

}
