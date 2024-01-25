package com.onclick.moduloA.Entidades;

import javax.persistence.Entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Clase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private int indice;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "clase_id")
    private List<Contenido> contenidos = new ArrayList<>();

    // Constructores
    public Clase() {
    }

    public Clase(String titulo, int indice) {
        this.titulo = titulo;
        this.indice = indice;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public List<Contenido> getContenidos() {
        return contenidos;
    }

    public void setContenidos(List<Contenido> contenidos) {
        this.contenidos = contenidos;
    }

    @Override
    public String toString() {
        return "Clase{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", indice=" + indice +
                ", contenidos=" + contenidos +
                '}';
    }
}
