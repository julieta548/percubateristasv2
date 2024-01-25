package com.onclick.moduloA.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onclick.moduloA.Entidades.Clase;

@Repository
public interface ClaseRepository extends JpaRepository<Clase, Long> {
    // Puedes añadir métodos personalizados si es necesario
}
