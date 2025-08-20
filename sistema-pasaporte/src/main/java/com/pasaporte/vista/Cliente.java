package com.pasaporte.vista;

import com.pasaporte.modelo.Pasaporte;
import com.pasaporte.modelo.Titular;
import com.pasaporte.modelo.Visa;
import com.pasaporte.modelo.Pais;
import com.pasaporte.modelo.Ciudad;

import java.util.Arrays;

public class Cliente {
	public static void main(String[] args) {
		Ciudad bogota = new Ciudad("BOG", "Bogotá");
		Ciudad medellin = new Ciudad("MED", "Medellín");

		Pais colombia = new Pais("+57", "Colombia", Arrays.asList(bogota, medellin));

		Titular titular = new Titular("186454", "Julian", "25-05-2002");

		Pasaporte pasaporte = new Pasaporte("P-123456", titular, colombia, "A987654", bogota);

		Visa visa = new Visa("V-555", colombia, pasaporte, "Turismo");

		System.out.println("=== Datos del Pasaporte ===");
		System.out.println(pasaporte);

		System.out.println("\n=== Datos de la Visa ===");
		System.out.println(visa);
	}
}
