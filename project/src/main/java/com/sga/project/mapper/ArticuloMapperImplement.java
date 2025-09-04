package com.sga.project.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sga.project.dto.ArticuloDto;
import com.sga.project.models.Articulo;

@Component class ArticuloMapperImplement implements ArticuloMapper{


    @Override
    public Articulo toArticulo(ArticuloDto articuloDto) {
 if (articuloDto == null){
        return null;
    }
    Articulo articulo = new Articulo();
    articulo.setId_articulo(articuloDto.getIdArt());
    articulo.setGenero(articuloDto.getGeneroArt());
    articulo.setTalla(articuloDto.getTallaArt());
    articulo.setColor(articuloDto.getColorArt());
    articulo.setNomArt(articuloDto.getNombre());
    articulo.setPrecio(articuloDto.getPrecioArt());
    return articulo;

    }

    

    @Override
    public ArticuloDto toArticuloDto(Articulo articulo) {
    if (articulo == null){
        return null;
    }
    ArticuloDto articuloDto = new ArticuloDto();
    articuloDto.setIdArt(articulo.getId_articulo());
    articuloDto.setGeneroArt(articulo.getGenero());
    articuloDto.setTallaArt(articulo.getTalla());
    articuloDto.setColorArt(articulo.getColor());
    articuloDto.setNombre(articulo.getNomArt());
    articulo.setPrecio(articulo.getPrecio());
    return articuloDto;
    }

    @Override
    public List<ArticuloDto> toArticuloList(List<Articulo> articulos) {
    if (articulos == null){
        return List.of();
    }
    List <ArticuloDto> list = new ArrayList<ArticuloDto>(articulos.size());
    for(Articulo Articulo : articulos){
        list.add(toArticuloDto(Articulo));
    }
    return list;

}



    @Override
    public void updateArticulos(Articulo articulo, ArticuloDto articuloDto) {
        if (articuloDto == null) {
            return;

        }
        articulo.setId_articulo(articuloDto.getIdArt());
        articulo.setGenero(articuloDto.getGeneroArt());
        articulo.setTalla(articuloDto.getTallaArt());
        articulo.setColor(articuloDto.getColorArt());
        articulo.setNomArt(articuloDto.getNombre());
        articulo.setPrecio(articuloDto.getPrecioArt());
    }

}
