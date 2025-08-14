package com.pasaporte.modelo;

public class Pasaporte {
    private String id;
    private String titular;
    private Pais pais;
    private String NumeroPasaporte;
    private Ciudad ciudad;

    public Pasaporte(String id, String titular, Pais pais, String NumeroPasaporte) {
        this.id = id;
        this.titular = titular;
        this.pais = pais;
        this.NumeroPasaporte= NumeroPasaporte;
        this.ciudad = ciudad;
    }

    public Pasaporte(Pais pais2, Ciudad ciudad2, Titular titular2) {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
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

	public String getNumeroPasaporte() {
		// TODO Auto-generated method stub
		return NumeroPasaporte;
	}
	
	public Ciudad getCiudad() {
		return ciudad;
	}
}
