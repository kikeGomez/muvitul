package mx.com.tecnetia.muvitul.negocio.taquilla.vo;

import java.util.Date;

public class ExistenciaBoletoVO {
	private Integer idExistenciaBoletos;
	private ProgramacionVO programacionVO;
	private Date fechaExhibicion;
	private long boletosReservados;
	private Date fechaReserva;
	private long disponibles;
	private int reservar;
	private String color;

	public Integer getIdExistenciaBoletos() {
		return idExistenciaBoletos;
	}
	public void setIdExistenciaBoletos(Integer idExistenciaBoletos) {
		this.idExistenciaBoletos = idExistenciaBoletos;
	}
	public ProgramacionVO getProgramacionVO() {
		return programacionVO;
	}
	public void setProgramacionVO(ProgramacionVO programacionVO) {
		this.programacionVO = programacionVO;
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
	public Date getFechaReserva() {
		return fechaReserva;
	}
	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}
	public long getDisponibles() {
		return disponibles;
	}
	public void setDisponibles(long disponibles) {
		this.disponibles = disponibles;
	}
	public int getReservar() {
		return reservar;
	}
	public void setReservar(int reservar) {
		this.reservar = reservar;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
}
