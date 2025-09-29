package com.sga.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sga.project.dto.ArticuloDto;
import com.sga.project.mapper.ArticuloMapper;
import com.sga.project.models.Articulo;
import com.sga.project.repositoryes.ArticuloRepositoryes;
import com.sga.project.repositoryes.CategoriaRepositoryes;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class ArticuloServiceImplement implements ArticuloService{

    private final ArticuloMapper artiMap;
    private final ArticuloRepositoryes artiRepo;
    private final CategoriaRepositoryes cateRepo;

    public ArticuloServiceImplement (ArticuloMapper artiMap, ArticuloRepositoryes artiRepo, CategoriaRepositoryes cateRepo) {
    this.artiMap = artiMap;
    this.artiRepo = artiRepo;
    this.cateRepo = cateRepo;
}

@Override
public ArticuloDto getArticuloById (Integer idArt) {
    return artiRepo.findById(idArt).map(artiMap::toArticuloDto).orElseThrow(() -> new EntityNotFoundException("Articulo no encontrado por el ID: " + idArt));
}

@Override
@Transactional
public ArticuloDto saveArticulo (ArticuloDto articuloDto) {
    Articulo arti = artiMap.toArticulo(articuloDto);
    Articulo artiGuardado = artiRepo.save(arti);
    return artiMap.toArticuloDto(artiGuardado);
}

@Override
@Transactional
public List<ArticuloDto> getListArticulos () {
    return artiRepo.findAll().stream().map(artiMap::toArticuloDto).toList();
}

@Override
@Transactional
public void deleteArticulo (Integer idArt){
    Articulo arti = artiRepo.findById(idArt).orElseThrow(() -> new EntityNotFoundException("Articulo no encontrado por el ID: " + idArt));
    artiRepo.delete(arti);
}
}
