package mx.com.tecnetia.muvitul.negocio.taquilla.vo;

public class TipoClienteVO {
	private Integer idTipoCliente;
	private String nombre;
	private boolean activo;
	
	public Integer getIdTipoCliente() {
		return idTipoCliente;
	}
	public void setIdTipoCliente(Integer idTipoCliente) {
		this.idTipoCliente = idTipoCliente;
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

}
