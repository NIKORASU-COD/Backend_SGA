package com.sga.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuarioDto {
    private Integer numDocumento;
    private String dire;
    private String nombre1;
    private String nombre2;
    private String apellido1;
    private String apellido2;
    private Long tele;
}
