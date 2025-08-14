package com.pasaporte.vista;

import com.pasaporte.modelo.Pasaporte;
import com.pasaporte.modelo.Titular;
import com.pasaporte.modelo.Pais;
import com.pasaporte.modelo.Ciudad;

public class Cliente {
	public static void main(String[] args) {
		// Crear un objeto 
		Pais pais = new Pais("+57", "Colombia", "Bogota");
		Ciudad ciudad = new Ciudad("Bog", "Bogota");
		Titular titular = new Titular("186454", "Julian", "25-45-2016");
		Pasaporte mipasaporte = new Pasaporte (pais, ciudad, titular);

		// Imprimir la información del pasaporte
		System.out.println("=== Datos del Pasaporte ===");
		System.out.println("Id: " + mipasaporte.getId());
		System.out.println("Numero Pasaporte: " + mipasaporte.getNumeroPasaporte());
		System.out.println("Titular: " + mipasaporte.getTitular());
		System.out.println("Pais:" + mipasaporte.getPais());
		System.out.println("Ciudad:" + mipasaporte.getCiudad());
	}
}