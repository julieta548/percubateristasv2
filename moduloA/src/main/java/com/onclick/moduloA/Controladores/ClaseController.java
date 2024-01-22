package com.onclick.moduloA.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.onclick.moduloA.Entidades.Clase;
import com.onclick.moduloA.Repositorios.ClaseRepository;

import java.util.List;

@RestController
@RequestMapping("/clases")
public class ClaseController {

    @Autowired
    private ClaseRepository claseRepository;

    @PostMapping
    public ResponseEntity<Clase> agregarClase(@RequestBody Clase clase) {
        Clase nuevaClase = claseRepository.save(clase);
        return new ResponseEntity<>(nuevaClase, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Clase>> obtenerTodasLasClases() {
        List<Clase> clases = claseRepository.findAll();
        return new ResponseEntity<>(clases, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Clase> obtenerClasePorId(@PathVariable Long id) {
        Clase clase = claseRepository.findById(id).orElse(null);
        return new ResponseEntity<>(clase, clase != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Clase> actualizarClase(@PathVariable Long id, @RequestBody Clase claseActualizada) {
        Clase claseExistente = claseRepository.findById(id).orElse(null);

        if (claseExistente != null) {
            claseExistente.setTitulo(claseActualizada.getTitulo());
            claseExistente.setIndice(claseActualizada.getIndice());
            claseExistente.setContenidos(claseActualizada.getContenidos());
            Clase claseActualizadaDb = claseRepository.save(claseExistente);
            return new ResponseEntity<>(claseActualizadaDb, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarClase(@PathVariable Long id) {
        claseRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
