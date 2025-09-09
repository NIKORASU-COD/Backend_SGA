package com.sga.project.repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sga.project.models.Usuario;

public interface UsuarioRepositoryes extends JpaRepository <Usuario, Integer> {

}
