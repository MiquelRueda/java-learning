package com.miquelrueda.todo_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "tareas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El título no puede estar vacío")
    @Size(min = 3, max = 100, message = "El título debe tener entre 3 y 100 caracteres")
    @Column(nullable = false)
    private String titulo;

    @Size(max = 500, message = "La descripción no puede superar los 500 caracteres")
    private String descripcion;

    @Column(nullable = false)
    private Boolean completada = false;
}