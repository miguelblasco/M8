package com.videos.servei;

import java.time.LocalDate;
import java.util.ArrayList;

import com.videos.domain.Usuario;
import com.videos.domain.Video;

public class UsuarioMemoriaDAO implements IUsuarioDAO {
	
	// Singleton
	public static UsuarioMemoriaDAO getInstance() {
		if (instance == null) {
			instance = new UsuarioMemoriaDAO();

		}
		return instance;
	}

	private UsuarioMemoriaDAO() {
		listaUsuarios = new ArrayList<Usuario>();
	}

	private static UsuarioMemoriaDAO instance = null;
	// Final Singleton
	
	
	

	private ArrayList<Usuario> listaUsuarios;

	@Override
	public Usuario UsuarioAdd(String nombre, String apellido, String password, LocalDate fechaRegistro) {
		Usuario usuario = new Usuario();
		usuario.setNombre(nombre);
		usuario.setApellido(apellido);
		usuario.setPassword(password);
		usuario.setFechaRegistro(fechaRegistro);

		validaDatosUsuario(usuario);
		
		
		//periodista = new Periodista(nom, cognoms, password, dataRegistre);
		

		listaUsuarios.add(usuario);

		return usuario;

	}

	@Override
	public void VideoAdd(Usuario usuario, String titulo, String url, String tags) {

		Video video = preparaVideo(titulo, url, tags);
		validaDatosVideo(video);
		usuario.addVideo(video);
	}

	

	@Override
	public void VideoDelete(Usuario usuario, String titulo) {
		usuario.deleteVideo(titulo);

	}

	private void validaDatosUsuario(Usuario usuario) {
		if (usuario == null) {
			throw new RuntimeException("El usuario no se ha creado");
		} else {
			if (this.vacio(usuario.getNombre())) {
				throw new RuntimeException("No se ha rellenado el nombre del usuario");
			} else if (this.vacio(usuario.getApellido())) {
				throw new RuntimeException("No se ha rellenado el apellido del usuario");
			} else if (this.vacio(usuario.getPassword())) {
				throw new RuntimeException("Falta añadir password");
			} else if (usuario.getFechaRegistro() == null) {
				throw new RuntimeException("La fecha del registro está vacía");
			}
		}
	}

	private Video preparaVideo(String titulo, String url, String tags) {
		Video video = new Video();
		video.setTitulo(titulo);
		video.setUrl(url);
		if (!this.vacio(tags)) {
			String[] tagsArray = tags.split(",");
			if (tagsArray != null && tagsArray.length > 0) {
				ArrayList<String> tagsList = new ArrayList<String>();
				for (String s : tagsArray) {
					tagsList.add(s);
				}
				video.setTags(tagsList);
			}

		}

		return video;
	}
	
	private void validaDatosVideo(Video video) {
		if (video == null) {
			throw new RuntimeException("El vídeo no se ha creado");
		} else {
			if (this.vacio(video.getTitulo())) {
				throw new RuntimeException("El título está vacío");
			} else if (this.vacio(video.getUrl())) {
				throw new RuntimeException("La Url del vídeo está vacía");
			} else {
				ArrayList<String> tagsList = video.getTags();

				if (tagsList == null || tagsList.size() == 0) {
					throw new RuntimeException("No se han agregado tags para el vídeo");
				}

			}
		}
	}

	private boolean vacio(String valor) {
		boolean resultado = false;
		if (valor == null || valor.isBlank() || valor.isEmpty()) {
			resultado = true;
		}
		return resultado;

	}

}
