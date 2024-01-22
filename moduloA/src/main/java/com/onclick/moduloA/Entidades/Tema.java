package com.onclick.moduloA.Entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Tema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private int indice;
    private List<String> clases;

    // Constructores, getters y setters

    public Tema() {
        // Constructor por defecto necesario para JPA
    }

    public Tema(String titulo, int indice, List<String> clases) {
        this.titulo = titulo;
        this.indice = indice;
        this.clases = clases;
    }

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

    public List<String> getClases() {
        return clases;
    }

    public void setClases(List<String> clases) {
        this.clases = clases;
    }

    @Override
    public String toString() {
        return "Tema{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", indice=" + indice +
                ", clases=" + clases +
                '}';
    }
}
