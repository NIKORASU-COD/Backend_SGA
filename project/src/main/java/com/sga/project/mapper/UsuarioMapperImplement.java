package com.sga.project.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sga.project.dto.UsuarioDto;
import com.sga.project.models.Barrio;
import com.sga.project.models.Rol;
import com.sga.project.models.TipoDoc;
import com.sga.project.models.Usuario;
import com.sga.project.repositoryes.BarrioRepositoryes;
import com.sga.project.repositoryes.RolRepositoryes;
import com.sga.project.repositoryes.TipoDocRepositoryes;

import jakarta.persistence.EntityNotFoundException;

@Component class UsuarioMapperImplement implements UsuarioMapper {
    private final BarrioRepositoryes barRep;
    private final RolRepositoryes rolRep;
    private final TipoDocRepositoryes tipRe;

    public UsuarioMapperImplement(BarrioRepositoryes barRep, RolRepositoryes rolRep, TipoDocRepositoryes tipRe){
        this.barRep = barRep;
        this.rolRep = rolRep;
        this.tipRe = tipRe;
    }
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
    usuario.setCorreoElec(usuarioDto.getCorreoElectronico());
    usuario.setContraseña(usuarioDto.getContra());
    
    Barrio barrio = barRep.findById(usuarioDto.getIdBarrio())
    .orElseThrow(() -> new EntityNotFoundException("barrio no encontrado"));
    usuario.setBarrio(barrio);

    Rol rol = rolRep.findById(usuarioDto.getIdRol())
    .orElseThrow(() -> new EntityNotFoundException("rol no encontrado"));
    usuario.setRol(rol);

    TipoDoc tipoDoc = tipRe.findById(usuarioDto.getIdTipoDoc())
    .orElseThrow(() -> new EntityNotFoundException("tipo de documento no encontrado mi papacho"));
    usuario.setTipoDoc(tipoDoc);
    return usuario;
    }
    
    @Override
    public UsuarioDto toUsuarioDto(Usuario usuario) {
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
    usuarioDto.setCorreoElectronico(usuario.getCorreoElec());

    usuarioDto.setContra(usuario.getContraseña());
    return usuarioDto;
    }

    @Override
    public List<UsuarioDto> toUsuarioDtoList(List<Usuario> usuarios) {
    if (usuarios == null) {
        return List.of();
        
    }
    List<UsuarioDto> list = new ArrayList<UsuarioDto>(usuarios.size());
    for(Usuario Usuario : usuarios){
        list.add(toUsuarioDto(Usuario));
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
    usuario.setCorreoElec(usuarioDto.getCorreoElectronico());
    usuario.setContraseña(usuarioDto.getContra());
    }
}
