package com.sga.project.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table ( name = "rol")
public class Rol {
    @Id
    @Column (name = "id_rol")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_rol;
    @Column(length = 20)
    private String nomRol;
}
