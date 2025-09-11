package com.sga.project.service;

import java.util.List;

import com.sga.project.dto.RolDto;

public interface RolService {

public RolDto getRol(Integer idRol);
public RolDto saveRol(RolDto rolDto);
public List<RolDto> getRol();
public RolDto delete(Integer Rolid);
public RolDto update(Integer rol, RolDto rolDto);
}
