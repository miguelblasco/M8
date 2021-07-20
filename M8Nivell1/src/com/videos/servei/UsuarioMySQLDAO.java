package com.videos.servei;

import java.time.LocalDate;

import com.videos.domain.Usuario;


public class UsuarioMySQLDAO implements IUsuarioDAO {
	
	@Override
	public Usuario UsuarioAdd(String nombre, String apellido, String password, LocalDate fechaRegistro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void VideoAdd(Usuario usuario, String titulo, String url, String tags) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void VideoDelete(Usuario usuario, String titulo) {
		// TODO Auto-generated method stub
		
	}

}
