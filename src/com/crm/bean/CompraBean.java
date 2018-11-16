package com.crm.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.crm.dto.CompraDto;
import com.crm.dto.ProductoDto;
import com.crm.services.CompraSrv;

public class CompraBean {

	private CompraSrv compraSrv;

	private CompraDto compraDto;
	private CompraDto compraSelecDto;
	
	private List<CompraDto> listaCompras;
	private List<ProductoDto> listaProductos;
	
	private boolean mcaEditar;

	public CompraBean() {
		compraDto = new CompraDto();
	}
	
	public void guardarCompra(){
		
		int id = compraSrv.guardarCompra(compraDto);
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Se guardo la compra con código " + id));
	}
	
	public void consultarCompra(){
		
		listaCompras = compraSrv.buscarCompra(compraDto);
	}
	
	public String consultarUnCompra(){
		this.mcaEditar = true;
		this.compraDto = compraSelecDto;
		
		return "compra";
	}
	
	public String nuevoCompra(){
		this.mcaEditar = false;
		this.compraDto = new CompraDto();
		
		return "compra";
	}
	
	public void actualizar(){
		compraSrv.actualizarCompra(compraDto);
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Se actualizo la compra con código"));
	}

	public void setCompraSrv(CompraSrv compraSrv) {
		this.compraSrv = compraSrv;
	}

	public void setCompraDto(CompraDto compraDto) {
		this.compraDto = compraDto;
	}
	public CompraDto getCompraDto() {
		return compraDto;
	}

	public CompraDto getCompraSelecDto() {
		return compraSelecDto;
	}

	public void setCompraSelecDto(CompraDto compraSelecDto) {
		this.compraSelecDto = compraSelecDto;
	}

	public List<CompraDto> getListaCompras() {
		return listaCompras;
	}

	public void setListaCompras(List<CompraDto> listaCompras) {
		this.listaCompras = listaCompras;
	}

	public boolean isMcaEditar() {
		return mcaEditar;
	}

	public void setMcaEditar(boolean mcaEditar) {
		this.mcaEditar = mcaEditar;
	}

	public List<ProductoDto> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(List<ProductoDto> listaProductos) {
		this.listaProductos = listaProductos;
	}
}