package com.sga.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sga.project.dto.RolDto;
import com.sga.project.mapper.RolMapper;
import com.sga.project.models.Rol;
import com.sga.project.repositoryes.RolRepositoryes;

@Service
public class RolServiceImplement implements RolService {

    @Autowired
    private RolRepositoryes rr;
    @Autowired
    private RolMapper rm;

    @Override
    public RolDto getRol(Integer idRol) {
    Rol rol = rr.findById(idRol).get();
    return rm.toRolDto(rol);
    }

    @Override
    public RolDto saveRol(RolDto rolDto) {
    Rol rol = rm.toRol(rolDto);
    return rm.toRolDto(rr.save(rol));
    }

    @Override
    public List<RolDto> getRol() {
    List <Rol> rols = rr.findAll();
    return (List<RolDto>) rm.toRolDtoList(rols);
    }

    @Override
    public RolDto delete(Integer Rolid) {
    Rol rol = rr.findById(Rolid).get();
    rr.delete(rol);
    return rm.toRolDto(rol);
    }

    @Override
    public RolDto update(Integer rol, RolDto rolDto) {
    Rol rol2 = rr.findById(rol).get();
    rm.updateRol(rol2, rolDto);
    return rm.toRolDto(rr.save(rol2));
    }

}
