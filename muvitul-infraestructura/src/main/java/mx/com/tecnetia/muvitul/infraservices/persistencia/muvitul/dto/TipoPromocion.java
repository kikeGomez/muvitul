package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto;
// Generated 9/01/2017 07:06:09 PM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TipoPromocion generated by hbm2java
 */
@Entity
@Table(name="tipo_promocion"
    ,catalog="muvitul"
)
public class TipoPromocion  implements java.io.Serializable {


     private Integer idTipoPromocion;
     private int nombre;
     private Set<Promocion> promocions = new HashSet<Promocion>(0);

    public TipoPromocion() {
    }

	
    public TipoPromocion(int nombre) {
        this.nombre = nombre;
    }
    public TipoPromocion(int nombre, Set<Promocion> promocions) {
       this.nombre = nombre;
       this.promocions = promocions;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="id_tipo_promocion", unique=true, nullable=false)
    public Integer getIdTipoPromocion() {
        return this.idTipoPromocion;
    }
    
    public void setIdTipoPromocion(Integer idTipoPromocion) {
        this.idTipoPromocion = idTipoPromocion;
    }
    
    @Column(name="nombre", nullable=false)
    public int getNombre() {
        return this.nombre;
    }
    
    public void setNombre(int nombre) {
        this.nombre = nombre;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="tipoPromocion")
    public Set<Promocion> getPromocions() {
        return this.promocions;
    }
    
    public void setPromocions(Set<Promocion> promocions) {
        this.promocions = promocions;
    }




}


