package com.sga.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sga.project.dto.UsuarioDto;
import com.sga.project.mapper.UsuarioMapper;
import com.sga.project.models.Usuario;
import com.sga.project.repositoryes.UsuarioRepositoryes;

@Service
public class UsuarioServiceImplement implements UsuarioService {

@Autowired
private UsuarioRepositoryes ur;
@Autowired
private UsuarioMapper um;

@Override
public UsuarioDto getUsuario(Integer numDocumento) {
Usuario usuario = ur.findById(numDocumento).get();
return um.toUsuarioDto(usuario);
}
@Override
public UsuarioDto saveUsuario(UsuarioDto UsuarioDto) {
Usuario usuario = um.toUsuario(UsuarioDto);
return um.toUsuarioDto(ur.save(usuario));
}
@Override
public List<UsuarioDto> getUsuario() {
List <Usuario> usuario = ur.findAll();
return um.toUsuarioDtoList(usuario);
}
@Override
public UsuarioDto deleteUsuario(Integer numDocumento) {
Usuario usuario = ur.findById(numDocumento).get();
ur.delete(usuario);
return um.toUsuarioDto(usuario);
}
@Override
public UsuarioDto updateUsuario(Integer Usuario, UsuarioDto usuarioDto) {
Usuario usuario2 = ur.findById(Usuario).get();
um.updateUser(usuario2, usuarioDto);
return um.toUsuarioDto(ur.save(usuario2));
}

}
