package com.sga.project.mapper;

import org.springframework.stereotype.Component;
import com.sga.project.dto.PagoDto;
import com.sga.project.models.Pago;

@Component class PagoMapperImplement implements PagoMapper {

    @Override
    public Pago toPago(PagoDto pagoDto) {
    if (pagoDto == null){ 
    return null;
        
    }
    Pago pago = new Pago();
    pago.setId_pago(pagoDto.getIdPago());
    pago.setFechaUltimoAbono(pagoDto.getFechaUltimoAbono());
    pago.setValorAbono(pagoDto.getValAbo());
    return pago;
    }

    @Override
    public PagoDto toPagoDto(Pago pago) {
    if (pago == null) {
        return null;
        
    }
    PagoDto pagoDto = new PagoDto();
    pagoDto.setIdPago(pago.getId_pago());
    pagoDto.setFechaUltimoAbono(pago.getFechaUltimoAbono());
    pagoDto.setValAbo(pago.getValorAbono());
    return pagoDto;
}

}
