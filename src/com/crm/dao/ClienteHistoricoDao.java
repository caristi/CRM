package com.crm.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.crm.dto.ClienteHistoricoDto;

@Component
public class ClienteHistoricoDao{
	
	private Session sesion;				    							
	
	@Autowired
    private SessionFactory sessionFactory;
	
    @Transactional
	public int guardarHistorico(ClienteHistoricoDto clientehistoricoDto){
    	int id;
		sesion = sessionFactory.getCurrentSession();
	    id = (Integer) sesion.save(clientehistoricoDto);
		return id;
	}
    @Transactional		
	public void actualizarHistorico(ClienteHistoricoDto clientehistoricoDto){
		sesion = sessionFactory.getCurrentSession();
		sesion.update(clientehistoricoDto);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<ClienteHistoricoDto> listaHistoricos(){
		sesion = sessionFactory.getCurrentSession();
		List<ClienteHistoricoDto> listaHistoricos = null;
		listaHistoricos = sesion.createQuery("select m from ClienteHistoricoDto m").list();
		return listaHistoricos; 
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	 public List<ClienteHistoricoDto> filtroHistoricos(String opcion_busqueda, String valor_busqueda){
			
			String sql = "select g from ClienteHistoricoDto g";
		    			     
		  	List<ClienteHistoricoDto> historicos = new ArrayList<ClienteHistoricoDto>();
		  	
		   	sesion = sessionFactory.getCurrentSession();
		   	
		   	if (opcion_busqueda.equals("TC")){
		   		sql = sql+" Where g.clihis_tipo_contacto like '%"+valor_busqueda+"%'";
		   	}
		   	else if (opcion_busqueda.equals("U")){
		   		sql = sql+" Where g.usu_id like '%"+valor_busqueda+"%'";
		   	}
		   	else if (opcion_busqueda.equals("C")){
		   		sql = sql+" Where g.cli_id like '%"+valor_busqueda+"%'";
		   	}
		   	historicos = sesion.createQuery(sql).list();
		   			
		   	return historicos;
		}
	
	
	public void setSesion(Session sesion) {
		this.sesion = sesion;
	}  
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}
