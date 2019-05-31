package com.crm.bean;
import java.util.Date;
import java.util.List;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.crm.dto.ReportesDto;
import com.crm.services.ReportesSrv;

@Component
@Named
public class ReportesBean {
	
	private ReportesDto reportesDto;
	
	@Autowired
	private ReportesSrv reportesSrv;
	private List<ReportesDto> listaReportes;
	private List<ReportesDto> listaVentas;
	private List<ReportesDto> listaVentasProductos;

	
	private int codigo_vendedor;
	private Date fecha_inicio;
	private Date fecha_fin;
	
	
	public ReportesBean() {
		
	}
	
	public void ventasUsuarioEspecifico(){
		listaReportes = reportesSrv.ventasUsuarioEspecifico(codigo_vendedor, fecha_inicio, fecha_fin);
	}
	
	public void ventaTotalGeneral(){
		listaVentas = reportesSrv.ventasTotales(fecha_inicio, fecha_fin);
	}

	public void ventasProductos(){
		listaVentasProductos = reportesSrv.ventasProductos(fecha_inicio, fecha_fin);
	}
	
	public ReportesDto getReportesDto() {
		return reportesDto;
	}

	public void setReportesDto(ReportesDto reportesDto) {
		this.reportesDto = reportesDto;
	}

	public void setReportesSrv(ReportesSrv reportesSrv) {
		this.reportesSrv = reportesSrv;
	}

	public List<ReportesDto> getListaReportes() {
		return listaReportes;
	}

	public void setListaReportes(List<ReportesDto> listaReportes) {
		this.listaReportes = listaReportes;
	}

	public int getCodigo_vendedor() {
		return codigo_vendedor;
	}

	public void setCodigo_vendedor(int codigo_vendedor) {
		this.codigo_vendedor = codigo_vendedor;
	}

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Date getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public List<ReportesDto> getVentasTotales() {
		return listaVentas;
	}

	public void setVentasTotales(List<ReportesDto> ventasTotales) {
		this.listaVentas = ventasTotales;
	}

	public List<ReportesDto> getListaVentas() {
		return listaVentas;
	}

	public void setListaVentas(List<ReportesDto> listaVentas) {
		this.listaVentas = listaVentas;
	}

	public List<ReportesDto> getListaVentasProductos() {
		return listaVentasProductos;
	}

	public void setListaVentasProductos(List<ReportesDto> listaVentasProductos) {
		this.listaVentasProductos = listaVentasProductos;
	}

	public ReportesSrv getReportesSrv() {
		return reportesSrv;
	}
	
		
	
	



	
}