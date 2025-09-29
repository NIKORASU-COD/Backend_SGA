package com.sga.project.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sga.project.dto.AlquilerDto;
import com.sga.project.models.Alquiler;
import com.sga.project.repositoryes.AlquilerRepositoryes;
import com.sga.project.service.AlquilerService;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/Alquiler")
public class AlquilerController {

    private final AlquilerService alquiServi;
    private final AlquilerRepositoryes alquiRep;

    public AlquilerController (AlquilerService alquiServi, AlquilerRepositoryes alquiRep) {
        this.alquiServi = alquiServi;
        this.alquiRep = alquiRep;
    }

    @GetMapping
    public List<Alquiler> alquilando() {
        return alquiRep.findAll();
    }
    
    //Crear
    @PostMapping("/CrearAlquiler")
    public ResponseEntity<?> crearAlqui (@Valid @RequestBody AlquilerDto alquilerDto) {
        try {
            AlquilerDto crearAlqui = alquiServi.saveAlquiler(alquilerDto);
            return ResponseEntity.status(HttpStatus.CREATED)
            .body(Map.of("mensaje", "Alquiler creado con exito", "data", crearAlqui));
        } catch(IllegalStateException exception){
            return ResponseEntity.status(HttpStatus.CONFLICT)
            .body(Map.of("error", exception.getMessage()));
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(Map.of("Error","Error al crear el alquiler", "detalle", ex.getMessage()));
        }
    };

    @GetMapping("/ConsultarById/{id}")
    public ResponseEntity <AlquilerDto> ConsultarPorId (@PathVariable Integer id) {
        AlquilerDto alquilerDto = alquiServi.getAlquilerById(id);
        return ResponseEntity.ok(alquilerDto);
    }
    
    @DeleteMapping ("/Eliminar/{id}") 
    public ResponseEntity <Void> eliminarAlqui (@PathVariable Integer id) {
        alquiServi.deleteAlquiler(id);
        return ResponseEntity.noContent().build();
    }
    
}
