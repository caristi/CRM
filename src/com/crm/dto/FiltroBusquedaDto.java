package com.crm.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FiltroBusquedaDto{
	
	private Date fechaInicio;
	private Date fechaFin;
	
	private String nombre;
	private String estado;

}
