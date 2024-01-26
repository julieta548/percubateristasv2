package com.onclick.moduloA.Controllers;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onclick.moduloA.DTOs.DtoAuthRespuesta;
import com.onclick.moduloA.DTOs.DtoLogin;
import com.onclick.moduloA.DTOs.DtoRegistro;
import com.onclick.moduloA.Entidades.Rol;
import com.onclick.moduloA.Entidades.Usuario;
import com.onclick.moduloA.Repositorios.RolRepository;
import com.onclick.moduloA.Repositorios.UsuarioRepository;
import com.onclick.moduloA.Seguridad.JwtTokenProvider;

@RestController
@RequestMapping("/api/auth/")
public class RestControllerAuth {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RolRepository rolRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("registro")
    public ResponseEntity<String> registrar(@RequestBody DtoRegistro dtoRegistro){
        if (usuarioRepository.existsByNombre(dtoRegistro.getNombre())) {
            return new ResponseEntity<>("El usuario ya existe, intenta con otro nombre de usuario", HttpStatus.BAD_REQUEST);
        }

        Usuario usuario = new Usuario();
        usuario.setNombre(dtoRegistro.getNombre());
        usuario.setApellido(dtoRegistro.getApellido());
        usuario.setCorreo(dtoRegistro.getCorreo());
        usuario.setOcupacion(dtoRegistro.getOcupacion());
        usuario.setContrasenia(passwordEncoder.encode(dtoRegistro.getContrasenia()));
        Rol rol = rolRepository.findByNombre("USER").get();
        usuario.setRoles(Collections.singletonList(rol));
        usuarioRepository.save(usuario);
        return new ResponseEntity<>("Registro de usuario exitoso", HttpStatus.OK);
    }

    @PostMapping("registroAdm")
    public ResponseEntity<String> registrarAdmin(@RequestBody DtoRegistro dtoRegistro){
        if (usuarioRepository.existsByNombre(dtoRegistro.getNombre())) {
            return new ResponseEntity<>("El usuario ya existe, intenta con otro nombre de usuario", HttpStatus.BAD_REQUEST);
        }

        Usuario usuario = new Usuario();
        usuario.setNombre(dtoRegistro.getNombre());
        usuario.setContrasenia(passwordEncoder.encode(dtoRegistro.getContrasenia()));
        Rol rol = rolRepository.findByNombre("ADMIN").get();
        usuario.setRoles(Collections.singletonList(rol));
        usuarioRepository.save(usuario);
        return new ResponseEntity<>("Registro de usuario admin exitoso", HttpStatus.OK);
    }

    @PostMapping("login")
    public ResponseEntity<DtoAuthRespuesta> login(@RequestBody DtoLogin dtoLogin) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(dtoLogin.getNombre(), dtoLogin.getContrasenia()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenProvider.generarToken(authentication);
        return new ResponseEntity<>(new DtoAuthRespuesta(token), HttpStatus.OK);

    }

}
