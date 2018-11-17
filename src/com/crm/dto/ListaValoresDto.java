package com.crm.dto;

import java.io.Serializable;

public class ListaValoresDto implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private String codItem;
	private String nomItem;

	public String getNomItem() {
		return nomItem;
	}
	public void setNomItem(String nomItem) {
		this.nomItem = nomItem;
	}
	public String getCodItem() {
		return codItem;
	}
	public void setCodItem(String codItem) {
		this.codItem = codItem;
	}
}
