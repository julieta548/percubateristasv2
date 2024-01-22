package com.onclick.moduloA.Repositorios;


import org.springframework.data.jpa.repository.JpaRepository;

import com.onclick.moduloA.Entidades.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
