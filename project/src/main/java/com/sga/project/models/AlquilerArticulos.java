package com.sga.project.models;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;  
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "alquilerarticulos")
public class AlquilerArticulos {
    
    @EmbeddedId
    private AlquilerArticulosId id = new AlquilerArticulosId();

    @ManyToOne
    @MapsId ("alquilerId")
    @JoinColumn (name = "idAlquiler", foreignKey = @ForeignKey (name = "FK_AlquilerArticulos_Alquiler"))
    private Alquiler alquiler;

    @ManyToOne
    @MapsId ("articuloId")
    @JoinColumn (name = "idArticulos", foreignKey = @ForeignKey (name = "FK_AlquilerArticulos_Articulo"))
    private Articulo articulo;

    private Boolean estado;
    private Integer precio;
    
    @Column(length = 100)
    private String observaciones;

    
}
