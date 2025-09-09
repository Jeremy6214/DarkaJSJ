package com.darkai.backend.DataInitializer;

import com.darkai.backend.entities.ActividadSemanal;
import com.darkai.backend.repository.ActividadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private ActividadRepository repository;

    @Override
    public void run(String... args) {
        for (int i = 1; i <= 7; i++) {
            Optional<ActividadSemanal> existente = repository.findByDiaSemana(i);

            if (existente.isEmpty()) {
                // Si no existe, lo creamos
                repository.save(new ActividadSemanal(i, 0));
            }
        }
    }
}
