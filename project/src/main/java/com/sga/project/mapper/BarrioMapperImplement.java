package com.sga.project.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sga.project.dto.BarrioDto;
import com.sga.project.models.Barrio;

@Component public class BarrioMapperImplement implements BarrioMapper {

    @Override
    public Barrio toBarrio(BarrioDto barrioDto) {
    if (barrioDto == null){
        return null;
    }
   Barrio barrio = new Barrio();
   barrio.setId_barrio(barrioDto.getIdBarrio());
   barrio.setNomBar(barrioDto.getNombreBarrio());
   return barrio;
    }

    @Override
    public BarrioDto toBarrioDto(Barrio barrio) {
    if (barrio == null) {
        return null;
    }
    BarrioDto barrioDto = new BarrioDto();
    barrioDto.setIdBarrio(barrio.getId_barrio());
    barrioDto.setNombreBarrio(barrio.getNomBar());
    return barrioDto;
    }

    @Override
    public List<BarrioDto> toBarrioDtoList(List<Barrio> barrio) {
    if (barrio == null) {
        return List.of();
    }
    List<BarrioDto> list = new ArrayList<BarrioDto>(barrio.size());
    for(Barrio Barrios : barrio){
        list.add(toBarrioDto(Barrios));
    }
    return list;
    }

    @Override
    public void updateBarrio(Barrio barrio, BarrioDto barrioDto) {
        if (barrioDto == null) {
            return;
        }
        barrio.setId_barrio(barrioDto.getIdBarrio());
        barrio.setNomBar(barrioDto.getNombreBarrio());
        

}
}