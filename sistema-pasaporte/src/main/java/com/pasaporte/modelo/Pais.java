package com.pasaporte.modelo;

import java.util.List;

public class Pais {
    private String codigo;
    private String nombre;
    private String ciudades;

    public Pais(String codigo, String nombre, String ciudades) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.ciudades = ciudades;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudades() {
        return ciudades;
    }

    public void setCiudades(String ciudades) {
        this.ciudades = ciudades;
    }

    @Override
    public String toString() {
        return "Pais{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", ciudades=" + ciudades +
                '}';
    }
}
