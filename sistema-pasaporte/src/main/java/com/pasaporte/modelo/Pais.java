package com.pasaporte.modelo;

import java.util.List;

public class Pais {
    private String codigo;
    private String nombre;
    private List<Ciudad> ciudad;

    public Pais(String codigo, String nombre, List<Ciudad> ciudad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.ciudad = ciudad;
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public List<Ciudad> getCiudad() { return ciudad; }

    @Override
    public String toString() {
        return nombre + " [" + codigo + "]" +
               (ciudad != null && !ciudad.isEmpty() ? ", Ciudades: " + ciudad : "");
    }
}
