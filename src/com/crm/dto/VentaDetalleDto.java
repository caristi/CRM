package com.crm.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

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
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ven_id")
	private VentaCabeceraDto ventaDto;
	
	public VentaDetalleDto() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getVlrProducto() {
		return vlrProducto;
	}

	public void setVlrProducto(double vlrProducto) {
		this.vlrProducto = vlrProducto;
	}

	public double getVlrDescuento() {
		return vlrDescuento;
	}

	public void setVlrDescuento(double vlrDescuento) {
		this.vlrDescuento = vlrDescuento;
	}

	public double getVlrIva() {
		return vlrIva;
	}

	public void setVlrIva(double vlrIva) {
		this.vlrIva = vlrIva;
	}

	public double getVlrSubTotal() {
		return vlrSubTotal;
	}

	public void setVlrSubTotal(double vlrSubTotal) {
		this.vlrSubTotal = vlrSubTotal;
	}

	public float getPctDescuento() {
		return pctDescuento;
	}

	public void setPctDescuento(float pctDescuento) {
		this.pctDescuento = pctDescuento;
	}

	public ProductoDto getProductoDto() {
		return productoDto;
	}

	public void setProductoDto(ProductoDto productoDto) {
		this.productoDto = productoDto;
	}

	public VentaCabeceraDto getVentaDto() {
		return ventaDto;
	}

	public void setVentaDto(VentaCabeceraDto ventaDto) {
		this.ventaDto = ventaDto;
	}
	
}
