package com.sga.project.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.sga.project.dto.ArticuloDto;
import com.sga.project.dto.ArticuloUpdateDto;
import com.sga.project.mapper.ArticuloMapper;
import com.sga.project.models.Articulo;
import com.sga.project.repositoryes.ArticuloRepositoryes;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class ArticuloServiceImplement implements ArticuloService{

    private final ArticuloMapper artiMap;
    private final ArticuloRepositoryes artiRepo;


    public ArticuloServiceImplement (ArticuloMapper artiMap, ArticuloRepositoryes artiRepo) {
    this.artiMap = artiMap;
    this.artiRepo = artiRepo;

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

@Override
@Transactional
public ArticuloDto updateArticulo (ArticuloUpdateDto artiUpdateDto) {
    Articulo art = artiRepo.findById(artiUpdateDto.getIdArt())
    .orElseThrow(() -> new EntityNotFoundException("Articulo no encontrado"));

    art.setPrecio(artiUpdateDto.getPrecioArti());
    art.setFoto(artiUpdateDto.getFotoArti());

    Articulo artiActualizado = artiRepo.save(art);
    return artiMap.toArticuloDto(artiActualizado);
}
}
