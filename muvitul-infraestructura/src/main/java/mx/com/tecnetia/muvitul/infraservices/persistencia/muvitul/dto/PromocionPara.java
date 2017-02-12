package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto;
// Generated 12/02/2017 04:03:11 PM by Hibernate Tools 4.3.1.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * PromocionPara generated by hbm2java
 */
@Entity
@Table(name = "promocion_para", catalog = "muvitul")
public class PromocionPara implements java.io.Serializable {

	private Integer idPromocionPara;
	private String nombre;
	private Set<Promocion> promocions = new HashSet<Promocion>(0);

	public PromocionPara() {
	}

	public PromocionPara(String nombre) {
		this.nombre = nombre;
	}

	public PromocionPara(String nombre, Set<Promocion> promocions) {
		this.nombre = nombre;
		this.promocions = promocions;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_promocion_para", unique = true, nullable = false)
	public Integer getIdPromocionPara() {
		return this.idPromocionPara;
	}

	public void setIdPromocionPara(Integer idPromocionPara) {
		this.idPromocionPara = idPromocionPara;
	}

	@Column(name = "nombre", nullable = false, length = 100)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "promocionPara")
	public Set<Promocion> getPromocions() {
		return this.promocions;
	}

	public void setPromocions(Set<Promocion> promocions) {
		this.promocions = promocions;
	}

}