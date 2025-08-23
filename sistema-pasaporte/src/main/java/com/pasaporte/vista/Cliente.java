package com.pasaporte.vista;

import com.pasaporte.modelo.Pasaporte;
import com.pasaporte.repositorio.Repositorio;
import com.pasaporte.repositorio.PasaporteRepositorioSQL;

public class Cliente {
    public static void main(String[] args) {
        // Crear un pasaporte de prueba
        Pasaporte pasaporte = new Pasaporte("P-123456", "A987654", "Julian", "Colombia", "Bogotá");

        // Repositorio (implementación solo para Pasaporte)
        Repositorio<Pasaporte> repo = new PasaporteRepositorioSQL();

        // Insertar
        System.out.println(repo.insertar(pasaporte));

        // Buscar
        Pasaporte buscado = repo.buscar("P-123456");
        System.out.println("🔎 Buscado: " + (buscado != null ? buscado : "No encontrado"));

        // Actualizar
        Pasaporte actualizado = new Pasaporte("P-123456", "A987654", "Julian", "Colombia", "Medellín");
        System.out.println(repo.actualizar(actualizado));

        // Listar
        System.out.println("\n=== Lista de Pasaportes ===");
        for (Pasaporte p : repo.listar()) {
            System.out.println(p);
        }

        // Eliminar
        System.out.println(repo.eliminar("P-123456"));
    }
}
