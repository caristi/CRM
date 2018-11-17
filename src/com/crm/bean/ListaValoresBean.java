package com.crm.bean;

import java.io.Serializable;
import java.util.List;

import com.crm.dto.ListaValoresDto;
import com.crm.services.ListaValoresSrv;

public class ListaValoresBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private ListaValoresSrv listaValoresSrv;
	
	public List<ListaValoresDto> getListaProductos() {

		return listaValoresSrv.listaProductos();
	}

	public void setListaValoresSrv(ListaValoresSrv listaValoresSrv) {
		this.listaValoresSrv = listaValoresSrv;
	}
}
