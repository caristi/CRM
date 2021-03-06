package com.crm.bean;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;
import org.springframework.stereotype.Controller;

import com.crm.dto.FacturaCabeceraDto;

@Controller
public class FacturaBean {

	private FacturaCabeceraDto facCabeceraDto;
	
	public FacturaBean() {
		 
		facCabeceraDto = new FacturaCabeceraDto();
//		FacturaDetalleDto detalleFactura= new FacturaDetalleDto();
//		facCabeceraDto.getListaDetalleFactura().add(detalleFactura);
	}
	
	public void resetear(){
//		facCabeceraDto.getListaDetalleFactura().get(facCabeceraDto.getListaDetalleFactura().size() + 1);
	}
	
	public void actualizarCelda(RowEditEvent event) {
//        Object oldValue = event.getOldValue();
//        Object newValue = event.getNewValue();
         
//        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage("Car Edited");
            FacesContext.getCurrentInstance().addMessage(null, msg);
//        }
    }

	public FacturaCabeceraDto getFacCabeceraDto() {
		return facCabeceraDto;
	}

	public void setFacCabeceraDto(FacturaCabeceraDto facCabeceraDto) {
		this.facCabeceraDto = facCabeceraDto;
	}


}