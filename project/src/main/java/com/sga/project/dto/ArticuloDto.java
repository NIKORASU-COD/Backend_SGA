package com.sga.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ArticuloDto {
    private Integer idArt;
    private String generoArt;
    private Integer tallaArt;
    private String colorArt;
    private String nombre;
    private Integer precioArt;
}
