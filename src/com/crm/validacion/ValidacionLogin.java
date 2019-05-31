package com.crm.validacion;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.crm.dto.UsuarioDto;
import com.crm.services.BaseException;
import com.crm.services.NegocioException;

@Component
public class ValidacionLogin {
	
	public void validacionAcceso(UsuarioDto usuarioDto, String login, String contrasena) {
		
		if(!login.toUpperCase().equals(usuarioDto.getUsu_login())){

			throw new NegocioException("El login no existe en el sistema.", BaseException.SEVERITY_WARNNIN);

		}if(!contrasena.equals(usuarioDto.getUsu_contrasena())){

			throw new NegocioException("La contraseña es incorrecta.", BaseException.SEVERITY_WARNNIN);
		}
	}
	
	public void validarDatosObligatorios(String login, String contrasena) {
		
		ArrayList<String> msgValidacion = new ArrayList<String>();
		
		if(login == null || login.isEmpty()) {
			msgValidacion.add("Login");
		}
		
		if(contrasena == null || contrasena.isEmpty()) {
			msgValidacion.add("Contraseña");
		}

		String validaciones = "";
		
		for(String msj:msgValidacion) {
			validaciones += " *" + msj;
		}
		
		if(msgValidacion.size() > 0) {
			throw new NegocioException("Dato(s) obligatorio(s) " + validaciones, BaseException.SEVERITY_WARNNIN);
		}
		
	}
}
