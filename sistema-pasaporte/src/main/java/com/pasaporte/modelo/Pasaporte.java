package com.pasaporte.modelo;

public class Pasaporte {
	 private String id;
	    private String numeroPasaporte;  // ahora se llama igual que la BD
	    private String titular;
	    private String pais;
	    private String ciudad;

	    public Pasaporte(String id, String numeroPasaporte, String titular, String pais, String ciudad) {
	        this.id = id;
	        this.numeroPasaporte = numeroPasaporte;
	        this.titular = titular;
	        this.pais = pais;
	        this.ciudad = ciudad;
	    }

	    public String getId() {
	        return id;
	    }

	    public String getNumeroPasaporte() {
	        return numeroPasaporte;
	    }

	    public String getTitular() {
	        return titular;
	    }

	    public String getPais() {
	        return pais;
	    }

	    public String getCiudad() {
	        return ciudad;
	    }

	    @Override
	    public String toString() {
	        return "Pasaporte{" +
	                "id='" + id + '\'' +
	                ", numeroPasaporte='" + numeroPasaporte + '\'' +
	                ", titular='" + titular + '\'' +
	                ", pais='" + pais + '\'' +
	                ", ciudad='" + ciudad + '\'' +
	                '}';
	    }
	}