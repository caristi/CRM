package com.crm.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="usuario")
public class UsuarioDto implements java.io.Serializable  {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //esta l�nea me genera el autoincrementable
	@Column(name="usu_id")
	private int usu_id;

	@Column(name="usu_num_docum")
	private String usu_num_docum;

	@Column(name="usu_nombre")
	private String usu_nombre;

	@Column(name="usu_apellido1")
	private String usu_apellido1;

	@Column(name="usu_apellido2")
	private String usu_apellido2;
	
	@Column(name="usu_login")
	private String usu_login;

	@Column(name="usu_contrasena")
	private String usu_contrasena;
	
	@Column(name="usu_fecha_nacimiento")
	private Date usu_fecha_nacimiento;
	
	@Column(name="usu_ciudad_nacimiento")
	private String usu_ciudad_nacimiento;
	
	@Column(name="usu_direccion")
	private String usu_direccion;

	@Column(name="usu_telefono")
	private String usu_telefono;

	@Column(name="usu_celular")
	private String usu_celular;

	@Column(name="usu_email")
	private String usu_email;

	@Column(name="usu_cargo")
	private String usu_cargo;

	@Column(name="usu_fecha_ingreso")
	private Date usu_fecha_ingreso;
	
	@Column(name="usu_perfil")
	private String usu_perfil;
	
	@Transient
	private boolean acceso;
	
	@Transient
	private String mensajeAcceso;
	
	public UsuarioDto() {

	}

}