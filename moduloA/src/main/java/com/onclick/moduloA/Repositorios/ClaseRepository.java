package com.onclick.moduloA.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onclick.moduloA.Entidades.Clase;

public interface ClaseRepository extends JpaRepository<Clase, Long> {
    // Puedes añadir métodos personalizados si es necesario
}
