package com.crm.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="venta_detalle")
public class VentaDetalleDto implements java.io.Serializable  {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="vend_id")
	private int id;
	
	@Column(name="vend_cantidad")
	private int cantidad;

	@Column(name="vend_vlr_producto")
	private double vlrProducto;
	
	@Column(name="vend_vlr_descuento")
	private double vlrDescuento;
	
	@Column(name="vend_vlr_iva")
	private double vlrIva;

	@Column(name="vend_subtotal")
	private double vlrSubTotal;
	
	@Transient
	private float pctDescuento;
	
	@ManyToOne
	@JoinColumn(name="pro_id")
	private ProductoDto productoDto;
	
	@Column(name="ven_id")
	private int venId;
	
	public VentaDetalleDto() {
		
	}

}
