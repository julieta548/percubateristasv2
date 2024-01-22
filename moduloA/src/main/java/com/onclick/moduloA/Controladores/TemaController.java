package com.onclick.moduloA.Controladores;

// TemaController.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.onclick.moduloA.Entidades.Tema;
import com.onclick.moduloA.Repositorios.TemaRepository;

import java.util.List;

@RestController
@RequestMapping("/temas")
public class TemaController {

    @Autowired
    private TemaRepository temaRepository;

    @PostMapping
    public ResponseEntity<Tema> agregarTema(@RequestBody Tema tema) {
        Tema nuevoTema = temaRepository.save(tema);
        return new ResponseEntity<>(nuevoTema, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Tema>> obtenerTodosLosTemas() {
        List<Tema> temas = temaRepository.findAll();
        return new ResponseEntity<>(temas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tema> obtenerTemaPorId(@PathVariable Long id) {
        Tema tema = temaRepository.findById(id).orElse(null);
        return new ResponseEntity<>(tema, tema != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tema> actualizarTema(@PathVariable Long id, @RequestBody Tema temaActualizado) {
        Tema temaExistente = temaRepository.findById(id).orElse(null);

        if (temaExistente != null) {
            temaExistente.setTitulo(temaActualizado.getTitulo());
            temaExistente.setIndice(temaActualizado.getIndice());
            temaExistente.setClases(temaActualizado.getClases());

            Tema temaActualizadoDb = temaRepository.save(temaExistente);
            return new ResponseEntity<>(temaActualizadoDb, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTema(@PathVariable Long id) {
        temaRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

