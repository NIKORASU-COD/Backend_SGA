package com.sga.project.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sga.project.dto.BarrioDto;
import com.sga.project.models.Barrio;
import com.sga.project.repositoryes.BarrioRepositoryes;
import com.sga.project.service.BarrioService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/barrio")
public class BarrioControlller {

    private final BarrioRepositoryes br;
    private final BarrioService bs;

    private BarrioControlller(BarrioRepositoryes br, BarrioService bs){
        this.br = br;
        this.bs = bs;
    }

    @GetMapping
    public List<Barrio>barrios() {
        return br.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<BarrioDto> encontrar(@PathVariable Integer id) {
        BarrioDto barrioDto = bs.getBarrio(id);
        return ResponseEntity.ok(barrioDto);
    }
    
    @PostMapping("/crear")
    public ResponseEntity<BarrioDto> saveBarrio(@Valid @RequestBody BarrioDto barrioDto) {
        BarrioDto guardar = bs.saveBarrio(barrioDto);
        return ResponseEntity.ok(guardar);
    }
    
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        bs.deleteBarrio(id);
        return ResponseEntity.noContent().build();
    }
}
