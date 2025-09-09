package com.sga.project.mapper;

import java.util.List;

import com.sga.project.dto.UsuarioDto;
import com.sga.project.models.Usuario;

public interface UsuarioMapper {

 Usuario toUsuario (UsuarioDto usuarioDto);
 UsuarioDto tUsuarioDto (Usuario usuario);
 List <UsuarioDto> toUsuarioDtoList (List <Usuario>usuarios);
 void updateUser (Usuario usuario,UsuarioDto usuarioDto);
}
