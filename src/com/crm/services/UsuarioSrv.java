package com.crm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.crm.dao.UsuarioDao;
import com.crm.dto.UsuarioDto;
import com.crm.validacion.ValidacionLogin;
import com.crm.validacion.ValidacionUsuario;

@Component
public class UsuarioSrv{
	
	@Autowired
	private ValidacionLogin validacionLogin;
	@Autowired
	private ValidacionUsuario validacionUsuario;
	@Autowired
	private UsuarioDao usuarioDao;
	
	public int guardarUsuario(UsuarioDto usuarioDto){
		
		validacionUsuario.validarDatosOblogatorios(usuarioDto);
		
		return usuarioDao.guardarUsuario(usuarioDto);
	}
	
	public void actualizarUsuario (UsuarioDto usuarioDto) {
		
		validacionUsuario.validarDatosOblogatorios(usuarioDto);
		
		usuarioDao.actualizarUsuario(usuarioDto);
	}
	
	public List<UsuarioDto> listaUsuarios(){
		return usuarioDao.listaUsuarios();
	}
	
	public List<UsuarioDto> filtroUsuarios(String opcion_busqueda, String valor_busqueda){
		return usuarioDao.filtroUsuarios(opcion_busqueda, valor_busqueda);
	}
	
	public UsuarioDto consultarUsuario(UsuarioDto usuario){

		String login = usuario.getUsu_login();
		String contrasena = usuario.getUsu_contrasena();
		
		validacionLogin.validarDatosObligatorios(login, contrasena);

		usuario =  usuarioDao.consultarUsuario(usuario);

		usuario.setAcceso(true);
		
		validacionLogin.validacionAcceso(usuario,login,contrasena);

		return usuario;
	}
	
	public void setValidacionLogin(ValidacionLogin validacionLogin) {
		this.validacionLogin = validacionLogin;
	}
	
	public void setValidacionUsuario(ValidacionUsuario validacionUsuario) {
		this.validacionUsuario = validacionUsuario;
	}
	
	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}
}
