package com.crm.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.crm.dto.OpcionDto;

@Repository
public class MenuDao{

	private Session sesion;				    							

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Transactional
	public List<OpcionDto> consultarOpciones() {

		String sql = "select o from OpcionDto o ";

		List<OpcionDto> opciones = new ArrayList<OpcionDto>();

		sesion = sessionFactory.getCurrentSession();

		opciones = sesion.createQuery(sql).list();
		
		return opciones;
	}

	public void setSesion(Session sesion) {
		this.sesion = sesion;
	}  
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
