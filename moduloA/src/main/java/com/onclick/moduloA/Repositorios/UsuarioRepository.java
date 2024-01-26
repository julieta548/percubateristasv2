package com.onclick.moduloA.Repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onclick.moduloA.Entidades.Usuario;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByNombre(String nombre);
    Boolean existsByNombre(String nombre);
}
