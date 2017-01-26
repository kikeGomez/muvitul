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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * MateriaPrima generated by hbm2java
 */
@Entity
@Table(name="materia_prima"
    ,catalog="muvitul"
)
public class MateriaPrima  implements java.io.Serializable {


     private Integer idMateriaPrima;
     private Cine cine;
     private String nombre;
     private boolean activo;
     private Set<Producto> productos = new HashSet<Producto>(0);
     private Set<MovimientoInventario> movimientoInventarios = new HashSet<MovimientoInventario>(0);
     private Set<ExistenciaMatPrima> existenciaMatPrimas = new HashSet<ExistenciaMatPrima>(0);

    public MateriaPrima() {
    }

	
    public MateriaPrima(Cine cine, String nombre, boolean activo) {
        this.cine = cine;
        this.nombre = nombre;
        this.activo = activo;
    }
    public MateriaPrima(Cine cine, String nombre, boolean activo, Set<Producto> productos, Set<MovimientoInventario> movimientoInventarios, Set<ExistenciaMatPrima> existenciaMatPrimas) {
       this.cine = cine;
       this.nombre = nombre;
       this.activo = activo;
       this.productos = productos;
       this.movimientoInventarios = movimientoInventarios;
       this.existenciaMatPrimas = existenciaMatPrimas;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="id_materia_prima", unique=true, nullable=false)
    public Integer getIdMateriaPrima() {
        return this.idMateriaPrima;
    }
    
    public void setIdMateriaPrima(Integer idMateriaPrima) {
        this.idMateriaPrima = idMateriaPrima;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_cine", nullable=false)
    public Cine getCine() {
        return this.cine;
    }
    
    public void setCine(Cine cine) {
        this.cine = cine;
    }
    
    @Column(name="nombre", nullable=false, length=200)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Column(name="activo", nullable=false)
    public boolean isActivo() {
        return this.activo;
    }
    
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="materiaPrimas")
    public Set<Producto> getProductos() {
        return this.productos;
    }
    
    public void setProductos(Set<Producto> productos) {
        this.productos = productos;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="materiaPrima")
    public Set<MovimientoInventario> getMovimientoInventarios() {
        return this.movimientoInventarios;
    }
    
    public void setMovimientoInventarios(Set<MovimientoInventario> movimientoInventarios) {
        this.movimientoInventarios = movimientoInventarios;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="materiaPrima")
    public Set<ExistenciaMatPrima> getExistenciaMatPrimas() {
        return this.existenciaMatPrimas;
    }
    
    public void setExistenciaMatPrimas(Set<ExistenciaMatPrima> existenciaMatPrimas) {
        this.existenciaMatPrimas = existenciaMatPrimas;
    }




}


