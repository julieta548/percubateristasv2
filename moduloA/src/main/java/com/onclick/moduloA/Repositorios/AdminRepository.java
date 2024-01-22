package com.onclick.moduloA.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onclick.moduloA.Entidades.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}

