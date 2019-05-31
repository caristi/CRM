package com.crm.validacion;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.crm.dto.UsuarioDto;
import com.crm.services.NegocioException;

@Component
public class ValidacionUsuario {
	
	public void validarDatosOblogatorios(UsuarioDto usuarioDto) {
		
		List<String> listaValidacion = new ArrayList<String>();
		
		if(usuarioDto.getUsu_login() == null || usuarioDto.getUsu_login().isEmpty()) {
			listaValidacion.add("Login");
		}
		
		if(usuarioDto.getUsu_contrasena() == null || usuarioDto.getUsu_contrasena().isEmpty()) {
			listaValidacion.add("contraseña");
		}
		
		if(usuarioDto.getUsu_nombre() == null || usuarioDto.getUsu_nombre().isEmpty()){
			listaValidacion.add("nombre");
		}
		
		if(usuarioDto.getUsu_apellido1() == null || usuarioDto.getUsu_apellido1().isEmpty()) {
			listaValidacion.add("Primer Apellido");
		}
		
		String validaciones = "";
		
		for(String msj:listaValidacion) {
			validaciones += " *" + msj;
		}
		
		if(listaValidacion.size() > 0) {
			throw new NegocioException("Dato(s) obligatorio(s)" + validaciones, NegocioException.SEVERITY_WARNNIN);
		}
	}
}
