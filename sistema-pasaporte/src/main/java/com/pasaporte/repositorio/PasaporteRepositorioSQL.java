package com.pasaporte.repositorio;

import com.pasaporte.modelo.Pasaporte;
import java.util.*;

public class PasaporteRepositorioSQL implements Repositorio<Pasaporte> {
    private List<Pasaporte> pasaportes = new ArrayList<>();

    @Override
    public void agregar(Pasaporte p) {
        pasaportes.add(p);
    }

    @Override
    public void actualizar(Pasaporte p) {
        for (int i = 0; i < pasaportes.size(); i++) {
            if (pasaportes.get(i).getId().equals(p.getId())) {
                pasaportes.set(i, p);
                break;
            }
        }
    }

    @Override
    public void eliminar(String id) {
        pasaportes.removeIf(p -> p.getId().equals(id));
    }

    @Override
    public List<Pasaporte> listar() {
        return pasaportes;
    }

    @Override
    public Pasaporte buscarPorId(String id) {
        return pasaportes.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
