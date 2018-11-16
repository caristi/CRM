package com.crm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.crm.dao.CompraDao;
import com.crm.dto.CompraDto;

public class CompraSrv{

	@Autowired
	private CompraDao CompraDao;

	public int guardarCompra(CompraDto CompraDto){

		return	CompraDao.guardarCompra(CompraDto);
	}

	public List<CompraDto> listarCompras(){
		return CompraDao.listarCompras();
	}

	public List<CompraDto> buscarCompra(CompraDto CompraDto){
		return CompraDao.buscarCompra(CompraDto);
	}
	
	public void actualizarCompra(CompraDto CompraDto){
		CompraDao.actualizarCompra(CompraDto);
	}
	
	public void setCompraDao(CompraDao CompraDao) {
		this.CompraDao = CompraDao;
	}
}
