package com.crm.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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

	public int getUsu_id() {
		return usu_id;
	}

	public void setUsu_id(int usu_id) {
		this.usu_id = usu_id;
	}

	public int getCli_id() {
		return cli_id;
	}

	public void setCli_id(int cli_id) {
		this.cli_id = cli_id;
	}

	public String getCli_tip_docum() {
		return cli_tip_docum;
	}

	public void setCli_tip_docum(String cli_tip_docum) {
		this.cli_tip_docum = cli_tip_docum;
	}

	public String getCli_num_docum() {
		return cli_num_docum;
	}

	public void setCli_num_docum(String cli_num_docum) {
		this.cli_num_docum = cli_num_docum;
	}

	public String getCli_nombre() {
		return cli_nombre;
	}

	public void setCli_nombre(String cli_nombre) {
		this.cli_nombre = cli_nombre;
	}

	public String getCli_apellido1() {
		return cli_apellido1;
	}

	public void setCli_apellido1(String cli_apellido1) {
		this.cli_apellido1 = cli_apellido1;
	}

	public String getCli_apellido2() {
		return cli_apellido2;
	}

	public void setCli_apellido2(String cli_apellido2) {
		this.cli_apellido2 = cli_apellido2;
	}

	public String getCli_pais() {
		return cli_pais;
	}

	public void setCli_pais(String cli_pais) {
		this.cli_pais = cli_pais;
	}

	public String getCli_ciudad() {
		return cli_ciudad;
	}

	public void setCli_ciudad(String cli_ciudad) {
		this.cli_ciudad = cli_ciudad;
	}

	public String getCli_direccion() {
		return cli_direccion;
	}

	public void setCli_direccion(String cli_direccion) {
		this.cli_direccion = cli_direccion;
	}

	public String getCli_telefono() {
		return cli_telefono;
	}

	public void setCli_telefono(String cli_telefono) {
		this.cli_telefono = cli_telefono;
	}

	public String getCli_celular() {
		return cli_celular;
	}

	public void setCli_celular(String cli_celular) {
		this.cli_celular = cli_celular;
	}

	public String getCli_email() {
		return cli_email;
	}

	public void setCli_email(String cli_email) {
		this.cli_email = cli_email;
	}

	public String getCli_contacto() {
		return cli_contacto;
	}

	public void setCli_contacto(String cli_contacto) {
		this.cli_contacto = cli_contacto;
	}

	public String getCli_cargo_contacto() {
		return cli_cargo_contacto;
	}

	public void setCli_cargo_contacto(String cli_cargo_contacto) {
		this.cli_cargo_contacto = cli_cargo_contacto;
	}

	public String getCli_tel_contacto() {
		return cli_tel_contacto;
	}

	public void setCli_tel_contacto(String cli_tel_contacto) {
		this.cli_tel_contacto = cli_tel_contacto;
	}

	public String getCli_email_contacto() {
		return cli_email_contacto;
	}

	public void setCli_email_contacto(String cli_email_contacto) {
		this.cli_email_contacto = cli_email_contacto;
	}

	public String getCli_estado() {
		return cli_estado;
	}

	public void setCli_estado(String cli_estado) {
		this.cli_estado = cli_estado;
	}

	public String getCli_observaciones() {
		return cli_observaciones;
	}

	public void setCli_observaciones(String cli_observaciones) {
		this.cli_observaciones = cli_observaciones;
	}
}