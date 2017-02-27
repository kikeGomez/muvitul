package mx.com.tecnetia.muvitul.negocio.taquilla.assembler;

import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.UsuarioFirmadoVO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Usuario;

public class UsuarioAssembler {
	
	public static Usuario getUsuario(UsuarioFirmadoVO usuarioFirmadoVO){

		if(usuarioFirmadoVO==null)
			return null;
		
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(usuarioFirmadoVO.getId());
		
		return usuario;
	}

}