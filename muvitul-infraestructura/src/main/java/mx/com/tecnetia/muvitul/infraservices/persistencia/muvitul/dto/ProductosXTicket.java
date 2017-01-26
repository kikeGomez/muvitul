package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto;
// Generated 9/01/2017 07:06:09 PM by Hibernate Tools 3.2.1.GA


import java.math.BigDecimal;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * ProductosXTicket generated by hbm2java
 */
@Entity
@Table(name="productos_x_ticket"
    ,catalog="muvitul"
)
public class ProductosXTicket  implements java.io.Serializable {


     private ProductosXTicketId id;
     private TicketVenta ticketVenta;
     private Producto producto;
     private int cantidad;
     private BigDecimal importe;

    public ProductosXTicket() {
    }

    public ProductosXTicket(ProductosXTicketId id, TicketVenta ticketVenta, Producto producto, int cantidad, BigDecimal importe) {
       this.id = id;
       this.ticketVenta = ticketVenta;
       this.producto = producto;
       this.cantidad = cantidad;
       this.importe = importe;
    }
   
     @EmbeddedId
    
    @AttributeOverrides( {
        @AttributeOverride(name="idTicket", column=@Column(name="id_ticket", nullable=false) ), 
        @AttributeOverride(name="idProducto", column=@Column(name="id_producto", nullable=false) ) } )
    public ProductosXTicketId getId() {
        return this.id;
    }
    
    public void setId(ProductosXTicketId id) {
        this.id = id;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_ticket", nullable=false, insertable=false, updatable=false)
    public TicketVenta getTicketVenta() {
        return this.ticketVenta;
    }
    
    public void setTicketVenta(TicketVenta ticketVenta) {
        this.ticketVenta = ticketVenta;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_producto", nullable=false, insertable=false, updatable=false)
    public Producto getProducto() {
        return this.producto;
    }
    
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    @Column(name="cantidad", nullable=false)
    public int getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    @Column(name="importe", nullable=false, precision=15)
    public BigDecimal getImporte() {
        return this.importe;
    }
    
    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }




}


