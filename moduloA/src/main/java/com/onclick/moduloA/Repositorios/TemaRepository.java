package com.onclick.moduloA.Repositorios;

// TemaRepository.java
import org.springframework.data.jpa.repository.JpaRepository;

import com.onclick.moduloA.Entidades.Tema;

public interface TemaRepository extends JpaRepository<Tema, Long> {
    // Puedes agregar métodos adicionales según sea necesario
}

