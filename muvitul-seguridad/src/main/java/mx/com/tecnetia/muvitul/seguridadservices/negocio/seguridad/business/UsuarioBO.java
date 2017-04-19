package mx.com.tecnetia.muvitul.seguridadservices.negocio.seguridad.business;


import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.LoginResponseVO;
import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.RecursoVO;
import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.UserDetailsVO;
import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.UsuarioLoginVO;
import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.UsuarioVO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Perfil;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Usuario;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.enumeration.ClaimsEnum;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.enumeration.ErroresSeguridadEnum;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.enumeration.UsuarioEstatusEnum;
import mx.com.tecnetia.muvitul.infraservices.persistencia.utileria.business.FechasUtilsBO;
import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.infraservices.servicios.GlobalService;
import mx.com.tecnetia.muvitul.seguridadservices.negocio.seguridad.assembler.PerfilAssembler;
import mx.com.tecnetia.muvitul.seguridadservices.negocio.seguridad.assembler.UsuarioAssembler;
import mx.com.tecnetia.muvitul.seguridadservices.persistencia.muvitul.dao.RecursoDAOI;
import mx.com.tecnetia.muvitul.seguridadservices.persistencia.muvitul.dao.RecursoIbatisDAOI;
import mx.com.tecnetia.muvitul.seguridadservices.persistencia.muvitul.dao.UsuarioDAOI;
import mx.com.tecnetia.muvitul.seguridadservices.persistencia.muvitul.dao.UsuarioIbatisDAOI;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Configuration
@PropertySource({"classpath:config/${ENV_VAR}/global.properties","classpath:config/aplicacion/aplicacion.properties"})
public class UsuarioBO extends GlobalService{
 
	@Autowired
	UsuarioDAOI usuarioDAO;		
	@Autowired
	UsuarioIbatisDAOI usuarioIbatisDAO;		
	@Autowired
	StandardPBEStringEncryptor stringEcryptor;
	@Autowired
    Environment env;
	@Autowired
	RecursoIbatisDAOI recursoIbatisDAO;
	@Autowired
	RecursoDAOI recursoDAO;		
	
	/**
     * Servicio para validar la contrase�a actual de un usuario
     */
	@Transactional (readOnly=true)
	public boolean contraseniaActualValida(UsuarioLoginVO usuarioVO) throws Exception{
		 if (usuarioVO == null) 
	            throw new BusinessGlobalException("Error al validar contrasenia. El objeto de usuario no puede ser nulo.");
		 if (usuarioVO.getUsuario() == null) 
	            throw new BusinessGlobalException("Error al validar contrasenia. El usuario no puede ser nulo.");
		 if (usuarioVO.getContrasenia() == null) 
	            throw new BusinessGlobalException("Error al validar contrasenia. La contrasenia no puede ser nulo.");
			
		Usuario usuario = this.usuarioDAO.getUsuario(usuarioVO.getUsuario());
		if(usuario==null)
            throw new BusinessGlobalException("Error al validar contrasenia. No se encontr� el usuario actual.");
			
		 //Este metodo asume que la contrasenia viene encriptada con SHA1
		if(!usuarioVO.getContrasenia().equals(usuario.getContrasenia()))
			return false;
		
		return true;
	}
	
	/**
     * Servicio para cambiar la cotrase�a de un usuario
     */
	@Transactional (readOnly=false)
	public void cambiarContrasenia(UsuarioLoginVO usuarioVO) throws Exception{
		 if (usuarioVO == null) 
	            throw new BusinessGlobalException("Error al cambiar contrasenia. El objeto de usuario no puede ser nulo.");
	
		Usuario usuario = this.usuarioDAO.getUsuario(usuarioVO.getUsuario());
		usuario.setContrasenia(usuarioVO.getContrasenia());
		this.usuarioDAO.update(usuario);
	}
	
	@Transactional(readOnly = true)
	public LoginResponseVO autenticarConJwt(UsuarioLoginVO usuarioVO) throws BusinessGlobalException, Exception {
		 if (usuarioVO == null) 
	            throw new BusinessGlobalException("Error al autenticarse. El objeto de usuario no puede ser nulo.");
		 if (usuarioVO.getUsuario() == null) 
	            throw new BusinessGlobalException("Error al autenticarse. El usuario no puede ser nulo.");
		 if (usuarioVO.getContrasenia() == null) 
	            throw new BusinessGlobalException("Error al autenticarse. La contrase�a no puede ser nula.");
		 	     
		 //Buscamos al usuario. Que exista...
		 Usuario usuario = this.usuarioDAO.getUsuario(usuarioVO.getUsuario());
		 if (usuario==null)
		        return new LoginResponseVO(ErroresSeguridadEnum.USUARIO_NO_EXISTE);	

		 //Este metodo asume que la contrasenia viene encriptada con SHA1
		 if(!usuarioVO.getContrasenia().equals(usuario.getContrasenia()))
		        return new LoginResponseVO(ErroresSeguridadEnum.CONTRASENIA_INCORRECTA);	
	
		 if (UsuarioEstatusEnum.INACTIVO == usuario.getEstatusUsuario().getIdEstatus())
		        return new LoginResponseVO(ErroresSeguridadEnum.USUARIO_INACTIVO);	
		 
		 List<Integer> roles = PerfilAssembler.getPerfilesId(usuario.getPerfilesXUsuarios());
		 
		 String pwdEncryptor = env.getProperty("jwt.password");
		 Integer expirationMinutes = new Integer(env.getProperty("jwt.expiration.minutes"));
		 
		 Date fechaActual = FechasUtilsBO.getCurrentDate();
		 Date fechaExpriacion = FechasUtilsBO.addMinutesToDate(fechaActual, expirationMinutes);
		 
		 //Map<String,Object> claims = new HashMap<String,Object>();
		 //claims.put(ClaimsEnum.ROLES, roles);
		 //claims.put(ClaimsEnum.CINE, usuario.getIdCine());
		 
		 return new LoginResponseVO(
				       Jwts.builder().setSubject(usuarioVO.getUsuario())
				       	  			 .claim(ClaimsEnum.ROLES, roles)
				       	  			 .claim(ClaimsEnum.USUARIO, usuario.getIdUsuario())
				       	  			 .claim(ClaimsEnum.CINE, usuario.getCine().getIdCine())
				       	  			 .claim(ClaimsEnum.PUNTO_VENTA, usuario.getPuntoVenta()==null?null:usuario.getPuntoVenta().getIdPuntoVenta())
				       	  			 .setIssuedAt(fechaActual)
				       	  			 .setExpiration(fechaExpriacion)
				       	  			 .signWith(SignatureAlgorithm.HS256, pwdEncryptor)
				       	  			 .compact());
	}
	
