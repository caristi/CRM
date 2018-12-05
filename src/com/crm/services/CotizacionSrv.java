package com.crm.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.crm.dao.CotizacionDao;
import com.crm.dto.ClienteDto;
import com.crm.dto.CotizacionCabeceraDto;
import com.crm.dto.CotizacionDetalleDto;
import com.crm.dto.FiltroBusquedaDto;
import com.crm.dto.ProductoDto;

public class CotizacionSrv{

	@Autowired
	private CotizacionDao cotizacionDao;
	private ProductoSrv productoSrv;
	private ClienteSrv clienteSrv;

	public List<ProductoDto> completeProductos(String query) {
        
		List<ProductoDto> todosProductos  = productoSrv.listarProductos();
        List<ProductoDto> filtroProductos = new ArrayList<ProductoDto>();
        ProductoDto producto = null;
        for (int i = 0; i < todosProductos.size(); i++) {
        	producto = todosProductos.get(i);
            if(producto.getNombre().toUpperCase().contains(query.toUpperCase())) {
            	filtroProductos.add(producto);
            }
        }
        return filtroProductos;
    }
	
	public ClienteDto buscarCliente(String codDocum) {
		
		if(codDocum == null || codDocum.isEmpty()){
			return new ClienteDto();
		}
        
		List<ClienteDto> clientes = clienteSrv.filtroClientes("D", codDocum);
		
		if(clientes.size() > 0){
			return clientes.get(0);
		}else{
			return new ClienteDto();
		}
    }
	
	public CotizacionDetalleDto realizarCalculosDetalle(CotizacionCabeceraDto cotizacionDto,CotizacionDetalleDto detalleDto){
		
		if(detalleDto != null  && detalleDto.getCantidad() > 0 
			&& detalleDto.getProductoDto() != null && detalleDto.getProductoDto().getId() > 0){
			
			detalleDto.setVlrProducto(detalleDto.getProductoDto().getVlrVenta() * detalleDto.getCantidad());
			
			if(detalleDto.getPctDescuento() > 0){
				detalleDto.setVlrDescuento(detalleDto.getVlrProducto() * (detalleDto.getPctDescuento() / 100) + 1 );
			}else{
				detalleDto.setVlrDescuento(0);
			}
			
			detalleDto.setVlrSubTotal(detalleDto.getVlrProducto() - detalleDto.getVlrDescuento());
			
			realizaCalculosCotizacion(cotizacionDto);
			
		}
		
		return detalleDto;
	}
	
	public CotizacionCabeceraDto realizaCalculosCotizacion(CotizacionCabeceraDto cotizacion){
		
		cotizacion.setVlrIvaTotal(0);
		cotizacion.setVlrSubTotal(0);
		cotizacion.setVlrTotal(0);
		cotizacion.setVlrTotalDescuento(0);
		
		double vlrIva;
		double vlrSubTotal;
		int registrosCompletos = 0;
		
		ProductoDto producto;
		
		for(CotizacionDetalleDto detalle:cotizacion.getListaDetalles()){

			if(detalle != null  && detalle.getCantidad() > 0 
			    && detalle.getProductoDto() != null && detalle.getProductoDto().getId() > 0){
				
				vlrIva = 0;
				vlrSubTotal = 0;
	
				producto = detalle.getProductoDto();
	
				if(producto.getPct_iva() > 0){
					vlrSubTotal = detalle.getVlrSubTotal()  - (detalle.getVlrSubTotal() * (producto.getPct_iva() / 100));
					vlrIva = detalle.getVlrSubTotal() * (producto.getPct_iva() / 100);
				}else{
					vlrSubTotal = detalle.getVlrSubTotal();
					vlrIva = 0;
				}
	
				cotizacion.setVlrTotalDescuento(cotizacion.getVlrTotalDescuento() + detalle.getVlrDescuento());
				cotizacion.setVlrSubTotal(cotizacion.getVlrSubTotal() + vlrSubTotal);
				cotizacion.setVlrIvaTotal(cotizacion.getVlrIvaTotal() + vlrIva);
				cotizacion.setVlrTotal(cotizacion.getVlrIvaTotal() + cotizacion.getVlrSubTotal());
				
				if(detalle.getVlrSubTotal() > 0){
					registrosCompletos ++;
				}
			}
		}
		
		if(registrosCompletos == cotizacion.getListaDetalles().size()){
			cotizacion.getListaDetalles().add(new CotizacionDetalleDto());
		}
		
		return cotizacion;
	}
	
	public int guardarCotizacion(CotizacionCabeceraDto cotizacionDto){

		int id = cotizacionDao.guardarCotizacion(cotizacionDto);

		return id;
	}

	public List<CotizacionCabeceraDto> listarCotizacions(){
		return cotizacionDao.listarCotizacions();
	}

	public List<CotizacionCabeceraDto> buscarCotizacion(FiltroBusquedaDto filtro){
		
		return cotizacionDao.buscarCotizacion(filtro);
	}
	
	public void actualizarCotizacion(CotizacionCabeceraDto cotizacionDto){
		cotizacionDao.actualizarCotizacion(cotizacionDto);
	}
	
	public void setCotizacionDao(CotizacionDao cotizacionDao) {
		this.cotizacionDao = cotizacionDao;
	}

	public void setProductoSrv(ProductoSrv productoSrv) {
		this.productoSrv = productoSrv;
	}
	
	public void setClienteSrv(ClienteSrv clienteSrv) {
		this.clienteSrv = clienteSrv;
	}
}
