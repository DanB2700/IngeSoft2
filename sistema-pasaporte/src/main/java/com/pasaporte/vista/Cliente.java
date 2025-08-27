package com.pasaporte.vista;

import com.pasaporte.modelo.*;
import com.pasaporte.repositorio.PasaporteDAO;
import java.util.Arrays;

public class Cliente {
	public static void main(String[] args) {
		Titular titular = new Titular("Oscar", "Julian");
		Pais pais = new Pais("Colombia");
		Ciudad ciudad = new Ciudad("Bogotá");

		Pasaporte pasaporte = new Pasaporte("0001", titular, pais, ciudad);
		pasaporte.setVisas(Arrays.asList(new Visa("Turismo", new Pais("Estados Unidos"))));

		PasaporteDAO dao = new PasaporteDAO();
		dao.insertarCompleto(pasaporte);
	}
}
//BD