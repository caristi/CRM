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
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
	
	@Transient
	private int cantidadAEnviar;
	
	public SalidaDetalleDto() {
		
	}

}
