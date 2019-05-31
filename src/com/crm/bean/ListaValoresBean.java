package com.crm.bean;

import java.io.Serializable;
import java.util.List;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.crm.dto.ListaValoresDto;
import com.crm.services.ListaValoresSrv;

@Component
@Named
public class ListaValoresBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ListaValoresSrv listaValoresSrv;
		
	public List<ListaValoresDto> getListaProductos() {

		return listaValoresSrv.listaProductos();
	}
	
	public List<ListaValoresDto> getListaUsuarios() {

		return listaValoresSrv.listaUsuarios();
	}
	
	public List<ListaValoresDto> getListaClientes() {

		return listaValoresSrv.listaClientes();
	}
	
	public List<ListaValoresDto> getListaEstadoDeSalida(){
		return listaValoresSrv.listaEstadosDeSalida();
	}

	public void setListaValoresSrv(ListaValoresSrv listaValoresSrv) {
		this.listaValoresSrv = listaValoresSrv;
	}
}
