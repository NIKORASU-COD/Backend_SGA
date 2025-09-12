package com.sga.project.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

public class AlquilerArticulosDto {
@NotNull (message = "El ID del Alquiler no puede estar vacío")
private Integer alquilerId;

@NotNull (message = "El ID del Articulo no puede estar vacío")
private Integer articuloId;

@NotNull
private Boolean estado;

@NotNull
private Integer precio;

@NotNull
private String observaciones;
}
