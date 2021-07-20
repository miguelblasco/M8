package com.videos.controller;

import java.time.LocalDate;

import com.videos.domain.Usuario;
import com.videos.servei.IUsuarioDAO;
import com.videos.servei.UsuarioFactoryDAO;



	public class UsuarioController {
		
		public Usuario UsuarioAdd(String nombre, String apellido, String password, LocalDate fechaRegistro) {
			
			IUsuarioDAO iUsuarioDAO = this.getDAO(); 

			return iUsuarioDAO.UsuarioAdd(nombre, apellido, password, fechaRegistro);
		}

		public void VideoAdd(Usuario usuario, String titulo, String url, String tags) {
			
			IUsuarioDAO iUsuarioDAO = this.getDAO(); 
			iUsuarioDAO.VideoAdd(usuario, titulo, url, tags);
		}

		public void VideoDelete(Usuario usuario, String tituloVideo) {
			IUsuarioDAO iUsuarioDAO = this.getDAO(); 
			
			iUsuarioDAO.VideoDelete(usuario, tituloVideo);

		}

		private IUsuarioDAO getDAO() {
			if (usuarioFactoryDAO == null) {
				usuarioFactoryDAO = new UsuarioFactoryDAO();
			}

			return usuarioFactoryDAO.getDefaultPersistence();
			//return periodistaFactoryDAO.getDAO(Tipus.MEMORIA);
		}

		private UsuarioFactoryDAO usuarioFactoryDAO = null;
	}
