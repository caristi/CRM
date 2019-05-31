package com.crm.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReportesDto  {

	private int usuId;
	private int venId;
	private int proId;
	
	private double cantidadArticulos;
	private double valorVentaTotal;
	
	private String usuNombre;
	private String usuApellido1;
	private String usuApellido2;
	private String proNombre;
	
	private Date fechaIncio;
	private Date fechaFinal;
	
}