package com.pasaporte.repositorio;

import java.util.List;
import java.util.Optional;

public interface Repositorio<T> {

void crear(T t); // CRUD - Create

List<T> listar(); // CRUD - Read

void actualizar(T t); // CRUD - Update

void eliminar(String id); // CRUD - Delete

List<T> buscar(String criterio); // Requerimiento de bsúsqueda

}