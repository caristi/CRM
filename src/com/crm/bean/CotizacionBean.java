package com.crm.bean;

import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import com.crm.dto.ClienteDto;
import com.crm.dto.CotizacionCabeceraDto;
import com.crm.dto.CotizacionDetalleDto;
import com.crm.dto.FiltroBusquedaDto;
import com.crm.dto.ProductoDto;
import com.crm.services.CotizacionSrv;

public class CotizacionBean {

	private CotizacionSrv cotizacionSrv;
	
	private CotizacionCabeceraDto cotizacionDto;
	private CotizacionCabeceraDto cotizacionSelecDto;
	private FiltroBusquedaDto filtro;
	
	private List<CotizacionCabeceraDto> listaCotizacionDto;
	private List<ProductoDto> listaProductos;
	
	public CotizacionBean() {
		
		cotizacionDto = new CotizacionCabeceraDto();
		cotizacionDto.setFecha(new Date());
		filtro = new FiltroBusquedaDto();
	}
	
	public void buscarCliente(){
		
		ClienteDto clienteDto = cotizacionSrv.buscarCliente(cotizacionDto.getClienteDto().getCli_num_docum());
		
		if(clienteDto.getCli_num_docum() != null && !clienteDto.getCli_num_docum().isEmpty()){
			cotizacionDto.setClienteDto(clienteDto);
		}else{
			
			FacesContext contextBean = FacesContext.getCurrentInstance();
            ClienteBean clienteBean = (ClienteBean) contextBean.getELContext().getELResolver().getValue(contextBean.getELContext(), null, "clienteBean");
        	
			RequestContext context = RequestContext.getCurrentInstance();
			context.execute("PF('dlgCliente').show();"); 
		}
	}
	
	public List<ProductoDto> completeProductos(String query) {
		listaProductos = cotizacionSrv.completeProductos(query);
		
		return listaProductos;
    }
	
	public void realizarCalculosDetalle(CotizacionDetalleDto detalleDto){
		detalleDto = cotizacionSrv.realizarCalculosDetalle(cotizacionDto,detalleDto);
	}
	
    public void eliminarRegistroTabla(CotizacionDetalleDto detalle) {
    	
    	cotizacionDto.getListaDetalles().remove(detalle);
    	
    	cotizacionDto = cotizacionSrv.realizaCalculosCotizacion(cotizacionDto);
    }
    
	public void guardarCotizacion(){
		cotizacionSrv.guardarCotizacion(cotizacionDto);
	}
	
	public void buscarCotizacion(){
		
		listaCotizacionDto = cotizacionSrv.buscarCotizacion(filtro);
	}
	
	public String nuevaCotizacion(){
		
		cotizacionDto = new CotizacionCabeceraDto();
		
		return "cotizacion";
	}
	
	public String consultarUnaCotizacion(){
		
		cotizacionDto = cotizacionSelecDto;
		
		return "cotizacion";
	}
	
	public void setCotizacionSrv(CotizacionSrv cotizacionSrv) {
		this.cotizacionSrv = cotizacionSrv;
	}

	public CotizacionCabeceraDto getCotizacionDto() {
		return cotizacionDto;
	}

	public List<CotizacionCabeceraDto> getListaCotizacionDto() {
		return listaCotizacionDto;
	}

	public FiltroBusquedaDto getFiltro() {
		return filtro;
	}

	public CotizacionCabeceraDto getCotizacionSelecDto() {
		return cotizacionSelecDto;
	}

	public void setCotizacionSelecDto(CotizacionCabeceraDto cotizacionSelecDto) {
		this.cotizacionSelecDto = cotizacionSelecDto;
	}

	public List<ProductoDto> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(List<ProductoDto> listaProductos) {
		this.listaProductos = listaProductos;
	}
}