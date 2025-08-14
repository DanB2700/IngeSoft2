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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Titular getTitular() {
        return titular;
    }

    public void setTitular(Titular titular) {
        this.titular = titular;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Pasaporte{" +
                "id='" + id + '\'' +
                ", titular=" + titular +
                ", pais=" + pais +
                '}';
    }
}
