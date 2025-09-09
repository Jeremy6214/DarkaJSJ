package com.darkai.backend.services;

import com.darkai.backend.models.UsuarioDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface UsuarioService {

    UsuarioDto save(UsuarioDto usuarioDto);
    UsuarioDto update(Long id, UsuarioDto usuarioDto);
    void deleteById(Long id);
    UsuarioDto findById(Long id);
    List<UsuarioDto> findAll();
    UsuarioDto findByEmail(String email);
    UsuarioDto findByUsername(String username); // ✅ nuevo método


}
