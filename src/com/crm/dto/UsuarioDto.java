package com.crm.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

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

	public int getUsu_id() {
		return usu_id;
	}

	public void setUsu_id(int usu_id) {
		this.usu_id = usu_id;
	}

	public String getUsu_num_docum() {
		return usu_num_docum;
	}

	public void setUsu_num_docum(String usu_num_docum) {
		this.usu_num_docum = usu_num_docum;
	}

	public String getUsu_nombre() {
		return usu_nombre;
	}

	public void setUsu_nombre(String usu_nombre) {
		this.usu_nombre = usu_nombre;
	}

	public String getUsu_apellido1() {
		return usu_apellido1;
	}

	public void setUsu_apellido1(String usu_apellido1) {
		this.usu_apellido1 = usu_apellido1;
	}
	
	public String getUsu_apellido2() {
		return usu_apellido2;
	}

	public void setUsu_apellido2(String usu_apellido2) {
		this.usu_apellido2 = usu_apellido2;
	}
	
	public String getUsu_login() {
		return usu_login;
	}

	public void setUsu_login(String usu_login) {
		this.usu_login = usu_login;
	}

	public String getUsu_contrasena() {
		return usu_contrasena;
	}

	public void setUsu_contrasena(String usu_contrasena) {
		this.usu_contrasena = usu_contrasena;
	}

	public Date getUsu_fecha_nacimiento() {
		return usu_fecha_nacimiento;
	}

	public void setUsu_fecha_nacimiento(Date usu_fecha_nacimiento) {
		this.usu_fecha_nacimiento = usu_fecha_nacimiento;
	}

	public String getUsu_ciudad_nacimiento() {
		return usu_ciudad_nacimiento;
	}

	public void setUsu_ciudad_nacimiento(String usu_ciudad_nacimiento) {
		this.usu_ciudad_nacimiento = usu_ciudad_nacimiento;
	}

	public String getUsu_direccion() {
		return usu_direccion;
	}

	public void setUsu_direccion(String usu_direccion) {
		this.usu_direccion = usu_direccion;
	}

	public String getUsu_telefono() {
		return usu_telefono;
	}

	public void setUsu_telefono(String usu_telefono) {
		this.usu_telefono = usu_telefono;
	}

	public String getUsu_celular() {
		return usu_celular;
	}

	public void setUsu_celular(String usu_celular) {
		this.usu_celular = usu_celular;
	}

	public String getUsu_email() {
		return usu_email;
	}

	public void setUsu_email(String usu_email) {
		this.usu_email = usu_email;
	}

	public String getUsu_cargo() {
		return usu_cargo;
	}

	public void setUsu_cargo(String usu_cargo) {
		this.usu_cargo = usu_cargo;
	}

	public Date getUsu_fecha_ingreso() {
		return usu_fecha_ingreso;
	}

	public void setUsu_fecha_ingreso(Date usu_fecha_ingreso) {
		this.usu_fecha_ingreso = usu_fecha_ingreso;
	}

	public String getUsu_perfil() {
		return usu_perfil;
	}

	public void setUsu_perfil(String usu_perfil) {
		this.usu_perfil = usu_perfil;
	}

	public boolean isAcceso() {
		return acceso;
	}

	public void setAcceso(boolean acceso) {
		this.acceso = acceso;
	}

	public String getMensajeAcceso() {
		return mensajeAcceso;
	}

	public void setMensajeAcceso(String mensajeAcceso) {
		this.mensajeAcceso = mensajeAcceso;
	}

	
}