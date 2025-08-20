package com.pasaporte.modelo;

public class Visa {
	private String numero;
	private Pais pais;
	private Pasaporte pasaporte;
	private String tipo;

	public Visa(String numero, Pais pais, Pasaporte pasaporte, String tipo) {
		this.numero = numero;
		this.pais = pais;
		this.pasaporte = pasaporte;
		this.tipo = tipo;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
        return "Visa{" +
                "numero='" + numero + '\'' +
                ", pais=" + pais +
                ", pasaporte=" + pasaporte.getNumeroPasaporte() +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
