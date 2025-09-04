package com.sga.project.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sga.project.dto.AlquilerDto;
import com.sga.project.models.Alquiler;

@Component class AlquilermapperImplement implements AlquilerMapper{

    @Override
    public Alquiler toAlquiler(AlquilerDto alquilerDto) {
    if (alquilerDto == null){
        return null;
    }
    Alquiler alquiler = new Alquiler();
    alquiler.setId_alquiler(alquilerDto.getId_alquiler());
    alquiler.setFechaRet(alquilerDto.getFechaRetiro());
    alquiler.setFechaEnt(alquilerDto.getFechaEntrega());
    alquiler.setFechaAlq(alquiler.getFechaAlq());
    return alquiler;

    }

    @Override
    public AlquilerDto toAlquilerDto(Alquiler alquiler) {
    if (alquiler == null){
        return null;
    }
    AlquilerDto alquilerDto = new AlquilerDto();
    alquilerDto.setId_alquiler(alquiler.getId_alquiler());
    alquilerDto.setFechaRetiro(alquiler.getFechaRet());
    alquilerDto.setFechaEntrega(alquiler.getFechaEnt());
    alquilerDto.setFechaAlquiler(alquiler.getFechaAlq());
    return alquilerDto;
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

    @Override
    public void updateAlquiler(Alquiler alquiler, AlquilerDto alquilerDto) {

        if (alquilerDto == null){
            return;
        }
        alquiler.setId_alquiler(alquilerDto.getId_alquiler());
        alquiler.setFechaAlq(alquilerDto.getFechaAlquiler());
        alquiler.setFechaEnt(alquilerDto.getFechaEntrega());
        alquiler.setFechaRet(alquilerDto.getFechaRetiro());
    }

}









    




