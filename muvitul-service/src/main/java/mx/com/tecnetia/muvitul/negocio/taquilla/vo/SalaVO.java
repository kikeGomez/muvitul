package mx.com.tecnetia.muvitul.negocio.taquilla.vo;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Cine;

public class SalaVO {
	private Integer idSala;
	private CineVO cineVO;
	public Integer getIdSala() {
		return idSala;
	}
	public void setIdSala(Integer idSala) {
		this.idSala = idSala;
	}
	public CineVO getCineVO() {
		return cineVO;
	}
	public void setCineVO(CineVO cineVO) {
		this.cineVO = cineVO;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	private String nombre;
	private boolean activo;
	
}
