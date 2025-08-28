package com.sga.project.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_alquiler", nullable = false, foreignKey = @ForeignKey(name = "FK_alquiler_articulosalquiler"))
    private Alquiler alquiler;
}
