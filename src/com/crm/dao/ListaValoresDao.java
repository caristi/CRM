package com.crm.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.crm.dto.ListaValoresDto;
import com.crm.dto.ProductoDto;

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
    		
    		lista.setCodItem(p.getId());
    		lista.setNomItem(p.getNombre());
    		
    		listaValores.add(lista);
    	}
    	
    	return listaValores;
    }
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}
