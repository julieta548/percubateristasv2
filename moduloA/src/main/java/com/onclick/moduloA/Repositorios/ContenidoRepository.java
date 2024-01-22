package com.onclick.moduloA.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onclick.moduloA.Entidades.Contenido;

public interface ContenidoRepository extends JpaRepository<Contenido, Long> {
    // Puedes añadir métodos personalizados si es necesario
}
