package com.darkai.backend.entities;
import jakarta.persistence.*;

@Entity
@Table(name = "actividad_semanal")
public class ActividadSemanal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int diaSemana;
    private int horas;

    public ActividadSemanal() {}

    public ActividadSemanal(int diaSemana, int horas) {
        this.diaSemana = diaSemana;
        this.horas = horas;
    }

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public int getDiaSemana() { return diaSemana; }
    public void setDiaSemana(int diaSemana) { this.diaSemana = diaSemana; }

    public int getHoras() { return horas; }
    public void setHoras(int horas) { this.horas = horas; }
}