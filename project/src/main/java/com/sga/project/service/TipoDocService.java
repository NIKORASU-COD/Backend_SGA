package com.sga.project.service;

import java.util.List;

import com.sga.project.dto.TipoDocDto;

public interface TipoDocService {

public TipoDocDto getTipoDoc (Integer idTipDocumento);
public TipoDocDto saveTipoDoc (TipoDocDto tipoDocDto);
public List<TipoDocDto> getTipoDoc ();
public TipoDocDto deleteTipoDoc (Integer TipoDocumentoid);
public TipoDocDto updateTipoDoc (Integer tipoDoc, TipoDocDto tipoDocDto);
}

