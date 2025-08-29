package com.sga.project.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    @Id
    @Column (name = "id_alqu")
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private Integer id_alqu;
    private boolean estado;
    private Integer precio;
    @Column(length = 100)
    private String Observaciones;
}
