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
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "usuario")
public class Usuario {
    @Id
    @Column (name = "numDoc")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer numDoc;
    @Column(length = 20)   
    private String nom1;
    @Column(length = 20)
    private String nom2;
    @Column(length = 20)
    private String ape2;
    @Column(length = 20)
    private String ape3;
    @Column(length = 35)
    private String direccion;
    private Long numTel;
    @Column(length = 100)
    private String correoElec;
    @Column(length = 200)
    private String contraseña;

    @ManyToOne(optional = false)
    @JoinColumn( name = "id_barrio", nullable = false, foreignKey =  @ForeignKey(name = "FK_usuario_barrio"))
    private Barrio barrio;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_tipoDoc", nullable = false, foreignKey = @ForeignKey(name = "FK_usuarios_documento"))
    private TipoDoc tipoDoc;

    @ManyToOne (optional = false)
    @JoinColumn(name = "id_rol", nullable = false, foreignKey = @ForeignKey(name = "FK_usuarios_rol"))
    private Rol rol;
}
