package com.crm.bean;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.crm.dto.CompraDto;
import com.crm.dto.FiltroBusquedaDto;
import com.crm.dto.ProductoDto;
import com.crm.services.CompraSrv;

public class CompraBean {

	private CompraSrv compraSrv;

	private CompraDto compraDto;
	private CompraDto compraSelecDto;
	private FiltroBusquedaDto filtro;
	
	private List<CompraDto> listaCompras;
	private List<ProductoDto> listaProductos;
	
	private boolean mcaEditar;
	private boolean campoEditable;

	public CompraBean() {
		
		compraDto = new CompraDto();
		compraDto.setFecha(new Date());
		compraDto.setProductoDto(new ProductoDto());
		
		filtro = new FiltroBusquedaDto();
		campoEditable = false;
	}
	
	public void guardarCompra(){
		
		int id = compraSrv.guardarCompra(compraDto);
		mcaEditar = true;
		campoEditable = false;
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Se guardo la compra con código " + id + " y se actualiza el invertario"));
	}
	
	public void consultarCompra(){
		
		listaCompras = compraSrv.buscarCompra(filtro);
		
		if(listaCompras == null || listaCompras.size() == 0){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "", "No se encontraron registros con ese filtro"));
		}else{
			filtro = new FiltroBusquedaDto();
		}
	}
	
	public String consultarUnCompra(){
		this.mcaEditar = true;
		this.compraDto = compraSelecDto;
		
		return "compra";
	}
	
	public String nuevoCompra(){
		
		mcaEditar = false;
		campoEditable = false;
		
		compraDto = new CompraDto();
		compraDto.setFecha(new Date());
		compraDto.setProductoDto(new ProductoDto());
		
		return "compra";
	}
	
	public void actualizar(){
		
		compraSrv.actualizarCompra(compraDto);
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Se actualizo la compra con código"));
	}
	
	public void inicializarCompra(ProductoDto productoDto){
		
		campoEditable = true;
		mcaEditar = false;
		
		compraDto = new CompraDto();
		compraDto.setFecha(new Date());
		compraDto.setProductoDto(productoDto);
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

	public FiltroBusquedaDto getFiltro() {
		return filtro;
	}

	public boolean isCampoEditable() {
		return campoEditable;
	}
}