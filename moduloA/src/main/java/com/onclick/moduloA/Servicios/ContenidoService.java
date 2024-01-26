package com.onclick.moduloA.Servicios;

import com.onclick.moduloA.Entidades.Contenido;
import com.onclick.moduloA.Repositorios.ContenidoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContenidoService {
    private ContenidoRepository contenidoRepository;

    @Autowired
    public ContenidoService(ContenidoRepository contenidoRepository) {
        this.contenidoRepository = contenidoRepository;
    }

    //Creamos un contenido
    public void crear(Contenido contenido) {
        contenidoRepository.save(contenido);
    }

    //Obtenemos toda una lista de contenidos
    public List<Contenido> readAll() {
        return contenidoRepository.findAll();
    }

    //Obtenemos un contenido por su id
    public Optional<Contenido> readOne(Long id) {
        return contenidoRepository.findById(id);
    }

    //Actualizamos un contenido
    public void update(Contenido contenido) {
        contenidoRepository.save(contenido);
    }

    //Eliminamos un contenido
    public void delete(Long id) {
        contenidoRepository.deleteById(id);
    }
}
