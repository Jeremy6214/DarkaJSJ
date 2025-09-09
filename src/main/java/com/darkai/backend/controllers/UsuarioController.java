package com.darkai.backend.controllers;

import com.darkai.backend.models.UsuarioDto;
import com.darkai.backend.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public List<UsuarioDto> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public UsuarioDto getById(@PathVariable Long id) {
        UsuarioDto user = service.findById(id);
        if (user == null) {
            // ✅ Si no existe el usuario, lanzamos excepción con 404
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado");
        }
        return user;
    }



    // ✅ Registro desde formulario HTML con validación
    @PostMapping(path = "/auth/register", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public RedirectView registerForm(@Valid UsuarioDto dto) {
        // Verificamos que no haya campos vacíos
        if (dto.getUsername() == null || dto.getUsername().isBlank() ||
                dto.getEmail() == null || dto.getEmail().isBlank() ||
                dto.getPassword() == null || dto.getPassword().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Los campos no pueden estar vacíos");
        }

        service.save(dto);
        return new RedirectView("/auth/login.html");
    }

    // ✅ Login con email o username
    @PostMapping(path = "/auth/login", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public RedirectView loginForm(@RequestParam("emailOrUsername") String emailOrUsername,
                                  @RequestParam String password) {

        UsuarioDto user;

        // 🔍 Buscar primero por email, si no existe buscar por username
        user = service.findByEmail(emailOrUsername);
        if (user == null) {
            user = service.findByUsername(emailOrUsername);
        }

        // ✅ Validamos usuario y contraseña
        if (user != null && user.getPassword().equals(password)) {
            return new RedirectView("/principal.html"); // login correcto
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Credenciales incorrectas");
        }
    }

    /**
     * Crear usuario desde form-urlencoded (POST /api/usuarios).
     */
    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public UsuarioDto create(@Valid UsuarioDto dto) {
        if (dto.getUsername() == null || dto.getUsername().isBlank() ||
                dto.getEmail() == null || dto.getEmail().isBlank() ||
                dto.getPassword() == null || dto.getPassword().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Los campos no pueden estar vacíos");
        }
        return service.save(dto);
    }

    @PutMapping(path = "/{id}",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public UsuarioDto update(@PathVariable Long id, @Valid UsuarioDto dto) {
        UsuarioDto updated = service.update(id, dto);
        if (updated == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se pudo actualizar. Usuario no encontrado");
        }
        return updated;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        UsuarioDto existing = service.findById(id);
        if (existing == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se pudo eliminar. Usuario no existe");
        }
        service.deleteById(id);
    }
}
