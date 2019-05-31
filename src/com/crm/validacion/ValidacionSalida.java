package com.crm.validacion;

import org.springframework.stereotype.Component;

import com.crm.services.NegocioException;

@Component 
public class ValidacionSalida {
	
	public void validarDatosNegocio(int cantidadVendida, int cantidadEnviada,int cantidadAEnviar) {
		
		if(cantidadVendida < (cantidadEnviada + cantidadAEnviar)) {
			
			throw new NegocioException("La cantidad enviada es mayor a la cantidad vendida", NegocioException.SEVERITY_WARNNIN);
		}
	}

}
