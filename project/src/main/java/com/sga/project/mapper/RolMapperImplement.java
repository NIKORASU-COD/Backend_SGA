package com.sga.project.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sga.project.dto.RolDto;
import com.sga.project.models.Rol;

@Component class RolMapperImplement implements RolMapper {

    @Override
    public Rol toRol(RolDto rolDto) {
    if (rolDto == null){
        return null;
    }
    Rol rol = new Rol();
    rolDto.getIdRol();
    rolDto.getNombreRol();
    return rol;

    }

    @Override
    public RolDto toRolDto(Rol rol) {
    if (rol == null){
        return null;
    }
    RolDto rolDto = new RolDto();
    rol.getId_rol();
    rol.getNomRol();
    return rolDto;
    }

    @Override
    public List<Rol> toRolDtoList(List<Rol> roles) {
    if (roles == null) {
        return List.of();
    }
    List <RolDto> list = new ArrayList<RolDto>(roles.size());
    for(Rol Rol : roles){
        list.add(toRolDto(Rol));
    }
    return roles;
    }

    @Override
    public void updateRol(Rol rol, RolDto rolDto) {
    if (rolDto == null){
        return;
    }
    rol.getId_rol();
    rol.getNomRol();
    }

}
