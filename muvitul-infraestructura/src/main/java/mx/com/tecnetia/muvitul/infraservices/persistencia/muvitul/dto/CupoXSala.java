package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto;
// Generated 9/01/2017 07:06:09 PM by Hibernate Tools 3.2.1.GA


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * CupoXSala generated by hbm2java
 */
@Entity
@Table(name="cupo_x_sala"
    ,catalog="muvitul"
)
public class CupoXSala  implements java.io.Serializable {


     private Integer idCupoXSala;
     private Sala sala;
     private int noAsientos;
     private boolean activo;

    public CupoXSala() {
    }

    public CupoXSala(Sala sala, int noAsientos, boolean activo) {
       this.sala = sala;
       this.noAsientos = noAsientos;
       this.activo = activo;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="id_cupo_x_sala", unique=true, nullable=false)
    public Integer getIdCupoXSala() {
        return this.idCupoXSala;
    }
    
    public void setIdCupoXSala(Integer idCupoXSala) {
        this.idCupoXSala = idCupoXSala;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_sala", nullable=false)
    public Sala getSala() {
        return this.sala;
    }
    
    public void setSala(Sala sala) {
        this.sala = sala;
    }
    
    @Column(name="no_asientos", nullable=false)
    public int getNoAsientos() {
        return this.noAsientos;
    }
    
    public void setNoAsientos(int noAsientos) {
        this.noAsientos = noAsientos;
    }
    
    @Column(name="activo", nullable=false)
    public boolean isActivo() {
        return this.activo;
    }
    
    public void setActivo(boolean activo) {
        this.activo = activo;
    }




}


