package com.crm.dao;

import java.util.ArrayList;
import java.util.List;			
import java.util.Date;		

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.crm.dto.ReportesDto;

@Component
public class ReportesDao{
	
	private Session sesion;				    							
	
	@Autowired
    private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Transactional
public List<ReportesDto> ventasUsuarioEspecifico(int codigo_vendedor, Date fecha_inicio, Date fecha_fin) {
		
		List<ReportesDto> listaReporte = null;

		sesion = sessionFactory.getCurrentSession();
		
		List<Object[]> rows = sesion.createSQLQuery	("SELECT COUNT(ven_id), SUM(ven_vlr_total) "
													+ "FROM venta_cabecera "
													+ "where usu_id = :usu_id and ven_fecha BETWEEN :fecha_inicio AND :fecha_fin")
													.setParameter("usu_id", codigo_vendedor)
													.setParameter("fecha_inicio", fecha_inicio)
													.setParameter("fecha_fin", fecha_fin).list();
		listaReporte = new ArrayList<ReportesDto>();
		
		for(Object[] row : rows){
			
		    ReportesDto rep = new ReportesDto();
//		    rep.setUsuId(Integer.parseInt(row[0].toString()));
		    rep.setVenId(row[0] != null ? Integer.parseInt(row[0].toString()):0);
		    rep.setValorVentaTotal(row[1] != null ? new Double(row[1].toString()):0);
//		    rep.setNombreMateria(row[2].toString());
		    
		    
		    listaReporte.add(rep);
		}
		
		return listaReporte;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
public List<ReportesDto> ventasTotales(Date fecha_inicio, Date fecha_fin) {
		
		List<ReportesDto> listaVentas = null;

		sesion = sessionFactory.getCurrentSession();
		
		List<Object[]> rows = sesion.createSQLQuery	("SELECT COUNT(ven_id), SUM(ven_vlr_total) "
													+ "FROM venta_cabecera "
													+ "where ven_fecha BETWEEN :fecha_inicio AND :fecha_fin")
													.setParameter("fecha_inicio", fecha_inicio)
													.setParameter("fecha_fin", fecha_fin).list();
		listaVentas = new ArrayList<ReportesDto>();
		
		for(Object[] row : rows){
			
		    ReportesDto rep = new ReportesDto();
//		    rep.setUsuId(Integer.parseInt(row[0].toString()));
		    rep.setVenId(row[0] != null ? Integer.parseInt(row[0].toString()):0);
		    rep.setValorVentaTotal(row[1] != null ? new Double(row[1].toString()):0);
//		    rep.setNombreMateria(row[2].toString());
		    
		    
		    listaVentas.add(rep);
		}
		
		return listaVentas;
	}

	@SuppressWarnings("unchecked")
	@Transactional
public List<ReportesDto> ventasProductos(Date fecha_inicio, Date fecha_fin) {
		
		List<ReportesDto> listaVentasProductos = null;

		sesion = sessionFactory.getCurrentSession();
		
		List<Object[]> rows = sesion.createSQLQuery	("SELECT vd.pro_id, p.pro_nombre, sum(vd.vend_cantidad) from venta_detalle vd, venta_cabecera v, producto p "
													+ "where vd.vend_id = v.ven_id and p.pro_id = vd.pro_id and v.ven_fecha "
													+ "BETWEEN :fecha_inicio AND :fecha_fin group by pro_id")
													.setParameter("fecha_inicio", fecha_inicio)
													.setParameter("fecha_fin", fecha_fin).list();
		listaVentasProductos = new ArrayList<ReportesDto>();
		
		for(Object[] row : rows){
			
		    ReportesDto rep = new ReportesDto();
//		    rep.setUsuId(Integer.parseInt(row[0].toString()));
		    rep.setProId(row[0] != null ? Integer.parseInt(row[0].toString()):0);
		    rep.setProNombre(row[1].toString());
		    rep.setCantidadArticulos(row[2] != null ? new Double(row[2].toString()):0);
//		    rep.setCantidadArticulos(row[2] != null ? Integer.parseInt(row[2].toString()):0);

		    
		    
		    listaVentasProductos.add(rep);
		}
		
		return listaVentasProductos;
	}

	
	
	public void setSesion(Session sesion) {
		this.sesion = sesion;
	}  
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
