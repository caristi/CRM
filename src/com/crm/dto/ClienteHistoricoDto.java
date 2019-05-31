package com.crm.dto;

import java.sql.Time;
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

}