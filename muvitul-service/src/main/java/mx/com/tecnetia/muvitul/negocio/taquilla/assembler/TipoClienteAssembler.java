package mx.com.tecnetia.muvitul.negocio.taquilla.assembler;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.TipoCliente;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.TipoClienteVO;

public class TipoClienteAssembler {

	public static TipoClienteVO getTipoClienteVO(TipoCliente tipoCliente){

		if(tipoCliente==null )
			return null;
		
		TipoClienteVO tipoClienteVO = new TipoClienteVO();
		tipoClienteVO.setIdTipoCliente(tipoCliente.getIdTipoCliente());
		tipoClienteVO.setNombre(tipoCliente.getNombre());
		tipoClienteVO.setActivo(tipoCliente.isActivo());

		return tipoClienteVO;
	}
	
	
}
