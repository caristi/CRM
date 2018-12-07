package com.crm.dto;

import java.util.Date;

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
	
	
	
	
	public int getUsuId() {
		return usuId;
	}
	public void setUsuId(int usuId) {
		this.usuId = usuId;
	}
	public int getVenId() {
		return venId;
	}
	public void setVenId(int venId) {
		this.venId = venId;
	}
	public double getValorVentaTotal() {
		return valorVentaTotal;
	}
	public void setValorVentaTotal(double valorVentaTotal) {
		this.valorVentaTotal = valorVentaTotal;
	}
	public String getUsuNombre() {
		return usuNombre;
	}
	public void setUsuNombre(String usuNombre) {
		this.usuNombre = usuNombre;
	}
	public String getUsuApellido1() {
		return usuApellido1;
	}
	public void setUsuApellido1(String usuApellido1) {
		this.usuApellido1 = usuApellido1;
	}
	public String getUsuApellido2() {
		return usuApellido2;
	}
	public void setUsuApellido2(String usuApellido2) {
		this.usuApellido2 = usuApellido2;
	}
	public Date getFechaIncio() {
		return fechaIncio;
	}
	public void setFechaIncio(Date fechaIncio) {
		this.fechaIncio = fechaIncio;
	}
	public Date getFechaFinal() {
		return fechaFinal;
	}
	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
	public int getProId() {
		return proId;
	}
	public void setProId(int proId) {
		this.proId = proId;
	}
	
	public String getProNombre() {
		return proNombre;
	}
	public void setProNombre(String proNombre) {
		this.proNombre = proNombre;
	}
	public double getCantidadArticulos() {
		return cantidadArticulos;
	}
	public void setCantidadArticulos(double cantidadArticulos) {
		this.cantidadArticulos = cantidadArticulos;
	}
	
	
	
	
	
	}