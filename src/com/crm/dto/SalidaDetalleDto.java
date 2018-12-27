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

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="salida_detalle")
@DynamicUpdate
public class SalidaDetalleDto implements java.io.Serializable  {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sald_id")
	private int id;
	
	@Column(name="sald_cantidad_enviada")
	private int cantidadEnviada;
	
	@Column(name="sald_cantidad_vendido")
	private int cantidadVendida;
	
	@Column(name="sald_mca_enviada")
	private char mcaEnviada;
	
	@Column(name="sald_observacion")
	private String observacion;
	
	@Column(name="sald_fec_actu")
	private Date fechaActu;

	@Column(name="sald_fec_enviado")
	private Date fechaEnviado;
	
	@Column(name="sald_pct_avance")
	private float pctEnviado;
	
	@ManyToOne
	@JoinColumn(name="pro_id")
	private ProductoDto productoDto;
	
	@Column(name="sal_id")
	private int salId;
	
	@ManyToOne
	@JoinColumn(name="usu_id")
	private UsuarioDto usuarioDto;
	
	public SalidaDetalleDto() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantidadEnviada() {
		return cantidadEnviada;
	}

	public void setCantidadEnviada(int cantidadEnviada) {
		this.cantidadEnviada = cantidadEnviada;
	}

	public int getCantidadVendida() {
		return cantidadVendida;
	}

	public void setCantidadVendida(int cantidadVendida) {
		this.cantidadVendida = cantidadVendida;
	}

	public char getMcaEnviada() {
		return mcaEnviada;
	}

	public void setMcaEnviada(char mcaEnviada) {
		this.mcaEnviada = mcaEnviada;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Date getFechaActu() {
		return fechaActu;
	}

	public void setFechaActu(Date fechaActu) {
		this.fechaActu = fechaActu;
	}

	public Date getFechaEnviado() {
		return fechaEnviado;
	}

	public void setFechaEnviado(Date fechaEnviado) {
		this.fechaEnviado = fechaEnviado;
	}

	public float getPctEnviado() {
		return pctEnviado;
	}

	public void setPctEnviado(float pctEnviado) {
		this.pctEnviado = pctEnviado;
	}

	public ProductoDto getProductoDto() {
		return productoDto;
	}

	public void setProductoDto(ProductoDto productoDto) {
		this.productoDto = productoDto;
	}

	public int getSalId() {
		return salId;
	}

	public void setSalId(int salId) {
		this.salId = salId;
	}

	public UsuarioDto getUsuarioDto() {
		return usuarioDto;
	}

	public void setUsuarioDto(UsuarioDto usuarioDto) {
		this.usuarioDto = usuarioDto;
	}
}
