package com.crm.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.crm.dto.UsuarioDto;

@Repository
public class UsuarioDao{
	
	private Session sesion;				    							
	
	@Autowired
    private SessionFactory sessionFactory;
	
    @Transactional
	public int guardarUsuario(UsuarioDto usuarioDto){
		sesion = sessionFactory.getCurrentSession();
		return (Integer) sesion.save(usuarioDto);
	}
    @Transactional		
	public void actualizarUsuario(UsuarioDto usuarioDto){
		sesion = sessionFactory.getCurrentSession();
		sesion.update(usuarioDto);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<UsuarioDto> listaUsuarios(){
		sesion = sessionFactory.getCurrentSession();
		List<UsuarioDto> listaUsuario = null;
		listaUsuario = sesion.createQuery("select m from UsuarioDto m").list();
		return listaUsuario; 
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	 public List<UsuarioDto> filtroUsuarios(String opcion_busqueda, String valor_busqueda){
			
			String sql = "select g from UsuarioDto g";
		    			     
		  	List<UsuarioDto> usuarios = new ArrayList<UsuarioDto>();
		  	
		   	sesion = sessionFactory.getCurrentSession();
		   	
		   	if(opcion_busqueda.equals("D")){
		   		sql = sql+" Where g.usu_num_docum = "+valor_busqueda;
		   	}	
		   	else if (opcion_busqueda.equals("N")){
		   		sql = sql+" Where g.usu_nombre like '%"+valor_busqueda+"%'";
		   	}
		   	
		   	usuarios = sesion.createQuery(sql).list();
		   			
		   	return usuarios;
		}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public UsuarioDto consultarUsuario(UsuarioDto usuario){

	  sesion = sessionFactory.getCurrentSession();

	  List<UsuarioDto> usuarios = sesion.createQuery("select u from UsuarioDto u where u.usu_login = :login").setParameter("login", usuario.getUsu_login()).list();
	
	  if (usuarios != null && usuarios.size() > 0){
		  
		  return usuarios.get(0); 
	  }else{
		  
		  return new UsuarioDto();
	  }
	}
	
	
	public void setSesion(Session sesion) {
		this.sesion = sesion;
	}  
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}
