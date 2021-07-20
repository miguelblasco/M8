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

				// Men� de la plicaci�n
				boolean salir = false;
				while (salir == false) {
					String opcion = pedirDato("Men�",
							"Opciones: \n 1. A�adir v�deo \n 2. Eliminar v�deo \n 3. Listar \n 4. Salir \n");
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
			System.out.println("Final de la aplicaci�n");

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
				// Pedimos los datos del v�deo
				String titulo = pedirDato("Alta V�deo", "Introduzca el t�tulo del v�deo");
				String url = pedirDato("Alta V�deo", "Introduzca la URL del v�deo");
				String tags = pedirDato("Alta V�deo", "Tags del v�deo (separadas por comas):");

				usuarioController.VideoAdd(usuario, titulo, url, tags);
				System.out.println(usuario.toString());
				System.out.println("V�deo creado correctamente");
			} catch (Exception ex) {
				System.err.println(ex.getMessage());
			}
		}

		private void pedirVideoDelete(Usuario usuario) {
			try {
				// Pedimos los datos del v�deo
				String titulo = pedirDato("Baja V�deo", "Introduzca el t�tulo del v�deo");

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


