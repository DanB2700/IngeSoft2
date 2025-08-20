package com.pasaporte.modelo;

public class Pasaporte {
	private String id;
	private Titular titular;
	private Pais pais;
	private String numeroPasaporte;
	private Ciudad ciudad;

	public Pasaporte(String id, Titular titular, Pais pais, String numeroPasaporte, Ciudad ciudad) {
		this.id = id;
		this.titular = titular;
		this.pais = pais;
		this.numeroPasaporte = numeroPasaporte;
		this.ciudad = ciudad;
	}

	public String getId() {
		return id;
	}

	public Titular getTitular() {
		return titular;
	}

	public Pais getPais() {
		return pais;
	}

	public String getNumeroPasaporte() {
		return numeroPasaporte;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	@Override
	public String toString() {
        return "Pasaporte{" +
                "id='" + id + '\'' +
                ", titular=" + titular +
                ", pais=" + pais +
                ", numeroPasaporte='" + numeroPasaporte + '\'' +
                ", ciudad=" + ciudad +
                '}';
    }
}
