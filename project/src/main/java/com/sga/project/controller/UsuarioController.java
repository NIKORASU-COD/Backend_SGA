package com.sga.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sga.project.dto.UsuarioDto;
import com.sga.project.models.Usuario;
import com.sga.project.repositoryes.UsuarioRepositoryes;
import com.sga.project.service.UsuarioService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping ("/Usuario")
public class UsuarioController {

@Autowired
private UsuarioRepositoryes usuarioRepo;
private UsuarioService usuarioService;

public UsuarioController(UsuarioService usuarioService) {
    this.usuarioService = usuarioService;
}

@GetMapping("/consultarlista")
public List<Usuario> consulList() {
    return usuarioRepo.findAll();
}

@PostMapping("/Crear")
public ResponseEntity<UsuarioDto> createUser (@Valid @RequestBody @)
    
    return entity;
}


}
