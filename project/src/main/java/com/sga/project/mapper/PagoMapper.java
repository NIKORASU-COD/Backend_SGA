package com.sga.project.mapper;

import java.util.List;

import com.sga.project.dto.PagoDto;
import com.sga.project.models.Pago;

public interface PagoMapper {

    Pago toPago (PagoDto pagoDto);
    PagoDto toPagoDto (Pago pago);
    List <Pago> toPagoDtoList (List <Pago> pagos);
    void updatePago (Pago pago, PagoDto pagoDto);

}
