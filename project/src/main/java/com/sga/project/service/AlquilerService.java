package com.sga.project.service;

import java.util.List;


import com.sga.project.dto.AlquilerDto;

public interface AlquilerService {

public AlquilerDto getAlquiler (Integer Id_alquiler);
public AlquilerDto saveAlquiler (AlquilerDto alquilerDto);
public List <AlquilerDto> getAlquiler ();
public AlquilerDto deleteAlquiler (Integer alquiler_id);
public AlquilerDto updateAlquiler (Integer alquiler, AlquilerDto alquilerDto);
}
