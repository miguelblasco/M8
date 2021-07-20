package com.videos.servei;

import java.time.LocalDate;

import com.videos.domain.Usuario;

public interface IUsuarioDAO {
	
	Usuario UsuarioAdd(String nombre, String apellido, String password, LocalDate fechaRegistro);

	void VideoAdd(Usuario usuario, String titulo, String url, String tags);

	void VideoDelete(Usuario usuario, String titulo);

}
