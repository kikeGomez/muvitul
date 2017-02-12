package mx.com.tecnetia.muvitul.infraservices.presentacion.seguridad.frontcontroller;

import org.springframework.stereotype.Component;

@Component
 public class UsuarioFirmadoBean  {
	private String user;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	 
	
}
