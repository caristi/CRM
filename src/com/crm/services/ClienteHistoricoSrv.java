package com.crm.services;

import java.util.List;
import com.crm.dao.ClienteHistoricoDao;
import com.crm.dto.ClienteHistoricoDto;

public class ClienteHistoricoSrv{
	
	private ClienteHistoricoDao clientehistoricoDao;
	
	public int guardarHistorico(ClienteHistoricoDto clientehistoricoDto){
		
		int id = clientehistoricoDao.guardarHistorico(clientehistoricoDto);
		
		return id;
	}
	
	public void actualizarHistorico(ClienteHistoricoDto clientehistoricoDto) {
		clientehistoricoDao.actualizarHistorico(clientehistoricoDto);
	}
	
	public List<ClienteHistoricoDto> listaHistoricos(){
		return clientehistoricoDao.listaHistoricos();
	}
	
	public List<ClienteHistoricoDto> filtroHistoricos(String opcion_busqueda, String valor_busqueda){
		return clientehistoricoDao.filtroHistoricos(opcion_busqueda, valor_busqueda);
	}
	
	public void setClientehistoricoDao(ClienteHistoricoDao clientehistoricoDao) {
		this.clientehistoricoDao = clientehistoricoDao;
	}
	
	
}
