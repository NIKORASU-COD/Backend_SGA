package com.sga.project.mapper;

import java.util.List;

import com.sga.project.dto.RolDto;
import com.sga.project.models.Rol;

public interface RolMapper {

    Rol toRol (RolDto rolDto);
    RolDto toRolDto (Rol rol);
    List<RolDto> toRolDtoList (List <Rol> roles);
    void updateRol (Rol rol, RolDto rolDto);
    
}
