package com.darkai.backend.repository;

import com.darkai.backend.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Buscar usuario por email (para login o validaciones)
    Optional<Usuario> findByEmail(String email);

    // Buscar usuario por username
    Optional<Usuario> findByUsername(String username);

    // Verificar si ya existe un email registrado
    boolean existsByEmail(String email);

    // Verificar si ya existe un username registrado
    boolean existsByUsername(String username);

}
