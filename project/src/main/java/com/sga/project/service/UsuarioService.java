package com.sga.project.service;

import java.util.List;

import com.sga.project.dto.UsuarioDto;

public interface UsuarioService {

public UsuarioDto getUsuario (Integer numDocumento);
public UsuarioDto saveUsuario (UsuarioDto usuarioDto);
public List <UsuarioDto> getUsuario ();
public UsuarioDto deleteUsuario(Integer numDocumento);
public UsuarioDto updateUsuario (Integer Usuario, UsuarioDto usuarioDto);

}
