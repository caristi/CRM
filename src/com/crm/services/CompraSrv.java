package com.crm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.dao.CompraDao;
import com.crm.dao.ProductoDao;
import com.crm.dto.CompraDto;
import com.crm.dto.FiltroBusquedaDto;
import com.crm.dto.ProductoDto;

@Service
public class CompraSrv{

	@Autowired
	private CompraDao compraDao;
	@Autowired
	private ProductoDao productoDao;

	public int guardarCompra(CompraDto compraDto){

		int id = compraDao.guardarCompra(compraDto);
		
		if(id > 0){
			
			ProductoDto productoDto = new ProductoDto();
			productoDto.setId(compraDto.getProductoDto().getId());
			productoDto.setCantidad(compraDto.getCantidad());
			
			productoDao.sumarCantidadProducto(productoDto);
		}
		
		return id;
	}

	public List<CompraDto> listarCompras(){
		return compraDao.listarCompras();
	}

	public List<CompraDto> buscarCompra(FiltroBusquedaDto filtro){
		
		return compraDao.buscarCompra(filtro);
	}
	
	public void actualizarCompra(CompraDto compraDto){
		compraDao.actualizarCompra(compraDto);
	}
	
	public void setCompraDao(CompraDao compraDao) {
		this.compraDao = compraDao;
	}
	
	public void setProductoDao(ProductoDao productoDao) {
		this.productoDao = productoDao;
	}
}
