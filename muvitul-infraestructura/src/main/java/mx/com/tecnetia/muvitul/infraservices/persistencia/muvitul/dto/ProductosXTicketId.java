package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto;
// Generated 9/01/2017 07:06:09 PM by Hibernate Tools 3.2.1.GA


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ProductosXTicketId generated by hbm2java
 */
@Embeddable
public class ProductosXTicketId  implements java.io.Serializable {


     private int idTicket;
     private int idProducto;

    public ProductosXTicketId() {
    }

    public ProductosXTicketId(int idTicket, int idProducto) {
       this.idTicket = idTicket;
       this.idProducto = idProducto;
    }
   

    @Column(name="id_ticket", nullable=false)
    public int getIdTicket() {
        return this.idTicket;
    }
    
    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    @Column(name="id_producto", nullable=false)
    public int getIdProducto() {
        return this.idProducto;
    }
    
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ProductosXTicketId) ) return false;
		 ProductosXTicketId castOther = ( ProductosXTicketId ) other; 
         
		 return (this.getIdTicket()==castOther.getIdTicket())
 && (this.getIdProducto()==castOther.getIdProducto());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdTicket();
         result = 37 * result + this.getIdProducto();
         return result;
   }   


}


