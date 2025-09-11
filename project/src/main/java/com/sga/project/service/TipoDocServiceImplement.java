package com.sga.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sga.project.dto.TipoDocDto;
import com.sga.project.mapper.TipoDocMapper;
import com.sga.project.models.TipoDoc;
import com.sga.project.repositoryes.TipoDocRepositoryes;

@Service
public class TipoDocServiceImplement  implements TipoDocService{


@Autowired
private TipoDocRepositoryes tr;
@Autowired
private TipoDocMapper tm;
@Override

public TipoDocDto getTipoDoc(Integer idTipDocumento) {
TipoDoc tipoDoc = tr.findById(idTipDocumento).get();
return tm.toTipoDocDto(tipoDoc);
}
@Override
public TipoDocDto saveTipoDoc(TipoDocDto tipoDocDto) {
TipoDoc tipoDoc = tm.toTipoDoc(tipoDocDto);
return tm.toTipoDocDto(tr.save(tipoDoc));
}
@Override
public List<TipoDocDto> getTipoDoc() {
List <TipoDoc> tipoDocs = tr.findAll();
return (List<TipoDocDto>) tm.toTipoDocDtoList(tipoDocs);
}
@Override
public TipoDocDto deleteTipoDoc(Integer TipoDocumentoid) {
TipoDoc tipoDoc = tr.findById(TipoDocumentoid).get();
tr.delete(tipoDoc);
return tm.toTipoDocDto(tipoDoc);
}
@Override
public TipoDocDto updateTipoDoc(Integer tipoDoc, TipoDocDto tipoDocDto) {
TipoDoc tipoDoc2 = tr.findById(tipoDoc).get();
tm.updateTipoDoc(tipoDoc2, tipoDocDto);
return tm.toTipoDocDto(tr.save(tipoDoc2));

}

}
