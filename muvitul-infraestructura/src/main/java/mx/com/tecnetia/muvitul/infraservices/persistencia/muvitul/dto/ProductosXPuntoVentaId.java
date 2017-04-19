package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto;
// Generated 14-abr-2017 14:25:39 by Hibernate Tools 4.3.1.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ProductosXPuntoVentaId generated by hbm2java
 */
@Embeddable
public class ProductosXPuntoVentaId implements java.io.Serializable {

	private int idPuntoVenta;
	private int idProducto;

	public ProductosXPuntoVentaId() {
	}

	public ProductosXPuntoVentaId(int idPuntoVenta, int idProducto) {
		this.idPuntoVenta = idPuntoVenta;
		this.idProducto = idProducto;
	}

	@Column(name = "id_punto_venta", nullable = false)
	public int getIdPuntoVenta() {
		return this.idPuntoVenta;
	}

	public void setIdPuntoVenta(int idPuntoVenta) {
		this.idPuntoVenta = idPuntoVenta;
	}

	@Column(name = "id_producto", nullable = false)
	public int getIdProducto() {
		return this.idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ProductosXPuntoVentaId))
			return false;
		ProductosXPuntoVentaId castOther = (ProductosXPuntoVentaId) other;

		return (this.getIdPuntoVenta() == castOther.getIdPuntoVenta())
				&& (this.getIdProducto() == castOther.getIdProducto());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getIdPuntoVenta();
		result = 37 * result + this.getIdProducto();
		return result;
	}

}
