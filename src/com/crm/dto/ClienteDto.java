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
@Table(name="cliente")
public class ClienteDto implements java.io.Serializable  {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //esta l�nea me genera el autoincrementable
	@Column(name="cli_id")
	private int cli_id;

	@Column(name="cli_tip_docum")
	private String cli_tip_docum;

	@Column(name="cli_num_docum")
	private String cli_num_docum;

	@Column(name="cli_nombre")
	private String cli_nombre;

	@Column(name="cli_apellido1")
	private String cli_apellido1;

	@Column(name="cli_apellido2")
	private String cli_apellido2;
	
	@Column(name="cli_pais")
	private String cli_pais;

	@Column(name="cli_ciudad")
	private String cli_ciudad;

	@Column(name="cli_direccion")
	private String cli_direccion;

	@Column(name="cli_telefono")
	private String cli_telefono;

	@Column(name="cli_celular")
	private String cli_celular;

	@Column(name="cli_email")
	private String cli_email;

	@Column(name="cli_contacto")
	private String cli_contacto;

	@Column(name="cli_cargo_contacto")
	private String cli_cargo_contacto;

	@Column(name="cli_tel_contacto")
	private String cli_tel_contacto;

	@Column(name="cli_email_contacto")
	private String cli_email_contacto;

	@Column(name="cli_estado")
	private String cli_estado;

	@Column(name="cli_observaciones")
	private String cli_observaciones;

	@Column(name="usu_id")
	private int usu_id;
		
	public ClienteDto() {

	}

}