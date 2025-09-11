package com.sga.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sga.project.dto.PagoDto;
import com.sga.project.mapper.PagoMapper;
import com.sga.project.models.Pago;
import com.sga.project.repositoryes.PagoRepositoryes;

@Service
public class PagoServiceImplement implements PagoService {

    @Autowired
    private PagoRepositoryes pr;
    @Autowired
    private PagoMapper pm;

    @Override
    public PagoDto getPago(Integer idPago) {
    Pago pago = pr.findById(idPago).get();
    return pm.toPagoDto(pago);
    }

    @Override
    public PagoDto savePago(PagoDto pagoDto) {
    Pago pago = pm.toPago(pagoDto);
    return pm.toPagoDto(pr.save(pago));
    }

    @Override
    public List<PagoDto> getPago() {
    List <Pago> pagos = pr.findAll();
    return (List<PagoDto>) pm.toPagoDtoList(pagos);
    }

    @Override
    public PagoDto deletePago(Integer Pagoid) {
    Pago pago = pr.findById(Pagoid).get();
    pr.delete(pago); 
    return  pm.toPagoDto(pago); 
    }

    @Override
    public PagoDto updatePago(Integer pago, PagoDto pagoDto) {
    Pago pago2 = pr.findById(pago).get();
    pm.updatePago(pago2, pagoDto);
    return pm.toPagoDto(pr.save(pago2));
    }

}
