package com.darkai.backend.services;

import com.darkai.backend.entities.ActividadSemanal;
import com.darkai.backend.repository.ActividadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActividadService {
    @Autowired
    private ActividadRepository repository;

    public List<ActividadSemanal> obtenerActividad() {
        return repository.findAll();
    }

    public ActividadSemanal sumarActividad(int dia, int horas) {
        ActividadSemanal actividad = repository.findByDiaSemana(dia)
                .orElseGet(() -> {
                    ActividadSemanal nuevo = new ActividadSemanal();
                    nuevo.setDiaSemana(dia);
                    nuevo.setHoras(0);
                    return nuevo;
                });

        actividad.setHoras(actividad.getHoras() + horas);
        return repository.save(actividad);
    }
}
