package com.onclick.moduloA.Repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onclick.moduloA.Entidades.Rol;

public interface RolRepository extends JpaRepository<Rol, Long> {
    Optional<Rol> findByNombre(String nombre);
}