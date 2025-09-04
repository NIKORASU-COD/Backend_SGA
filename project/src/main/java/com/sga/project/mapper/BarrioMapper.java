package com.sga.project.mapper;

import java.util.List;

import com.sga.project.dto.BarrioDto;
import com.sga.project.models.Barrio;

public interface BarrioMapper {
    Barrio toBarrio (BarrioDto barrioDto );
    BarrioDto toBarrioDto (Barrio barrio);
    List<BarrioDto> toBarrioDtoList (List<Barrio> barrio);
    void updateBarrio (Barrio barrio,BarrioDto barrioDto);
}
