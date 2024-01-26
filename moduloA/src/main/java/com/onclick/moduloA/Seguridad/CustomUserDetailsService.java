package com.onclick.moduloA.Seguridad;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.onclick.moduloA.Entidades.Rol;
import com.onclick.moduloA.Entidades.Usuario;
import com.onclick.moduloA.Repositorios.UsuarioRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Collection<GrantedAuthority> mapToAuthorities(List<Rol> roles){
        return roles.stream().map(rol -> new SimpleGrantedAuthority(rol.getNombre())).collect(Collectors.toList());
    }

    @Override
    public UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException {
        
        Usuario usuario = usuarioRepository.findByNombre(nombre).orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

       return new User(usuario.getNombre(), usuario.getContrasenia(), mapToAuthorities(usuario.getRoles()));
    }

}
