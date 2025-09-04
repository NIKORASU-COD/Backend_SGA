package com.sga.project.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sga.project.dto.UsuarioDto;
import com.sga.project.models.Usuario;

@Component class UsuarioMapperImplement implements UsuarioMapper {

    @Override
    public Usuario toUsuario(UsuarioDto usuarioDto) {
    if (usuarioDto == null) {
        return null;
    }
    Usuario usuario = new Usuario();
    usuario.setNumDoc(usuarioDto.getNumDocumento());
    usuario.setDireccion(usuarioDto.getDire());
    usuario.setNom1(usuarioDto.getNombre1());
    usuario.setNom2(usuarioDto.getNombre2());
    usuario.setApe1(usuarioDto.getApellido1());
    usuario.setApe2(usuarioDto.getApellido2());
    usuario.setNumTel(usuarioDto.getTele());
    return usuario;

    }
    @Override
    public UsuarioDto tUsuarioDto(Usuario usuario) {
    if (usuario == null) {
        return null;
        
    }
    UsuarioDto usuarioDto = new UsuarioDto();
    usuarioDto.setNumDocumento(usuario.getNumDoc());
    usuarioDto.setDire(usuario.getDireccion());
    usuarioDto.setNombre1(usuario.getNom1());
    usuarioDto.setNombre2(usuario.getNom2());
    usuarioDto.setApellido1(usuario.getApe1());
    usuarioDto.setApellido2(usuario.getApe2());
    usuarioDto.setTele(usuario.getNumTel());
    return usuarioDto;
    }

    @Override
    public List<UsuarioDto> toUsuarioDtoList(List<Usuario> usuarios) {
    if (usuarios == null) {
        return List.of();
        
    }
    List<UsuarioDto> list = new ArrayList<UsuarioDto>(usuarios.size());
    for(Usuario Usuario : usuarios){
        list.add(tUsuarioDto(Usuario));
    }
    return list;
    }

    @Override
    public void updateUser(Usuario usuario, UsuarioDto usuarioDto) {
    if (usuarioDto == null){
        return;
    }
    usuario.setNumDoc(usuarioDto.getNumDocumento());
    usuario.setDireccion(usuarioDto.getDire());
    usuario.setNom1(usuarioDto.getNombre1());
    usuario.setNom2(usuarioDto.getNombre2());
    usuario.setApe1(usuarioDto.getApellido1());
    usuario.setApe2(usuarioDto.getApellido2());
    usuario.setNumTel(usuarioDto.getTele());
    }


    }
