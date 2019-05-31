package com.crm.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListaValoresDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String codItem;
	private String nomItem;

}
