package com.sga.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sga.project.dto.AlquilerDto;
import com.sga.project.mapper.AlquilerMapper;
import com.sga.project.models.Alquiler;
import com.sga.project.repositoryes.AlquilerRepositoryes;

@Service
public class AlquilerServiceImplement implements AlquilerService{

    @Autowired
    private AlquilerRepositoryes ar;
    @Autowired
    private AlquilerMapper am;
    
    @Override
    public AlquilerDto getAlquiler(Integer Id_alquiler) {
        Alquiler alquiler = ar.findById (Id_alquiler).get();
        return am.toAlquilerDto(alquiler);
        
    }

    @Override
    public AlquilerDto saveAlquiler(AlquilerDto alquilerDto) {
    Alquiler alquiler = am.toAlquiler(alquilerDto);
    return am.toAlquilerDto(ar.save (alquiler));
    }


    @Override
    public List<AlquilerDto> getAlquiler() {
    List <Alquiler> alquiler = ar.findAll();
    return am.toAlquilerDtoList(alquiler);
    }

    @Override
    public AlquilerDto deleteAlquiler(Integer alquiler_id) {
    Alquiler alquiler = ar.findById(alquiler_id).get();
    ar.delete(alquiler);
    return am.toAlquilerDto(alquiler);
    }

    @Override
    public AlquilerDto updateAlquiler(Integer alquiler, AlquilerDto alquilerDto) {
    Alquiler alquiler2 = ar.findById(alquiler).get();
    am.updateAlquiler (alquiler2, alquilerDto);
    return am.toAlquilerDto(ar.save(alquiler2));

    }

}
