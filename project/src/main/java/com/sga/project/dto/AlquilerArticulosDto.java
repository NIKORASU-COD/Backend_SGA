package com.sga.project.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

public class AlquilerArticulosDto {
    @NotNull
 private Integer alquilerId;

 @NotNull
 private Integer articuloId;


}
