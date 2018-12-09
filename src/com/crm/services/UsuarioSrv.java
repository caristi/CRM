package com.crm.services;

import java.util.List;

import com.crm.dao.UsuarioDao;
import com.crm.dto.UsuarioDto;

public class UsuarioSrv{
	
	private UsuarioDao usuarioDao;
	
	public int guardarUsuario(UsuarioDto usuarioDto){
		
		int id = usuarioDao.guardarUsuario(usuarioDto);
		
		return id;
	}
	
	public void actualizarUsuario (UsuarioDto usuarioDto) {
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

		usuario =  usuarioDao.consultarUsuario(usuario);

		usuario.setAcceso(true);

		if(!login.toUpperCase().equals(usuario.getUsu_login())){

			usuario.setAcceso(false);
			usuario.setMensajeAcceso("El login no existe en el sistema.");

		}else if(!contrasena.equals(usuario.getUsu_contrasena())){
			usuario.setAcceso(false);
			usuario.setMensajeAcceso("La contrase�a es incorrecta.");			
		}

		return usuario;
	}
	
	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}
}
