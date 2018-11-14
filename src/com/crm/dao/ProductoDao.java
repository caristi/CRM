package com.crm.dao;

import java.util.List;			

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.crm.dto.ProductoDto;

public class ProductoDao{
	
	private Session sesion;				    							
	
	@Autowired
    private SessionFactory sessionFactory;
	
    @Transactional
	public int guardarProducto(ProductoDto productoDto){
    	
    	int id;
		
		sesion = sessionFactory.getCurrentSession();
		
	    id = (Integer) sesion.save(productoDto);
		
		return id;
	}
    
    @SuppressWarnings("unchecked")
	@Transactional
	public List<ProductoDto> listarProductos(){
    	
    	sesion = sessionFactory.getCurrentSession();
		
		List<ProductoDto> lista = null;
    	
		lista = sesion.createQuery("select p from ProductoDto p").list();
    	
    	return lista;
    }
    
	@SuppressWarnings("unchecked")
	@Transactional
    public List<ProductoDto> buscarProducto(ProductoDto productoDto){
		
		String sql = "select p from ProductoDto p ";
	    			     
	   	sesion = sessionFactory.getCurrentSession();
	   	
	   	if(productoDto.getNombre() != null && !productoDto.getNombre().isEmpty()){
	   		
	   		sql += "Where p.nombre like '%" + productoDto.getNombre() + "%' ";
	   	}
	   	
	   	return sesion.createQuery(sql).list();
	}
	
	@Transactional
	public void actualizarProducto(ProductoDto productoDto){
		
		sesion = sessionFactory.getCurrentSession();
		
		sesion.update(productoDto);
	}
    
	public void setSesion(Session sesion) {
		this.sesion = sesion;
	}  
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
