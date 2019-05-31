package com.crm.bean;

import java.util.List;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.crm.dto.FiltroBusquedaDto;
import com.crm.dto.VentaCabeceraDto;
import com.crm.services.VentaSrv;
import com.crm.util.Constantes;

@Component
@Named
public class VentaBean {

	@Autowired
	private VentaSrv ventaSrv;
	
	private VentaCabeceraDto ventaDto;
	private VentaCabeceraDto ventaSelecDto;
	private FiltroBusquedaDto filtro;
	
	private List<VentaCabeceraDto> listaVentaDto;
	
	public VentaBean() {
		
		filtro = new FiltroBusquedaDto();
	}
	
	public void buscarVenta(){
		
		listaVentaDto = ventaSrv.buscarVenta(filtro);
	}
	
	public String consultarUnaVenta(){
		
		ventaDto = ventaSelecDto;
		
		ventaDto.setListaDetalles(ventaSrv.listarDetalleVenta(ventaDto.getId()));
		
		return Constantes.urlRegistroVenta;
	}
	
	public void setVentaSrv(VentaSrv ventaSrv) {
		this.ventaSrv = ventaSrv;
	}
	
	public VentaCabeceraDto getVentaDto() {
		return ventaDto;
	}

	public VentaCabeceraDto getVentaSelecDto() {
		return ventaSelecDto;
	}
	
	public void setVentaSelecDto(VentaCabeceraDto ventaSelecDto) {
		this.ventaSelecDto = ventaSelecDto;
	}

	public FiltroBusquedaDto getFiltro() {
		return filtro;
	}

	public List<VentaCabeceraDto> getListaVentaDto() {
		return listaVentaDto;
	}
}