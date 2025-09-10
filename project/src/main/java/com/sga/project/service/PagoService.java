package com.sga.project.service;

import java.util.List;

import com.sga.project.dto.PagoDto;

public interface PagoService {

public PagoDto getPago (Integer idPago);
public PagoDto savePago (PagoDto pagoDto);
public List<PagoDto> getPago ();
public PagoDto deletePago(Integer Pagoid);
public PagoDto updatePago (Integer pago, PagoDto pagoDto);

}
