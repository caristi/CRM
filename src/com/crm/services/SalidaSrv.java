package com.crm.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.crm.dao.SalidaDao;
import com.crm.dto.FiltroBusquedaDto;
import com.crm.dto.SalidaCabeceraDto;
import com.crm.dto.SalidaDetalleDto;

public class SalidaSrv{

	@Autowired
	private SalidaDao salidaDao;

	public int guardarSalida(SalidaCabeceraDto salidaDto){

		return salidaDao.guardarSalida(salidaDto);
	}

	public List<SalidaCabeceraDto> buscarSalida(FiltroBusquedaDto filtro){
		
		return salidaDao.buscarSalida(filtro);
	}
	
	public void actualizarDetalleSalida(SalidaCabeceraDto salidaDto, int usuarioId) {
		
		float pctEnviado = 0;
		float pctTotalEnviado = 0;
		
		for(SalidaDetalleDto salidaDetalle:salidaDto.getListaDetalles()){
			
			if(salidaDetalle.getCantidadEnviada() > 0) {
				pctEnviado = (float)(salidaDetalle.getCantidadEnviada() * 100) / salidaDetalle.getCantidadVendida() ;
			}else {
				pctEnviado = 0;
			}
			
			if(pctEnviado >= 100) {
				salidaDetalle.setMcaEnviada('S');
			}else {
				salidaDetalle.setMcaEnviada('N');
			}
			salidaDetalle.setFechaEnviado(new Date());
			salidaDetalle.getUsuarioDto().setUsu_id(usuarioId);
			salidaDetalle.setPctEnviado(pctEnviado);
			
			pctTotalEnviado = pctTotalEnviado + pctEnviado ;
		}
		
		pctTotalEnviado = pctTotalEnviado / salidaDto.getListaDetalles().size();
		
		salidaDto.setPctEnviado(pctTotalEnviado);
		salidaDto.getUsuarioDto().setUsu_id(usuarioId);
		
		if(salidaDto.getPctEnviado() >= 100) {
			salidaDto.setMcaCompletada('S');
		}else {
			salidaDto.setMcaCompletada('N');
		}
		
		salidaDao.actualizarDetalleSalida(salidaDto);
	}
	
	public List<SalidaDetalleDto> listarDetalleSalida(int idSalida){
		
		return salidaDao.listarDetalleSalida(idSalida);
	}
	
	public List<SalidaDetalleDto> seleccionarTodoNinguno(List<SalidaDetalleDto> listaDetalle,boolean valor) {
		
		for(SalidaDetalleDto det:listaDetalle) {
			if(valor) {
				det.setCantidadEnviada(det.getCantidadVendida());
			}else {
				if(det.getMcaEnviada()== 'N') {
					det.setCantidadEnviada(0);				
				}
			}
		}
		
		return listaDetalle;
	}
	
	public void setSalidaDao(SalidaDao salidaDao) {
		this.salidaDao = salidaDao;
	}
}
