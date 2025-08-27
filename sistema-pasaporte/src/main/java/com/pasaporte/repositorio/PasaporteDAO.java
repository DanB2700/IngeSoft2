package com.pasaporte.repositorio;

import com.pasaporte.modelo.*;
import java.sql.*;

public class PasaporteDAO {

	public void insertarCompleto(Pasaporte p) {
		final String UPSERT_PAIS = "INSERT INTO pais (nombre) VALUES (?) "
				+ "ON CONFLICT (nombre) DO UPDATE SET nombre = EXCLUDED.nombre " + "RETURNING id";

		final String UPSERT_CIUDAD = "INSERT INTO ciudad (nombre, pais_id) VALUES (?, ?) "
				+ "ON CONFLICT (nombre, pais_id) DO UPDATE SET nombre = EXCLUDED.nombre " + "RETURNING id";

		final String INSERT_TITULAR = "INSERT INTO titular (nombre, apellido, ciudad_id) VALUES (?, ?, ?) RETURNING id";

		final String UPSERT_PASAPORTE = "INSERT INTO pasaporte (numero, titular_id, pais_id, ciudad_id) VALUES (?, ?, ?, ?) "
				+ "ON CONFLICT (numero) DO UPDATE SET titular_id=EXCLUDED.titular_id, "
				+ "    pais_id=EXCLUDED.pais_id, ciudad_id=EXCLUDED.ciudad_id";

		final String UPSERT_VISA = "INSERT INTO visa (tipo, pais_id, pasaporte_numero) VALUES (?, ?, ?) "
				+ "ON CONFLICT (tipo, pais_id, pasaporte_numero) DO NOTHING";

		try (Connection conn = ConexionBD.getConexion()) {
			conn.setAutoCommit(false);

			// 1) País del pasaporte
			int paisId;
			try (PreparedStatement st = conn.prepareStatement(UPSERT_PAIS)) {
				st.setString(1, p.getPais().getNombre());
				try (ResultSet rs = st.executeQuery()) {
					rs.next();
					paisId = rs.getInt(1);
				}
				p.getPais().setId(paisId);
			}

			// 2) Ciudad (ligada al país)
			int ciudadId;
			try (PreparedStatement st = conn.prepareStatement(UPSERT_CIUDAD)) {
				st.setString(1, p.getCiudad().getNombre());
				st.setInt(2, paisId);
				try (ResultSet rs = st.executeQuery()) {
					rs.next();
					ciudadId = rs.getInt(1);
				}
				p.getCiudad().setId(ciudadId);
			}

			// 3) Titular (requiere ciudad_id -> ¡aquí estaba tu error!)
			int titularId;
			try (PreparedStatement st = conn.prepareStatement(INSERT_TITULAR)) {
				st.setString(1, p.getTitular().getNombre());
				st.setString(2, p.getTitular().getApellido());
				st.setInt(3, ciudadId);
				try (ResultSet rs = st.executeQuery()) {
					rs.next();
					titularId = rs.getInt(1);
				}
				p.getTitular().setId(titularId);
			}

			// 4) Pasaporte
			try (PreparedStatement st = conn.prepareStatement(UPSERT_PASAPORTE)) {
				st.setString(1, p.getNumero());
				st.setInt(2, titularId);
				st.setInt(3, paisId);
				st.setInt(4, ciudadId);
				st.executeUpdate();
			}

			// 5) Visas (si vienen)
			if (p.getVisas() != null) {
				for (Visa v : p.getVisas()) {
					Pais destino = (v.getPais() != null) ? v.getPais() : p.getPais();
					int destinoId;
					try (PreparedStatement st = conn.prepareStatement(UPSERT_PAIS)) {
						st.setString(1, destino.getNombre());
						try (ResultSet rs = st.executeQuery()) {
							rs.next();
							destinoId = rs.getInt(1);
						}
					}
					try (PreparedStatement st = conn.prepareStatement(UPSERT_VISA)) {
						st.setString(1, v.getTipo());
						st.setInt(2, destinoId);
						st.setString(3, p.getNumero());
						st.executeUpdate();
					}
				}
			}

			conn.commit();
			System.out.println("✅ Insertado todo correctamente");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("❌ Error al insertar pasaporte: " + e.getMessage());
		}
	}
}
