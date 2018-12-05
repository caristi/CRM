package com.crm.services;

import java.util.List;
import com.crm.dao.ClienteDao;
import com.crm.dto.ClienteDto;

public class ClienteSrv{
	
	private ClienteDao clienteDao;
	
	public int guardarCliente(ClienteDto clienteDto){
		
		int id = clienteDao.guardarCliente(clienteDto);
		
		return id;
	}
	
	public void actualizarCliente(ClienteDto clienteDto) {
		clienteDao.actualizarCliente(clienteDto);
	}
	
	public List<ClienteDto> listaClientes(){
		return clienteDao.listaClientes();
	}
	
	public List<ClienteDto> filtroClientes(String opcion_busqueda, String valor_busqueda){
		return clienteDao.filtroClientes(opcion_busqueda, valor_busqueda);
	}
	
	public void setClienteDao(ClienteDao clienteDao) {
		this.clienteDao = clienteDao;
	}
}
