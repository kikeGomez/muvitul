package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto;
// Generated 14-abr-2017 14:25:39 by Hibernate Tools 4.3.1.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PaquetesXPuntoVentaId generated by hbm2java
 */
@Embeddable
public class PaquetesXPuntoVentaId implements java.io.Serializable {

	private int idPuntoVenta;
	private int idPaquete;

	public PaquetesXPuntoVentaId() {
	}

	public PaquetesXPuntoVentaId(int idPuntoVenta, int idPaquete) {
		this.idPuntoVenta = idPuntoVenta;
		this.idPaquete = idPaquete;
	}

	@Column(name = "id_punto_venta", nullable = false)
	public int getIdPuntoVenta() {
		return this.idPuntoVenta;
	}

	public void setIdPuntoVenta(int idPuntoVenta) {
		this.idPuntoVenta = idPuntoVenta;
	}

	@Column(name = "id_paquete", nullable = false)
	public int getIdPaquete() {
		return this.idPaquete;
	}

	public void setIdPaquete(int idPaquete) {
		this.idPaquete = idPaquete;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PaquetesXPuntoVentaId))
			return false;
		PaquetesXPuntoVentaId castOther = (PaquetesXPuntoVentaId) other;

		return (this.getIdPuntoVenta() == castOther.getIdPuntoVenta())
				&& (this.getIdPaquete() == castOther.getIdPaquete());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getIdPuntoVenta();
		result = 37 * result + this.getIdPaquete();
		return result;
	}

}
