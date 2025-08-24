package com.pasaporte.repositorio;

import java.util.List;

public interface Repositorio<T> {
    void agregar(T t);
    void actualizar(T t);
    void eliminar(String id);
    List<T> listar();
    T buscarPorId(String id);
}
