package mx.com.tecnetia.muvitul.negocio.taquilla.vo;

import java.util.Date;

public class ExistenciaBoletoVO {
	private Integer idExistenciaBoletos;
	//private Programacion programacion;
	private Date fechaExhibicion;
	private long boletosReservados;
	
	public Integer getIdExistenciaBoletos() {
		return idExistenciaBoletos;
	}
	public void setIdExistenciaBoletos(Integer idExistenciaBoletos) {
		this.idExistenciaBoletos = idExistenciaBoletos;
	}
	public Date getFechaExhibicion() {
		return fechaExhibicion;
	}
	public void setFechaExhibicion(Date fechaExhibicion) {
		this.fechaExhibicion = fechaExhibicion;
	}
	public long getBoletosReservados() {
		return boletosReservados;
	}
	public void setBoletosReservados(long boletosReservados) {
		this.boletosReservados = boletosReservados;
	}
	
}
