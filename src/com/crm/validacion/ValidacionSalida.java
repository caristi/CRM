package com.crm.validacion;

import com.crm.services.NegocioException;

public class ValidacionSalida {
	
	public void validarDatosNegocio(int cantidadVendida, int cantidadEnviada,int cantidadAEnviar) {
		
		if(cantidadVendida < (cantidadEnviada + cantidadAEnviar)) {
			
			throw new NegocioException("La cantidad enviada es mayor a la cantidad vendida", NegocioException.SEVERITY_WARNNIN);
		}
	}

}
