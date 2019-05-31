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
@Table(name="cotizacion_detalle")
public class CotizacionDetalleDto implements java.io.Serializable  {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cotd_id")
	private int id;

	@Column(name="cotd_vlr_producto")
	private double vlrProducto;
	
	@Column(name="cotd_vlr_iva")
	private double vlrIva;

	@Column(name="cotd_cantidad")
	private int cantidad;

	@Column(name="cotd_subtotal")
	private double vlrSubTotal;
	
	@Column(name="cotd_descuento")
	private double vlrDescuento;

	@Column(name="cot_id")
	private int codId;
	
	@Transient
	private float pctDescuento;
	
	@ManyToOne
	@JoinColumn(name="pro_id")
	private ProductoDto productoDto;
	
	@Transient
	private boolean infoCompleta;
	
	public CotizacionDetalleDto() {
		
	}
}
