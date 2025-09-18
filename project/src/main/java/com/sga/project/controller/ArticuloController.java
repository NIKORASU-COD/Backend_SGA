package com.sga.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sga.project.models.Articulo;
import com.sga.project.repositoryes.ArticuloRepositoryes;
import com.sga.project.service.ArticuloService;

@RestController
@RequestMapping ("/Articulos")
public class ArticuloController {

    @Autowired
    private ArticuloRepositoryes artiRepo;
    @Autowired
    private ArticuloService artiServi;

    public ArticuloController(ArticuloService articuloService){
        this.artiServi = articuloService;
    }
}
