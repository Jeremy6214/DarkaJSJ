package com.darkai.backend.repository;

import com.darkai.backend.entities.ActividadSemanal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ActividadRepository extends JpaRepository<ActividadSemanal, Long> {
    Optional<ActividadSemanal> findByDiaSemana(int diaSemana);
}
