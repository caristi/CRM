package com.crm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.crm.dao.ProductoDao;
import com.crm.dto.FiltroBusquedaDto;
import com.crm.dto.ProductoDto;
import com.crm.validacion.ValidacionProducto;

@Component
public class ProductoSrv{

	@Autowired
	private ProductoDao productoDao;
	@Autowired
	private ValidacionProducto validacionProducto;

	public int guardarProducto(ProductoDto productoDto){
		
		validacionProducto.validacionDatosProducto(productoDto);

		return	productoDao.guardarProducto(productoDto);
	}

	public List<ProductoDto> listarProductos(){
		return productoDao.listarProductos();
	}

	public List<ProductoDto> buscarProducto(FiltroBusquedaDto filtro){
		return productoDao.buscarProducto(filtro);
	}
	
	public void actualizarProducto(ProductoDto productoDto){
		productoDao.actualizarProducto(productoDto);
	}
	
	public void setProductoDao(ProductoDao productoDao) {
		this.productoDao = productoDao;
	}

	public void setValidacionProducto(ValidacionProducto validacionProducto) {
		this.validacionProducto = validacionProducto;
	}
}
