package com.crm.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="compra")
public class CompraDto implements java.io.Serializable{
	
	private static final long serialVersionUID = 1;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="com_id")
	private int id;

	@Column(name="com_fecha")
	private Date fecha;
	
	@Column(name="com_cantidad")
	private int cantidad;
	
	@Column(name="com_observacion")
	private String observacion;
	
	@Column(name="com_vlr_total")
	private double vlrTotal;
	
	@ManyToOne
	@JoinColumn(name="pro_id")
	private ProductoDto productoDto;
	
	@ManyToOne
	@JoinColumn(name="prov_id")
	private ProveedorDto proveedorDto;
	
	@ManyToOne
	@JoinColumn(name="usu_id")
	private UsuarioDto usuarioDto;
	
	public CompraDto() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public double getVlrTotal() {
		return vlrTotal;
	}

	public void setVlrTotal(double vlrTotal) {
		this.vlrTotal = vlrTotal;
	}

	public ProductoDto getProductoDto() {
		return productoDto;
	}

	public void setProductoDto(ProductoDto productoDto) {
		this.productoDto = productoDto;
	}

	public ProveedorDto getProveedorDto() {
		return proveedorDto;
	}

	public void setProveedorDto(ProveedorDto proveedorDto) {
		this.proveedorDto = proveedorDto;
	}

	public UsuarioDto getUsuarioDto() {
		return usuarioDto;
	}

	public void setUsuarioDto(UsuarioDto usuarioDto) {
		this.usuarioDto = usuarioDto;
	}
}
