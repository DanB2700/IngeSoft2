package com.pasaporte.modelo;

public class Titular {
    private String id;
    private String nombre;
    private String fecha;

    public Titular(String id, String nombre, String fecha) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getFecha() { return fecha; }

    @Override
    public String toString() {
        return nombre + " (ID: " + id + ", Fecha: " + fecha + ")";
    }
}
