package com.videos.view;

import java.time.LocalDate;
import javax.swing.JOptionPane;

import com.videos.controller.UsuarioController;
import com.videos.domain.Usuario;


	public class MenuOpciones {
		
		public MenuOpciones() {
			usuarioController = new UsuarioController();
		}

		private UsuarioController usuarioController = null;

		public void inicio() {

			// Pedimos los datos del usuario con el que trabajamos
			Usuario usuario = pedirUsuario();

			if (usuario != null) {
				System.out.println(usuario.toString());

				// Menú de la plicación
				boolean salir = false;
				while (salir == false) {
					String opcion = pedirDato("Menú",
							"Opciones: \n 1. Añadir vídeo \n 2. Eliminar vídeo \n 3. Listar \n 4. Salir \n");
					if (opcion != null) {
						if (opcion.equals("1")) {
							pedirVideoAdd(usuario);

						} else if (opcion.equals("2")) {
							pedirVideoDelete(usuario);

						} else if (opcion.equals("3")) {
							System.out.println(usuario);

						} else if (opcion.equals("4")) {
							salir = true;
						}
					}
				}

			}
			System.out.println("Final de la aplicación");

		}

		private Usuario pedirUsuario() {

			Usuario usuario = null;
			try {
				// Pedimos los datos del usuario
				String nombre = pedirDato("Alta Usuario", "Introduzca el nombre del usuario");
				String apellido = pedirDato("Alta Usuario", "Introduzca el apellido del usuario");
				String password = pedirDato("Alta Usuario", "Introduzca el password del usuario");

				usuario = usuarioController.UsuarioAdd(nombre, apellido, password, LocalDate.now());
			} catch (Exception ex) {
				System.err.println(ex.getMessage());
			}
			return usuario;

		}

		private void pedirVideoAdd(Usuario usuario) {
			try {
				// Pedimos los datos del vídeo
				String titulo = pedirDato("Alta Vídeo", "Introduzca el título del vídeo");
				String url = pedirDato("Alta Vídeo", "Introduzca la URL del vídeo");
				String tags = pedirDato("Alta Vídeo", "Tags del vídeo (separadas por comas):");

				usuarioController.VideoAdd(usuario, titulo, url, tags);
				System.out.println(usuario.toString());
				System.out.println("Vídeo creado correctamente");
			} catch (Exception ex) {
				System.err.println(ex.getMessage());
			}
		}

		private void pedirVideoDelete(Usuario usuario) {
			try {
				// Pedimos los datos del vídeo
				String titulo = pedirDato("Baja Vídeo", "Introduzca el título del vídeo");

				usuarioController.VideoDelete(usuario, titulo);
				System.out.println(usuario.toString());
				
				

			} catch (Exception ex) {
				System.err.println(ex.getMessage());
			}

		}

		private String pedirDato(String titulo, String textoSobreElDatoApedir) {
			String dato = JOptionPane.showInputDialog(null, textoSobreElDatoApedir, titulo, JOptionPane.QUESTION_MESSAGE);
			return dato;
		}
	}


