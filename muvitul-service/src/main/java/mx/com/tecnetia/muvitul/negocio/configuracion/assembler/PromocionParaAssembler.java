package mx.com.tecnetia.muvitul.negocio.configuracion.assembler;

import java.util.ArrayList;
import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.PromocionPara;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.PromocionParaVO;


public class PromocionParaAssembler {

	public static PromocionParaVO getPromocionPara(PromocionPara promocionPara){

		if(promocionPara==null)
			return null;
		
		PromocionParaVO promocionParaVO = new PromocionParaVO();
		promocionParaVO.setIdPromocionPara(promocionPara.getIdPromocionPara());
		promocionParaVO.setNombre(promocionPara.getNombre());
		
		return promocionParaVO;
	}

	
	public static List<PromocionParaVO> getPromocionParaVO(List<PromocionPara> promocionesPara) {

		if (promocionesPara == null || promocionesPara.isEmpty())
			return null;

		List<PromocionParaVO> promocionesParaVO = new ArrayList<PromocionParaVO>();

		for (PromocionPara promocionPara : promocionesPara) {
			promocionesParaVO.add(PromocionParaAssembler.getPromocionPara(promocionPara));
		}

		return promocionesParaVO;
	}
	
	
}
