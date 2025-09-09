package com.sga.project.models;


import java.sql.Date;

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

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table (name = "alquiler")
public class Alquiler {
    @Id
    @Column (name = "id_alquiler")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id_alquiler;
    private Date fechaRet;
    private Date fechaEnt;
    private Date fechaAlq;
    @ManyToOne (optional = false)
    @JoinColumn (name = "usuarioDoc", nullable = false, foreignKey = @ForeignKey(name = "FK_alquiler_usuario"))
    private Usuario usuario;
}
