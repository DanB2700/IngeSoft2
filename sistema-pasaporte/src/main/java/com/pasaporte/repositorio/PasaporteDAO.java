package com.pasaporte.repositorio;

import com.pasaporte.repositorio.ConexionBD;
import com.pasaporte.modelo.Pasaporte;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PasaporteDAO implements Repositorio<Pasaporte> {

    private Connection conexion;

    public PasaporteDAO() {
        this.conexion = ConexionBD.getInstancia().getConexion();
    }

    @Override
    public void crear(Pasaporte p) {
        String sql = "INSERT INTO pasaporte (numero) VALUES (?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, p.getNumero());
            stmt.executeUpdate();
            System.out.println("✅ Pasaporte creado");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Pasaporte> listar() {
        List<Pasaporte> lista = new ArrayList<>();
        String sql = "SELECT * FROM pasaporte";
        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Pasaporte p = new Pasaporte(
                        rs.getString("numero"),
                        null, null, null
                );
                lista.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public void actualizar(Pasaporte p) {
        String sql = "UPDATE pasaporte SET numero=? WHERE numero=?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, p.getNumero());
            stmt.setString(2, p.getNumero());
            stmt.executeUpdate();
            System.out.println("✅ Pasaporte actualizado");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(String numero) {
        String sql = "DELETE FROM pasaporte WHERE numero=?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, numero);
            stmt.executeUpdate();
            System.out.println("✅ Pasaporte eliminado");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Pasaporte> buscar(String criterio) {
        List<Pasaporte> lista = new ArrayList<>();
        String sql = "SELECT * FROM pasaporte WHERE numero LIKE ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, "%" + criterio + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Pasaporte p = new Pasaporte(
                        rs.getString("numero"),
                        null, null, null
                );
                lista.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
