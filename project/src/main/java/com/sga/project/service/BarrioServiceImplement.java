package com.sga.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sga.project.dto.BarrioDto;
import com.sga.project.mapper.BarrioMapper;
import com.sga.project.models.Barrio;
import com.sga.project.repositoryes.BarrioRepositoryes;

@Service
public class BarrioServiceImplement implements BarrioService{

    @Autowired
    private BarrioRepositoryes br;
    @Autowired
    private BarrioMapper bm;

    @Override
    public BarrioDto getBarrio(Integer idBarrio) {
        Barrio barrio = br.findById(idBarrio).get();
        return bm.toBarrioDto(barrio);
    }

    @Override
    public BarrioDto saveBarrio(BarrioDto barrioDto) {
    Barrio barrio = bm.toBarrio(barrioDto);
    return bm.toBarrioDto(br.save(barrio));
    }

    @Override
    public List<BarrioDto> getBarrio() {
    List <Barrio> barrios = br.findAll();
    return bm.toBarrioDtoList(barrios);
    }

    @Override
    public BarrioDto deleteBarrio(Integer Barrioid) {
    Barrio barrio = br.findById(Barrioid).get();
    br.delete(barrio);
    return bm.toBarrioDto(barrio);
    }

    @Override
    public BarrioDto updateBarrio(Integer Barrio, BarrioDto barriodto) {
    Barrio barrio2 = br.findById(Barrio).get();
    bm.updateBarrio(barrio2, barriodto);
    return bm.toBarrioDto(br.save(barrio2));
    }

}
