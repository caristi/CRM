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
	
	@Transient
	private float pctDescuento;
	
	@ManyToOne
	@JoinColumn(name="pro_id")
	private ProductoDto productoDto;
	
	@ManyToOne
	@JoinColumn(name="cot_id")
	private CotizacionCabeceraDto cotizacionDto;
	
	@Transient
	private boolean infoCompleta;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getVlrProducto() {
		return vlrProducto;
	}

	public void setVlrProducto(double vlrProducto) {
		this.vlrProducto = vlrProducto;
	}

	public double getVlrIva() {
		return vlrIva;
	}

	public void setVlrIva(double vlrIva) {
		this.vlrIva = vlrIva;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public ProductoDto getProductoDto() {
		return productoDto;
	}

	public void setProductoDto(ProductoDto productoDto) {
		this.productoDto = productoDto;
	}

	public double getVlrSubTotal() {
		return vlrSubTotal;
	}

	public void setVlrSubTotal(double vlrSubTotal) {
		this.vlrSubTotal = vlrSubTotal;
	}

	public double getVlrDescuento() {
		return vlrDescuento;
	}

	public void setVlrDescuento(double vlrDescuento) {
		this.vlrDescuento = vlrDescuento;
	}

	public float getPctDescuento() {
		return pctDescuento;
	}

	public void setPctDescuento(float pctDescuento) {
		this.pctDescuento = pctDescuento;
	}

	public boolean isInfoCompleta() {
		return infoCompleta;
	}

	public void setInfoCompleta(boolean infoCompleta) {
		this.infoCompleta = infoCompleta;
	}
}
