package com.videos.domain;

import java.util.ArrayList;

public class Video {
	
	private String url;
	private String titulo;
	private ArrayList<String> listaTags;
	

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public ArrayList<String> getTags() {
		return listaTags;
	}

	public void setTags(ArrayList<String> listaTags) {
		this.listaTags = listaTags;
	}

	@Override
	public String toString() {
		return "Video [url = " + url + ", titulo = " + titulo
				+ ", listaTags = " + listaTags + "]";
	}



}
