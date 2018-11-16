package com.crm.bean;

import java.io.Serializable;
import java.util.List;

import com.crm.dto.ListaValoresDto;
import com.crm.services.ListaValoresSrv;

public class ListaValoresBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private ListaValoresSrv listaValoresSrv;
	
	private List<ListaValoresDto> listaProductos;
	
	public List<ListaValoresDto> getListaProductos() {
		
		if(listaProductos == null || listaProductos.isEmpty()){
			listaProductos = listaValoresSrv.listaProductos();
		}
		return listaProductos;
	}

	public void setListaValoresSrv(ListaValoresSrv listaValoresSrv) {
		this.listaValoresSrv = listaValoresSrv;
	}
}
