package com.sga.project.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sga.project.dto.CategoriaDto;
import com.sga.project.models.Categoria;

@Component public class CategoriaMapperImplement implements CategoriaMapper {

    @Override
    public Categoria toCategoria(CategoriaDto categoriaDto) {
    if (categoriaDto == null) {
        return null;
}
    Categoria categoria = new Categoria();
    categoria.getId_categoria();
    categoria.getNomCate();
    categoria.getDescripcion();
    return categoria;
    

    }

    @Override
    public CategoriaDto toCategoriaDto(Categoria categoria) {
        if (categoria == null) {
            return null;
            
        }
        CategoriaDto categoriaDto = new CategoriaDto();
        categoriaDto.getIdCate();
        categoriaDto.getNomCate();
        categoriaDto.getDesCate();
        return  categoriaDto;

    }

    @Override
    public List<CategoriaDto> toCategoriaDtoList(List<Categoria> categorias) {
    if (categorias == null) {
        return List.of();
            
        }
    List <CategoriaDto> list = new ArrayList<CategoriaDto>(categorias.size());
        for (Categoria Categoria : categorias){
        list.add(toCategoriaDto(Categoria));
        
    }
    return list;
    }

    @Override
    public void updateCategoria(Categoria categoria, CategoriaDto categoriaDto) {
    if (categoriaDto == null) {
        return;
        
    }
    categoria.getId_categoria();
    categoria.getNomCate();
    categoria.getDescripcion();
    }



}
