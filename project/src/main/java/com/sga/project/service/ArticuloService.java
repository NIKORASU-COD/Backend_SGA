package com.sga.project.service;

import java.util.List;

import com.sga.project.dto.ArticuloDto;

public interface ArticuloService {

public ArticuloDto getArticuloById (Integer idArt);
public ArticuloDto saveArticulo (ArticuloDto articuloDto);
public List <ArticuloDto> getListArticulos ();
void deleteArticulo (Integer Artid);
public ArticuloDto updateArticulo (Integer articulo, ArticuloDto articuloDto);
}
