package com.pasaporte.repositorio;

import com.pasaporte.modelo.Pasaporte;
import com.pasaporte.util.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PasaporteRepositorioSQL implements Repositorio<Pasaporte> {

    @Override
    public String insertar(Pasaporte pasaporte) {
        String sql = "INSERT INTO pasaportes (id, numero_pasaporte, titular, pais, ciudad) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, pasaporte.getId());
            stmt.setString(2, pasaporte.getNumeroPasaporte());
            stmt.setString(3, pasaporte.getTitular());
            stmt.setString(4, pasaporte.getPais());
            stmt.setString(5, pasaporte.getCiudad());
            stmt.executeUpdate();
            return "✅ Pasaporte guardado";
        } catch (SQLException e) {
            return "❌ Error al guardar pasaporte: " + e.getMessage();
        }
    }

    @Override
    public Pasaporte buscar(String id) {
        String sql = "SELECT * FROM pasaportes WHERE id = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Pasaporte(
                        rs.getString("id"),
                        rs.getString("numero_pasaporte"),
                        rs.getString("titular"),
                        rs.getString("pais"),
                        rs.getString("ciudad")
                );
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al buscar pasaporte: " + e.getMessage());
        }
        return null;
    }

    @Override
    public String actualizar(Pasaporte pasaporte) {
        String sql = "UPDATE pasaportes SET numero_pasaporte = ?, titular = ?, pais = ?, ciudad = ? WHERE id = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, pasaporte.getNumeroPasaporte());
            stmt.setString(2, pasaporte.getTitular());
            stmt.setString(3, pasaporte.getPais());
            stmt.setString(4, pasaporte.getCiudad());
            stmt.setString(5, pasaporte.getId());
            int rows = stmt.executeUpdate();
            return rows > 0 ? "✅ Pasaporte actualizado" : "⚠️ Pasaporte no encontrado";
        } catch (SQLException e) {
            return "❌ Error al actualizar pasaporte: " + e.getMessage();
        }
    }

    @Override
    public String eliminar(String id) {
        String sql = "DELETE FROM pasaportes WHERE id = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            int rows = stmt.executeUpdate();
            return rows > 0 ? "✅ Pasaporte eliminado" : "⚠️ Pasaporte no encontrado";
        } catch (SQLException e) {
            return "❌ Error al eliminar pasaporte: " + e.getMessage();
        }
    }

    @Override
    public List<Pasaporte> listar() {
        List<Pasaporte> pasaportes = new ArrayList<>();
        String sql = "SELECT * FROM pasaportes";
        try (Connection conn = ConexionBD.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                pasaportes.add(new Pasaporte(
                        rs.getString("id"),
                        rs.getString("numero_pasaporte"),
                        rs.getString("titular"),
                        rs.getString("pais"),
                        rs.getString("ciudad")
                ));
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al listar pasaportes: " + e.getMessage());
        }
        return pasaportes;
    }
}
