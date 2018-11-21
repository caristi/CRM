package com.crm.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="proveedor")

public class ProveedorDto implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //esta linea me genera el autoincrementable
	@Column(name="pro_id")
	private int pro_id;
	
	@Column(name="pro_tip_docum")
	private String pro_tip_docum;
	
	@Column(name="pro_num_docum")
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
	
	@Column(name="pro_celular")
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

	public int getPro_id() {
		return pro_id;
	}

	public void setPro_id(int pro_id) {
		this.pro_id = pro_id;
	}

	public String getPro_tip_docum() {
		return pro_tip_docum;
	}

	public void setPro_tip_docum(String pro_tip_docum) {
		this.pro_tip_docum = pro_tip_docum;
	}

	public String getPro_num_docum() {
		return pro_num_docum;
	}

	public void setPro_num_docum(String pro_num_docum) {
		this.pro_num_docum = pro_num_docum;
	}

	public String getPro_nombre() {
		return pro_nombre;
	}

	public void setPro_nombre(String pro_nombre) {
		this.pro_nombre = pro_nombre;
	}

	public String getPro_apellido1() {
		return pro_apellido1;
	}

	public void setPro_apellido1(String pro_apellido1) {
		this.pro_apellido1 = pro_apellido1;
	}

	public String getPro_apellido2() {
		return pro_apellido2;
	}

	public void setPro_apellido2(String pro_apellido2) {
		this.pro_apellido2 = pro_apellido2;
	}

	public String getPro_pais() {
		return pro_pais;
	}

	public void setPro_pais(String pro_pais) {
		this.pro_pais = pro_pais;
	}

	public String getPro_ciudad() {
		return pro_ciudad;
	}

	public void setPro_ciudad(String pro_ciudad) {
		this.pro_ciudad = pro_ciudad;
	}

	public String getPro_direccion() {
		return pro_direccion;
	}

	public void setPro_direccion(String pro_direccion) {
		this.pro_direccion = pro_direccion;
	}

	

	public String getPro_telefono() {
		return pro_telefono;
	}

	public void setPro_telefono(String pro_telefono) {
		this.pro_telefono = pro_telefono;
	}

	public String getPro_celular() {
		return pro_celular;
	}

	public void setPro_celular(String pro_celular) {
		this.pro_celular = pro_celular;
	}

	public String getPro_email() {
		return pro_email;
	}

	public void setPro_email(String pro_email) {
		this.pro_email = pro_email;
	}

	public String getPro_estado() {
		return pro_estado;
	}

	public void setPro_estado(String pro_estado) {
		this.pro_estado = pro_estado;
	}

	public String getPro_contacto() {
		return pro_contacto;
	}

	public void setPro_contacto(String pro_contacto) {
		this.pro_contacto = pro_contacto;
	}

	public String getPro_cargo_contacto() {
		return pro_cargo_contacto;
	}

	public void setPro_cargo_contacto(String pro_cargo_contacto) {
		this.pro_cargo_contacto = pro_cargo_contacto;
	}

	public String getPro_tel_contacto() {
		return pro_tel_contacto;
	}

	public void setPro_tel_contacto(String pro_tel_contacto) {
		this.pro_tel_contacto = pro_tel_contacto;
	}

	public String getPro_email_contacto() {
		return pro_email_contacto;
	}

	public void setPro_email_contacto(String pro_email_contacto) {
		this.pro_email_contacto = pro_email_contacto;
	}

	public String getPro_observaciones() {
		return pro_observaciones;
	}

	public void setPro_observaciones(String pro_observaciones) {
		this.pro_observaciones = pro_observaciones;
	}

}
