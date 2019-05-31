package com.crm.validacion;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.crm.dto.ProductoDto;
import com.crm.services.BaseException;
import com.crm.services.NegocioException;

@Component
public class ValidacionProducto {
	
	public void validacionDatosProducto(ProductoDto productoDto){
		
		ArrayList<String> msgValidacion = new ArrayList<String>();
		
		if(productoDto.getNombre() == null || productoDto.getNombre().isEmpty()) {
			msgValidacion.add("nombre");
		}

		if(productoDto.getCodigo() == null || productoDto.getCodigo().isEmpty()){
			msgValidacion.add("Referencia");
		}
		
		String validaciones = "";
		
		for(String msj:msgValidacion) {
			validaciones += " *" + msj;
		}
		
		if(msgValidacion.size() >0) {
			throw new NegocioException("Dato(s) obligatorio(s) " + validaciones, BaseException.SEVERITY_WARNNIN);
		}
		
		validacionNegocio(productoDto);
	}
	
	public void validacionNegocio(ProductoDto productoDto) {
		
		if(productoDto.getCantidad() <=0) {
			throw new NegocioException("El campo cantidad debe ser mayor a cero(0)", BaseException.SEVERITY_WARNNIN);
		}
	}
}
