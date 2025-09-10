package com.sga.project.mapper;

import java.util.List;

import com.sga.project.dto.TipoDocDto;
import com.sga.project.models.TipoDoc;

public interface TipoDocMapper {

    TipoDoc toTipoDoc (TipoDocDto tipoDocDto);
    TipoDocDto toTipoDocDto (TipoDoc tipoDoc);
    List<TipoDocDto> toTipoDocDtoList (List <TipoDoc> tipoDocs);
    void updateTipoDoc (TipoDoc tipoDoc, TipoDocDto tipoDocDto);
}
