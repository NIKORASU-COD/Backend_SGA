package com.sga.project.mapper;

import java.util.List;

import com.sga.project.dto.ArticuloDto;
import com.sga.project.models.Articulo;

public interface ArticuloMapper {

    Articulo toArticulo (ArticuloDto articuloDto);
    ArticuloDto toArticuloDto (Articulo articulo);
    List<ArticuloDto> toArticuloList (List <Articulo> articulos);


}
