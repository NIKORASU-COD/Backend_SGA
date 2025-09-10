package com.sga.project.service;

import java.util.List;

import com.sga.project.dto.BarrioDto;
public interface BarrioService {

public BarrioDto getBarrio (Integer idBarrio); 
public BarrioDto saveBarrio (BarrioDto barrioDto);
public List<BarrioDto> getBarrio ();
public BarrioDto deleteBarrio (Integer Barrioid);
public BarrioDto updateBarrio (Integer Barrio,BarrioDto barriodto );
}
