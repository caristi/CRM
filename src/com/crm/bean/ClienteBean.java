package com.crm.bean;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import com.crm.dto.ClienteDto;
import com.crm.services.ClienteSrv;


public class ClienteBean {

	private ClienteDto clienteDto;
	private ClienteSrv clienteSrv;
	private List<ClienteDto> listaClientes;
	private ClienteDto selectClienteDto;
		
	
	private String opcion_busqueda;
	private String valor_busqueda;
	
	private boolean btnEditar;
	private boolean mcaEditar;
	private boolean campoEditable;
	
	
	public ClienteBean() {
		clienteDto = new ClienteDto();
		btnEditar = false;
		campoEditable = false;
	}
	
	public void resetear(){
	}
		
    public void guardar(){
    	clienteSrv.guardarCliente(clienteDto);
    	mcaEditar = true;
		campoEditable = false;
    	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Cliente Registrado �xitosamente"));

    }
    
    public String irVistaRegistroCliente(){
    	btnEditar = false;
    	return "actualizarAgregarCliente";
    }
    
    public void actualizar(){
    	clienteSrv.actualizarCliente(clienteDto);
    	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Cliente Actualizado �xitosamente"));
    }
    
	public void consultaClientes(){
		listaClientes = clienteSrv.listaClientes();
	}
	
	public void filtroClientes(){
		listaClientes = clienteSrv.filtroClientes(opcion_busqueda, valor_busqueda);
	}
	
	public String consultarUnCliente(){
		this.clienteDto = selectClienteDto; 
		btnEditar = true;
		return "actualizarAgregarCliente";
	}

	public List<ClienteDto> getListaClientes() {
		return listaClientes;
	}
    
	public ClienteSrv getClienteSrv() {
		return clienteSrv;
	}

	public ClienteDto getClienteDto() {
		return clienteDto;
	}
	
	public ClienteDto getclienteDto() {
		return clienteDto;
	}

	public ClienteDto getSelectClienteDto() {
		return selectClienteDto;
	}

	public void setClienteSrv(ClienteSrv clienteSrv) {
		this.clienteSrv = clienteSrv;
	}
    
    public void setClienteDto(ClienteDto clienteDto) {
		this.clienteDto = clienteDto;
	}

	public void setListaClientes(List<ClienteDto> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public void setSelectClienteDto(ClienteDto selectClienteDto) {
		this.selectClienteDto = selectClienteDto;
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

	public boolean isMcaEditar() {
		return mcaEditar;
	}

	public void setMcaEditar(boolean mcaEditar) {
		this.mcaEditar = mcaEditar;
	}

	public boolean isCampoEditable() {
		return campoEditable;
	}

	public void setCampoEditable(boolean campoEditable) {
		this.campoEditable = campoEditable;
	}


	
}