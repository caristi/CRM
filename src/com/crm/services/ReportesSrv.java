package com.crm.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.dao.ReportesDao;
import com.crm.dto.ReportesDto;

@Service
public class ReportesSrv{

	@Autowired
	private ReportesDao reportesDao;
	
	public List<ReportesDto> ventasUsuarioEspecifico(int codigo_vendedor, Date fecha_inicio, Date fecha_fin){
		return reportesDao.ventasUsuarioEspecifico(codigo_vendedor, fecha_inicio, fecha_fin);
	}

	public List<ReportesDto> ventasTotales(Date fecha_inicio, Date fecha_fin){
		return reportesDao.ventasTotales(fecha_inicio, fecha_fin);
	}
	
	public List<ReportesDto> ventasProductos(Date fecha_inicio, Date fecha_fin){
		return reportesDao.ventasProductos(fecha_inicio, fecha_fin);
	}	
	
	public void setReportesDao(ReportesDao reportesDao) {
		this.reportesDao = reportesDao;
	}
}
