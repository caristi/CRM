package com.crm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.crm.dto.FiltroBusquedaDto;
import com.crm.dto.SalidaCabeceraDto;
import com.crm.dto.SalidaDetalleDto;

@Repository
public class SalidaDao{
	
	private Session sesion;				    							
	
	@Autowired
    private SessionFactory sessionFactory;
	
    @Transactional
	public int guardarSalida(SalidaCabeceraDto salidaDto){
    	
		sesion = sessionFactory.getCurrentSession();
		
		return (Integer) sesion.save(salidaDto);
	}
    
	@SuppressWarnings("unchecked")
	@Transactional
    public List<SalidaCabeceraDto> buscarSalida(FiltroBusquedaDto filtro) {
		
	   	sesion = sessionFactory.getCurrentSession();
	   	
	   	String sql = "select p from SalidaCabeceraDto p where 1 = 1 ";
	   	
	   	if(filtro.getEstado() != null && !filtro.getEstado().isEmpty()) {
	   		
	   		sql = sql + " and estado = '" + filtro.getEstado() + "'";
	   	}
	   	
	   	if(filtro.getFechaInicio() != null && filtro.getFechaFin() != null) {
	   		sql = sql + " and fecha between " + filtro.getFechaInicio() +  " and " + filtro.getFechaFin();
	   	}
	   	
	   	return sesion.createQuery(sql).list();
	}
	
	@Transactional
	public void actualizarDetalleSalida(SalidaCabeceraDto salidaDto){
		
		sesion = sessionFactory.getCurrentSession();
		
		sesion.merge(salidaDto);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<SalidaDetalleDto> listarDetalleSalida(int idSalida){
    	
    	sesion = sessionFactory.getCurrentSession();
		
    	return sesion.createQuery("select d from SalidaDetalleDto d where salId = :idSalida")
								  				         .setParameter("idSalida", idSalida)
								  				         .list();
    }
	
	public void setSesion(Session sesion) {
		this.sesion = sesion;
	}  
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
