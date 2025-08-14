package com.pasaporte.modelo;

public class Visa {
    private String numero;
    private Pais pais;
    private Pasaporte pasaporte;
    private String attribute2;

    public Visa(String numero, Pais pais, Pasaporte pasaporte, String attribute2) {
        this.numero = numero;
        this.pais = pais;
        this.pasaporte = pasaporte;
        this.attribute2 = attribute2;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Pasaporte getPasaporte() {
        return pasaporte;
    }

    public void setPasaporte(Pasaporte pasaporte) {
        this.pasaporte = pasaporte;
    }

    public String getAttribute2() {
        return attribute2;
    }

    public void setAttribute2(String attribute2) {
        this.attribute2 = attribute2;
    }

    @Override
    public String toString() {
        return "Visa{" +
                "numero='" + numero + '\'' +
                ", pais=" + pais +
                ", pasaporte=" + pasaporte +
                ", attribute2='" + attribute2 + '\'' +
                '}';
    }
}
