package com.crm.dao;

import java.util.List;			

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.crm.dto.FiltroBusquedaDto;
import com.crm.dto.VentaCabeceraDto;
import com.crm.dto.VentaDetalleDto;

public class VentaDao{
	
	private Session sesion;				    							
	
	@Autowired
    private SessionFactory sessionFactory;
	
    @Transactional
	public int guardarVenta(VentaCabeceraDto ventaDto){
    	
    	int id;
		
		sesion = sessionFactory.getCurrentSession();
		
	    id = (Integer) sesion.save(ventaDto);
		
		return id;
	}
    
	@SuppressWarnings("unchecked")
	@Transactional
    public List<VentaCabeceraDto> buscarVenta(FiltroBusquedaDto filtro) {
		
	   	sesion = sessionFactory.getCurrentSession();
	   	
	   	return sesion.createQuery("select p from VentaCabeceraDto p where fecha between :fecInicio and :fecFin")
	   			                 .setParameter("fecInicio",filtro.getFechaInicio())
	   			                 .setParameter("fecFin", filtro.getFechaFin())
	   			                 .list();
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<VentaDetalleDto> listarDetalleVenta(int idVenta){
    	
    	sesion = sessionFactory.getCurrentSession();
		
		List<VentaDetalleDto> lista = sesion.createQuery("select d from VentaDetalleDto d where venId = :idVenta")
								  				         .setParameter("idVenta", idVenta)
								  				         .list();
    	
    	return lista;
    }
	
	public void setSesion(Session sesion) {
		this.sesion = sesion;
	}  
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
