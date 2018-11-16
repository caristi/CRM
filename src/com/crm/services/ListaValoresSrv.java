package com.crm.services;

import java.util.List;

import com.crm.dao.ListaValoresDao;
import com.crm.dto.ListaValoresDto;

public class ListaValoresSrv{
	
	ListaValoresDao listaValoresDao;
	
	public List<ListaValoresDto> listaProductos(){
		return listaValoresDao.listaProductos();
	}
	
	public void setListaValoresDao(ListaValoresDao listaValoresDao) {
		this.listaValoresDao = listaValoresDao;
	}
}
