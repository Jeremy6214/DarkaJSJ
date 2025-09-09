package com.darkai.backend.controllers;

import com.darkai.backend.entities.ActividadSemanal;
import com.darkai.backend.services.ActividadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/actividad")
public class ActividadController {

    private final ActividadService service;

    @Autowired
    public ActividadController(ActividadService service) {
        this.service = service;
    }

    // Obtener todas las actividades
    @GetMapping
    public List<ActividadSemanal> obtenerActividad() {
        return service.obtenerActividad();
    }

    // Sumar horas a un día
    @PostMapping("/sumar")
    public ActividadSemanal sumarActividad(@RequestParam int dia, @RequestParam int horas) {
        return service.sumarActividad(dia, horas);
    }
}
