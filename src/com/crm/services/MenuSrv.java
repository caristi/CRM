package com.crm.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.dao.MenuDao;
import com.crm.dto.OpcionDto;

@Service
public class MenuSrv implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private MenuDao menuDao;

	public List<OpcionDto> consultarOpciones() {
		
		List<OpcionDto> lista = menuDao.consultarOpciones();
		
		if(lista == null || lista.size() <= 0) {
			new NegocioException("Ocurrio un error, no existen opciones parametrizadas", BaseException.SEVERITY_WARNNIN);
		}
		
		return lista;
	}
	
	public void setMenuDao(MenuDao menuDao) {
		this.menuDao = menuDao;
	}
}