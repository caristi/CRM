package com.crm.dto;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cliente_historico")
public class ClienteHistoricoDto implements java.io.Serializable  {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //esta linea me genera el autoincrementable
	@Column(name="clihis_id")
	private int clihis_id;

	@Column(name="clihis_fecha")
	private Date clihis_fecha;

	@Column(name="clihis_hora")
	private Time clihis_hora;

	@Column(name="clihis_tipo_contacto")
	private String clihis_tipo_contacto;

	@Column(name="clihis_descripcion")
	private String clihis_descripcion;

	@Column(name="usu_id")
	private int usu_id;
		
	@Column(name="cli_id")
	private int cli_id;
	
	public ClienteHistoricoDto() {

	}

	public int getClihis_id() {
		return clihis_id;
	}

	public void setClihis_id(int clihis_id) {
		this.clihis_id = clihis_id;
	}

	public Date getClihis_fecha() {
		return clihis_fecha;
	}

	public void setClihis_fecha(Date clihis_fecha) {
		this.clihis_fecha = clihis_fecha;
	}

	public Time getClihis_hora() {
		return clihis_hora;
	}

	public void setClihis_hora(Time clihis_hora) {
		this.clihis_hora = clihis_hora;
	}

	public String getClihis_tipo_contacto() {
		return clihis_tipo_contacto;
	}

	public void setClihis_tipo_contacto(String clihis_tipo_contacto) {
		this.clihis_tipo_contacto = clihis_tipo_contacto;
	}

	public String getClihis_descripcion() {
		return clihis_descripcion;
	}

	public void setClihis_descripcion(String clihis_descripcion) {
		this.clihis_descripcion = clihis_descripcion;
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

	
}