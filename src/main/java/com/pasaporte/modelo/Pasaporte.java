package com.pasaporte.modelo;

import java.util.ArrayList;
import java.util.List;

public class Pasaporte {
	private String numero;
	private Titular titular;
	private Pais pais;
	private Ciudad ciudad;
	private List<Visa> visas = new ArrayList<>();

	public Pasaporte() {
	}

	public Pasaporte(String numero, Titular titular, Pais pais, Ciudad ciudad) {
		this.numero = numero;
		this.titular = titular;
		this.pais = pais;
		this.ciudad = ciudad;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
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

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public List<Visa> getVisas() {
		return visas;
	}

	public void setVisas(List<Visa> visas) {
		this.visas = visas;
	}

	@Override
	public String toString() {
		return "Pasaporte{numero='" + numero + "', titular=" + titular + ", pais=" + pais + ", ciudad=" + ciudad
				+ ", visas=" + visas + "}";
	}
}

//Pasaporte
