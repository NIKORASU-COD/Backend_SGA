package com.sga.project.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PagoDto {
    private Integer idPago;
    private Date fechaUltimoAbono;
    private Integer ValAbo;
}
