package com.crm.dao;

import java.util.List;			

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.crm.dto.CotizacionCabeceraDto;
import com.crm.dto.FiltroBusquedaDto;

public class CotizacionDao{
	
	private Session sesion;				    							
	
	@Autowired
    private SessionFactory sessionFactory;
	
    @Transactional
	public int guardarCotizacion(CotizacionCabeceraDto cotizacionDto){
    	
    	int id;
		
		sesion = sessionFactory.getCurrentSession();
		
	    id = (Integer) sesion.save(cotizacionDto);
		
		return id;
	}
    
    @SuppressWarnings("unchecked")
	@Transactional
	public List<CotizacionCabeceraDto> listarCotizacions(){
    	
    	sesion = sessionFactory.getCurrentSession();
		
		List<CotizacionCabeceraDto> lista = null;
    	
		lista = sesion.createQuery("select p from CotizacionCabeceraDto p").list();
    	
    	return lista;
    }
    
	@SuppressWarnings("unchecked")
	@Transactional
    public List<CotizacionCabeceraDto> buscarCotizacion(FiltroBusquedaDto filtro) {
		
		String sql = "select p from CotizacionCabeceraDto p where fecha between :fecInicio and :fecFin";
	    			     
	   	sesion = sessionFactory.getCurrentSession();
	   	
	   	return sesion.createQuery(sql).setParameter("fecInicio",filtro.getFechaInicio())
	   			                      .setParameter("fecFin", filtro.getFechaFin()).list();
	}
	
	@Transactional
	public void actualizarCotizacion(CotizacionCabeceraDto cotizacionDto){
		
		sesion = sessionFactory.getCurrentSession();
		
		sesion.update(cotizacionDto);
	}
	
	public void setSesion(Session sesion) {
		this.sesion = sesion;
	}  
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}