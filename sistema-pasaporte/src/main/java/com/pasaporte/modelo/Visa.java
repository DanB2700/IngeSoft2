package com.pasaporte.modelo;

public class Visa {
    private String numero;
    private Pais pais;
    private Pasaporte pasaporte;

    public Visa(String numero, Pais pais, Pasaporte pasaporte) {
        this.numero = numero;
        this.pais = pais;
        this.pasaporte = pasaporte;
    }

    public String getNumero() { return numero; }
    public Pais getPais() { return pais; }
    public Pasaporte getPasaporte() { return pasaporte; }

    @Override
    public String toString() {
        return "Visa " + numero + " | País: " + pais + " | Pasaporte: " + pasaporte.getId();
    }
}
