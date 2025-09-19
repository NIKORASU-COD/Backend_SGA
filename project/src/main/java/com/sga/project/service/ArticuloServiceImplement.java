package com.sga.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sga.project.dto.ArticuloDto;
import com.sga.project.mapper.ArticuloMapper;
import com.sga.project.models.Articulo;
import com.sga.project.repositoryes.ArticuloRepositoryes;

@Service
public class ArticuloServiceImplement implements ArticuloService{

    @Autowired
    private ArticuloRepositoryes art;
    @Autowired
    private ArticuloMapper amt;

    @Override
    public ArticuloDto getArticuloById(Integer idArt) {
    Articulo articulo = art.findById(idArt).get();
    return amt.toArticuloDto(articulo);
    }

    @Override
    public ArticuloDto saveArticulo(ArticuloDto articuloDto) {
    Articulo articulo = amt.toArticulo(articuloDto);
    return amt.toArticuloDto(art.save (articulo));
    }

    @Override
    public List<ArticuloDto> getListArticulos() {
    List <Articulo> articulos = art.findAll();
    return amt.toArticuloList(articulos);
    }

    @Override
    public void deleteArticulo(Integer Artid) {
    art.deleteById(Artid);
    }

    @Override
    public ArticuloDto updateArticulo(Integer articulo, ArticuloDto articuloDto) {
    Articulo articulo2 = art.findById(articulo).get();
    amt.updateArticulos(articulo2, articuloDto);
    return amt.toArticuloDto(art.save(articulo2));
    }

}
