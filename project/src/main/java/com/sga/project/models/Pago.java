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
@Table (name = "pago")
public class Pago {
    @Id
    @Column (name = "id_pago")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id_pago;
    private Integer valorAbono;
    private Integer fechaUltimoAbono;
    
    @ManyToOne
    @JoinColumn(name = "id_alquiler", nullable = false, foreignKey = @ForeignKey(name = "FK_pago_alquiler"))
    private Alquiler alquiler;
}
