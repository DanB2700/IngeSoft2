package com.pasaporte.repositorio;

import com.pasaporte.modelo.*;
import java.sql.*;
import java.util.*;

public class PasaporteDAO implements Repositorio<Pasaporte> {

    @Override
    public Pasaporte crear(Pasaporte p) {
        final String UPSERT_PAIS = "INSERT INTO pais (nombre) VALUES (?) " +
                "ON CONFLICT (nombre) DO UPDATE SET nombre = EXCLUDED.nombre " +
                "RETURNING id";
        final String UPSERT_CIUDAD = "INSERT INTO ciudad (nombre, pais_id) VALUES (?, ?) " +
                "ON CONFLICT (nombre, pais_id) DO UPDATE SET nombre = EXCLUDED.nombre " +
                "RETURNING id";
        final String INSERT_TITULAR = "INSERT INTO titular (nombre, apellido, ciudad_id) VALUES (?, ?, ?) RETURNING id";
        final String UPSERT_PASAPORTE = "INSERT INTO pasaporte (numero, titular_id, pais_id, ciudad_id) VALUES (?, ?, ?, ?) " +
                "ON CONFLICT (numero) DO UPDATE SET titular_id=EXCLUDED.titular_id, " +
                "pais_id=EXCLUDED.pais_id, ciudad_id=EXCLUDED.ciudad_id";
        final String UPSERT_VISA = "INSERT INTO visa (tipo, pais_id, pasaporte_numero) VALUES (?, ?, ?) " +
                "ON CONFLICT (tipo, pais_id, pasaporte_numero) DO NOTHING";

        try (Connection conn = ConexionBD.getConexion()) {
            conn.setAutoCommit(false);

            // País del pasaporte
            int paisId;
            try (PreparedStatement st = conn.prepareStatement(UPSERT_PAIS)) {
                st.setString(1, p.getPais().getNombre());
                try (ResultSet rs = st.executeQuery()) {
                    rs.next();
                    paisId = rs.getInt(1);
                }
                p.getPais().setId(paisId);
            }

            // Ciudad
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

            // Titular
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

            // Pasaporte
            try (PreparedStatement st = conn.prepareStatement(UPSERT_PASAPORTE)) {
                st.setString(1, p.getNumero());
                st.setInt(2, titularId);
                st.setInt(3, paisId);
                st.setInt(4, ciudadId);
                st.executeUpdate();
            }

            // Visas
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
            System.out.println("✅ Pasaporte creado con éxito!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("❌ Error al crear pasaporte: " + e.getMessage());
        }
        return p;
    }

    @Override
    public Optional<Pasaporte> leer(String numero) {
        String SQL = "SELECT p.numero, t.id, t.nombre, t.apellido, c.id, c.nombre, pa.id, pa.nombre " +
                "FROM pasaporte p " +
                "JOIN titular t ON p.titular_id = t.id " +
                "JOIN ciudad c ON p.ciudad_id = c.id " +
                "JOIN pais pa ON p.pais_id = pa.id " +
                "WHERE p.numero = ?";
        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement st = conn.prepareStatement(SQL)) {
            st.setString(1, numero);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    Titular titular = new Titular(rs.getInt(2), rs.getString(3), rs.getString(4));
                    Ciudad ciudad = new Ciudad(rs.getInt(5), rs.getString(6));
                    Pais pais = new Pais(rs.getInt(7), rs.getString(8));
                    Pasaporte pasaporte = new Pasaporte(rs.getString(1), titular, pais, ciudad);
                    return Optional.of(pasaporte);
                }
            }
        } catch (SQLException e) {
            System.out.println("❌ Error en leer: " + e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public List<Pasaporte> listar() {
        List<Pasaporte> lista = new ArrayList<>();
        String SQL = "SELECT p.numero, t.id, t.nombre, t.apellido, c.id, c.nombre, pa.id, pa.nombre " +
                "FROM pasaporte p " +
                "JOIN titular t ON p.titular_id = t.id " +
                "JOIN ciudad c ON p.ciudad_id = c.id " +
                "JOIN pais pa ON p.pais_id = pa.id";
        try (Connection conn = ConexionBD.getConexion();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(SQL)) {
            while (rs.next()) {
                Titular titular = new Titular(rs.getInt(2), rs.getString(3), rs.getString(4));
                Ciudad ciudad = new Ciudad(rs.getInt(5), rs.getString(6));
                Pais pais = new Pais(rs.getInt(7), rs.getString(8));
                Pasaporte pasaporte = new Pasaporte(rs.getString(1), titular, pais, ciudad);
                lista.add(pasaporte);
            }
        } catch (SQLException e) {
            System.out.println("❌ Error en listar: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public Pasaporte actualizar(String numero, Pasaporte p) {
        String SQL = "UPDATE titular SET nombre=?, apellido=? WHERE id=?";
        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement st = conn.prepareStatement(SQL)) {
            st.setString(1, p.getTitular().getNombre());
            st.setString(2, p.getTitular().getApellido());
            st.setInt(3, p.getTitular().getId());
            st.executeUpdate();
            System.out.println("✅ Pasaporte actualizado correctamente");
        } catch (SQLException e) {
            System.out.println("❌ Error en actualizar: " + e.getMessage());
        }
        return p;
    }

    @Override
    public Optional<Pasaporte> eliminar(String numero) {
        Optional<Pasaporte> pasaporte = leer(numero);
        String SQL = "DELETE FROM pasaporte WHERE numero=?";
        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement st = conn.prepareStatement(SQL)) {
            st.setString(1, numero);
            st.executeUpdate();
            System.out.println("✅ Pasaporte eliminado correctamente");
        } catch (SQLException e) {
            System.out.println("❌ Error en eliminar: " + e.getMessage());
        }
        return pasaporte;
    }
}