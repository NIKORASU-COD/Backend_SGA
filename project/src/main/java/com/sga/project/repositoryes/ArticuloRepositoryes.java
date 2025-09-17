package com.sga.project.repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sga.project.models.Articulo;

@Repository
public interface ArticuloRepositoryes extends JpaRepository <Articulo, Integer>{

}
