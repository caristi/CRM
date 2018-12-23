package com.crm.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.crm.dto.ClienteDto;
import com.crm.dto.ListaValoresDto;
import com.crm.dto.ProductoDto;
import com.crm.dto.UsuarioDto;

public class ListaValoresDao{
	
	private Session sesion;
    private SessionFactory sessionFactory;
    
    @SuppressWarnings("unchecked")
	@Transactional
	public List<ListaValoresDto> listaProductos(){
    	
    	List<ListaValoresDto> listaValores = new ArrayList<ListaValoresDto>();
    	sesion = sessionFactory.getCurrentSession();
    	List<ProductoDto> listaProducto = sesion.createQuery("select p from ProductoDto p").list();
    	for(ProductoDto p: listaProducto){
    		ListaValoresDto lista = new ListaValoresDto();
    		lista.setCodItem(p.getId()+"");
    		lista.setNomItem(p.getNombre());
    		listaValores.add(lista);
    	}
    	return listaValores;
    }	
    	@SuppressWarnings("unchecked")
    	@Transactional
    	public List<ListaValoresDto> listaUsuarios(){
        	
        	List<ListaValoresDto> listaValores = new ArrayList<ListaValoresDto>();
        	sesion = sessionFactory.getCurrentSession();
        	List<UsuarioDto> listaUsuario = sesion.createQuery("select p from UsuarioDto p").list();
        	for(UsuarioDto p: listaUsuario){
        		ListaValoresDto lista = new ListaValoresDto();
        		lista.setCodItem(p.getUsu_id()+"");
        		lista.setNomItem(p.getUsu_nombre());
        		listaValores.add(lista);
        	}
        	
    	return listaValores;
    }

    	@SuppressWarnings("unchecked")
    	@Transactional
    	public List<ListaValoresDto> listaClientes(){
        	
        	List<ListaValoresDto> listaValores = new ArrayList<ListaValoresDto>();
        	sesion = sessionFactory.getCurrentSession();
        	List<ClienteDto> listaCliente = sesion.createQuery("select p from ClienteDto p").list();
        	for(ClienteDto p: listaCliente){
        		ListaValoresDto lista = new ListaValoresDto();
        		lista.setCodItem(p.getCli_id()+"");
        		lista.setNomItem(p.getCli_nombre());
        		listaValores.add(lista);
        	}
        	
    	return listaValores;
    }	
    	
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}
