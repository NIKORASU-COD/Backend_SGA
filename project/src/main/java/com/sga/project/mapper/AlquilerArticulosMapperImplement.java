package com.sga.project.mapper;

import org.springframework.stereotype.Component;

import com.sga.project.dto.AlquilerArticulosDto;
import com.sga.project.models.Alquiler;
import com.sga.project.models.AlquilerArticulos;
import com.sga.project.models.AlquilerArticulosId;
import com.sga.project.models.Articulo;
import com.sga.project.repositoryes.AlquilerRepositoryes;
import com.sga.project.repositoryes.ArticuloRepositoryes;

import jakarta.persistence.EntityNotFoundException;


@Component
public class AlquilerArticulosMapperImplement implements AlquilerArticuloMapper{

    private final AlquilerRepositoryes alquilerRepo;
    private final ArticuloRepositoryes articuloRepo;
    
    public AlquilerArticulosMapperImplement(ArticuloRepositoryes articuloRepo, AlquilerRepositoryes alquilerRepo) {
        this.alquilerRepo = alquilerRepo;
        this.articuloRepo = articuloRepo;
    }
    
    @Override
    public AlquilerArticulos toEntity(AlquilerArticulosDto alquiArticuloDto) {
        Articulo articulo = articuloRepo.findById(alquiArticuloDto.getArticuloId())
        .orElseThrow(()-> new EntityNotFoundException("Artículo no encontrado"));
        
        Alquiler alquiler = alquilerRepo.findById(alquiArticuloDto.getAlquilerId())
        .orElseThrow(()-> new EntityNotFoundException("Alquiler no encontrado"));

        AlquilerArticulosId id = new AlquilerArticulosId(alquiArticuloDto.getArticuloId(), alquiArticuloDto.getAlquilerId());

        AlquilerArticulos aa = new AlquilerArticulos();
        aa.setId(id);
        aa.setAlquiler(alquiler);
        aa.setArticulo(articulo);
        aa.setObservaciones(alquiArticuloDto.getObservaciones());
        aa.setPrecio(alquiArticuloDto.getPrecio());
        aa.setEstado(alquiArticuloDto.getEstado());

        return aa;
    }

    @Override
    public AlquilerArticulosDto toDto (AlquilerArticulos alquiArticulos) {
        return new AlquilerArticulosDto(
            alquiArticulos.getAlquiler().getId(),
            alquiArticulos.getArticulo().getId(),
            alquiArticulos.getEstado(),
            alquiArticulos.getPrecio(),
            alquiArticulos.getObservaciones()
        );
    }
}
