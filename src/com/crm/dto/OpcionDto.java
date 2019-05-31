package com.crm.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="opcion")
public class OpcionDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="opc_id")
	private int id;
	
	@Column(name="opc_codigo")
	private int codigo;
	
	@Column(name="opc_url")
	private String url;
	
	@Column(name="opc_descripcion")
	private String descripcion;
	
	@Column(name="opc_tipo")
	private String tipo;
	
	@Column(name="opc_cod_princ")
	private int cod_principal;
	
	@Column(name="opc_icon")
	private String iconOpc;
	
	@Column(name="opc_fec_act")
	private Date fecActu;
	
	@Column(name="opc_cod_usr")
	private String codUsr;
	
}
