package com.pasaporte.repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
	// Patrón Singleton
	private static ConexionBD instancia;
	private Connection conexion;

	private static final String URL = "jdbc:postgresql://aws-1-us-east-2.pooler.supabase.com:5432/postgres"; // cambia
																												// con
																												// tu BD
	private static final String USUARIO = "postgres.qtwbancwlbohtgbnhskr"; // cambia usuario
	private static final String CLAVE = "Politecnico123*"; // cambia contraseña

	private ConexionBD() {
		try {
			conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
			System.out.println("✅ Conexión exitosa a la base de datos");
		} catch (SQLException e) {
			System.out.println("❌ Error en la conexión: " + e.getMessage());
		}
	}

	// Método para obtener la instancia única
	public static ConexionBD getInstancia() {
		if (instancia == null) {
			instancia = new ConexionBD();
		}
		return instancia;
	}

	public Connection getConexion() {
		return conexion;
	}
}
