package com.sga.project.mapper;

import com.sga.project.dto.AlquilerArticulosDto;
import com.sga.project.models.AlquilerArticulos;

public interface AlquilerArticuloMapper{
    AlquilerArticulos toEntity(AlquilerArticulosDto alquilerArticulosDto);
    AlquilerArticulosDto toDto(AlquilerArticulos alquilerArticulos);
}
