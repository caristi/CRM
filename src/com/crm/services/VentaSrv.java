package com.crm.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.crm.dao.VentaDao;
import com.crm.dto.FiltroBusquedaDto;
import com.crm.dto.VentaCabeceraDto;
import com.crm.dto.VentaDetalleDto;

public class VentaSrv{

	@Autowired
	private VentaDao ventaDao;

	public int guardarVenta(VentaCabeceraDto ventaDto){

		ventaDto.setListaDetalles(ventaDto.getListaDetalles().stream().filter(det -> det.getVlrSubTotal() > 0).collect(Collectors.toList()));
		
		return ventaDao.guardarVenta(ventaDto);
	}

	public List<VentaCabeceraDto> buscarVenta(FiltroBusquedaDto filtro){
		
		return ventaDao.buscarVenta(filtro);
	}
	
	public List<VentaDetalleDto> listarDetalleVenta(int idVenta){
		return ventaDao.listarDetalleVenta(idVenta);
	}
	
	public void setVentaDao(VentaDao ventaDao) {
		this.ventaDao = ventaDao;
	}
}
