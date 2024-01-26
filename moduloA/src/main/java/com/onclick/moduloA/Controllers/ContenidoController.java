package com.onclick.moduloA.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onclick.moduloA.Entidades.Contenido;
import com.onclick.moduloA.Servicios.ContenidoService;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/contenido/")
public class ContenidoController {
    private ContenidoService contenidoService;

    @Autowired
    public ContenidoController(ContenidoService contenidoService) {
        this.contenidoService = contenidoService;
    }

    //Petición para crear un  contenido
    @PostMapping(value = "crear", headers = "Accept=application/json")
    public void crearContenido(@RequestBody Contenido contenido) {
        contenidoService.crear(contenido);
    }

    //Petición para obtener todos los contenidos en la BD
    @GetMapping(value = "listar", headers = "Accept=application/json")
    public List<Contenido> listarContenidos() {
        return contenidoService.readAll();
    }

    //Petición para obtener contenido mediante "ID"
    @GetMapping(value = "listarId/{id}", headers = "Accept=application/json")
    public Optional<Contenido> obtenerContenidoPorId(@PathVariable Long id) {
        return contenidoService.readOne(id);
    }

    //Petición para actualizar un contenido
    @PutMapping(value = "actualizar", headers = "Accept=application/json")
    public void actualizarContenido(@RequestBody Contenido contenido) {
        contenidoService.update(contenido);
    }

    //Petición para eliminar un contenido por "Id"
    @DeleteMapping(value = "eliminar/{id}", headers = "Accept=application/json")
    public void eliminarContenido(@PathVariable Long id) {
        contenidoService.delete(id);
    }
    
}
