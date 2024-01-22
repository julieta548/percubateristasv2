package com.onclick.moduloA.Controladores;

// AdminController.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.onclick.moduloA.Entidades.Admin;
import com.onclick.moduloA.Repositorios.AdminRepository;

import java.util.List;

@RestController
@RequestMapping("/admins")
public class AdminController {

    @Autowired
    private AdminRepository adminRepository;

    @PostMapping
    public ResponseEntity<Admin> agregarAdmin(@RequestBody Admin admin) {
        Admin nuevoAdmin = adminRepository.save(admin);
        return new ResponseEntity<>(nuevoAdmin, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Admin>> obtenerTodosLosAdmins() {
        List<Admin> admins = adminRepository.findAll();
        return new ResponseEntity<>(admins, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Admin> obtenerAdminPorId(@PathVariable Long id) {
        Admin admin = adminRepository.findById(id).orElse(null);
        return new ResponseEntity<>(admin, admin != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Admin> actualizarAdmin(@PathVariable Long id, @RequestBody Admin adminActualizado) {
        Admin adminExistente = adminRepository.findById(id).orElse(null);

        if (adminExistente != null) {
            adminExistente.setNombre(adminActualizado.getNombre());
            adminExistente.setContrasenia(adminActualizado.getContrasenia());

            Admin adminActualizadoDb = adminRepository.save(adminExistente);
            return new ResponseEntity<>(adminActualizadoDb, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAdmin(@PathVariable Long id) {
        adminRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
