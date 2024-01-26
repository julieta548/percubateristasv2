package com.onclick.moduloA.Repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onclick.moduloA.Entidades.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long>{
    Optional<Rol> findByNombre(String nombre);
    
}
