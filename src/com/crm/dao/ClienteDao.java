package com.crm.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.crm.dto.ClienteDto;

@Component
public class ClienteDao{
	
	private Session sesion;				    							
	
	@Autowired
    private SessionFactory sessionFactory;
	
    @Transactional
	public int guardarCliente(ClienteDto clienteDto){
    	int id;
		sesion = sessionFactory.getCurrentSession();
	    id = (Integer) sesion.save(clienteDto);
		return id;
	}
    @Transactional		
	public void actualizarCliente(ClienteDto clienteDto){
		sesion = sessionFactory.getCurrentSession();
		sesion.update(clienteDto);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<ClienteDto> listaClientes(){
		sesion = sessionFactory.getCurrentSession();
		List<ClienteDto> listaCliente = null;
		listaCliente = sesion.createQuery("select m from ClienteDto m").list();
		return listaCliente; 
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	 public List<ClienteDto> filtroClientes(String opcion_busqueda, String valor_busqueda){
			
			String sql = "select g from ClienteDto g";
		    			     
		  	List<ClienteDto> clientes = new ArrayList<ClienteDto>();
		  	
		   	sesion = sessionFactory.getCurrentSession();
		   	
		   	if(opcion_busqueda.equals("D")){
		   		sql = sql+" Where g.cli_num_docum = "+valor_busqueda;
		   	}	
		   	else if (opcion_busqueda.equals("N")){
		   		sql = sql+" Where g.cli_nombre like '%"+valor_busqueda+"%'";
		   	}
		   	else if (opcion_busqueda.equals("C")){
		   		sql = sql+" Where g.cli_ciudad like '%"+valor_busqueda+"%'";
		   	}
		   	
		   	clientes = sesion.createQuery(sql).list();
		   			
		   	return clientes;
		}
	
	
	public void setSesion(Session sesion) {
		this.sesion = sesion;
	}  
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}
