package com.pasaporte.vista;

import com.pasaporte.modelo.*;
import com.pasaporte.repositorio.*;

import java.util.*;

public class Cliente {
    public static void main(String[] args) {
        // Crear repositorio para Pasaporte
        Repositorio<Pasaporte> pasaporteRepo = new PasaporteRepositorioSQL();

        // Crear objetos Ciudad, País y Titular
        Ciudad ciudad1 = new Ciudad("01", "Bogotá");
        List<Ciudad> ciudades = new ArrayList<>();
        ciudades.add(ciudad1);

        Pais colombia = new Pais("CO", "Colombia", ciudades);
        Titular titular = new Titular("T1", "Daniel", "2025-08-23");

        // Crear pasaporte
        Pasaporte pasaporte = new Pasaporte("P1", titular, colombia);
        pasaporteRepo.agregar(pasaporte);
        System.out.println("🆕 Pasaporte creado: " + pasaporte);

        // Mostrar lista actual
        System.out.println("📋 Lista actual: " + pasaporteRepo.listar());

        // Actualizar titular del pasaporte
        Titular titularActualizado = new Titular("T1", "Daniel Manrique", "2025-08-23");
        pasaporte.setTitular(titularActualizado);
        pasaporteRepo.actualizar(pasaporte);
        System.out.println("✏️ Pasaporte actualizado: " + pasaporte);

        // Mostrar lista después de actualizar
        System.out.println("📋 Lista después de actualizar: " + pasaporteRepo.listar());

        // Eliminar pasaporte
        pasaporteRepo.eliminar("P1");
        System.out.println("🗑️ Pasaporte eliminado con id: P1");

        // Mostrar lista final
        System.out.println("📋 Lista final: " + pasaporteRepo.listar());
    }
}
