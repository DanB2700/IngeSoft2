package com.pasaporte.repositorio;

import java.util.List;

public interface Repositorio<T> {
    String insertar(T entidad);
    String actualizar(T entidad);
    String eliminar(String id);
    T buscar(String id);
    List<T> listar();
}
