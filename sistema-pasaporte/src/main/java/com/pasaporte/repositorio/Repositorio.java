package com.pasaporte.repositorio;

import java.util.List;
import java.util.Optional;

public interface Repositorio<T> {
    T crear(T entidad);
    Optional<T> leer(String id);
    List<T> listar();
    T actualizar(String id, T entidad);
    Optional<T> eliminar(String id);
}

