package com.crm.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="cabecera_factura")
public class FacturaDetalleDto implements java.io.Serializable  {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="det_id")
	private int id;

	@Column(name="det_vlr_producto")
	private double vlrProducto;
	
	@Column(name="det_vlr_iva")
	private double vlrIva;

	@Column(name="det_cantidad")
	private int cantidad;
	
	@ManyToOne
	@JoinColumn(name="pro_id")
	private ProductoDto productoDto;
	
}