	@Transactional(readOnly = true)
	private Boolean contieneRol(final Set<Perfil> rolesRecurso, final List<Integer> rolesUsr) throws BusinessGlobalException, Exception{
		if (rolesRecurso == null) 
            return false;
		if (rolesUsr == null) 
			return false;
		
		Iterator<Perfil> perfilesRecursoItr = rolesRecurso.iterator();
		while(perfilesRecursoItr.hasNext()){
			Perfil perfilRec = perfilesRecursoItr.next();
			if(rolesUsr.contains(perfilRec.getIdPerfil()))
				return true;
		}
		
		return false;
	}
	
	@Transactional(readOnly = true)
	public Boolean autorizaAccesoRecurso(RecursoVO recursoVO, List<Integer> roles) throws BusinessGlobalException, Exception{
		if (roles == null) 
            throw new BusinessGlobalException("Error al autorizar. El objeto claims no puede ser nulo.");
		if (recursoVO == null) 
            throw new BusinessGlobalException("Error al autorizar. El objeto recurso no puede ser nulo.");
		if (recursoVO.getUrl() == null) 
            throw new BusinessGlobalException("Error al autorizar. La url no puede ser nula.");

		//buscamos recursos activos para la aplicacion determinada
		recursoVO = this.recursoIbatisDAO.getRecursoPorUrl(recursoVO.getUrl(),true);
		if(recursoVO==null){
			//no existe ese recurso o no tiene permiso
		    return false;
		}
		
		if(!recursoVO.getPermitirATodos()){
			//validamos si tiene permiso el usuario, para ese recurso
			//return this.contieneRol(this.recursoDAO.findById(recursoVO.getIdRecurso()).getPerfils(), roles);
		}	
			
		return true;
	}
		

	@Transactional(readOnly = true)
	public UserDetailsVO getUserDetails(UsuarioVO usuarioVO) throws UsernameNotFoundException, DataAccessException{		
		if (usuarioVO == null) {
			throw new UsernameNotFoundException("Error en el servicio UsuarioController.getUserDetails el objeto de UsuarioVO no puede ser nulo");
		}
		if (usuarioVO.getCorreo() == null) {
			throw new UsernameNotFoundException("Error en el servicio UsuarioController.getUserDetails el correo no puede ser nulo");
		}
		
		Usuario usuario;
		try{
			usuario = this.usuarioDAO.getUsuario(usuarioVO.getCorreo());
		}catch(Exception e){
			throw new UsernameNotFoundException("Error en el servicio UsuarioController.getUserDetails no se puede obtener el usuario",e);			
		}
				
		UserDetailsVO userDetailsVO = UsuarioAssembler.getUserDetailsVO(usuario);
		if(userDetailsVO!=null && usuario!=null)
			userDetailsVO.setEnabled(usuario.getEstatusUsuario().getIdEstatus().equals(UsuarioEstatusEnum.ACTIVO));
		
		return userDetailsVO;	
	}

	@Transactional(readOnly = false)
	public void guardarUsuario(UsuarioVO usuarioVO) throws BusinessGlobalException, Exception{
		if (usuarioVO == null) 
            throw new BusinessGlobalException("Error al guardar usuario. El usuario no puede ser nulo.");
		
		this.usuarioDAO.save(UsuarioAssembler.getUsuario(usuarioVO));
	}
	
	/*@Transactional(readOnly = false)	
	public Boolean guardarUsuario(UsuarioVO usuarioVO) throws BusinessGlobalException, Exception{
		
		Usuario u1 =  new Usuario();
		EncripcionBO encripcionBO = new EncripcionBO();

		u1.setContrasenia(encripcionBO.encriptarConSHA1("ruiz"));
		u1.setCorreo("carlos.ruiz@unitis.com.mx");
		u1.setIdEstatus(1);
		u1.setMaterno("Perez");
		u1.setNombre("Fernando");
		u1.setPaterno("Perez");
		
		this.usuarioDAO.save(u1);

		
		//// BUSCAMOS POR IBATIS
		List<Usuario> usuarios = usuarioIbatisDAO.obtenerListaUsuarios();
		UsuarioAssembler.getUsuarios(usuarios, this.stringEcryptor);
			
		return true;	
	}*/
 
}