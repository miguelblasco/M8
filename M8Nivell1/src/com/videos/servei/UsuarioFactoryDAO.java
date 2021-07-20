package com.videos.servei;

public class UsuarioFactoryDAO {
	
	public enum Tipos {
		MEMORIA, XML, JSON, CSV, MYSQL, MARIADB, ORACLE, SQL_SERVER, MONGODB
	}

	public IUsuarioDAO getDefaultPersistence()
	{
		return this.getDAO(Tipos.MEMORIA);
	}
	
	
	public IUsuarioDAO getDAO(Tipos tipos) {
		IUsuarioDAO dao = null;

		if (tipos == Tipos.MEMORIA) {
			dao = UsuarioMemoriaDAO.getInstance();
		} else {
			throw new RuntimeException("ERROR: Éste tipo de DAO no está implementado.");
		}

		return dao;
	}

}
