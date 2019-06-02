package com.crm.bean;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.crm.dto.ClienteHistoricoDto;
import com.crm.services.ClienteHistoricoSrv;

@Controller
public class ClienteHistoricoBean {

	@Autowired
	private ClienteHistoricoSrv clientehistoricoSrv;
	
	private ClienteHistoricoDto clientehistoricoDto;
	private ClienteHistoricoDto selectClientehistoricoDto;
	
	private List<ClienteHistoricoDto> listaHistoricos;

	private String opcion_busqueda;
	private String valor_busqueda;
	
	public ClienteHistoricoBean() {
		clientehistoricoDto = new ClienteHistoricoDto();
	}
	
	public void resetear(){
	}
		
    public void guardar(){
    	clientehistoricoSrv.guardarHistorico(clientehistoricoDto);
    	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Registro Guardado exitosamente"));
    }
    
    public String irVistaRegistroHistorico(){
    	clientehistoricoDto = new ClienteHistoricoDto();
       	return "actualizarAgregarHistorico";
    }
    
    public void actualizar(){
    	//origenCotizacion = false;
    	clientehistoricoSrv.actualizarHistorico(clientehistoricoDto);
    	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Registro Actualizado exitosamente"));
    }
    
     
	public void consultaHistoricos(){
		listaHistoricos = clientehistoricoSrv.listaHistoricos();
	}
	
	public void filtroHistoricos(){
		listaHistoricos = clientehistoricoSrv.filtroHistoricos(opcion_busqueda, valor_busqueda);
	}
	
	public String consultarUnHistorico(){
		this.clientehistoricoDto = selectClientehistoricoDto;
		return "actualizarAgregarHistorico";
	}

	public ClienteHistoricoDto getClientehistoricoDto() {
		return clientehistoricoDto;
	}

	public void setClientehistoricoDto(ClienteHistoricoDto clientehistoricoDto) {
		this.clientehistoricoDto = clientehistoricoDto;
	}

	public ClienteHistoricoSrv getClientehistoricoSrv() {
		return clientehistoricoSrv;
	}

	public void setClientehistoricoSrv(ClienteHistoricoSrv clientehistoricoSrv) {
		this.clientehistoricoSrv = clientehistoricoSrv;
	}

	public List<ClienteHistoricoDto> getListaHistoricos() {
		return listaHistoricos;
	}

	public void setListaHistoricos(List<ClienteHistoricoDto> listaHistoricos) {
		this.listaHistoricos = listaHistoricos;
	}

	public ClienteHistoricoDto getSelectClienteDto() {
		return selectClientehistoricoDto;
	}

	public void setSelectClienteDto(ClienteHistoricoDto selectClienteHistoricoDto, ClienteHistoricoDto selectClientehistoricoDto) {
		this.selectClientehistoricoDto = selectClientehistoricoDto;
	}

	public String getOpcion_busqueda() {
		return opcion_busqueda;
	}

	public void setOpcion_busqueda(String opcion_busqueda) {
		this.opcion_busqueda = opcion_busqueda;
	}

	public String getValor_busqueda() {
		return valor_busqueda;
	}

	public void setValor_busqueda(String valor_busqueda) {
		this.valor_busqueda = valor_busqueda;
	}

	
}