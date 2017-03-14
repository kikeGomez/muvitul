package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto;
// Generated 13/03/2017 10:51:10 PM by Hibernate Tools 4.3.1.Final

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * ImpuestoBoleto generated by hbm2java
 */
@Entity
@Table(name = "impuesto_boleto", catalog = "muvitul")
public class ImpuestoBoleto implements java.io.Serializable {

	private Integer idImpuestoBoleto;
	private Cine cine;
	private String nombre;
	private BigDecimal porcentaje;
	private boolean activo;
	private Set<ImpuestosXTicketTaquilla> impuestosXTicketTaquillas = new HashSet<ImpuestosXTicketTaquilla>(0);

	public ImpuestoBoleto() {
	}

	public ImpuestoBoleto(Cine cine, String nombre, BigDecimal porcentaje, boolean activo) {
		this.cine = cine;
		this.nombre = nombre;
		this.porcentaje = porcentaje;
		this.activo = activo;
	}

	public ImpuestoBoleto(Cine cine, String nombre, BigDecimal porcentaje, boolean activo,
			Set<ImpuestosXTicketTaquilla> impuestosXTicketTaquillas) {
		this.cine = cine;
		this.nombre = nombre;
		this.porcentaje = porcentaje;
		this.activo = activo;
		this.impuestosXTicketTaquillas = impuestosXTicketTaquillas;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_impuesto_boleto", unique = true, nullable = false)
	public Integer getIdImpuestoBoleto() {
		return this.idImpuestoBoleto;
	}

	public void setIdImpuestoBoleto(Integer idImpuestoBoleto) {
		this.idImpuestoBoleto = idImpuestoBoleto;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cine", nullable = false)
	public Cine getCine() {
		return this.cine;
	}

	public void setCine(Cine cine) {
		this.cine = cine;
	}

	@Column(name = "nombre", nullable = false, length = 50)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "porcentaje", nullable = false, precision = 15)
	public BigDecimal getPorcentaje() {
		return this.porcentaje;
	}

	public void setPorcentaje(BigDecimal porcentaje) {
		this.porcentaje = porcentaje;
	}

	@Column(name = "activo", nullable = false)
	public boolean isActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "impuestoBoleto")
	public Set<ImpuestosXTicketTaquilla> getImpuestosXTicketTaquillas() {
		return this.impuestosXTicketTaquillas;
	}

	public void setImpuestosXTicketTaquillas(Set<ImpuestosXTicketTaquilla> impuestosXTicketTaquillas) {
		this.impuestosXTicketTaquillas = impuestosXTicketTaquillas;
	}

}
