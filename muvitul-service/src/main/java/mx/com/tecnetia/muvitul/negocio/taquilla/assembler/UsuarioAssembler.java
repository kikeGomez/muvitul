package mx.com.tecnetia.muvitul.negocio.taquilla.assembler;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Usuario;

public class UsuarioAssembler {
	
	public static Usuario getUsuario(Integer idUsuario){

		if(idUsuario==null)
			return null;
		
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(idUsuario);
		
		return usuario;
	}
	
	public static mx.com.tecnetia.muvitul.negocio.taquilla.vo.UsuarioVO getUsuarioVO(Integer idUsuario){

		if(idUsuario==null)
			return null;
		
		mx.com.tecnetia.muvitul.negocio.taquilla.vo.UsuarioVO usuarioVO = new mx.com.tecnetia.muvitul.negocio.taquilla.vo.UsuarioVO();
		usuarioVO.setIdUsuario(idUsuario);
		
		return usuarioVO;
	}
	
}