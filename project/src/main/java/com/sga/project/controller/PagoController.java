package com.sga.project.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sga.project.dto.PagoDto;
import com.sga.project.service.PagoService;

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
@RequestMapping ("/pagos")
public class PagoController {

    private final PagoService pagoServi;

    public PagoController (PagoService pagoServi) {
        this.pagoServi = pagoServi;
    }

    @PostMapping("/AñadirPago")
    public ResponseEntity <?> crear (@Valid @RequestBody PagoDto pagoDto) {
        try {
            PagoDto añadir = pagoServi.savePago(pagoDto);
            return ResponseEntity.status(HttpStatus.CREATED)
            .body(Map.of("mensaje", "Pago añadido", "data", añadir));
        } catch (IllegalStateException exception) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
            .body(Map.of("error", exception.getMessage()));
        }catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(Map.of("error", "Error al añadir un pago","detalle", ex.getMessage()));
        }
        
    };

    @GetMapping("/ConsultarPagos")
    public ResponseEntity<List<PagoDto>>listarPagos() {
        List<PagoDto> pagos  = pagoServi.getListPago();
        return ResponseEntity.ok(pagos);
    };

    @DeleteMapping ("/Eliminar/{id}")
    public ResponseEntity<Void> eliminarpago (@PathVariable Integer id) {
    pagoServi.deletePago(id);
    return ResponseEntity.noContent().build();
    };

    @GetMapping("ConsultarById/{id}")
    public ResponseEntity <PagoDto> buscarPorId(@PathVariable Integer id) {
        PagoDto pagoDto = pagoServi.getPagoById(id);
        return ResponseEntity.ok(pagoDto);
    }
    
    
    
    

}
