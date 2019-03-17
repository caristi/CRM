package com.crm.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.crm.dao.ProductoDao;
import com.crm.dao.SalidaDao;
import com.crm.dto.FiltroBusquedaDto;
import com.crm.dto.ProductoDto;
import com.crm.dto.SalidaCabeceraDto;
import com.crm.dto.SalidaDetalleDto;
import com.crm.validacion.ValidacionSalida;

public class SalidaSrv{

	@Autowired
	private ValidacionSalida validacionSalida;
	private SalidaDao salidaDao;
	private ProductoDao productoDao;

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
			
			validacionSalida.validarDatosNegocio(salidaDetalle.getCantidadVendida(),salidaDetalle.getCantidadEnviada(),salidaDetalle.getCantidadAEnviar());

			salidaDetalle.setCantidadEnviada(salidaDetalle.getCantidadEnviada() + salidaDetalle.getCantidadAEnviar());
			
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
			
			pctTotalEnviado = pctTotalEnviado + pctEnviado;
			
			ProductoDto productoDto = new ProductoDto();
			productoDto.setId(salidaDetalle.getProductoDto().getId());
			productoDto.setCantidad(salidaDetalle.getCantidadAEnviar());
			
			productoDao.restarCantidadProducto(productoDto);
			salidaDetalle.setCantidadAEnviar(0);
			
		}
		
		pctTotalEnviado = pctTotalEnviado / salidaDto.getListaDetalles().size();
		
		salidaDto.setPctEnviado(pctTotalEnviado);
		salidaDto.getUsuarioDto().setUsu_id(usuarioId);
		
		if(salidaDto.getPctEnviado() >= 100) {
			salidaDto.setMcaCompletada('S');
			salidaDto.setEstado("C");
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
				det.setCantidadAEnviar(det.getCantidadVendida() - det.getCantidadEnviada());
			}else {
				if(det.getMcaEnviada()== 'N') {
					det.setCantidadAEnviar(0);				
				}
			}
		}
		
		return listaDetalle;
	}
	
	public void setValidacionSalida(ValidacionSalida validacionSalida) {
		this.validacionSalida = validacionSalida;
	}
	
	public void setSalidaDao(SalidaDao salidaDao) {
		this.salidaDao = salidaDao;
	}
	
	public void setProductoDao(ProductoDao productoDao) {
		this.productoDao = productoDao;
	}
}
