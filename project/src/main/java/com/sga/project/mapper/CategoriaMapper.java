package com.sga.project.mapper;

import java.util.List;

import com.sga.project.dto.CategoriaDto;
import com.sga.project.models.Categoria;

public interface CategoriaMapper {
    Categoria toCategoria (CategoriaDto categoriaDto);
    CategoriaDto toCategoriaDto (Categoria categoria);
    List <CategoriaDto> toCategoriaDtoList (List <Categoria> categorias);
    void updateCategoria (Categoria categoria, CategoriaDto categoriaDto);
    
}
