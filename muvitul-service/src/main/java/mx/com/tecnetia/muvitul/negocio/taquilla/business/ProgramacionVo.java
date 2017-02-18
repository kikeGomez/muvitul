package mx.com.tecnetia.muvitul.negocio.taquilla.business;

import java.util.ArrayList;
import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Programacion;

public class ProgramacionVo {
	private String nombrePelicula;
	private List<Programacion> programaciones= new ArrayList<Programacion>();
	
	public void  addProgramacion(Programacion programacion){
		programaciones.add(programacion);
	}
	
	public String getNombrePelicula() {
		return nombrePelicula;
	}
	public void setNombrePelicula(String nombrePelicula) {
		this.nombrePelicula = nombrePelicula;
	}
	public List<Programacion> getProgramaciones() {
		return programaciones;
	}
	public void setProgramacion(List<Programacion> programaciones) {
		this.programaciones = programaciones;
	}
}
