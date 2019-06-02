package com.crm.bean;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.crm.dto.ProveedorDto;
import com.crm.services.ProveedorSrv;

@Controller
public class ProveedorBean {

	private ProveedorDto proveedorDto;
	
	@Autowired
	private ProveedorSrv proveedorSrv;
	private List<ProveedorDto> listaProveedores;
	private ProveedorDto selectProveedorDto;
		
	
	private String opcion_busqueda;
	private String valor_busqueda;
	
	private boolean btnEditar;
	
	
	public ProveedorBean() {
		proveedorDto = new ProveedorDto();
		btnEditar = false;
	}
	
	public void resetear(){
	}
		
    public void guardar(){
  		proveedorSrv.guardarProveedor(proveedorDto);
    	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Proveedor Registrado �xitosamente"));
    }
    
    public String irVistaRegistroProveedor(){
    	setBtnEditar(false);
    	proveedorDto = new ProveedorDto();
    	return "actualizarAgregarProveedor";
    }
    
    public void actualizar(){
    	proveedorSrv.actualizarProveedor(proveedorDto);
    	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Proveedor Actualizado �xitosamente"));
    }
    
	public void consultaProveedores(){
		listaProveedores = proveedorSrv.listaProveedores();
	}
	
	public void filtroProveedores(){
		listaProveedores = proveedorSrv.filtroProveedor(opcion_busqueda, valor_busqueda);
	}
	
	public String consultarUnProveedor(){
		this.proveedorDto = selectProveedorDto; 
		btnEditar = true;
		return "actualizarAgregarProveedor";
	}

	public List<ProveedorDto> getListaProveedores() {
		return listaProveedores;
	}

	public boolean isBtnEditar() {
		return btnEditar;
	}

	public ProveedorDto getProveedorDto() {
		return proveedorDto;
	}

	public void setProveedorDto(ProveedorDto proveedorDto) {
		this.proveedorDto = proveedorDto;
	}

	public ProveedorSrv getProveedorSrv() {
		return proveedorSrv;
	}

	public void setProveedorSrv(ProveedorSrv proveedorSrv) {
		this.proveedorSrv = proveedorSrv;
	}

	public ProveedorDto getSelectProveedorDto() {
		return selectProveedorDto;
	}

	public void setSelectProveedorDto(ProveedorDto selectProveedorDto) {
		this.selectProveedorDto = selectProveedorDto;
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

	public void setListaProveedores(List<ProveedorDto> listaProveedores) {
		this.listaProveedores = listaProveedores;
	}

	public void setBtnEditar(boolean btnEditar) {
		this.btnEditar = btnEditar;
	}



	
}