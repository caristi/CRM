package com.crm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.crm.dao.CompraDao;
import com.crm.dto.CompraDto;
import com.crm.dto.FiltroBusquedaDto;

public class CompraSrv{

	@Autowired
	private CompraDao compraDao;

	public int guardarCompra(CompraDto compraDto){

		return	compraDao.guardarCompra(compraDto);
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
}
