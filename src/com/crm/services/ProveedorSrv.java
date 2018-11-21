package com.crm.services;

import java.util.List;

import com.crm.dao.ProveedorDao;
import com.crm.dto.ProveedorDto;

public class ProveedorSrv{
	
	private ProveedorDao proveedorDao;
	
	public int guardarProveedor(ProveedorDto proveedorDto){
		
		int id = proveedorDao.guardarProveedor(proveedorDto);
		
		return id;
	}
	
	public void actualizarProveedor (ProveedorDto proveedorDto) {
		proveedorDao.actualizaProveedor(proveedorDto);
	}
	
	public List<ProveedorDto> listaProveedores(){
		return proveedorDao.listaProveedores();
	}
	
	public List<ProveedorDto> filtroProveedor(String opcion_busqueda, String valor_busqueda){
		return proveedorDao.filtroProveedores(opcion_busqueda, valor_busqueda);
	}
	
	public void setProveedorDao(ProveedorDao proveedorDao) {
		this.proveedorDao = proveedorDao;
	}
}
