package com.sga.project.repositoryes;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sga.project.models.AlquilerArticulos;
import com.sga.project.models.AlquilerArticulosId;

public interface AlquilerArticuloRepository extends JpaRepository <AlquilerArticulos, AlquilerArticulosId>{
    List<AlquilerArticulos> findByAlquilerId (Integer alquilerId);
    List<AlquilerArticulos> findByArticuloId (Integer articuloId);
}
