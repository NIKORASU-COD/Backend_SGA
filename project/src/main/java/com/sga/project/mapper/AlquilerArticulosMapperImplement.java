package com.sga.project.mapper;

import org.springframework.stereotype.Component;

import com.sga.project.dto.AlquilerArticulosDto;
import com.sga.project.models.Alquiler;
import com.sga.project.models.AlquilerArticulos;
import com.sga.project.repositoryes.AlquilerRepositoryes;
import com.sga.project.repositoryes.ArticuloRepositoryes;

import jakarta.persistence.EntityNotFoundException;


@Component
public class AlquilerArticulosMapperImplement implements AlquilerArticuloMapper{

    private final AlquilerRepositoryes alquilerRepositoryes;
    private final ArticuloRepositoryes articuloRepositoryes;
    
    public AlquilerArticulosMapperImplement (AlquilerRepositoryes alquilerRepositoryes, ArticuloRepositoryes articuloRepositoryes){
    this.alquilerRepositoryes = alquilerRepositoryes;
    this.articuloRepositoryes = articuloRepositoryes;
    }
    
    @Override
    public AlquilerArticulos toEntity(AlquilerArticulosDto alquilerArticulosDto) {
    Alquiler alquiler = alquilerRepositoryes.findById(alquilerArticulosDto.getAlquilerId())
    .orElseThrow (() -> new EntityNotFoundException("Alquiler no encontrado"));
    }
    @Override
    public AlquilerArticulosDto toDto(AlquilerArticulos alquilerArticulos) {
        
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }


}
