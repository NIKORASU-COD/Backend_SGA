package com.sga.project.service;

import java.util.List;

import com.sga.project.dto.CategoriaDto;

public interface CategoriaService {

public CategoriaDto getCategoria (Integer idCate);
public CategoriaDto saveCategoria (CategoriaDto categoriaDto);
public List<CategoriaDto> getCategoria ();
public CategoriaDto deleteCategoria(Integer Cateid);
public CategoriaDto updateCategoria (Integer categoria, CategoriaDto categoriaDto);
}
