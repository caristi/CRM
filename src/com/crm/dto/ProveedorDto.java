package com.crm.dto;

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
@Table(name="proveedor")
public class ProveedorDto implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //esta linea me genera el autoincrementable
	@Column(name="pro_id")
	private int pro_id;
	
	@Column(name="pro_tip_docum",nullable = false)
	private String pro_tip_docum;
	
	@Column(name="pro_num_docum",nullable = false,unique = true)
	private String pro_num_docum;
	
	@Column(name="pro_nombre")
	private String pro_nombre;
	
	@Column(name="pro_apellido1")
	private String pro_apellido1;
	
	@Column(name="pro_apellido2")
	private String pro_apellido2;
	
	@Column(name="pro_pais")
	private String pro_pais;
	
	@Column(name="pro_ciudad")
	private String pro_ciudad;
	
	@Column (name="pro_direccion")
	private String pro_direccion;
	
	@Column(name="pro_telefono")
	private String pro_telefono;
	
	
	@Column(name="pro_celular",length=10)
	private String pro_celular;
	
	@Column(name="pro_email")
	private String pro_email;

	@Column(name="pro_estado")
	private String pro_estado;
	
	@Column(name="pro_contacto")
	private String pro_contacto;
	
	@Column(name="pro_cargo_contacto")
	private String pro_cargo_contacto;
	
	@Column(name="pro_tel_contacto")
	private String pro_tel_contacto;
	
	@Column(name="pro_email_contacto")
	private String pro_email_contacto;
	
	@Column(name="pro_observaciones")
	private String pro_observaciones;

}
