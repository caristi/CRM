package com.crm.bean;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.crm.dto.UsuarioDto;
import com.crm.services.UsuarioSrv;


public class UsuarioBean {

	private UsuarioDto usuarioDto;
	private UsuarioSrv usuarioSrv;
	private List<UsuarioDto> listaUsuarios;
	private UsuarioDto selectUsuarioDto;
		
	
	private String opcion_busqueda;
	private String valor_busqueda;
	
	private boolean btnEditar;
	
	public UsuarioBean() {
		usuarioDto = new UsuarioDto();
		setBtnEditar(false);
	}
	
	public void resetear(){
	}
	
	public void guardar(){
    	usuarioSrv.guardarUsuario(usuarioDto);
    	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Usuario Registrado exitosamente"));
    }
	    
	public String irVistaRegistroUsuario(){
	    	setBtnEditar(false);
	    	usuarioDto = new UsuarioDto();
	    	return "actualizarAgregarUsuario";
	}
	  
    public void actualizar(){
    	usuarioSrv.actualizarUsuario(usuarioDto);
    	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Usuario Actualizado exitosamente"));
    }
    
	public void consultaUsuarios(){
		listaUsuarios = usuarioSrv.listaUsuarios();
	}
	
	public void filtroUsuarios(){
		listaUsuarios = usuarioSrv.filtroUsuarios(opcion_busqueda, valor_busqueda);
	}
	
	public String consultarUnUsuario(){
		this.usuarioDto = selectUsuarioDto; 
		setBtnEditar(true);
		return "actualizarAgregarUsuario";
	}
	
	public List<UsuarioDto> getListaUsuarios() {
		return listaUsuarios;
	}
    
	public UsuarioSrv getUsuarioSrv() {
		return usuarioSrv;
	}

	public UsuarioDto getUsuarioDto() {
		return usuarioDto;
	}
	
	public UsuarioDto getusuarioDto() {
		return usuarioDto;
	}

	public UsuarioDto getSelectUsuarioDto() {
		return selectUsuarioDto;
	}

	public void setUsuarioSrv(UsuarioSrv usuarioSrv) {
		this.usuarioSrv = usuarioSrv;
	}
    
    public void setUsuarioDto(UsuarioDto usuarioDto) {
		this.usuarioDto = usuarioDto;
	}

	public void setListaUsuarios(List<UsuarioDto> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public void setSelectUsuarioDto(UsuarioDto selectUsuarioDto) {
		this.selectUsuarioDto = selectUsuarioDto;
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

	public boolean isBtnEditar() {
		return btnEditar;
	}

	public void setBtnEditar(boolean btnEditar) {
		this.btnEditar = btnEditar;
	}
}