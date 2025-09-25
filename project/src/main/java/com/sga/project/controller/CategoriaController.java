package com.sga.project.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.sga.project.models.Categoria;
import com.sga.project.repositoryes.CategoriaRepositoryes;

@RestController
@RequestMapping("api/cat")
public class CategoriaController {
    private final CategoriaRepositoryes cp;
    private CategoriaController (CategoriaRepositoryes cp){
    this.cp = cp;
    }

    @GetMapping
    private List<Categoria> categoria(){
        return cp.findAll();
    }
}
