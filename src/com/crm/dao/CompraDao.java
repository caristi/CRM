package com.crm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.crm.dto.CompraDto;
import com.crm.dto.FiltroBusquedaDto;

@Repository
public class CompraDao{
	
	private Session sesion;				    							
	
	@Autowired
    private SessionFactory sessionFactory;
	
    @Transactional
	public int guardarCompra(CompraDto CompraDto){
    	
    	int id;
		
		sesion = sessionFactory.getCurrentSession();
		
	    id = (Integer) sesion.save(CompraDto);
		
		return id;
	}
    
    @SuppressWarnings("unchecked")
	@Transactional
	public List<CompraDto> listarCompras(){
    	
    	sesion = sessionFactory.getCurrentSession();
		
		List<CompraDto> lista = null;
    	
		lista = sesion.createQuery("select p from CompraDto p").list();
    	
    	return lista;
    }
    
	@SuppressWarnings("unchecked")
	@Transactional
    public List<CompraDto> buscarCompra(FiltroBusquedaDto filtro) {
		
		String sql = "select p from CompraDto p where fecha between :fecInicio and :fecFin";
	    			     
	   	sesion = sessionFactory.getCurrentSession();
	   	
	   	return sesion.createQuery(sql).setParameter("fecInicio",filtro.getFechaInicio())
	   			                      .setParameter("fecFin", filtro.getFechaFin()).list();
	}
	
	@Transactional
	public void actualizarCompra(CompraDto CompraDto){
		
		sesion = sessionFactory.getCurrentSession();
		
		sesion.update(CompraDto);
	}
	
	public void setSesion(Session sesion) {
		this.sesion = sesion;
	}  
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
