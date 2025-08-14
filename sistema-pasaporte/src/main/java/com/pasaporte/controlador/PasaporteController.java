package com.pasaporte.controlador;

import com.pasaporte.modelo.Pasaporte;
import com.pasaporte.modelo.Pais;
import com.pasaporte.modelo.Titular;

public class PasaporteController {
    public Pasaporte crearPasaporte(String id, String nombreTitular, String fecha, Pais pais) {
        Titular titular = new Titular(id, nombreTitular, fecha);
        return new Pasaporte(id, titular, pais);
    }
}
