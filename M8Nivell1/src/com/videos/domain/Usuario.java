package com.videos.domain;

import java.time.LocalDate;
import java.util.ArrayList;



public class Usuario {
	
	public Usuario() {
	
		this.listaVideos = new ArrayList<Video>();
	}
	
	private String nombre;
	private String apellido;
	private String password;
	private LocalDate fechaRegistro;
	private ArrayList<Video> listaVideos;
	
	
public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getApellido() {
	return apellido;
}

public void setApellido(String apellido) {
	this.apellido = apellido;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public LocalDate getFechaRegistro() {
	return fechaRegistro;
}

public void setFechaRegistro(LocalDate fechaRegistro) {
	this.fechaRegistro = fechaRegistro;
}

public void addVideo(Video video) {
	listaVideos.add(video);
}

public void deleteVideo(String tituloVideo) {

	if (listaVideos != null && listaVideos.size() > 0) {
		int pos = 0;
		for (Video p : listaVideos) {
			if (p.getTitulo().equals(tituloVideo)) {
				listaVideos.remove(pos);
				break;
			}
			pos++;
		}
	}
}



@Override
public String toString() {
	return "Usuario [nombre = " + nombre + ", apellido = " + apellido
			+ ", password = " + password + ", fecha = " + fechaRegistro
			+ ", listaVideos" + listaVideos + "]";
}



}
