package com.pasaporte.vista;

import com.pasaporte.modelo.*;
import com.pasaporte.repositorio.PasaporteDAO;
import java.util.*;

public class Cliente {
    public static void main(String[] args) {
        PasaporteDAO dao = new PasaporteDAO();

        // Crear pasaporte
        Titular titular = new Titular("Oscar", "Julian");
        Pais pais = new Pais("Colombia");
        Ciudad ciudad = new Ciudad("Bogotá");
        Pasaporte pasaporte = new Pasaporte("0001", titular, pais, ciudad);
        pasaporte.setVisas(Arrays.asList(new Visa("Turismo", new Pais("Estados Unidos"))));
        dao.crear(pasaporte);

        // Listar
        System.out.println("\n📋 Listado de pasaportes:");
        dao.listar().forEach(System.out::println);

        // Actualizar
        pasaporte.getTitular().setNombre("Oscar Modificado");
        dao.actualizar(pasaporte.getNumero(), pasaporte);

        // Mostrar de nuevo
        System.out.println("\n📋 Listado después de actualizar:");
        dao.listar().forEach(System.out::println);

        // Eliminar con confirmación
        Scanner sc = new Scanner(System.in);
        System.out.println("\n❓ ¿Desea eliminar el pasaporte con número " + pasaporte.getNumero() + "? (s/n)");
        String resp = sc.nextLine();
        if (resp.equalsIgnoreCase("s")) {
            dao.eliminar(pasaporte.getNumero());
        } else {
            System.out.println("⏩ No se eliminó el pasaporte");
        }

        // Mostrar final
        System.out.println("\n📋 Listado final:");
        dao.listar().forEach(System.out::println);
    }
}