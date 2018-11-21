package com.crm.services;

import java.util.ArrayList;
import java.util.List;

import com.crm.dao.ListaValoresDao;
import com.crm.dto.ListaValoresDto;

public class ListaValoresSrv{
	
	ListaValoresDao listaValoresDao;
	
	public List<ListaValoresDto> listaProductos(){
		return incluirCamposVacio(listaValoresDao.listaProductos());
	}
	
	private List<ListaValoresDto> incluirCamposVacio(List<ListaValoresDto> lista){
		
		List<ListaValoresDto> listaNueva = new ArrayList<ListaValoresDto>();
		
		ListaValoresDto itemVacio = new ListaValoresDto();
		itemVacio.setCodItem("");
		itemVacio.setNomItem("Seleccione uno..");
		listaNueva.add(itemVacio);
		
		for(ListaValoresDto item:lista){
			listaNueva.add(item);
		}
		
		return listaNueva;
	}
	
	public void setListaValoresDao(ListaValoresDao listaValoresDao) {
		this.listaValoresDao = listaValoresDao;
	}
}