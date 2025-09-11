package com.sga.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sga.project.dto.CategoriaDto;
import com.sga.project.mapper.CategoriaMapper;
import com.sga.project.models.Categoria;
import com.sga.project.repositoryes.CategoriaRepositoryes;

@Service
public class CategoriaServiceImplement implements CategoriaService {

    @Autowired
    private CategoriaRepositoryes cr;
    @Autowired
    private CategoriaMapper cm;
    @Override
    public CategoriaDto getCategoria(Integer idCate) {
    Categoria categoria = cr.findById(idCate).get();
    return cm.toCategoriaDto(categoria);
    }

    @Override
    public CategoriaDto saveCategoria(CategoriaDto categoriaDto) {
    Categoria categoria = cm.toCategoria(categoriaDto);
    return cm.toCategoriaDto(cr.save(categoria));
    }

    @Override
    public List<CategoriaDto> getCategoria() {
    List <Categoria> categorias = cr.findAll();
    return cm.toCategoriaDtoList(categorias);
    }

    @Override
    public CategoriaDto deleteCategoria(Integer Cateid) {
    Categoria categoria = cr.findById(Cateid).get();
    cr.delete(categoria);
    return cm.toCategoriaDto(categoria);
    }

    @Override
    public CategoriaDto updateCategoria(Integer categoria, CategoriaDto categoriaDto) {
    Categoria categoria2 = cr.findById(categoria).get();
    cm.updateCategoria(categoria2, categoriaDto);
    return cm.toCategoriaDto(cr.save (categoria2));
}


}
