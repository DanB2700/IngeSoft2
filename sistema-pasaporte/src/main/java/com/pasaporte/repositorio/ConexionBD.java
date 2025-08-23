package com.pasaporte.repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static final String URL = "jdbc:postgresql://aws-1-us-east-1.pooler.supabase.com:5432/postgres";
    private static final String USER = "postgres.cwqngcvrtautiavvslck";
    private static final String PASSWORD = "Politecnico123*"; // 👈 tu clave

    public static Connection getConnection() throws SQLException {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("❌ Error al conectar a Supabase: " + e.getMessage());
            throw e;
        }
    }
}
