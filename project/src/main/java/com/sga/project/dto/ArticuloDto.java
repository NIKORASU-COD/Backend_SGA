package com.sga.project.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ArticuloDto {
    
    private Integer idArt;
    @NotNull
    private String generoArt;
    private String tallaArt;
    private String colorArt;
    private String nombre;
    private Integer precioArt;
}
