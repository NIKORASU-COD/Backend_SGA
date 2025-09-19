package com.sga.project.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sga.project.dto.AlquilerDto;
import com.sga.project.models.Alquiler;
import com.sga.project.repositoryes.AlquilerRepositoryes;
import com.sga.project.service.AlquilerService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping("/api/alquiler")
public class AlquilerController {

    private final AlquilerService alservi;
    private final AlquilerRepositoryes alrepo;
    public AlquilerController(AlquilerService alservi, AlquilerRepositoryes alrepo){
        this.alservi = alservi;
        this.alrepo = alrepo;
    }

    @GetMapping("/Alquileres")
    public List<Alquiler> alquiler() {
        return alrepo.findAll();
    }
    
    @PostMapping("/alquilar")
    public ResponseEntity<AlquilerDto> saveAlquiler(@Valid @RequestBody AlquilerDto alquilerDto) {
        AlquilerDto alquilar = alservi.saveAlquiler(alquilerDto);
        return ResponseEntity.ok(alquilar);
    }
    
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<Void> borrar(@PathVariable Integer id){
        alservi.deleteAlquiler(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity <AlquilerDto> buscarporid(@PathVariable Integer id) {
        AlquilerDto alquilerDto = alservi.getAlquiler(id);
        return ResponseEntity.ok(alquilerDto);

    }
    
    @PutMapping("actualizar/{id}")
    public ResponseEntity <AlquilerDto> actualizar(@PathVariable Integer id, @Valid @RequestBody AlquilerDto alquilerDto) {
    alquilerDto.setId_alquiler(id);
    AlquilerDto actualizar = alservi.updateAlquiler(id, alquilerDto);
    return ResponseEntity.ok(actualizar);
    }


}
