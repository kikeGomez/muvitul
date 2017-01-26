package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto;
// Generated 9/01/2017 07:06:09 PM by Hibernate Tools 3.2.1.GA


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PromocionesXTicketId generated by hbm2java
 */
@Embeddable
public class PromocionesXTicketId  implements java.io.Serializable {


     private int idTicket;
     private int idPromocion;

    public PromocionesXTicketId() {
    }

    public PromocionesXTicketId(int idTicket, int idPromocion) {
       this.idTicket = idTicket;
       this.idPromocion = idPromocion;
    }
   

    @Column(name="id_ticket", nullable=false)
    public int getIdTicket() {
        return this.idTicket;
    }
    
    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    @Column(name="id_promocion", nullable=false)
    public int getIdPromocion() {
        return this.idPromocion;
    }
    
    public void setIdPromocion(int idPromocion) {
        this.idPromocion = idPromocion;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof PromocionesXTicketId) ) return false;
		 PromocionesXTicketId castOther = ( PromocionesXTicketId ) other; 
         
		 return (this.getIdTicket()==castOther.getIdTicket())
 && (this.getIdPromocion()==castOther.getIdPromocion());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdTicket();
         result = 37 * result + this.getIdPromocion();
         return result;
   }   


}


