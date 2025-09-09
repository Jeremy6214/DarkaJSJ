package com.darkai.backend.services.impl;

import com.darkai.backend.entities.Usuario;
import com.darkai.backend.models.UsuarioDto;
import com.darkai.backend.repository.UsuarioRepository;
import com.darkai.backend.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository repo;

    // ===== Conversión de Entity -> DTO =====
    private UsuarioDto toDto(Usuario u) {
        UsuarioDto d = new UsuarioDto();
        d.setId(u.getId());
        d.setUsername(u.getusername()); // ✅ corregido camelCase
        d.setEmail(u.getEmail());
        d.setPassword(u.getPassword());
        return d;
    }

    // ===== Conversión de DTO -> Entity =====
    private Usuario toEntity(UsuarioDto d) {
        Usuario u = new Usuario();
        u.setId(d.getId());
        u.setusername(d.getUsername());
        u.setEmail(d.getEmail());
        u.setPassword(d.getPassword());
        return u;
    }

    @Override
    public UsuarioDto save(UsuarioDto dto) {
        Usuario saved = repo.save(toEntity(dto));
        return toDto(saved);
    }

    @Override
    public UsuarioDto update(Long id, UsuarioDto dto) {
        Usuario u = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado: " + id));
        u.setusername(dto.getUsername());
        u.setEmail(dto.getEmail());
        u.setPassword(dto.getPassword());
        Usuario updated = repo.save(u);
        return toDto(updated);
    }

    @Override
    public void deleteById(Long id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Usuario no encontrado: " + id);
        }
        repo.deleteById(id);
    }

    @Override
    public UsuarioDto findById(Long id) {
        return repo.findById(id)
                .map(this::toDto)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado: " + id));
    }

    @Override
    public List<UsuarioDto> findAll() {
        return repo.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioDto findByEmail(String email) {
        return repo.findByEmail(email)
                .map(this::toDto)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con email: " + email));
    }

    @Override
    public UsuarioDto findByUsername(String username) {
        return repo.findByUsername(username)
                .map(this::toDto)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con username: " + username));
    }
}
