package com.crm.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.crm.dto.FiltroBusquedaDto;
import com.crm.dto.SalidaCabeceraDto;
import com.crm.dto.UsuarioDto;
import com.crm.services.SalidaSrv;
import com.crm.util.Constantes;

public class SalidaBean {

	private SalidaSrv salidaSrv;
	
	private SalidaCabeceraDto salidaDto;
	private SalidaCabeceraDto salidaSelecDto;
	private FiltroBusquedaDto filtro;
	private UsuarioDto usuarioLogueado;
	
	private List<SalidaCabeceraDto> listaSalidaDto;
	
	public SalidaBean() {
		
		filtro = new FiltroBusquedaDto();
	}
	
	public void consultaEstadosPendientes(){
		
		filtro = new FiltroBusquedaDto();
		filtro.setEstado("P");

		listaSalidaDto = salidaSrv.buscarSalida(filtro);
		
		filtro = new FiltroBusquedaDto();
	}
	
	public void buscarSalida(){
		
		listaSalidaDto = salidaSrv.buscarSalida(filtro);
	}
	
	public String consultarUnaSalida(){
		
		salidaDto = salidaSelecDto;
		
		salidaDto.setListaDetalles(salidaSrv.listarDetalleSalida(salidaDto.getId()));
		
		return Constantes.urlRegistroSalida;
	}
	
	public void actualizarDetalleSalida() {
		
		obtenerUsuario();

		salidaSrv.actualizarDetalleSalida(salidaDto,usuarioLogueado.getUsu_id());
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Se guardo la salida"));
	}
	
	public void obtenerUsuario() {
		FacesContext contextBean = FacesContext.getCurrentInstance();
		LoginBean loginBean = (LoginBean) contextBean.getELContext().getELResolver().getValue(contextBean.getELContext(), null, "loginBean");
		usuarioLogueado = loginBean.getUsuario();
	}
	
	public void seleccionarTodoNinguno() {
		
		salidaSrv.seleccionarTodoNinguno(salidaDto.getListaDetalles(),salidaDto.isSeleccionTodos());
	}
	
	public void setSalidaSrv(SalidaSrv salidaSrv) {
		this.salidaSrv = salidaSrv;
	}
	
	public FiltroBusquedaDto getFiltro() {
		return filtro;
	}

	public SalidaCabeceraDto getSalidaDto() {
		return salidaDto;
	}

	public SalidaCabeceraDto getSalidaSelecDto() {
		return salidaSelecDto;
	}

	public void setSalidaSelecDto(SalidaCabeceraDto salidaSelecDto) {
		this.salidaSelecDto = salidaSelecDto;
	}
	
	public List<SalidaCabeceraDto> getListaSalidaDto() {
		return listaSalidaDto;
	}
}