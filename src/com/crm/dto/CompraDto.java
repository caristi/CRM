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

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
	
//	@ManyToOne
//	@JoinColumn(name="prov_id")
//	private ProveedorDto proveedorDto;
	
	@ManyToOne
	@JoinColumn(name="usu_id")
	private UsuarioDto usuarioDto;
	
	public CompraDto() {
	}

}
