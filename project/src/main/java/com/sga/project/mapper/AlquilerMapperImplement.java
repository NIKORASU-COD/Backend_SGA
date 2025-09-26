package com.sga.project.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sga.project.dto.AlquilerDto;
import com.sga.project.models.Alquiler;
import com.sga.project.models.Usuario;
import com.sga.project.repositoryes.UsuarioRepositoryes;

import jakarta.persistence.EntityNotFoundException;

@Component class AlquilermapperImplement implements AlquilerMapper{

    private final UsuarioRepositoryes usuRepo;
    public AlquilermapperImplement (UsuarioRepositoryes usuRepo) {
        this.usuRepo = usuRepo;
    }

    @Override
    public Alquiler toAlquiler(AlquilerDto alquilerDto) {
    if (alquilerDto == null){
        return null;
    }
    Alquiler alquiler = new Alquiler();
    alquiler.setId(alquilerDto.getId_alquiler());
    alquiler.setFechaRet(alquilerDto.getFechaRetiro());
    alquiler.setFechaEnt(alquilerDto.getFechaEntrega());
    alquiler.setFechaAlq(alquiler.getFechaAlq());
    
    Usuario usu = usuRepo.findById(alquilerDto.getNumDocUsuario())
    .orElseThrow(()-> new EntityNotFoundException("Usuario no encontrado"));
    alquiler.setUsuario(usu);

    return alquiler;

    }

    @Override
    public AlquilerDto toAlquilerDto(Alquiler alquiler) {
    if (alquiler == null){
        return null;
    }
    return new AlquilerDto (
        alquiler.getId(),
        alquiler.getFechaAlq(),
        alquiler.getFechaEnt(),
        alquiler.getFechaRet(),

        alquiler.getUsuario() != null ? alquiler.getUsuario().getNumDoc() : null
    );
    }

    @Override
    public List<AlquilerDto> toAlquilerDtoList(List<Alquiler> alquiler) {
    if (alquiler == null){
        return List.of();
    }
    List <AlquilerDto> list = new ArrayList<AlquilerDto>(alquiler.size());
    for(Alquiler Alquiler : alquiler){
        list.add(toAlquilerDto(Alquiler));
    }
    return list;

    }


}


