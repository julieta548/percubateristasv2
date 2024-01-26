package com.onclick.moduloA.DTOs;

import lombok.Data;

@Data
public class DtoLogin {
    private String nombre;
    private String apellido;
    private String ocupacion;
    private String correo;
    private String contrasenia;
}
