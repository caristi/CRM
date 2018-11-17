package com.crm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.crm.dao.ProductoDao;
import com.crm.dto.FiltroBusquedaDto;
import com.crm.dto.ProductoDto;

public class ProductoSrv{

	@Autowired
	private ProductoDao productoDao;

	public int guardarProducto(ProductoDto productoDto){

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

}
