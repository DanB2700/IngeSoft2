package com.pasaporte.modelo;

public class Pasaporte {
    private String id;
    private Titular titular;
    private Pais pais;

    public Pasaporte(String id, Titular titular, Pais pais) {
        this.id = id;
        this.titular = titular;
        this.pais = pais;
    }

    public String getId() { return id; }
    public Titular getTitular() { return titular; }
    public Pais getPais() { return pais; }

    public void setTitular(Titular titular) { this.titular = titular; }
    public void setPais(Pais pais) { this.pais = pais; }

    @Override
    public String toString() {
        return "Pasaporte " + id + " | Titular: " + titular + " | País: " + pais;
    }
}
