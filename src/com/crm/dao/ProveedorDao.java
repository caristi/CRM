package com.crm.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.crm.dto.ProveedorDto;

public class ProveedorDao{
	
	private Session sesion;				    							
	
	@Autowired
    private SessionFactory sessionFactory;
	
    @Transactional
	public int guardarProveedor(ProveedorDto proveedorDto){
    	int id;
		sesion = sessionFactory.getCurrentSession();
	    id = (Integer) sesion.save(proveedorDto);
		return id;
	}
    @Transactional		
	public void actualizaProveedor(ProveedorDto proveedorDto){
		sesion = sessionFactory.getCurrentSession();
		sesion.update(proveedorDto);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<ProveedorDto> listaProveedores(){
		sesion = sessionFactory.getCurrentSession();
		List<ProveedorDto> listaProveedor = null;
		listaProveedor = sesion.createQuery("select m from ProveedorDto m").list();
		return listaProveedor; 
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	 public List<ProveedorDto> filtroProveedores(String opcion_busqueda, String valor_busqueda){
			
			String sql = "select g from ProveedorDto g";
		    			     
		  	List<ProveedorDto> proveedores = new ArrayList<ProveedorDto>();
		  	
		   	sesion = sessionFactory.getCurrentSession();
		   	
		   	if (opcion_busqueda.equals("D")){
		   		sql = sql+" Where g.pro_num_docum like '%"+valor_busqueda+"%'";
		   	}	
		   	else if (opcion_busqueda.equals("N")){
		   		sql = sql+" Where g.pro_nombre like '%"+valor_busqueda+"%'";
		   	}
		   	else if (opcion_busqueda.equals("C")){
		   		sql = sql+" Where g.pro_ciudad like '%"+valor_busqueda+"%'";
		   	}
		   	proveedores = sesion.createQuery(sql).list();
		   			
		   	return proveedores;
		}
	
	
	public void setSesion(Session sesion) {
		this.sesion = sesion;
	}  
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}
