package com.onclick.moduloA.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.onclick.moduloA.Entidades.Contenido;
import com.onclick.moduloA.Repositorios.ContenidoRepository;

import java.util.List;

@RestController
@RequestMapping("/contenidos")
public class ContenidoController {

    @Autowired
    private ContenidoRepository contenidoRepository;

    @PostMapping
    public ResponseEntity<Contenido> agregarContenido(@RequestBody Contenido contenido) {
        Contenido nuevoContenido = contenidoRepository.save(contenido);
        return new ResponseEntity<>(nuevoContenido, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Contenido>> obtenerTodosLosContenidos() {
        List<Contenido> contenidos = contenidoRepository.findAll();
        return new ResponseEntity<>(contenidos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contenido> obtenerContenidoPorId(@PathVariable Long id) {
        Contenido contenido = contenidoRepository.findById(id).orElse(null);
        return new ResponseEntity<>(contenido, contenido != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contenido> actualizarContenido(@PathVariable Long id, @RequestBody Contenido contenidoActualizado) {
        Contenido contenidoExistente = contenidoRepository.findById(id).orElse(null);

        if (contenidoExistente != null) {
            contenidoExistente.setTitulo(contenidoActualizado.getTitulo());
            contenidoExistente.setArchivoPdf(contenidoActualizado.getArchivoPdf());
            contenidoExistente.setIndice(contenidoActualizado.getIndice());
            Contenido contenidoActualizadoDb = contenidoRepository.save(contenidoExistente);
            return new ResponseEntity<>(contenidoActualizadoDb, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarContenido(@PathVariable Long id) {
        contenidoRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
